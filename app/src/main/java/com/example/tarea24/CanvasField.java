package com.example.tarea24;

import android.graphics.Canvas;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CanvasField extends View{

    float x,y;
    int option;
    Paint paint= new Paint();
    Path path = new Path();

    public CanvasField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);

    }

    protected void onDraw (Canvas canvas){
        canvas.drawColor(Color.WHITE);
        if (option ==1){
            path.moveTo(x,y);
        }
        if (option ==2){
            path.lineTo(x,y);
        }
        canvas.drawPath(path,paint);

    }


    public boolean onTouchEvent (MotionEvent event) {
        int accion = event.getAction();
        x= event.getX();
        y= event.getY();
        if (accion== MotionEvent.ACTION_DOWN){
            option = 1;
        }
        if (accion== MotionEvent.ACTION_MOVE){
            option = 2;
        }
        invalidate();
        return true;

    }
}
