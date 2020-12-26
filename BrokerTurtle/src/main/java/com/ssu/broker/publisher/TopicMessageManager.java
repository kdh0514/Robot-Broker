/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.publisher;

import com.ssu.broker.Broker;

/**
 *
 * @author jonathan
 */
public class TopicMessageManager {
    
    public void keepMessage(String message) {
        switch(message) {
            case "IoTGoodMorning":
                Broker.accessMessageQueue("set", "IoTGoodMorning");
                break;
            case "IoTDailyRoutine":
                Broker.accessMessageQueue("set", "IoTDailyRoutine");
                break;
            case "IoTCallRobot":
                Broker.accessMessageQueue("set", "IoTCallRobot");
                break;
            case "IoTJustMove":
                Broker.accessMessageQueue("set", "IoTJustMove");
                break;
            case "IoTEmergStatusAbnormal":
                Broker.accessMessageQueue("set", "IoTEmergStatusAbnormal");
                break;
            case "IoTEmergStatusNormal":
                Broker.accessMessageQueue("set", "IoTEmergStatusNormal");
                break;
            case "IoTWarningStatus":
                Broker.accessMessageQueue("set", "IoTWarningStatus");
                break;
            case "IoTHealthReport":
                Broker.accessMessageQueue("set", "IoTHealthReport");
                break;
            case "IoTWarningStatusMove":
                Broker.accessMessageQueue("set", "IoTWarningStatusMove");
                break;
            case "IoTAltoMove":
                Broker.accessMessageQueue("set", "IoTAltoMove");
                break;
            case "IoTComeBack":
                Broker.accessMessageQueue("set", "IoTComeBack");
                break;
            case "IoTReporting":
                Broker.accessMessageQueue("set", "IoTReporting");
                break;
            case "IoTTurtlebotMoveOne":
                Broker.accessMessageQueue("set", "IoTTurtlebotMoveOne");
                break;
            case "IoTTurtlebotMoveTwo":
                Broker.accessMessageQueue("set", "IoTTurtlebotMoveTwo");
                break;
            case "IoTTurtlebotMoveThree":
                Broker.accessMessageQueue("set", "IoTTurtlebotMoveThree");
                break;
            case "IoTTurtlebotMoveFour":
                Broker.accessMessageQueue("set", "IoTTurtlebotMoveFour");
                break;
            case "IoTTurtlebotMoveHome":
                Broker.accessMessageQueue("set", "IoTTurtlebotMoveHome");
                break;
                
            default :
                break;
        }
    }
}
