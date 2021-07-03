package com.example.mcasgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;        //for View
import android.widget.ImageView; // for linking the ImageView object
import android.view.MotionEvent; //for touch and drag event


public class MainActivity extends AppCompatActivity {

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

}