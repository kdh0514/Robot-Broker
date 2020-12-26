/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker.collectormanager;

import com.ssu.broker.Broker;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author jonathan
 */
public class SubCollectorManager {
    
    public void sendData(String id, String type, String value) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        HttpClient httpClient = HttpClients.createDefault();
        
        HttpPost httpPost = new HttpPost(Broker.SubCollectorManagerURL);
        params.add(new BasicNameValuePair("id", id));
        params.add(new BasicNameValuePair("type", type));
        params.add(new BasicNameValuePair("value", value));
        System.out.println("=========== send msg =============");
        System.out.println("id : "+id+", type : "+type+", value : "+value);
        
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                // EntityUtils to get the response content
                String content = EntityUtils.toString(respEntity);
                System.out.println(content);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
	} catch (ClientProtocolException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
}
