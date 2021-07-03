package com.example.mcasgapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();
    int number1 = r.nextInt(4);
    int number2 = r.nextInt(4);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        ImageButton btn0 = (ImageButton) findViewById(R.id.button0);
        btn0.setTag(new Integer(0));
        btn0.setOnClickListener(handleTouch);

        ImageButton btn1 = (ImageButton) findViewById(R.id.button1);
        btn1.setTag(new Integer(1));
        btn1.setOnClickListener(handleTouch);

        ImageButton btn2 = (ImageButton) findViewById(R.id.button2);
        btn2.setTag(new Integer(2));
        btn2.setOnClickListener(handleTouch);

        ImageButton btn3 = (ImageButton) findViewById(R.id.button3);
        btn3.setTag(new Integer(3));
        btn3.setOnClickListener(handleTouch);

        ImageButton btn4 = (ImageButton) findViewById(R.id.button4);
        btn4.setTag(new Integer(4));
        btn4.setOnClickListener(handleTouch);

        ImageButton btn5 = (ImageButton) findViewById(R.id.button5);
        btn5.setTag(new Integer(5));
        btn5.setOnClickListener(handleTouch);

        ImageButton btn6 = (ImageButton) findViewById(R.id.button6);
        btn6.setTag(new Integer(6));
        btn6.setOnClickListener(handleTouch);

        ImageButton btn7 = (ImageButton) findViewById(R.id.button7);
        btn7.setTag(new Integer(7));
        btn7.setOnClickListener(handleTouch);

        ImageButton btn8 = (ImageButton) findViewById(R.id.button8);
        btn8.setTag(new Integer(8));
        btn8.setOnClickListener(handleTouch);

        ImageButton btn9 = (ImageButton) findViewById(R.id.button9);
        btn9.setTag(new Integer(9));
        btn9.setOnClickListener(handleTouch);


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

    private View.OnClickListener handleClick = new View.OnClickListener() {
        int temp;
        @Override
        public void onClick(View v) {
            temp = (int) v.getTag();

            TextView answer = (TextView)  findViewById(R.id.summation);
            Toast.makeText(MainActivity.this, "button clicked", Toast.LENGTH_SHORT).show();

            if (bt == result) {
                answer.setText(String.valueOf(result));
                Intent intent = new Intent(MainActivity.this, finishingActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(MainActivity.this, "button clicked not correct", Toast.LENGTH_SHORT).show();
            }
        }
    };

}