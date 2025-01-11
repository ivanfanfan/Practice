package com.ivan.vdt1;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.*;

public class V1 {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        Customer customer = new Customer("a", "", new Address("city", "state"));
        CustomerValidator customerValidator = new CustomerValidator(new AddressValidator());
        Errors errors = customerValidator.validateObject(customer);
//                .failOnError(IllegalArgumentException::new);
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
        }
    }

    private static void test1() {
        Person person = new Person();
        person.setAge(101);
        person.setName("a");
        PersonValidator validator = new PersonValidator();
        Errors errors = validator.validateObject(person);
        errors.failOnError(IllegalArgumentException::new);

    }


}
class PersonValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
class AddressValidator implements Validator{


    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"city","field.required");
        ValidationUtils.rejectIfEmpty(errors,"state","field required");
    }
}

class CustomerValidator implements Validator {


    private Validator addressValidator;

    public CustomerValidator(Validator addressValidator) {
        this.addressValidator = addressValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","field.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"surname","field.required");
        Customer customer = (Customer) target;
        try {
            //TODO baocuo
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(this.addressValidator,customer.getAddress(),errors);
        } finally {
            errors.popNestedPath();
        }
    }
}

//record Customer(String firstName,String surname,Address address){}
@Data
@AllArgsConstructor
class Customer{
    String firstName;
    String surname;
    Address address;
}
@Data
class Person{
    @NotNull
    String name;
    @Min(0)
    int age;
}
@Data
class Address{

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    String city;
    String state;

}