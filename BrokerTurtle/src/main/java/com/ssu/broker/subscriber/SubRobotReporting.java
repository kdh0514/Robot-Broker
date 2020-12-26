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
import com.ssu.broker.collectormanager.SubCollectorManager;
import edu.wpi.rail.jrosbridge.messages.Message;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author jonathan
 */
public class SubRobotReporting implements Runnable {
    private CurrentTime currentTime;
    
    private Ros ros;
    private JSONObject objRobotState;
    
    public SubRobotReporting() {
        currentTime = new CurrentTime();
    }
    
    public void run() {
        try {
            while(true) {
                
                ros = new Ros(Broker.accessRosIP("get", ""));
                ros.connect();
                
                Topic echoBack = new Topic(ros, "/reporting", "silver_msgs/IoTWarningStatus");
                echoBack.subscribe(new TopicCallback() {
                    @Override
                    public void handleMessage(Message message) {
                        String reporting = message.toString();
                        
                        JSONParser jsonParser = new JSONParser();
                        
                        try {
                            objRobotState = (JSONObject) jsonParser.parse(reporting);
                            jTextArea2.append("[ " + currentTime.getTime() + " ]" + objRobotState.get("activity_value_preferred").toString() + "Robot activity data...\n");
                            
                        } catch (ParseException ex) {
                            Logger.getLogger(SubRobotReporting.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   }
                });
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Robot Reporting Subscriber Running...\n");
                
                sleep(3600000);
                
                ros.disconnect();
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Robot Reporting Subscriber Stopping...\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        ros.disconnect();
        
        jTextArea2.append("[ " + currentTime.getTime() + " ] Robot Reporting Subscriber Stopping...\n");
    }
}
