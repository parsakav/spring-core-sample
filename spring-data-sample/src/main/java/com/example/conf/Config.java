package com.example.conf;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({JpaConfig.class})
@ImportResource("beans.xml")
public class Config {
}
