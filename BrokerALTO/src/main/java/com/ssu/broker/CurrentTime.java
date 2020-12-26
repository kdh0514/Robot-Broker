/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jonathan
 */
public class CurrentTime {
    private String timestamp;
    
    public CurrentTime() {
        timestamp = "";
    }
    
    public String getTime() {
        Date today = new Date();
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("a hh:mm:ss");
        
        String nowDate = date.format(today);
        String nowTime = time.format(today);
        
        timestamp = nowDate + ", " + nowTime;
        
        return timestamp;
    }
}
