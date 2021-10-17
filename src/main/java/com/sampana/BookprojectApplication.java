package com.sampana;

import com.sampana.secondassign.SendMail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookprojectApplication.class, args);

         ConfigurableApplicationContext applicationContext=SpringApplication.run(SendMail.class, args);
         SendMail sendMail = applicationContext.getBean(SendMail.class);
        sendMail.sendEmail("prince.mandal7861@gmail.com","prince.rasen@gmail.com","testmail","Hi, Message");
    }

}
