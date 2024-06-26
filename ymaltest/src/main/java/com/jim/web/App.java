package com.jim.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); //禁用将日期时间写成时间戳的特性
        try (InputStream fileInputStream = App.class.getClassLoader().getResourceAsStream("orderInput.yaml");) {
            Order order1 = mapper.readValue(fileInputStream, Order.class);
            String orderJson = mapper.writeValueAsString(order1);
            logger.debug(orderJson);
        }
    }
}
