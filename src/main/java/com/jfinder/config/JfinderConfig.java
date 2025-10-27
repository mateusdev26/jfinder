package com.jfinder.config;

import com.jfinder.domain.Word;
import com.jfinder.util.FinderUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JfinderConfig {
    @Bean
    public FinderUtil finderUtil(){
        return new FinderUtil();
    }
}
