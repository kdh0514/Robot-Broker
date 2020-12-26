/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.publisher.topicList;

import com.ssu.broker.collectormanager.PubCollectorManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author jonathan
 */
public class IoTEmergStatusNormal {
    private PubCollectorManager pubCollectorManager;
    
    private JSONParser jsonParser;
    private JSONObject jsonResultObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTEmergStatusNormal() {
        pubCollectorManager = new PubCollectorManager();
        
        jsonParser = new JSONParser();
        jsonResultObj = new JSONObject();
        
        topicName = "/iot_status/emergency";
        messageType = "silver_msgs/IoTEmergStatus";
        messageValue = "";
    }
    
    public String getTopicName() {
        return topicName;
    }
    
    public String getMessageType() {
        return messageType;
    }
    
    public String getMessageValue() {
        String DynamicData = pubCollectorManager.getData("IoTEmergStatusNormal");
        
        try {
            jsonResultObj = (JSONObject) jsonParser.parse(DynamicData);
            
            jsonResultObj.put("iot_event_state", 1);
            jsonResultObj.put("position_id", 0);
            
            messageValue = jsonResultObj.toJSONString();
        } catch(ParseException e) {
            e.printStackTrace();
        }
        
        return messageValue;
    }
}
