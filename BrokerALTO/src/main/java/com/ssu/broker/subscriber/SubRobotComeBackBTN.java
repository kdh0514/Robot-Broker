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
public class SubRobotComeBackBTN implements Runnable {
    private CurrentTime currentTime;
    
    private Ros ros;
    private JSONObject objRobotState;
    private SubCollectorManager subCollectorManager;
    
    public SubRobotComeBackBTN() {
        currentTime = new CurrentTime();
    }
    
    public void run() {
        subCollectorManager = new SubCollectorManager();
        try {
            while(true) {
                
                ros = new Ros(Broker.accessRosIP("get", ""));
                ros.connect();
                
                Topic echoBack = new Topic(ros, "/pubcomebackbtn", "silver_msgs/ComeBackBTN");
                echoBack.subscribe(new TopicCallback() {
                    @Override
                    public void handleMessage(Message message) {
                        System.out.println(message);
                        String position = message.toString();
                        
                        JSONParser jsonParser = new JSONParser();
                        
                        try {
                            objRobotState = (JSONObject) jsonParser.parse(position);
                            jTextArea2.append("[ " + currentTime.getTime() + " ]"+"ComeBackBTN value : "+objRobotState.get("comebackbtn").toString()+"Tab comeback btn click...\n");
                            
//                            Broker.accessRobotStateTwo("set", objRobotState.get("position_id").toString());
                        } catch (ParseException ex) {
                            Logger.getLogger(SubRobotPosition.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(message.toString());
                        subCollectorManager.sendData("Tablet", "ComeBackBTN", message.toString());
                   }
                });
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Tab ComeBackBTN Subscriber Running...\n");
                
                sleep(3600000);
                
                ros.disconnect();
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Tab ComeBackBTN Subscriber Stopping...\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        ros.disconnect();
        
        jTextArea2.append("[ " + currentTime.getTime() + " ] Tab ComeBackBTN Subscriber Stopping...\n");
    }
}
