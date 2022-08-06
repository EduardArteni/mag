package com.arteni.mag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MagApplication {

    public static void main(String[] args) {
        DataBaseConnection.connect();
        if(DataBaseConnection.connection != null){
            System.out.println("connected");
        }
        SpringApplication.run(MagApplication.class, args);
    }

}
