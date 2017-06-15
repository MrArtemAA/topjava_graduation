package ru.artemaa.topjavagraduate;

import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * MrArtemAA
 * 03.05.2017
 */
public class SpringMain {
    private static final Logger LOG = getLogger(SpringMain.class);

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/app.xml")) {
            LOG.info(Arrays.toString(applicationContext.getBeanDefinitionNames()));
            applicationContext.close();
        }
    }

}
