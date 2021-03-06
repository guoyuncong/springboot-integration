package com.springboot.startup.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Order(1)
public class MyApplicationRunner1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("Runner1 nonOptionArgs → " + nonOptionArgs);
        Set<String> optionNames = args.getOptionNames();
        for (String optionName:optionNames) {
            System.out.println("Runner1 optionNames key [" + optionName +
                    "]value[" + args.getOptionValues(optionName) + "]");
        }
    }
}
