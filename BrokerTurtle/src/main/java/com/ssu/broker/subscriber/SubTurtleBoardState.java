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
public class SubTurtleBoardState implements Runnable {
    private CurrentTime currentTime;
    
    private Ros ros;
    private JSONObject objRobotState;
    private SubCollectorManager subCollectorManager;
    
    
    
    public SubTurtleBoardState() {
        currentTime = new CurrentTime();
        
        objRobotState = new JSONObject();
    }
    
    public void run() {
        subCollectorManager = new SubCollectorManager();
        try {
            while(true) {
                ros = new Ros(Broker.accessRosIP("get", ""));
                ros.connect();
                
                Topic echoBack = new Topic(ros, "/board_state", "turtlebot_actions/boardstate");
                echoBack.subscribe(new TopicCallback() {
                    @Override
                    public void handleMessage(Message message) {
                        System.out.println("Board State : "+message);
                        String test = message.toString();
                        
                        JSONParser jsonParser = new JSONParser();
                        try {
                            objRobotState = (JSONObject) jsonParser.parse(test);
                            jTextArea2.append("[ " + currentTime.getTime() + " ]"+"Board State : "+objRobotState.get("board_state_id").toString()+" Sensor One :  "+objRobotState.get("sensor1").toString()+" Sensor Two :  "+objRobotState.get("sensor2").toString()+" Sensor Three :  "+objRobotState.get("sensor3").toString()+" Sensor Four :  "+objRobotState.get("sensor4").toString()+" Robot State id data...\n");
                            
                        } catch (ParseException ex) {
                            Logger.getLogger(SubRobotStateTwo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        subCollectorManager.sendData("Serving", "ServingBoard", message.toString());
                   }
                });
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Board State Subscriber Running...\n");
                
                sleep(3600000);
                
                ros.disconnect();
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Board State Subscriber Stopping...\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        ros.disconnect();
        
        jTextArea2.append("[ " + currentTime.getTime() + " ] Board State Subscriber Stopping...\n");
    }
}
