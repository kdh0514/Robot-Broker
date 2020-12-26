/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.subscriber;

import com.ssu.broker.Broker;
import static com.ssu.broker.BrokerUI.jTextArea2;
import com.ssu.broker.CurrentTime;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
import static java.lang.Thread.sleep;
import org.json.simple.JSONObject;

/**
 *
 * @author jonathan
 */
public class SubRobotState implements Runnable {
    private CurrentTime currentTime;
    
    private Ros ros;
    private JSONObject objRobotState;
    
    public SubRobotState() {
        currentTime = new CurrentTime();
        
        objRobotState = new JSONObject();
    }
    
    public void run() {
        try {
            while(true) {
                ros = new Ros(Broker.accessRosIP("get", ""));
                ros.connect();
                
                Topic echoBack = new Topic(ros, "/robot_mode", "silver_msgs/RobotMode");
                echoBack.subscribe(new TopicCallback() {
                    @Override
                    public void handleMessage(Message message) {
                        objRobotState = (JSONObject) message.toJsonObject();
                        Broker.accessRobotState("set", objRobotState.get("robot_control").toString(),
                                objRobotState.get("move_done").toString(), objRobotState.get("mode_state").toString());
                   }
                });
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Robot State Subscriber Running...\n");
                
                sleep(3600000);
                
                ros.disconnect();
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Robot State Subscriber Stopping...\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        ros.disconnect();
        
        jTextArea2.append("[ " + currentTime.getTime() + " ] Robot State Subscriber Stopping...\n");
    }
}
