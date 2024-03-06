package com.example.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;


@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {

    return args -> {
      Phone phone1 = new Phone();
      phone1.setNumber("123456789");
      phone1.setCitycode("123");
      phone1.setCountrycode("1");

      Phone phone2 = new Phone();
      phone2.setNumber("987654321");
      phone2.setCitycode("456");
      phone2.setCountrycode("2");

      Employee employee1 = new Employee("Bilbo Baggins", "burglar", "Bilbo@gmail.com", false, Arrays.asList(phone1));
      log.info("Preloading " + repository.save(employee1));
      Employee employee2 = new Employee("Frodo Baggins", "thief", "Frodo@gmail.com", false, Arrays.asList(phone2));
      log.info("Preloading " + repository.save(employee2));

     };
  }
}
