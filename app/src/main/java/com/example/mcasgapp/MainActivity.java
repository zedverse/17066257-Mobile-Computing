package com.example.mcasgapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();
    int number1 = r.nextInt(4);
    int number2 = r.nextInt(4);
    int result = 0;
    TextView num1TextView, num2TextView, ansTextView;



//    private TextView qNo1TextView;
//    qNo1TextView = (TextView)findViewById(R.id.qNo1);

//    private TextView qNo2TextView = (TextView)findViewById(R.id.n2);
//    private TextView ansTextView = (TextView)findViewById(R.id.ans);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1TextView = (TextView)findViewById(R.id.n1);
        num2TextView = (TextView)findViewById(R.id.n2);
        ansTextView = (TextView)findViewById(R.id.ans);
        MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.music);
        ring.start();
        randomCheck();
        // for dragging apple objects
        ImageView ap1 = (ImageView) findViewById(R.id.apple1);
        ap1.setOnTouchListener(handleTouch);
        ImageView ap2 = (ImageView) findViewById(R.id.apple2);
        ap2.setOnTouchListener(handleTouch);
        ImageView ap3 = (ImageView) findViewById(R.id.apple3);
        ap3.setOnTouchListener(handleTouch);
        ImageView ap4 = (ImageView) findViewById(R.id.apple4);
        ap4.setOnTouchListener(handleTouch);
        ImageView ap5 = (ImageView) findViewById(R.id.apple5);
        ap5.setOnTouchListener(handleTouch);
        ImageView ap6 = (ImageView) findViewById(R.id.apple6);
        ap6.setOnTouchListener(handleTouch);
        ImageView ap7 = (ImageView) findViewById(R.id.apple7);
        ap7.setOnTouchListener(handleTouch);
        ImageView ap8 = (ImageView) findViewById(R.id.apple8);
        ap8.setOnTouchListener(handleTouch);
        ImageView ap9 = (ImageView) findViewById(R.id.apple9);
        ap9.setOnTouchListener(handleTouch);

        //for buttons
        ImageButton btn0 = (ImageButton) findViewById(R.id.imageButton0);
        btn0.setTag(new Integer(0));

        btn0.setOnClickListener(handleClick);

        ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton1);
        btn1.setTag(new Integer(1));
        btn1.setOnClickListener(handleClick);

        ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton2);
        btn2.setTag(new Integer(2));
        btn2.setOnClickListener(handleClick);

        ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton3);
        btn3.setTag(new Integer(3));
        btn3.setOnClickListener(handleClick);

        ImageButton btn4 = (ImageButton) findViewById(R.id.imageButton4);
        btn4.setTag(new Integer(4));
        btn4.setOnClickListener(handleClick);

        ImageButton btn5 = (ImageButton) findViewById(R.id.imageButton5);
        btn5.setTag(new Integer(5));
        btn5.setOnClickListener(handleClick);

        ImageButton btn6 = (ImageButton) findViewById(R.id.imageButton6);
        btn6.setTag(new Integer(6));
        btn6.setOnClickListener(handleClick);

        ImageButton btn7 = (ImageButton) findViewById(R.id.imageButton7);
        btn7.setTag(new Integer(7));
        btn7.setOnClickListener(handleClick);

        ImageButton btn8 = (ImageButton) findViewById(R.id.imageButton8);
        btn8.setTag(new Integer(8));
        btn8.setOnClickListener(handleClick);

        ImageButton btn9 = (ImageButton) findViewById(R.id.imageButton9);
        btn9.setTag(new Integer(9));
        btn9.setOnClickListener(handleClick);


        ImageButton playBtn = (ImageButton) findViewById(R.id.playButton);
        ImageView thumb = (ImageView) findViewById(R.id.thumb);
        ImageView str1 = (ImageView) findViewById(R.id.star1);
        ImageView str2 = (ImageView) findViewById(R.id.star2);

        playBtn.setOnClickListener(restPlay);
        playBtn.setVisibility(View.INVISIBLE);
        thumb.setVisibility(View.INVISIBLE);
        str1.setVisibility(View.INVISIBLE);
        str2.setVisibility(View.INVISIBLE);
    }

    private View.OnTouchListener handleTouch = new View.OnTouchListener() {
        float dX, dY;
        @Override
        public boolean onTouch(View view, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    view.animate()
                            .x(event.getRawX() + dX)
                            .y(event.getRawY() + dY)
                            .setDuration(0)
                            .start();
                    break;
                default:
                    return false;
            }
            return true;
        }
    };

    private void randomCheck(){
        Random myRandom = new Random();
        int num1 = myRandom.nextInt(4);
        int num2 = myRandom.nextInt(4);
        result  = num1+num2;
        num1TextView.setText(String.valueOf(num1));
        num2TextView.setText(String.valueOf(num2));




        //qNo1TextView.setText(""+first_number);
//        qNo2TextView.setText(""+second_number);
//
    }

     public void animate(){
         ImageButton playBtn = (ImageButton) findViewById(R.id.playButton);
         ImageView thumb = (ImageView) findViewById(R.id.thumb);
         ImageView str1 = (ImageView) findViewById(R.id.star1);
         ImageView str2 = (ImageView) findViewById(R.id.star2);


         playBtn.setVisibility(View.VISIBLE);
         thumb.setVisibility(View.VISIBLE);
         str1.setVisibility(View.VISIBLE);
         str2.setVisibility(View.VISIBLE);
     }

    private final View.OnClickListener handleClick = new View.OnClickListener() {


        //int temp;
        @Override
        public void onClick(View v) {
            int temp = (int) v.getTag();
            //Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();


            if (temp == result) {
                ansTextView.setText(String.valueOf(result));
                Toast.makeText(MainActivity.this, "Well done, Correct answer!", Toast.LENGTH_SHORT).show();
                animate();
//                answer.setText(String.valueOf(result));
//                Intent intent = new Intent(MainActivity.this, finishingActivity.class);
//                startActivity(intent);
//                ansTextView.setText(""+ result);
            } else {
                Toast.makeText(MainActivity.this, "Incorrect button", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private View.OnClickListener restPlay = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            randomCheck();
            ansTextView.setText("?");
            ImageButton playBtn = (ImageButton) findViewById(R.id.playButton);
            ImageView thumb = (ImageView) findViewById(R.id.thumb);
            ImageView str1 = (ImageView) findViewById(R.id.star1);
            ImageView str2 = (ImageView) findViewById(R.id.star2);
            playBtn.setVisibility(View.INVISIBLE);
            thumb.setVisibility(View.INVISIBLE);
            str1.setVisibility(View.INVISIBLE);
            str2.setVisibility(View.INVISIBLE);
        }
    };



}