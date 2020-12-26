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
public class IoTCallRobot {
    private JSONObject jsonResultObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTCallRobot() {
        topicName = "/iot_status/calling_robot";
        messageType = "silver_msgs/IoTCallRobot";
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
        
        jsonResultObj.put("iot_event_state", 109);
        jsonResultObj.put("position_id", 30);
        
        messageValue = jsonResultObj.toJSONString();
        
        return messageValue;
    }
}
