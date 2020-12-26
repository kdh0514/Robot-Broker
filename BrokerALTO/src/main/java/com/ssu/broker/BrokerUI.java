/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.broker;

import com.ssu.broker.publisher.PublishThread;
import com.ssu.broker.publisher.TopicPublish;
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

import com.ssu.broker.subscriber.SubscribeThread;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author jonathan
 */
public class BrokerUI extends javax.swing.JFrame {
    /**
     * Creates new form BrokerUI
     */
    private DefaultCaret caret;
    private CurrentTime currentTime;
    
    private SubscribeThread subscribeThread;
    private PublishThread publishThread;
    
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
    
    private TopicPublish topicPublish;
    
    private String selectedTopic;
    private String selectedTopicName;
    private String selectedMessageType;
    private String selectedMessageValue;
    
    public BrokerUI() {
        initComponents();
        
        caret = (DefaultCaret)jTextArea2.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        currentTime = new CurrentTime();
        jTextArea2.append("[ " + currentTime.getTime() + " ] Welcome Robot Service Broker\n");
        
        subscribeThread = new SubscribeThread();
        publishThread = new PublishThread();
        
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
        
        
        topicPublish = new TopicPublish();
        
        selectedTopic = "";
        selectedTopicName = "";
        selectedMessageType = "";
        selectedMessageValue = "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 42)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Robot Service Broker");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel2.setText("Robot IP Address");

        jLabel3.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel3.setText("Broker Publisher");

        jLabel4.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel4.setText("Broker Subscriber");

        jTextField1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Not Connected");

        jLabel6.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Not Connected");

        jButton1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jButton1.setText("ON");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jButton2.setText("ON");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel7.setText("Topic List");

        jList1.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"IoTAltoMove","IoTComeBack","IoTReporting","IoTGoodMorning", "IoTDailyRoutine", "IoTCallRobot", "IoTJustMove", "IoTEmergStatusAbnormal", "IoTEmergStatusNormal", "IoTWarningStatus", "IoTHealthReport"};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Broker.accessRosIP("set", jTextField1.getText());
                    selectedTopic = (String)jList1.getSelectedValue();
                    selectedTopicView();
                }
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel8.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel8.setText("Topic Message");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jScrollPane2.setViewportView(jTextArea1);

        jButton3.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jButton3.setText("Publish");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel9.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel9.setText("Broker Log");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(231, 231, 231)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jButton2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jButton1.getText().equals("ON")) {
            jButton1.setText("OFF");
            jLabel5.setText("Connected");
            jLabel5.setForeground(new Color(0, 153, 51));
            
            jTextField1.setEditable(false);
            jTextField1.setBackground(new Color(204, 204, 204));
            
            Broker.accessRosIP("set", jTextField1.getText());
            
            Broker.messageQueue = new LinkedList<String>();
            
            publishThread.publishThreadStart();
        } else {
            jButton1.setText("ON");
            jLabel5.setText("Not Connected");
            jLabel5.setForeground(new Color(255, 0, 51));
            
            if(jButton2.getText().equals("ON")) {
                jTextField1.setEditable(true);
                jTextField1.setBackground(new Color(255, 255, 255));
            }
            
            publishThread.publishThreadStop();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jButton2.getText().equals("ON")) {
            jButton2.setText("OFF");
            jLabel6.setText("Connected");
            jLabel6.setForeground(new Color(0, 153, 51));
            
            jTextField1.setEditable(false);
            jTextField1.setBackground(new Color(204, 204, 204));
            
            Broker.accessRosIP("set", jTextField1.getText());
            
            subscribeThread.subscribeThreadStart();
        } else {
            jButton2.setText("ON");
            jLabel6.setText("Not Connected");
            jLabel6.setForeground(new Color(255, 0, 51));
            
            if(jButton1.getText().equals("ON")) {
                jTextField1.setEditable(true);
                jTextField1.setBackground(new Color(255, 255, 255));
            }
            
            subscribeThread.subscribeThreadStop();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        topicPublish.publish(selectedTopicName, selectedMessageType, selectedMessageValue);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void selectedTopicView() {
        switch(selectedTopic) {
            case "IoTGoodMorning":
                selectedTopicName = ioTGoodMorning.getTopicName();
                selectedMessageType = ioTGoodMorning.getMessageType();
                selectedMessageValue = ioTGoodMorning.getMessageValue();
                break;
            case "IoTDailyRoutine":
                selectedTopicName = ioTDailyRoutine.getTopicName();
                selectedMessageType = ioTDailyRoutine.getMessageType();
                selectedMessageValue = ioTDailyRoutine.getMessageValue();
                break;
            case "IoTCallRobot":
                selectedTopicName = ioTCallRobot.getTopicName();
                selectedMessageType = ioTCallRobot.getMessageType();
                selectedMessageValue = ioTCallRobot.getMessageValue();
                break;
            case "IoTJustMove":
                selectedTopicName = ioTJustMove.getTopicName();
                selectedMessageType = ioTJustMove.getMessageType();
                selectedMessageValue = ioTJustMove.getMessageValue();
                break;
            case "IoTEmergStatusAbnormal":
                selectedTopicName = ioTEmergStatusAbnormal.getTopicName();
                selectedMessageType = ioTEmergStatusAbnormal.getMessageType();
                selectedMessageValue = ioTEmergStatusAbnormal.getMessageValue();
                break;
            case "IoTEmergStatusNormal":
                selectedTopicName = ioTEmergStatusNormal.getTopicName();
                selectedMessageType = ioTEmergStatusNormal.getMessageType();
                selectedMessageValue = ioTEmergStatusNormal.getMessageValue();
                break;
            case "IoTWarningStatus":
                selectedTopicName = ioTWarningStatus.getTopicName();
                selectedMessageType = ioTWarningStatus.getMessageType();
                selectedMessageValue = ioTWarningStatus.getMessageValue();
                break;
            case "IoTHealthReport":
                selectedTopicName = ioTHealthReport.getTopicName();
                selectedMessageType = ioTHealthReport.getMessageType();
                selectedMessageValue = ioTHealthReport.getMessageValue();
                break;
            case "IoTAltoMove":
                selectedTopicName = ioTAltoMove.getTopicName();
                selectedMessageType = ioTAltoMove.getMessageType();
                selectedMessageValue = ioTAltoMove.getMessageValue();
                break;
            case "IoTComeBack":
                selectedTopicName = ioTComeBack.getTopicName();
                selectedMessageType = ioTComeBack.getMessageType();
                selectedMessageValue = ioTComeBack.getMessageValue();
                break;
            case "IoTReporting":
                selectedTopicName = ioTReporting.getTopicName();
                selectedMessageType = ioTReporting.getMessageType();
                selectedMessageValue = ioTReporting.getMessageValue();
                break;
            default :
                break;
        }
        
        jTextArea1.setText(selectedMessageValue);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BrokerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrokerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrokerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrokerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrokerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
