package com.ivan.proxy;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

@SpringBootApplication
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);

	}

	@Bean
	ApplicationRunner applicationRunner(){
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				var target = new DefaultCustomerService();
				var proxyInstance =(CustomerService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
						target.getClass().getInterfaces(),
						new InvocationHandler() {
							@Override
							public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
								System.out.println("calling " + method.getName() + " with arguments [" + Arrays.toString(args) + "]");
								return method.invoke(target, args);
							}
						}
				);
				proxyInstance.create();
			}
		};
	}




}



@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Reflective
@interface MyTransactional {
}

class DefaultCustomerService implements CustomerService {

	@Override
	public void create(){
		System.out.println("create() execute....");
	}
}

interface CustomerService {
	@MyTransactional
	void create();
}