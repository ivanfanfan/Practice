package com.ivan.v2;

import lombok.Data;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.validation.DataBinder;

import java.beans.*;
import java.util.Objects;

//@Slf4j
public class V2 {

    final static String path = "E:\\code\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\v2\\v2.xml";
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {

        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("file:"+path);
        context.refresh();
        DependsOnExoticType simple = context.getBean("simple", DependsOnExoticType.class);
        System.out.println(simple);
        System.out.println(simple.type);
        System.out.println(simple.type.name);
    }

    // BeanWrapper and PropertyValue
    private static void test2() {
        Company company = new Company();
        BeanWrapper companyBeanWrapper = new BeanWrapperImpl(company);
        companyBeanWrapper.setPropertyValue("name","ivan");
        //can also be done like this.
        System.out.println(company);
        PropertyValue value = new PropertyValue("name", "Some Company Inc");
        companyBeanWrapper.setPropertyValue(value);
        System.out.println(company);
        //----------

        BeanWrapper employBeanWrapper = new BeanWrapperImpl(new Employee());
        employBeanWrapper.setPropertyValue("name","ivan");
        companyBeanWrapper.setPropertyValue("managingDirector",employBeanWrapper.getWrappedInstance());
        System.out.println(company);

        System.out.println("---------------");
        Float salary = (Float) companyBeanWrapper.getPropertyValue(
                "managingDirector.salary");
        System.out.println(salary);

    }


    //TODO here is some issue, the question is how to use dataBinder
    private static void test1() {
        DataBinder dataBinder = new DataBinder(null);
        dataBinder.setTargetType(ResolvableType.forClass(Bean.class));
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("a","ac");
//        propertyValues.
        dataBinder.construct(null);
        System.out.println();


    }
}
class ExoticTypeEditor extends PropertyEditorSupport {
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new ExoticType(text.toUpperCase()));
    }
}


class ExoticType {
    String name;
    public ExoticType(String name){
        this.name = name;
    }
}
class DependsOnExoticType{
    ExoticType type;
    public void setType(ExoticType type){
        this.type = type;
    }
}

class SomethingBeanInfo extends SimpleBeanInfo{
    public PropertyDescriptor[] getPropertyDescriptors(){
        try {
            final PropertyEditor numberPE = new CustomNumberEditor(Integer.class,true);
            PropertyDescriptor ageDescriptor = new PropertyDescriptor("age",Something.class){
//                @Override
                public PropertyEditor getPropertyEditor() {
                    return numberPE;
                }

            };
            return new PropertyDescriptor[]{ageDescriptor};
        }
        catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }
}

@Data
class Something {
    int age;
}
final class Company {
    String name;
    Employee managingDirector;


    public Company(String name, Employee managingDirector) {
        this.name = name;
        this.managingDirector = managingDirector;
    }

    public Company() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }

    public String getName() {
        return name;
    }

    public Employee getManagingDirector() {
        return managingDirector;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Company) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.managingDirector, that.managingDirector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, managingDirector);
    }

    @Override
    public String toString() {
        return "Company[" +
                "name=" + name + ", " +
                "managingDirector=" + managingDirector + ']';
    }

}
@Data
final class Employee{
    String name;
    float salary;
}
record Bean(String a,int b) {
    public Bean(String a, int b){
        this.a = a;
        this.b = b;
    }
}
