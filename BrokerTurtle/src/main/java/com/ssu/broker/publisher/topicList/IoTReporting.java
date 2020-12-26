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
public class IoTReporting {
    private JSONObject jsonResultObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTReporting() {
        topicName = "/iot_status/reporting";
        messageType = "silver_msgs/IoTWarningStatus";
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
        
        jsonResultObj.put("position_id", 20);
        jsonResultObj.put("stress_value", 10);
        jsonResultObj.put("stress_level", 11);
        jsonResultObj.put("activity_value", 12);
        jsonResultObj.put("activity_level", 13);
        jsonResultObj.put("cardiac_value", 14);
        jsonResultObj.put("cardiac_state", 15);
        jsonResultObj.put("weight_value", 16);
        jsonResultObj.put("bmi_value", 17);
        jsonResultObj.put("voice_status", 18);
        jsonResultObj.put("stress_value_preferred", 19);
        jsonResultObj.put("cardiac_value_preferred", 20);
        jsonResultObj.put("activity_value_preferred", 21);

        
        messageValue = jsonResultObj.toJSONString();
        
        return messageValue;
    }
}
