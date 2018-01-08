package com.debugs.nhttpx.evaluator;

import com.debugs.nhttpx.message.Message;
import java.io.StringWriter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
public class FieldEvaluator {
    
    private final VelocityContext context;
    private final Message message;

    public FieldEvaluator(VelocityContext context, Message message) {
        this.context = context;
        this.message = message;
    }

    public VelocityContext getContext() {
        return context;
    }

    public Message getMessage() {
        return message;
    }
    
    public String[] evaluate(String[] fields) {
        String name = message.getName();
        
        String[] result = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];
            StringWriter stringWriter = new StringWriter();
            Velocity.evaluate(context, stringWriter, name, field);
            
            result[i] = stringWriter.toString();
        }
        
        return result;
    }
}
