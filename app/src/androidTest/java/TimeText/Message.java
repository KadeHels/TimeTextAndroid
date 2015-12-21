/**
 * 
 * 
 * 
 */
package TimeText;

/**
 *
 * @author Kade Helseth
 */
public class Message {
    /**
     * Default constructor for the Message class
     * @param newText the message as a S
     */
    public Message(String newText){
        this.text=newText;
        this.timeStamp= new Time();
    }
    
    public String getMessage(){
        return text;
    }
    public void setMessage(String newText){
        this.text= newText;
    }
    /**
     * 
     * @return returns the Time Stamp when the message was created as a String
     */
    public String getTimeStamp(){
        return timeStamp.toSting();
    }
    private Time timeStamp;
    private String text;
}
