package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class,args);
    }


    @Bean
    public CommandLineRunner demo(AdressBookRepository repository) {
        return (args) -> {

            AddressBook a1 = new AddressBook();


            a1.addBuddy(new BuddyInfo("Jack", "Bauer","ottawa", "613555666", 21));
            a1.addBuddy(new BuddyInfo("Chloe", "O'Brian","ottawa", "613555669", 23));
            a1.addBuddy(new BuddyInfo("Kim", "Bauer", "ottawa", "613559666", 34));
            a1.addBuddy(new BuddyInfo("David", "Palmer","ottawa", "613500666", 42));
            a1.addBuddy(new BuddyInfo("Michelle", "Dessler","ottawa", "613500666", 42));
            repository.save(a1);



            // fetch all Address Books
            log.info("Address found with findAll():");
            log.info("-------------------------------");
            for (AddressBook buddies : repository.findAll()) {
                log.info(buddies.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            AddressBook buddies = repository.findById(1L);
            log.info("Buddy found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddies.toString());
            log.info("");

        };
    }


}
