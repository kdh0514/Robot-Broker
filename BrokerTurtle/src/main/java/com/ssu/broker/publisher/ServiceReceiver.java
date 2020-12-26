/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.publisher;

import com.ssu.broker.Broker;
import static com.ssu.broker.BrokerUI.jTextArea2;
import com.ssu.broker.CurrentTime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author jonathan
 */
public class ServiceReceiver implements Runnable {
    private CurrentTime currentTime;
    
    private ServerSocket mServerSocket;
    private Socket mSocket;

    private BufferedReader mIn;
    private PrintWriter mOut;
    
    private TopicMessageManager topicMessageManager;
    
    private String message;
    
    public ServiceReceiver() {
        currentTime = new CurrentTime();
        
        topicMessageManager = new TopicMessageManager();
        
        message = "";
    }
    
    public void run() {
        try {
            while(true) {
                try {
                    mServerSocket = new ServerSocket(Broker.BrokerSocketServerPort);
                    
                    jTextArea2.append("[ " + currentTime.getTime() + " ] Robot Service Message Listener Waiting...\n");
                    
                    mSocket = mServerSocket.accept();
                    
                    mIn = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
                    
                    mOut = new PrintWriter(mSocket.getOutputStream());
                    
                    message = mIn.readLine();
                    topicMessageManager.keepMessage(message);
                    System.out.print("========================="+message+"=========================");
                    
                    mOut.println("true");
                    mOut.flush();
                    
                    jTextArea2.append("[ " + currentTime.getTime() + " ] Receive \"" + message + "\" Robot Service Message\n");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        mIn.close();
                        mOut.close();
                        mSocket.close();
                        mServerSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                
                jTextArea2.append("[ " + currentTime.getTime() + " ] Robot Service Message Listener Stopping...\n");
                
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        try {
            mServerSocket.close();
            
            jTextArea2.append("[ " + currentTime.getTime() + " ] Robot Service Message Listener Stopping...\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
