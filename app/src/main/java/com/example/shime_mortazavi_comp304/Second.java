package com.example.shime_mortazavi_comp304;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Second extends AppCompatActivity {

    CheckBox check1,check2,check3;
    Bitmap bitmap1,bitmap2;
    ImageView img,img3,img4;
    Canvas canvas;
    Button btn_Tesla,btn_Bitcoin,btn_Gold;
    public static TextView data;
    int values [];

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        check1 = (CheckBox)findViewById(R.id.ch1);
        check2 = (CheckBox)findViewById(R.id.ch2);
        check3 = (CheckBox)findViewById(R.id.ch3);
        btn_Tesla=(Button)findViewById(R.id.btn_Tesla);
        btn_Bitcoin=(Button)findViewById(R.id.btn_Bitcoin);
        btn_Gold=(Button)findViewById(R.id.btn_Gold);
        data=(TextView)findViewById(R.id.textView4);



        Paint paint = new Paint();

        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);

        //create the big image view to show memory map
        img = (ImageView) findViewById(R.id.img);

        bitmap1 = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap1);
        //set canvas background
        canvas.drawColor(Color.BLACK);
        String teslaArray[] = getResources().getStringArray(R.array.stock);
        int stopx=50;
        int startx=0;
       // canvas.drawLine(0, Integer.parseInt((String)Array.get(teslaArray, 0)), stopx,Integer.parseInt((String)Array.get(teslaArray, 1)), paint);
        for(int i=0;i<teslaArray.length-1;i++) {
            canvas.drawLine(startx, Integer.parseInt((String)Array.get(teslaArray, i)), stopx,Integer.parseInt((String)Array.get(teslaArray, i+1)), paint);
            startx=stopx;
            stopx=stopx+50;
        }
        img.setImageBitmap(bitmap1);
        img.draw(canvas);

        img.setVisibility(View.INVISIBLE);

        //Bitcoin
        img4 = (ImageView) findViewById(R.id.img4);

        bitmap1 = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap1);
        //set canvas background
        canvas.drawColor(Color.BLACK);
        String bitcoinArray[] = getResources().getStringArray(R.array.bitcoin);

        int stopx1=50;
        int startx1=0;
        // canvas.drawLine(0, Integer.parseInt((String)Array.get(teslaArray, 0)), stopx,Integer.parseInt((String)Array.get(teslaArray, 1)), paint);
        for(int i=0;i<bitcoinArray.length-1;i++) {
            canvas.drawLine(startx1, Integer.parseInt((String)Array.get(bitcoinArray, i)), stopx1,Integer.parseInt((String)Array.get(bitcoinArray, i+1)), paint);
            startx1=stopx1;
            stopx1=stopx1+50;
        }

/*
        canvas.drawLine(0,450,50,400,paint);
        canvas.drawLine(50,400,100,500,paint);
        canvas.drawLine(100,500,150,380,paint);
        canvas.drawLine(150,380,200,420,paint);
        canvas.drawLine(200,420,250,310,paint);
        canvas.drawLine(250,310,300,370,paint);
        canvas.drawLine(300,370,350,450,paint);
        canvas.drawLine(350,450,400,300,paint);
        canvas.drawLine(400,300,450,320,paint);
        canvas.drawLine(450,320,500,200,paint);
        canvas.drawLine(500,200,550,280,paint);*/

        img4.setImageBitmap(bitmap1);
        img4.draw(canvas);
        img4.setVisibility(View.INVISIBLE);

        ///////GOLD//////////

        img3 = (ImageView) findViewById(R.id.img3);

        bitmap1 = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap1);
        //set canvas background
        canvas.drawColor(Color.BLACK);

        FetchData process=new FetchData();
        process.execute();

        values = process.myArray;
        int stopx3=50;
        int startx3=0;
        int startY = 0;
        int stopY = 0;
        // canvas.drawLine(0, Integer.parseInt((String)Array.get(teslaArray, 0)), stopx,Integer.parseInt((String)Array.get(teslaArray, 1)), paint);
        for(int i=0;i<3;i++) {
            startY = values[i];
            stopY = values[i+1];
            /*canvas.drawLine(50, 0, 50,50, paint);
            canvas.drawLine(50, 470, 150,450, paint);
            canvas.drawLine(150, 450, 200,550, paint);*/
            canvas.drawLine(startx3, startY, stopx3,stopY, paint);
            startx3=stopx3;
            stopx3=stopx3+50;
        }

        img3.setImageBitmap(bitmap1);
        img3.draw(canvas);
        //img4.setVisibility(View.VISIBLE);

        img3.setVisibility(View.INVISIBLE);


        btn_Tesla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img3.setVisibility(View.INVISIBLE);
                img.setVisibility(View.VISIBLE);
                img4.setVisibility(View.INVISIBLE);
            }
        });


        btn_Bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.VISIBLE);
                img3.setVisibility(View.INVISIBLE);
            }
        });


        
        btn_Gold.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                img.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.VISIBLE);

                /*FetchData process=new FetchData();
                process.execute();

                values = process.myArray;
                int stopx3=50;
                int startx3=0;
                // canvas.drawLine(0, Integer.parseInt((String)Array.get(teslaArray, 0)), stopx,Integer.parseInt((String)Array.get(teslaArray, 1)), paint);
                for(int i=1;i<values.length-1;i++) {
                    canvas.drawLine(startx3, values[i], stopx3,values[i+1], paint);
                    startx3=stopx3;
                    stopx3=stopx3+50;
                }

                img4.setImageBitmap(bitmap1);
                img4.draw(canvas);
                img4.setVisibility(View.VISIBLE);*/


            }
        });


        //    String teslaArray[] = getResources().getStringArray(R.array.stock);
    }

    public void showTost(View v)

    {
        String textMessage =   (check1.isChecked() ? check1.getText().toString() : "" )+"\n"+
                (check2.isChecked() ? check2.getText().toString() : "" )+"\n"+
                (check3.isChecked() ? check3.getText().toString() : "" )+"\n"
        ;
        Toast.makeText(this, textMessage, Toast.LENGTH_SHORT).show();

    }

}