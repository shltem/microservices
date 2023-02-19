package com.example.feedbacksevice.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;
import java.io.IOException;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomSerialization() {
        return builder -> {
            SimpleModule module = new SimpleModule();
            module.addSerializer(ByteBuddyInterceptor.class, new ByteBuddyInterceptorSerializer());
            builder.modules(module);
        };
    }
}