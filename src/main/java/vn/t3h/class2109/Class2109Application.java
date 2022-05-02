package vn.t3h.class2109;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Class2109Application {

    public static void main(String[] args) {
        SpringApplication.run(Class2109Application.class, args);
    }

}
