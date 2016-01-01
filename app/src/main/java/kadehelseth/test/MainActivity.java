package kadehelseth.test;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AnalogClock;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import kadehelseth.test.TimeText.Message;
import kadehelseth.test.TimeText.MessageSystem;
import kadehelseth.test.TimeText.Time;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.system = new MessageSystem();

        final EditText edt = (EditText)findViewById(R.id.messageText);
        final EditText phoneNumb = (EditText)findViewById(R.id.PhoneNumberField);
        final EditText time = (EditText)findViewById(R.id.timeCollector);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String messageText = edt.getText().toString();
                String phoneNumber = phoneNumb.getText().toString();
                //fixme
                Time sendTime = new Time(Calendar.getInstance().getTimeInMillis());
                //end fixme
                Message textMessage = new Message(messageText, phoneNumber, sendTime);
                String tempTime = time.getText().toString();
                int sendingTimeMilliseconds = Integer.parseInt(tempTime) * 1000;

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //fixme
                        Time sendTime = new Time(Calendar.getInstance().getTimeInMillis());
                        //end fixme
                        String messageText = edt.getText().toString();
                        String phoneNumber = phoneNumb.getText().toString();
                        Message textMessage = new Message(messageText, phoneNumber, sendTime);
                        sendSMS(textMessage.getPhoneNumber(), textMessage.getMessage());
                        toastFactory("Message Sent!");
                    }
                }, sendingTimeMilliseconds);


            }
        });
    }

    /**
     * !FIXXX
     * sends the text message
     * @param phoneNumber the number to be sent to
     * @param messageText the message to be sent
     */
    private void sendSMS(String phoneNumber, String messageText)
    {
        Activity currentActivity = this;
        PendingIntent pi = PendingIntent.getActivity(currentActivity, 0,
                new Intent(currentActivity, MainActivity.class), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, messageText, pi, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * @param m the message to be displayed
     */
    private void toastFactory(String m){
        Context context = getApplicationContext();
        CharSequence text = m;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * adds the message to the messageSystem
     */
    private boolean delaySend(Message message){

        return false;
    }

    MessageSystem system;
}

