package com.example.feedbacksevice.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;

import java.io.IOException;

public class ByteBuddyInterceptorSerializer extends JsonSerializer<ByteBuddyInterceptor> {

    @Override
    public void serialize(ByteBuddyInterceptor interceptor, JsonGenerator generator, SerializerProvider provider)
            throws IOException {
        // Add logic here to serialize the ByteBuddyInterceptor instance as needed.
    }
}
