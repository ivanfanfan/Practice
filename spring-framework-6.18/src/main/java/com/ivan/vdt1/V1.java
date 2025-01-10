package com.ivan.vdt1;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.context.ApplicationContext;

public class V1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {

    }
}

@Data
class PersonForm {
    @NotNull
    String name;
    @Min(0)
    int age;
}
