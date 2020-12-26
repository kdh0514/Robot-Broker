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
public class IoTDailyRoutine {
    private JSONObject jsonResultObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTDailyRoutine() {
        topicName = "/iot_status/daily_routine";
        messageType = "silver_msgs/IoTDailyRoutine";
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
        
        jsonResultObj.put("iot_event_state", 132);
        jsonResultObj.put("position_id", 30);
        jsonResultObj.put("msg_idx", "11-A-1000");
        jsonResultObj.put("wearable_status", 1);
        
        messageValue = jsonResultObj.toJSONString();
        
        return messageValue;
    }
}
