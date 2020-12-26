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
public class IoTComeBack {
    private JSONObject jsonResultObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTComeBack() {
        topicName = "/iot_status/comeback";
        messageType = "silver_msgs/RobotState";
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
        
        jsonResultObj.put("position_id", 1);
        jsonResultObj.put("state_id", 2);

        
        messageValue = jsonResultObj.toJSONString();
        
        return messageValue;
    }
}
