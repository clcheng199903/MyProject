package com.example.propertiesdemo;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class ApplicationProperties {
    @Value("${version}")
    private String version;

    @PostConstruct
    public void init() {
//        String nation = SpringUtils.getProperty("person.nation");
//        log.info("version: {}, nation: {}", version, nation);
    }
}
