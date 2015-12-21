/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeText;

import java.io.IOException;
import java.util.LinkedList;

/**
 * This class is used for holding an queue of messages
 * @author Kade Helseth
 */
public class MessageQueue {
    /**
     * The default constructor for the message queue creates a new linked list 
     */
    public MessageQueue(){
    this.queue= new LinkedList();
    this.count=0;
}
    /**
     * adds a new message to the queue
     * @param newMessage the message to be added to the queue
     * @return returns a boolean if the message was able to add
     * @throws java.io.IOException if the message is <b>null</b>
     */
    public boolean add(Message newMessage) throws IOException{
        boolean canAdd=false;
        
        if(newMessage!=null){
           queue.add(newMessage); 
           ++count;
           canAdd=true;
        }
        else{
            throw new IOException("The message is invalid");
        }
        return canAdd;
    }
    /**
     * Gets the first message of the queue if the queue is empty then throws an error
     * @return 
     * @throws java.lang.Exception if the queue is empty
     */
    public Message peek() throws Exception{
        Message firstMessage=null;
        if(count!=0){
        firstMessage= queue.peekFirst();
        }
        else{
            throw new Exception("Calling peek on an empty queue");
            //!!!!!THIS NEEDS TO BE HANDLED
        }
        return firstMessage;     
    }
    /**
     * Pops and returns the first message in the queue
     * @return The Message at the top of a queue
     * @throws Exception if the queue is empty <b>null</b> is returned
     */
    public Message pop() throws Exception{
        Message retMessage;
        retMessage= queue.pollFirst();
        
        if(count==0){
           throw new Exception("Called pop on an empty Queue"); 
        }
        
        return retMessage;
    }

    private int count;
    private LinkedList<Message> queue;
}
