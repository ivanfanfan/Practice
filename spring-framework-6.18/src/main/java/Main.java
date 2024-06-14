import com.ivan.pojo.Person;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Introduction to the Spring IoC Container and Beans
 * Container Overview
 * Bean Overview
 * Dependencies
 * Bean Scopes
 * Customizing the Nature of a Bean
 * Bean Definition Inheritance
 * Container Extension Points
 * Annotation-based Container Configuration
 * Classpath Scanning and Managed Components
 * Using JSR 330 Standard Annotations
 * Java-based Container Configuration
 * Environment Abstraction
 * Registering a LoadTimeWeaver
 * Additional Capabilities of the ApplicationContext
 * The BeanFactory API
 *
 */
public class Main {
    /**
     * TODO
     * mondatory somewhat compatible
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
//        new GroovyBeanDefinitionReader(context).loadBeanDefinitions("services.groovy", "daos.groovy");
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("beans.xml","services.xml");
        context.refresh();
        Person bean = (Person) context.getBean("person");
        System.out.println(bean);

    }
}