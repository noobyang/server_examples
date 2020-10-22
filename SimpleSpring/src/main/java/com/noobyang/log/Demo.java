package com.noobyang.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.debug("debug");
    }

}
