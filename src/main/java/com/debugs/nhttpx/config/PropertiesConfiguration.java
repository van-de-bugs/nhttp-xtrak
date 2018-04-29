package com.debugs.nhttpx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
@Configuration
@PropertySource("file:config/application.properties")
public class PropertiesConfiguration {
    
    @Autowired
    private Environment environment;
    
    public String getStringProperty(String key) {
        return environment.getProperty(key);
    }
    
    public int getIntProperty(String key) {
        String value = getStringProperty(key);
        return Integer.parseInt(value);
    }
    
    public boolean getBooleanProperty(String key) {
        String value = getStringProperty(key);
        return Boolean.parseBoolean(value);
    }
    
    @Bean
    public ApplicationProperties applicationProperties() {
        ApplicationProperties properties = new ApplicationProperties();
        properties.setMessageSettingsFile(getStringProperty("message.settings.file"));
        properties.setOutputDir(getStringProperty("output.dir"));
        properties.setAllowDuplicate(getBooleanProperty("process.allowDuplicate"));
        properties.setProcessTimeout(getIntProperty("process.timeout"));
        
        return properties;
    }
    
    @Bean
    public ConnectionProperties connectionProperties() {
        ConnectionProperties properties = new ConnectionProperties();
        properties.setMaxErrorRepeat(getIntProperty("connection.repeatOnError.max"));
        properties.setResponseCodePattern(getStringProperty("connection.responseCode.pattern"));
            
        return properties;
    }
}
