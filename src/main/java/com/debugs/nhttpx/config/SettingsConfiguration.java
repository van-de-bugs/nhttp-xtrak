package com.debugs.nhttpx.config;

import com.debugs.nhttpx.message.MessageSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
@Configuration
public class SettingsConfiguration {
    
    @Autowired
    private Unmarshaller unmarshaller;
    
    @Autowired
    private ApplicationProperties applicationProperties;
    
    @Bean
    public MessageSettings messageSettings() throws IOException, JAXBException {
        File file = new File("config", applicationProperties.getMessageSettingsFile());
        InputStream is = new FileInputStream(file);
        MessageSettings messageSettings = (MessageSettings) unmarshaller.unmarshal(is);

        is.close();
        
        return messageSettings;
    }
}
