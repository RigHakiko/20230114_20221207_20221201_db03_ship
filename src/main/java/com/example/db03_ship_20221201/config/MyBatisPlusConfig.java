package com.example.db03_ship_20221201.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public PaginationInterceptor createPagination(){
        return new PaginationInterceptor();
    }
}
