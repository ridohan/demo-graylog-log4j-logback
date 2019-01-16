package com.ridohan.example.graylog.log4j.demograyloglog4j;

    import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoGraylogLog4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraylogLog4jApplication.class, args);
    }

    Logger LOGGER = LoggerFactory.getLogger(DemoGraylogLog4jApplication.class);

    private static final org.apache.log4j.Logger loggerWithLog4J = org.apache.log4j.LogManager.getLogger(DemoGraylogLog4jApplication.class);
    private static final org.apache.logging.log4j.Logger loggerWithLog4J2 = org.apache.logging.log4j.LogManager.getLogger(DemoGraylogLog4jApplication.class);

    @GetMapping("/log")
    public String log() {
        String logMessage  = "Hello World  !";

        LOGGER.error(logMessage);
        return logMessage;
    }

    @GetMapping("/logsWithLOG4J")
    public String logWithLOG4J() {
        String logMessage  = "Hello World LOG4J";

        loggerWithLog4J.error(logMessage);
        return logMessage;

    }

    @GetMapping("/logsWithLOG4J2")
    public String logWithLOG4J2() {
        String logMessage  = "Hello World LOG4J2";
        loggerWithLog4J2.error(logMessage);
        return logMessage;
    }


    @GetMapping("/exception")
    public String produceException() {
        String a= null;

        a.chars();

        return null;
    }


}

