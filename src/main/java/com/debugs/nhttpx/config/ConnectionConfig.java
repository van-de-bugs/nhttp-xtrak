package com.debugs.nhttpx.config;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
public class ConnectionConfig {
    
    private String responseCodePattern;
    private int maxErrorRepeat;

    public String getResponseCodePattern() {
        return responseCodePattern;
    }

    public void setResponseCodePattern(String responseCodePattern) {
        this.responseCodePattern = responseCodePattern;
    }

    public int getMaxErrorRepeat() {
        return maxErrorRepeat;
    }

    public void setMaxErrorRepeat(int maxErrorRepeat) {
        this.maxErrorRepeat = maxErrorRepeat;
    }
}
