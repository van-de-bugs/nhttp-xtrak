package com.debugs.nhttpx.config;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
public class ApplicationProperties {
    
    private boolean allowDuplicate;
    private int processTimeout;
    private String messageSettingsFile;
    private String outputDir;

    public boolean isAllowDuplicate() {
        return allowDuplicate;
    }

    public void setAllowDuplicate(boolean allowDuplicate) {
        this.allowDuplicate = allowDuplicate;
    }

    public int getProcessTimeout() {
        return processTimeout;
    }

    public void setProcessTimeout(int processTimeout) {
        this.processTimeout = processTimeout;
    }

    public String getMessageSettingsFile() {
        return messageSettingsFile;
    }

    public void setMessageSettingsFile(String messageSettingsFile) {
        this.messageSettingsFile = messageSettingsFile;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
}
