/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker;

import java.util.Queue;

/**
 *
 * @author jonathan
 */
public class Broker {
    // *********************************** Setting Start ***********************************
    
    // Collector Manager URL
    public static String PubCollectorManagerURL = "http://192.168.15.105:8080/spec/storage/get/procData";
    public static String SubCollectorManagerURL = "http://192.168.15.102:8881/SilverCM/collecting";
    public static int BrokerSocketServerPort = 5555;
    
    // *********************************** Setting End ***********************************
    
    // Robot Access Information Variable
    public static String rosIP = "";
    
    // Robot Access Information Function
    public static synchronized String accessRosIP(String type, String ip) {
        switch(type) {
            case "set":
                rosIP = ip;
                return "";
            case "get":
                if(rosIP != "") {
                    return rosIP;
                } else {
                    return "empty";
                }
            default :
                return "";
        }
    }
    
    // Robot State Information Variable
    public static String robotControl = "";
    public static String moveDone = "";
    public static String modeState = "";
    
    // Robot State Information Function
    public static synchronized String accessRobotState(String type, String control, String done, String state) {
        switch(type) {
            case "set":
                robotControl = control;
                moveDone = done;
                modeState = state;
                return "";
            case "get":
                if(robotControl != "") {
                    return robotControl + "," + moveDone + "," + modeState;
                } else {
                    return "empty,empty,empty";
                }
            default :
                return "";
        }
    }
    
    // Robot State Two Information Variable
    public static String stateid = "";
    
    // Robot State Information Function
    public static synchronized String accessRobotStateTwo(String type, String id) {
        switch(type) {
            case "set":
                stateid = id;
                return "";
            case "get":
                if(robotControl != "") {
                    return stateid;
                } else {
                    return "empty,empty,empty";
                }
            default :
                return "";
        }
    }
    
    // Robot Message Information Variable
    public static Queue<String> messageQueue;
    
    // Robot Message Information Function
    public static synchronized String accessMessageQueue(String type, String message) {
        switch(type) {
            case "set":
                messageQueue.offer(message);
                return "";
            case "get":
                if(messageQueue.isEmpty() == false) {
                    return messageQueue.poll();
                } else {
                    return "empty";
                }
            case "getAll":
                return messageQueue.toString();
            default :
                return "";
        }
    }
}
