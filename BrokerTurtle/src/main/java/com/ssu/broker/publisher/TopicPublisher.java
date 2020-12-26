/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.publisher;

import com.ssu.broker.Broker;
import static com.ssu.broker.BrokerUI.jTextArea2;
import com.ssu.broker.CurrentTime;
import com.ssu.broker.publisher.topicList.IoTCallRobot;
import com.ssu.broker.publisher.topicList.IoTDailyRoutine;
import com.ssu.broker.publisher.topicList.IoTEmergStatusAbnormal;
import com.ssu.broker.publisher.topicList.IoTEmergStatusNormal;
import com.ssu.broker.publisher.topicList.IoTGoodMorning;
import com.ssu.broker.publisher.topicList.IoTHealthReport;
import com.ssu.broker.publisher.topicList.IoTJustMove;
import com.ssu.broker.publisher.topicList.IoTWarningStatus;
import com.ssu.broker.publisher.topicList.IoTAltoMove;
import com.ssu.broker.publisher.topicList.IoTComeBack;
import com.ssu.broker.publisher.topicList.IoTReporting;

import com.ssu.broker.publisher.topicList.IoTTurtlebotMoveOne;
import com.ssu.broker.publisher.topicList.IoTTurtlebotMoveTwo;
import com.ssu.broker.publisher.topicList.IoTTurtlebotMoveThree;
import com.ssu.broker.publisher.topicList.IoTTurtlebotMoveFour;
import com.ssu.broker.publisher.topicList.IoTTurtlebotMoveHome;
import static java.lang.Thread.sleep;

/**
 *
 * @author jonathan
 */
public class TopicPublisher implements Runnable {
    private CurrentTime currentTime;
    
    private IoTGoodMorning ioTGoodMorning;
    private IoTDailyRoutine ioTDailyRoutine;
    private IoTCallRobot ioTCallRobot;
    private IoTJustMove ioTJustMove;
    private IoTEmergStatusAbnormal ioTEmergStatusAbnormal;
    private IoTEmergStatusNormal ioTEmergStatusNormal;
    private IoTWarningStatus ioTWarningStatus;
    private IoTHealthReport ioTHealthReport;
    private IoTAltoMove ioTAltoMove;
    private IoTComeBack ioTComeBack;
    private IoTReporting ioTReporting;
    
    private IoTTurtlebotMoveOne ioTTurtlebotMoveOne;
    private IoTTurtlebotMoveTwo ioTTurtlebotMoveTwo;
    private IoTTurtlebotMoveThree ioTTurtlebotMoveThree;
    private IoTTurtlebotMoveFour ioTTurtlebotMoveFour;
    private IoTTurtlebotMoveHome ioTTurtlebotMoveHome;
    
    private TopicPublish topicPublish;
    
    private String topicName;
    private String messageType;
    private String messageValue;
    
    public TopicPublisher() {
        currentTime = new CurrentTime();
        
        ioTGoodMorning = new IoTGoodMorning();
        ioTDailyRoutine = new IoTDailyRoutine();
        ioTCallRobot = new IoTCallRobot();
        ioTJustMove = new IoTJustMove();
        ioTEmergStatusAbnormal = new IoTEmergStatusAbnormal();
        ioTEmergStatusNormal = new IoTEmergStatusNormal();
        ioTWarningStatus = new IoTWarningStatus();
        ioTHealthReport = new IoTHealthReport();
        ioTAltoMove = new IoTAltoMove();
        ioTComeBack = new IoTComeBack();
        ioTReporting = new IoTReporting();
        
        ioTTurtlebotMoveOne = new IoTTurtlebotMoveOne();
        ioTTurtlebotMoveTwo = new IoTTurtlebotMoveTwo();
        ioTTurtlebotMoveThree = new IoTTurtlebotMoveThree();
        ioTTurtlebotMoveFour = new IoTTurtlebotMoveFour();
        ioTTurtlebotMoveHome = new IoTTurtlebotMoveHome();
        
        topicPublish = new TopicPublish();
        
        topicName = "";
        messageType = "";
        messageValue = "";
    }
    
    public void run() {
//        System.out.println("TEST-2");
        try {
            while(true) {
//                System.out.println("TEST-3");
//                String robotStateList = Broker.accessRobotState("get", "", "", "");
//                String[] robotState = robotStateList.split(",");
//                
//                if(robotState[0].equals("false") && robotState[1].equals("false") && robotState[2].equals("0")) {
                    String message = Broker.accessMessageQueue("get", "");

//                    System.out.println("TEST-4 : "+message);
                    switch(message) {
                        case "IoTGoodMorning":
                            topicName = ioTGoodMorning.getTopicName();
                            messageType = ioTGoodMorning.getMessageType();
                            messageValue = ioTGoodMorning.getMessageValue();
                            break;
                        case "IoTDailyRoutine":
                            topicName = ioTDailyRoutine.getTopicName();
                            messageType = ioTDailyRoutine.getMessageType();
                            messageValue = ioTDailyRoutine.getMessageValue();
                            break;
                        case "IoTCallRobot":
                            topicName = ioTCallRobot.getTopicName();
                            messageType = ioTCallRobot.getMessageType();
                            messageValue = ioTCallRobot.getMessageValue();
                            break;
                        case "IoTJustMove":
                            topicName = ioTJustMove.getTopicName();
                            messageType = ioTJustMove.getMessageType();
                            messageValue = ioTJustMove.getMessageValue();
                            break;
                        case "IoTEmergStatusAbnormal":
                            topicName = ioTEmergStatusAbnormal.getTopicName();
                            messageType = ioTEmergStatusAbnormal.getMessageType();
                            messageValue = ioTEmergStatusAbnormal.getMessageValue();
                            break;
                        case "IoTEmergStatusNormal":
                            topicName = ioTEmergStatusNormal.getTopicName();
                            messageType = ioTEmergStatusNormal.getMessageType();
                            messageValue = ioTEmergStatusNormal.getMessageValue();
                            break;
                        case "IoTWarningStatus":
                            topicName = ioTWarningStatus.getTopicName();
                            messageType = ioTWarningStatus.getMessageType();
                            messageValue = ioTWarningStatus.getMessageValue();
                            break;
                        case "IoTHealthReport":
                            topicName = ioTHealthReport.getTopicName();
                            messageType = ioTHealthReport.getMessageType();
                            messageValue = ioTHealthReport.getMessageValue();
                            break;
                        case "IoTAltoMove":
                            topicName = ioTAltoMove.getTopicName();
                            messageType = ioTAltoMove.getMessageType();
                            messageValue = ioTAltoMove.getMessageValue();
                            break;
                        case "IoTReporting":
                            topicName = ioTReporting.getTopicName();
                            messageType = ioTReporting.getMessageType();
                            messageValue = ioTReporting.getMessageValue();
                            break;
                        case "IoTComeBack":
                            topicName = ioTComeBack.getTopicName();
                            messageType = ioTComeBack.getMessageType();
                            messageValue = ioTComeBack.getMessageValue();
                            break;
                        case "IoTTurtlebotMoveOne":
                            topicName = ioTTurtlebotMoveOne.getTopicName();
                            messageType = ioTTurtlebotMoveOne.getMessageType();
                            messageValue = ioTTurtlebotMoveOne.getMessageValue();
                            break;
                        case "IoTTurtlebotMoveTwo":
                            topicName = ioTTurtlebotMoveTwo.getTopicName();
                            messageType = ioTTurtlebotMoveTwo.getMessageType();
                            messageValue = ioTTurtlebotMoveTwo.getMessageValue();
                            break;
                        case "IoTTurtlebotMoveThree":
                            topicName = ioTTurtlebotMoveThree.getTopicName();
                            messageType = ioTTurtlebotMoveThree.getMessageType();
                            messageValue = ioTTurtlebotMoveThree.getMessageValue();
                            break;
                        case "IoTTurtlebotMoveFour":
                            topicName = ioTTurtlebotMoveFour.getTopicName();
                            messageType = ioTTurtlebotMoveFour.getMessageType();
                            messageValue = ioTTurtlebotMoveFour.getMessageValue();
                            break;
                        case "IoTTurtlebotMoveHome":
                            topicName = ioTTurtlebotMoveHome.getTopicName();
                            messageType = ioTTurtlebotMoveHome.getMessageType();
                            messageValue = ioTTurtlebotMoveHome.getMessageValue();
                            break;
                        default :
                            break;
                    }
                    
                    if(message != "empty") {
                        topicPublish.publish(topicName, messageType, messageValue);
                        System.out.println("publish message : " + message);
                    }
                    
                    sleep(1000);
//                }
                
                sleep(1000);
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Robot Service Message Queue : " + Broker.accessMessageQueue("getAll", "") + "\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
