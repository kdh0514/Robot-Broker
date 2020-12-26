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
            case "IoTAltoComeBack":
                Broker.accessMessageQueue("set", "IoTAltoComeBack");
                break;
            case "IoTAltoReporting":
                Broker.accessMessageQueue("set", "IoTAltoReporting");
                break;
            default :
                break;
        }
    }
}
