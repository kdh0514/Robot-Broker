/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.subscriber;

import com.ssu.broker.Broker;
import static com.ssu.broker.BrokerUI.jTextArea2;
import com.ssu.broker.CurrentTime;
import com.ssu.broker.collectormanager.SubCollectorManager;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
import static java.lang.Thread.sleep;

/**
 *
 * @author jonathan
 */
public class SubVoice implements Runnable {
    private CurrentTime currentTime;
    
    private Ros ros;
    private SubCollectorManager subCollectorManager;
    
    public SubVoice() {
        currentTime = new CurrentTime();
        
        subCollectorManager = new SubCollectorManager();
    }
    
    public void run() {
        try {
            while(true) {
                ros = new Ros(Broker.accessRosIP("get", ""));
                ros.connect();
                
                Topic echoBack = new Topic(ros, "/voice_recog_result", "silver_msgs/VoiceResult");
                echoBack.subscribe(new TopicCallback() {
                    @Override
                    public void handleMessage(Message message) {
                        //
                        System.out.println("Voice : " + message);
                        //
                        subCollectorManager.sendData("voice", "voice", message.toString());
                    }
                });
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Voice Subscriber Running...\n");
                
                sleep(3600000);
                
                ros.disconnect();
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Voice Subscriber Stopping...\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        ros.disconnect();
        
        jTextArea2.append("[ " + currentTime.getTime() + " ] Voice Subscriber Stopping...\n");
    }
}
