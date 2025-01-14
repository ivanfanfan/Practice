package com.ivan.v3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.*;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormatterPropertyEditorAdapter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.validation.DataBinder;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.SimpleBeanInfo;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class V3 {

    static final String path = "D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\v3\\path.xml";

    public static void main(String[] args) {
//        test1();

        // there are subclass of TypeConverter
//        simpleTypeConvertorTest();
//        beanWrapperImplTest();
//        databinderTest();
//        directFieldAccessorTest();
//        test2();
//        test3();
        test4();

    }

    private static void test4() {
        DependsOnBean3 dependsOnBean3 = new DependsOnBean3();
        DataBinder dataBinder = new DataBinder(dependsOnBean3);
        ConfigurableConversionService conversionRegistrar = (ConfigurableConversionService) DefaultConversionService.getSharedInstance();
        FormattingConversionService formattingConversionService = new FormattingConversionService();
        formattingConversionService.addFormatter(new Bean3Formatter());
//        conversionRegistrar.addConverter(formattingConversionService);
//        conversionRegistrar.addc(Bean3Formatter.class);
        conversionRegistrar.addConverter(new Converter<String, Bean3>() {
            @Override
            public Bean3 convert(String source) {
                String[] split = source.split(",");
                return new Bean3(split[0], Integer.parseInt(split[1]));
            }
        });
        dataBinder.setConversionService(conversionRegistrar);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("bean3", "ivan,30");
        propertyValues.add("code", 1);
        dataBinder.bind(propertyValues);
        System.out.println(dependsOnBean3);
    }


    // propertyEditor
    private static void test3() {
        DependsOnBean3 dependsOnBean3 = new DependsOnBean3();
        DataBinder dataBinder = new DataBinder(dependsOnBean3);
//        dataBinder.addCustomFormatter(new Bean3Formatter());
        //register
        dataBinder.registerCustomEditor(Bean3.class, new FormatterPropertyEditorAdapter(new Bean3Formatter()));
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("bean3", "ivan,30");
        propertyValues.add("code", 123);
        dataBinder.bind(propertyValues);
        System.out.println(dependsOnBean3.bean3.toString());
    }

    private static void test2() {
        Bean1 target = null;
        DataBinder dataBinder = new DataBinder(target);
        System.out.println(dataBinder.getTarget());
        dataBinder.setTargetType(ResolvableType.forClass(Bean1.class));
        // here valueResolver is a interface,but is not have implementations;
        dataBinder.construct(null);
        //这里需要传valueResolver
        Object target1 = dataBinder.getTarget();
        System.out.println(target1);
    }

    private static void directFieldAccessorTest() {
        Bean2 bean2 = new Bean2();
        DirectFieldAccessor accessor = new DirectFieldAccessor(bean2);
        accessor.setPropertyValue("name", "ivan");
        accessor.setPropertyValue("age", 123);
        System.out.println(bean2.age);
        System.out.println(bean2.name);
    }

    private static void databinderTest() {
        Bean2 bean2 = new Bean2();
        DataBinder dataBinder = new DataBinder(bean2);
        dataBinder.initDirectFieldAccess();
        dataBinder.convertIfNecessary("2020/01/01", Date.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        PropertyValue propertyValue = new PropertyValue("age", 123);
        PropertyValue name = new PropertyValue("name", "ivan");
        propertyValues.addPropertyValue(propertyValue);
        propertyValues.addPropertyValue(name);

        dataBinder.bind(propertyValues);
        System.out.println(bean2.age);
        System.out.println(bean2.name);
    }

    private static void beanWrapperImplTest() {
        BeanWrapper beanWrapper = new BeanWrapperImpl();
        Integer i = beanWrapper.convertIfNecessary("123", Integer.class);
        System.out.println(i);
        BeanWrapperImpl beanWrapper1 = new BeanWrapperImpl(new Bean1());
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        PropertyValue num = new PropertyValue("num", 123);
        PropertyValue value = new PropertyValue("date", "2020/01/01");
        propertyValues.addPropertyValue(num);
        propertyValues.addPropertyValue(value);
        beanWrapper1.setPropertyValues(propertyValues);
        System.out.println(beanWrapper1.getWrappedInstance());
    }

    private static void simpleTypeConvertorTest() {
        SimpleTypeConverter typeConverter = new SimpleTypeConverter();
        Integer i = typeConverter.convertIfNecessary("123", Integer.class);
        // value must this format, "-" is not allowed
        Date date = typeConverter.convertIfNecessary("1995/08/13", Date.class);
        System.out.println(date);
        System.out.println(i);
    }


    private static void test1() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        TypeConverter typeConverter = beanFactory.getTypeConverter();
        System.out.println(typeConverter);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("file:" + path);

        ConversionService conversionService = beanFactory.getConversionService();

//        conversionService.
//        beanFactory.getBean()
    }
}

class Bean2 {
    int age;
    String name;
}

@Data
class Bean1 {
    Integer num;
    Date date;

    public Bean1() {
        System.out.println("Bean1 constructor be invoked...");
    }
}

class SomethingBeanInfo extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            final PropertyEditor numberPE = new CustomNumberEditor(Integer.class, true);
            PropertyDescriptor ageDescriptor = new PropertyDescriptor("age", Something.class) {
                @Override
                public PropertyEditor createPropertyEditor(Object bean) {
                    return numberPE;
                }
            };
            return new PropertyDescriptor[]{ageDescriptor};
        } catch (IntrospectionException ex) {
            throw new Error(ex.toString());
        }
    }
}

class Something {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

@Data
class DependsOnBean3 {
    Bean3 bean3;
    int code;

}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Bean3 {
    String name;
    int age;
}

class Bean3Formatter implements Formatter<Bean3> {

    @Override
    public Bean3 parse(String text, Locale locale) throws ParseException {
        String[] values = text.split(",");
        return new Bean3(values[0], Integer.parseInt(values[1]));
    }

    @Override
    public String print(Bean3 object, Locale locale) {

        return "姓名:" + object.getName() + ",年龄:" + object.getAge();
    }
}