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
public class IoTHealthReport {
    private PubCollectorManager pubCollectorManager;
    
    private JSONParser jsonParser;
    private JSONObject jsonResultObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTHealthReport() {
        pubCollectorManager = new PubCollectorManager();
        
        jsonParser = new JSONParser();
        jsonResultObj = new JSONObject();
        
        topicName = "/iot_status/entire_report";
        messageType = "silver_msgs/IoTHealthReport";
        messageValue = "";
    }
    
    public String getTopicName() {
        return topicName;
    }
    
    public String getMessageType() {
        return messageType;
    }
    
    public String getMessageValue() {
        String DynamicData = pubCollectorManager.getData("IoTHealthReport");
        
        try {
            jsonResultObj = (JSONObject) jsonParser.parse(DynamicData);
            
            jsonResultObj.put("iot_event_state", 4);
            jsonResultObj.put("position_id", 30);
            
            messageValue = jsonResultObj.toJSONString();
        } catch(ParseException e) {
            e.printStackTrace();
        }
        
        return messageValue;
    }
}
