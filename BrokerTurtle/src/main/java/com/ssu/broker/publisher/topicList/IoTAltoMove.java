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
public class IoTAltoMove {
    private JSONObject jsonResultObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTAltoMove() {
        topicName = "/iot_status/altomove";
        messageType = "silver_msgs/IoTAltoMove";
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
        
        jsonResultObj.put("iot_event_state", 2);
        jsonResultObj.put("position_id", 20);
        
        
        messageValue = jsonResultObj.toJSONString();
        
        return messageValue;
    }
}
