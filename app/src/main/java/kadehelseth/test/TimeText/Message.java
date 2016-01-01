/**
 * 
 * 
 * 
 */
package kadehelseth.test.TimeText;

/**
 *
 * @author Kade Helseth
 */
public class Message {


    /**
     * Default constructor for the Message class
     * @param newText the message as a S
     */
    public Message(String newText, String phoneNumber, Time newSendTime){
        this.text = newText;
        this.timeStamp = new Time();
        this.phoneNumber = phoneNumber;
        this.sendTime = newSendTime;
        isSent = false;
    }

    /**
     * gets the message to be sent
     * @return the text as a String
     */
    public String getMessage(){
        return text;
    }

    /**
     * returns a boolean if the message has been sent.
     *
     * @return true or false if the message has been sent
     */
    public boolean isSent(){
        return this.isSent;
    }
    /**
     * indicates that the message has been sent should be called after the message has been sent
     *  sets the isSent field to be true
     */
    public void messageSent(){
        this.isSent = true;
    }
    /**
     * sets the text in the message
     * @param newText
     */
    public void setMessage(String newText){
        this.text= newText;
    }

    /**
     * gets the time for the message to be sent at
     * @return the time in milliseconds
     */
    public long getSendTime(){
        return this.sendTime.getSendTime();
    }
    /**
     * 
     * @return returns the Time Stamp when the message was created as a String
     */
    public String getTimeStamp(){
        return timeStamp.toSting();
    }

    /**
     * returns the phone number of the person to send to as a String
     * @return the Phone Number as a string
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
     * Variables
     */

    private String phoneNumber;
    private Time timeStamp;
    private String text;
    private Time sendTime;
    private boolean isSent;
}
