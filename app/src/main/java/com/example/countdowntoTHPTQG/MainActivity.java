package com.example.countdowntoTHPTQG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.os.CountDownTimer;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    ChipNavigationBar bottomNav;
    FragmentManager fragmentManager;
    private ImageButton leftbtn;
    private ImageButton rightbtn;
    private ImageButton quotebtn;
    private long backPressedTime;
    private Toast backToast;
    TextView textQuote;
    TextView textWeek;
    TextView textHour;
    TextView textMin;
    TextView textSec;
    CountDownTimer countDownTimer;
    Random random = new Random();
    boolean twice = false;
    ViewFlipper viewFlipper;


    //Hiện toast thông báo khi đóng app
    @Override
    public void onBackPressed() {
        if(twice == true) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice = true;

        if (backPressedTime + 2500 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else{
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountdownView mCvCountdownView1 = findViewById(R.id.mycountdown1);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        this.leftbtn = (ImageButton) this.findViewById(R.id.leftbtn);
        this.rightbtn = (ImageButton) this.findViewById(R.id.rightbtn);
        textQuote = findViewById(R.id.textViewQuote);
        quotebtn = findViewById(R.id.quotebtn);
        textWeek = findViewById(R.id.textViewWeek);
        textHour = findViewById(R.id.textViewHour);
        textMin = findViewById(R.id.textViewMin);
        textSec = findViewById(R.id.textViewSec);

        //Định nghĩa lại định dạng cho ngày tháng năm
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String countDate = "25-06-2021 00:00:00";
        Date now = new Date();

        myAlarm();

        bottomNav = findViewById(R.id.bottom_nav);

        if(savedInstanceState==null){
            bottomNav.setItemSelected(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            Fragment homeFragment = new Fragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_main, homeFragment)
                    .commit();
        }

        //Bottom navigation bar
        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.home:
                        fragment = new Fragment();
                        break;
                    case R.id.quiz:
                        fragment = new QuizFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.activity_main, fragment)
                            .commit();
                }else{
                    Log.e(TAG, "Error in creating fragment");

                }
            }
        });




        rightbtn.setOnClickListener(this);
        leftbtn.setOnClickListener(this);
        quotebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayQuote();
            }
        }
        );

        //Trả về giá trị các thông số đếm thời gian thực
        //Hiển thị theo dạng dd/hh/mm/ss
        try {
            //Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long THPTQGDate = date.getTime();
            long countDownToTHPTQG = THPTQGDate - currentTime;
            mCvCountdownView1.start(countDownToTHPTQG);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Hiển thị theo dạng tuần
        try {
            //Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long THPTQGDate = date.getTime();
            long countDownToTHPTQG = THPTQGDate - currentTime;
            textWeek.setText(String.valueOf(countDownToTHPTQG/604800000));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Hiển thị theo dạng giờ
        try {
            //Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long THPTQGDate = date.getTime();
            long countDownToTHPTQG = THPTQGDate - currentTime;
            textHour.setText(String.valueOf(countDownToTHPTQG/3600000));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Hiển thị theo dạng phút
        try {
            //Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long THPTQGDate = date.getTime();
            long countDownToTHPTQG = THPTQGDate - currentTime;
            textMin.setText(String.valueOf(countDownToTHPTQG/60000));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Hiển thị theo dạng giây
        try {
            //Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long THPTQGDate = date.getTime();
            final long countDownToTHPTQG = THPTQGDate - currentTime;
            new CountDownTimer(countDownToTHPTQG, 1000) {

                public void onTick(long millisUntilFinished) {
                    textSec.setText(String.valueOf(millisUntilFinished/1000));

                }
                public void onFinish() {
                    textSec.setText("Done!");
                }
            }.start();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v){
        if (v == rightbtn){
            viewFlipper.showNext();
        }
        else if (v == leftbtn){
            viewFlipper.showPrevious();
        }
    }

    //Thiết lập giờ để hiển thị thông báo
    public void myAlarm() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 02);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        }

    }

    public void displayQuote(){
        int randNum = random.nextInt((11+1) - 1) + 1;
        String randQuote = "";
        switch (randNum){
            case 1:
                randQuote = getString(R.string.quote1);
                break;
            case 2:
                randQuote = getString(R.string.quote2);
                break;
            case 3:
                randQuote = getString(R.string.quote3);
                break;
            case 4:
                randQuote = getString(R.string.quote4);
                break;
            case 5:
                randQuote = getString(R.string.quote5);
                break;
            case 6:
                randQuote = getString(R.string.quote6);
                break;
            case 7:
                randQuote = getString(R.string.quote7);
                break;
            case 8:
                randQuote = getString(R.string.quote8);
                break;
            case 9:
                randQuote = getString(R.string.quote9);
                break;
            case 10:
                randQuote = getString(R.string.quote10);
                break;
            case 11:
                randQuote = getString(R.string.quote11);
                break;
        }
        textQuote.setText(randQuote);
    }

}
