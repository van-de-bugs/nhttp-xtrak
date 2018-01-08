package com.debugs.nhttpx.manager;

import com.debugs.nhttpx.config.ApplicationConfig;
import com.debugs.nhttpx.config.ConnectionConfig;
import com.debugs.nhttpx.message.MessageSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
@Service
public class ConfigurationManager {

    @Autowired
    private Environment environment;
    
    @Autowired
    private Unmarshaller unmarshaller;
    
    private final Logger LOGGER = LogManager.getLogger();
    
    private ApplicationConfig applicationConfig;
    private ConnectionConfig connectionConfig;
    private MessageSettings messageSettings;

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
    
    public ApplicationConfig getApplicationConfig() {
        if (applicationConfig == null) {
            applicationConfig = new ApplicationConfig();
            applicationConfig.setMessageSettingsFile(getStringProperty("message.settings.file"));
            applicationConfig.setOutputDir(getStringProperty("output.dir"));
            applicationConfig.setAllowDuplicate(getBooleanProperty("process.allowDuplicate"));
            applicationConfig.setProcessTimeout(getIntProperty("process.timeout"));
        }
        return applicationConfig;
    }
    
    public ConnectionConfig getConnectionConfig() {
        if (connectionConfig == null) {
            connectionConfig = new ConnectionConfig();
            connectionConfig.setMaxErrorRepeat(getIntProperty("connection.repeatOnError.max"));
            connectionConfig.setResponseCodePattern(getStringProperty("connection.responseCode.pattern"));
        }
        return connectionConfig;
    }
    
    public MessageSettings getMessageSettings() throws IOException, JAXBException {
        if (messageSettings == null) {
            ApplicationConfig config = getApplicationConfig();
            
            File file = new File("config", config.getMessageSettingsFile());
            InputStream is = new FileInputStream(file);
            messageSettings = (MessageSettings) unmarshaller.unmarshal(is);
            
            is.close();
            
            LOGGER.info("Message Settings loaded.");
        }
        return messageSettings;
    }
}
