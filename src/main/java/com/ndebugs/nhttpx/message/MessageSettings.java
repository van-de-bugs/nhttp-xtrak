package com.ndebugs.nhttpx.message;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
@XmlRootElement(name = "message-settings")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageSettings {
    
    @XmlElementWrapper
    @XmlElement(name = "message")
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
