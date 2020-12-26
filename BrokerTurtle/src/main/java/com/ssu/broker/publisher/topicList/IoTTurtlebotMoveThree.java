/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.publisher.topicList;

import org.json.simple.JSONObject;

/**
 *
 * @author jonathan
 */
public class IoTTurtlebotMoveThree {
    private JSONObject jsonResultObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTTurtlebotMoveThree() {
        topicName = "/move_to_p3";
        messageType = "turtlebot_actions/move_to";
        messageValue = "";
    }
    
    public String getTopicName() {
        return topicName;
    }
    
    public String getMessageType() {
        return messageType;
    }
    
    public String getMessageValue() {
        jsonResultObj = new JSONObject();
        
        jsonResultObj.put("point_id", 3);

        
        messageValue = jsonResultObj.toJSONString();
        
        return messageValue;
    }
}
