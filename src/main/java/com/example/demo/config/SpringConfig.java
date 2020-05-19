package com.example.demo.config;

import com.example.demo.model.AnimationDAO;
import com.example.demo.model.AnimationDAOImpl;
import com.example.demo.service.AnimationService;
import com.example.demo.service.AnimationServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class SpringConfig {


    @Bean

    @Qualifier("NumberDAO")
    public AnimationDAO getNumberDAO() {
        return new AnimationDAOImpl();
    }

    @Bean
    @Qualifier("NumberService")
    public AnimationService getNumberService() {
        return new AnimationServiceImpl();
    }
}
