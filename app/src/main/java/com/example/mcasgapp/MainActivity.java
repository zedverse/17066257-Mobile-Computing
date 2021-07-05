package com.example.mcasgapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
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
    TextView num1TextView, num2TextView, ansTextView, outputTextView;
    MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1TextView = (TextView)findViewById(R.id.n1);
        num2TextView = (TextView)findViewById(R.id.n2);
        ansTextView = (TextView)findViewById(R.id.ans);
        outputTextView= (TextView)findViewById(R.id.output);

        ring = MediaPlayer.create(MainActivity.this,R.raw.music); // set music for app
        ring.start(); // for sound appeal
        ring.setLooping(true);
        randomCheck(); // for generating random quiz
        hideAnimation(); // to hide the Winning view
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
        ansTextView.setText("?");

 }

     public void showAnimation(){// for starting animation


         View winView = (View) findViewById(R.id.winView);
         ImageButton playBtn = (ImageButton) findViewById(R.id.playButton);
         ImageView thumb = (ImageView) findViewById(R.id.thumb);
         ImageView str1 = (ImageView) findViewById(R.id.star1);
         ImageView str2 = (ImageView) findViewById(R.id.star2);
         ImageView str3 = (ImageView) findViewById(R.id.star3);
         winView.setVisibility(View.VISIBLE);
         playBtn.setVisibility(View.VISIBLE);
         thumb.setVisibility(View.VISIBLE);
         str1.setVisibility(View.VISIBLE);
         str2.setVisibility(View.VISIBLE);
         str3.setVisibility(View.VISIBLE);


         ScaleAnimation scale = new ScaleAnimation(0, 2, 0, 2);
         scale.setDuration(7200);
         thumb.startAnimation(scale);



         RotateAnimation rotate = new RotateAnimation(0, 300);
         rotate.setDuration(7200);
         str1.startAnimation(rotate);

          

         TranslateAnimation trans = new TranslateAnimation(0, 200, 0, 100);
         trans.setDuration(7200);
         str2.startAnimation(trans);



         AlphaAnimation alpha = new AlphaAnimation(0, 1);
         alpha.setDuration(7200);
         str3.startAnimation(alpha);



     }

    public void hideAnimation() {// for starting animation

        View winView = (View) findViewById(R.id.winView);
        ImageButton playBtn = (ImageButton) findViewById(R.id.playButton);
        ImageView thumb = (ImageView) findViewById(R.id.thumb);
        ImageView str1 = (ImageView) findViewById(R.id.star1);
        ImageView str2 = (ImageView) findViewById(R.id.star2);
        ImageView str3 = (ImageView) findViewById(R.id.star3);

        playBtn.setOnClickListener(restPlay);
        playBtn.setVisibility(View.INVISIBLE);
        winView.setVisibility(View.INVISIBLE);
        thumb.setVisibility(View.INVISIBLE);
        str1.setVisibility(View.INVISIBLE);
        str2.setVisibility(View.INVISIBLE);
        str3.setVisibility(View.INVISIBLE);
    }

    public void clearAnimation() {// for stopping animation

        View winView = (View) findViewById(R.id.winView);
        ImageButton playBtn = (ImageButton) findViewById(R.id.playButton);
        ImageView thumb = (ImageView) findViewById(R.id.thumb);
        ImageView str1 = (ImageView) findViewById(R.id.star1);
        ImageView str2 = (ImageView) findViewById(R.id.star2);
        ImageView str3 = (ImageView) findViewById(R.id.star3);


        playBtn.clearAnimation();
        winView.clearAnimation();
        thumb.clearAnimation();
        str1.clearAnimation();
        str2.clearAnimation();
        str3.clearAnimation();
    }


        private  View.OnClickListener handleClick = new View.OnClickListener() {



        @Override
        public void onClick(View v) {

            int temp = (int) v.getTag();
            outputTextView.clearAnimation();
//            Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();


            if (temp == result) {

                Toast.makeText(MainActivity.this, "Well done, Correct answer!", Toast.LENGTH_SHORT).show();
                ansTextView.setText(String.valueOf(result));
                outputTextView.setText("Well done, Last answer was Correct!");
                showAnimation();



            } else {

                Toast.makeText(MainActivity.this, "Incorrect button", Toast.LENGTH_SHORT).show();
                outputTextView.setText("Sorry, Incorrect answer!");
            }

            AlphaAnimation fadeOut = new AlphaAnimation(1, 0);
            fadeOut.setDuration(500);
            outputTextView.startAnimation(fadeOut);
        }
    };

    private View.OnClickListener restPlay = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            randomCheck();
            clearAnimation();
            hideAnimation();
        }
    };



}