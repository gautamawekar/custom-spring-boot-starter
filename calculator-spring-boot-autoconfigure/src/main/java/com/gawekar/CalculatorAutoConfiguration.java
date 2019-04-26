package com.gawekar;

import com.gawekar.service.Calculator;
import com.gawekar.service.CalculatorBuilder;
import com.gawekar.service.ScientificCalculator;
import com.gawekar.service.SimpleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //implies that this class can produce Beans
@ConditionalOnClass(CalculatorBuilder.class) //Enabled only if CalculatorBuilder on classpath
@EnableConfigurationProperties(CalculatorConfiguration.class)
// EnableConfigurationProperties EnableConfigurationPropertiesconvenient way for quickly register @ConfigurationProperties
// annotated beans.
// We could leave the @EnableConfigurationProperties empty
// if CalculatorConfiguration was registered as a bean
public class CalculatorAutoConfiguration {
    @Autowired
    private CalculatorConfiguration calculatorConfiguration;

    @Bean
    @ConditionalOnMissingBean
    public Calculator getCalculator() {
        switch (calculatorConfiguration.getCalculatorType()) {
            case "simple":
                return new SimpleCalculator();
            case "scientific":
                return new ScientificCalculator();
            default:
                throw new RuntimeException("invalid settings. Set - com.gawekar.calculatorType");
        }
    }
}
