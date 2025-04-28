package bootiful.jdbc;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Bean
	ApplicationRunner demo(CustomerRepository repository) {
		ApplicationRunner aa = new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                var customer = repository.save(new Customer(null, "aa"));
                repository.findAll().forEach(System.out::println);
            }
        };
		return aa;
	}
}

record Customer(@Id Integer id, String name){}

interface CustomerRepository extends ListCrudRepository<Customer, Integer> {}