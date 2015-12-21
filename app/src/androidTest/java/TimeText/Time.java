/*
 * This is to be used in the application TimeTest used as the time
 */
package TimeText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Gets the current time and can compare times 
 * @author Kade Helseth
 */
public class Time {
    
    /**\
     * The default constructor for the time class
     * sets the current time 
     */
    public Time(){
        this.currentTime= Calendar.getInstance();
        currentTime.toString();
        curDate= currentTime.getTime();
        this.milliSec= currentTime.getTimeInMillis();
        this.sdf = new SimpleDateFormat("HH:mm:ss");
        this.hour= Calendar.HOUR_OF_DAY;
        this.minute= Calendar.MINUTE;
        this.second= Calendar.SECOND;
        this.year= Calendar.YEAR;
    }

    /**
     * gets a string value for a time  (hh:mm:ss)
     * @return the time as a string 
     */
    public String toSting(){
        return sdf.format(currentTime.getTime());
    }
    
    /**
     * returns the time as a date 
     * @return The date of the current time
     */
    public Date getTime(){
        return curDate;
    }
    /**
     * Returns the time in milli seconds seconds since 1970 Jan 1
     * @return returns the value in millisecond
     */
    public long getMilliSec(){
        return this.milliSec;
    }
    /**
     * This gets the hour in a 24 hour period
     * @return returns the value of hours
     */
    public int getHours(){
        return this.hour;
    }
    /**
     * This gets the minutes in a hour
     * @return returns the value of hours
     */
    public int getMinutes(){
        return this.minute;
        
    }
    /**
     * This gets the seconds in a minute period (60 seconds)
     * @return returns the value of hours
     */
    public int getSeconds(){
        return this.second;
    }
    /**
     * This gets the year in a integer format
     * @return returns the value of years
     */
    public int getYear(){
        return this.year;
    }
    public long compair(Time otherTime){
        return otherTime.getMilliSec() - this.getMilliSec();
    }

    private SimpleDateFormat sdf;
    private long milliSec;
    private Date curDate;
    private Calendar currentTime;
    private String timeString;
    
    private final int hour;
    private final int minute;
    private final int second;
    private final int year;
}
