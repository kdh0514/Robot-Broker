/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.publisher;

import com.ssu.broker.Broker;
import static com.ssu.broker.BrokerUI.jTextArea2;
import com.ssu.broker.CurrentTime;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.messages.Message;

/**
 *
 * @author jonathan
 */
public class TopicPublish {
    private CurrentTime currentTime;
    
    public TopicPublish() {
        currentTime = new CurrentTime();
    }
    
    public void publish(String topicName, String messageType, String messageValue) {
        Ros ros = new Ros(Broker.accessRosIP("get", ""));
        ros.connect();
        
        Topic echo = new Topic(ros, topicName, messageType);
        Message toSend = new Message(messageValue);
        echo.publish(toSend);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        ros.disconnect();
        
        jTextArea2.append("[ " + currentTime.getTime() + " ] Publish Topic Name : " + topicName + ", Message Type : " + messageType + ", Message Value : " + messageValue + "\n");
    }
}
