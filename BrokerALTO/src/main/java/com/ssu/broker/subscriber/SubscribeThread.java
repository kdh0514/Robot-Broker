/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.subscriber;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class SubscribeThread {
    private ArrayList<Thread> subThreadList;
    
//    private SubVisionFalling subVisionFalling;
//    private SubVisionWalking subVisionWalking;
//    private SubVoice subVoice;
//    private SubRobotState subRobotState;
    private SubRobotStateTwo subRobotStateTwo;
    private SubRobotPosition subRobotPosition;
    private SubRobotComeBackBTN subRobotComeBackBTN;
    private SubRobotReportingBTN subRobotReportingBTN;
//    private SubRobotReporting subRobotReporting;
    
    
//    private Thread threadVisionFalling;
//    private Thread threadVisionWalking;
//    private Thread threadVoice;
//    private Thread threadRobotState;
    private Thread threadRobotStateTwo;
    private Thread threadRobotPosition;
    private Thread threadRobotComeBackBTN;
    private Thread threadRobotReportingBTN;
//    private Thread threadRobotReporting;
    
    public void subscribeThreadStart() {
        subThreadList = new ArrayList<Thread>();
        
//        subVisionFalling = new SubVisionFalling();
//        subVisionWalking = new SubVisionWalking();
//        subVoice = new SubVoice();
//        subRobotState = new SubRobotState();
        subRobotStateTwo = new SubRobotStateTwo();
        subRobotPosition = new SubRobotPosition();
        subRobotComeBackBTN = new SubRobotComeBackBTN();
        subRobotReportingBTN = new SubRobotReportingBTN();
//        subRobotReporting = new SubRobotReporting();
        
//        threadVisionFalling = new Thread(subVisionFalling);
//        threadVisionWalking = new Thread(subVisionWalking);
//        threadVoice = new Thread(subVoice);
//        threadRobotState = new Thread(subRobotState);
        threadRobotStateTwo = new Thread(subRobotStateTwo);
        threadRobotPosition = new Thread(subRobotPosition);
        threadRobotComeBackBTN = new Thread(subRobotComeBackBTN);
        threadRobotReportingBTN = new Thread(subRobotReportingBTN);
//        threadRobotReporting = new Thread(subRobotReporting);
        
//        subThreadList.add(threadVisionFalling);
//        subThreadList.add(threadVisionWalking);
//        subThreadList.add(threadVoice);
//        subThreadList.add(threadRobotState);
        subThreadList.add(threadRobotStateTwo);
        subThreadList.add(threadRobotPosition);
        subThreadList.add(threadRobotComeBackBTN);
        subThreadList.add(threadRobotReportingBTN);
//        subThreadList.add(threadRobotReporting);
        
        for(int index = 0; index < subThreadList.size(); index++) {
            subThreadList.get(index).start();
        }
    }
    
    public void subscribeThreadStop() {
//        subVisionFalling.stop();
//        subVisionWalking.stop();
//        subVoice.stop();
//        subRobotState.stop();
        subRobotStateTwo.stop();
        subRobotPosition.stop();
        subRobotComeBackBTN.stop();
        subRobotReportingBTN.stop();
//        subRobotReporting.stop();
        
        
        for(int index = 0; index < subThreadList.size(); index++) {
            subThreadList.get(index).interrupt();
        }
    }
}
