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
public class PubCollectorManager {
    private String content;
    
    public PubCollectorManager() {
        content = "";
    }
    
    public String getData(String id) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        HttpClient httpClient = HttpClients.createDefault();
        
        HttpPost httpPost = new HttpPost(Broker.PubCollectorManagerURL);
        params.add(new BasicNameValuePair("id", id));
        
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                // EntityUtils to get the response content
                content = EntityUtils.toString(respEntity);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return content;
    }
}
