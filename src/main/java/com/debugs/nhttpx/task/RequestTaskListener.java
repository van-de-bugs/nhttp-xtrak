package com.debugs.nhttpx.task;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
public interface RequestTaskListener extends ErrorTaskListener {
    
    void onComplete(RequestTask task, Object data);
}
