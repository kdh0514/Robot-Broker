/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.publisher.topicList;

import com.ssu.broker.collectormanager.PubCollectorManager;
import static java.lang.Math.toIntExact;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author jonathan
 */
public class IoTGoodMorning {
    private PubCollectorManager pubCollectorManager;
    
    private JSONParser jsonParser;
    private JSONObject jsonResultObj;
    private JSONObject jsonTempObj;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public IoTGoodMorning() {
        pubCollectorManager = new PubCollectorManager();
        
        jsonParser = new JSONParser();
        jsonResultObj = new JSONObject();
        jsonTempObj = new JSONObject();
        
        topicName = "/iot_status/morning_msg";
        messageType = "silver_msgs/IoTGoodMorning";
        messageValue = "";
    }
    
    public String getTopicName() {
        return topicName;
    }
    
    public String getMessageType() {
        return messageType;
    }
    
    public String getMessageValue() {
        String DynamicData = pubCollectorManager.getData("IoTGoodMorning");
        
        try {
            jsonResultObj = (JSONObject) jsonParser.parse(DynamicData);
            jsonTempObj = (JSONObject) jsonParser.parse(DynamicData);
            
            long typeLong = (long)jsonTempObj.get("morning_type");
            int typeInt = toIntExact(typeLong);
          
            
            if(typeInt == 1) {
                jsonResultObj.put("iot_event_state", 101);
                jsonResultObj.put("msg_idx0", "1-A-1000");
            } else {
                jsonResultObj.put("iot_event_state", 101);
                jsonResultObj.put("msg_idx0", "1-B-1000");
                jsonResultObj.put("msg_idx1", "3");
                jsonResultObj.put("msg_idx2", "4");
            }
            
            messageValue = jsonResultObj.toJSONString();
        } 
        catch(ParseException  e) {
            e.printStackTrace();
        }
        
        return messageValue;
    }
}
