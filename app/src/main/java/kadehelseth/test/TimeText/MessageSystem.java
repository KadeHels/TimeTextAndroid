package kadehelseth.test.TimeText;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.Calendar;

import kadehelseth.test.MainActivity;

/**
 * used to control the flow of messages from the user
 * Created by Kade on 12/30/2015.
 */
public class MessageSystem {

    public MessageSystem(){
        messQue = new MessageQueue();
}
    /**
     * adds a message to the message queue if the time to be sent is in the future
     * @param newMess the message to be added to the queue
     * @return boolean if the message was added
     */
    public boolean addMessage(Message newMess){
        boolean canAdd;
        try{
            messQue.add(newMess);
            canAdd = true;
        }
        catch(Exception e){
            canAdd = false;
        }
        return canAdd;
    }
    public boolean sendMessage(){
        long sendTime = 0;
        long curTime = 0;
        boolean canSend = false;
        try{
            sendTime = messQue.peek().getSendTime();
            curTime = Calendar.getInstance().getTimeInMillis();

        }
        catch (Exception e){
        canSend = false;
        }

        if(sendTime != 0 && curTime != 0){
            if(sendTime <= curTime){
                try {
                    Message messageToSend = messQue.pop();
                    sendSMS(messageToSend.getPhoneNumber(), messageToSend.getMessage());
                    messageToSend.messageSent();
                    canSend = true;
                }
                catch(Exception e){
                    canSend = false;
                }
            }
        }

        return canSend;
    }

    /**
     * !FIXXX
     * sends the text message
     * @param phoneNumber the number to be sent to
     * @param messageText the message to be sent
     */
    private void sendSMS(String phoneNumber, String messageText)
    {
        Activity currentActivity = new MainActivity();
        PendingIntent pi = PendingIntent.getActivity(currentActivity, 0,
                new Intent(currentActivity, MainActivity.class), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, messageText, pi, null);
    }

    /**
     * makes sure the information sent is valid
     * @param m the message to be sent
     * @return boolean if the message is valid
     */
    public boolean validInformation(Message m){
        //Toast.makeText(getApplicationContext(), "Message Sent!", Toast.LENGTH_SHORT).show();
//Toast.makeText(getBaseContext(),
//        "Please enter both phone number and message.",
//        Toast.LENGTH_SHORT).show();
        return m.getPhoneNumber().length() > 0 && m.getMessage().length() > 0;
    }
    /**
     * Variables
     */
    private MessageQueue messQue;
}
