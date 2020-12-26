/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.publisher;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class PublishThread {
    private ArrayList<Thread> subThreadList;
    
    private ServiceReceiver serviceReceiver;
    private TopicPublisher topicPublisher;
    
    private Thread threadServiceReceiver;
    private Thread threadTopicPublisher;
    
    public void publishThreadStart() {
        subThreadList = new ArrayList<Thread>();
        
        serviceReceiver = new ServiceReceiver();
        topicPublisher = new TopicPublisher();
        
        threadServiceReceiver = new Thread(serviceReceiver);
        threadTopicPublisher = new Thread(topicPublisher);
        
        subThreadList.add(threadServiceReceiver);
        subThreadList.add(threadTopicPublisher);
        
        for(int index = 0; index < subThreadList.size(); index++) {
            subThreadList.get(index).start();
        }
    }
    
    public void publishThreadStop() {
        serviceReceiver.stop();
        
        for(int index = 0; index < subThreadList.size(); index++) {
            subThreadList.get(index).interrupt();
        }
    }
}
