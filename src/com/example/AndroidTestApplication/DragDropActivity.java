package com.example.AndroidTestApplication;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class DragDropActivity extends Activity implements View.OnDragListener, View.OnTouchListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_drop);
        findViewById(R.id.textView).setOnTouchListener(this);
        findViewById(R.id.textView1).setOnTouchListener(this);
        findViewById(R.id.textView2).setOnTouchListener(this);
        findViewById(R.id.textView3).setOnTouchListener(this);

        TextView target = (TextView) findViewById(R.id.target);
        target.setOnDragListener(this);
    }

    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            DragShadow dragShadow = new DragShadow(v);
            v.startDrag(data, dragShadow, v, 0);
        }
        return true;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {

        int action = event.getAction();
        switch (action) {
            case DragEvent.ACTION_DROP:
                TextView targetView = (TextView) v;
                TextView textView = (TextView) event.getLocalState();
                targetView.setText(textView.getText());
                break;


        }

        return true;
    }

    private class DragShadow extends View.DragShadowBuilder {

        ColorDrawable box;

        public DragShadow(View view) {
            super(view);
            box = new ColorDrawable(Color.LTGRAY);
        }

        @Override
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            super.onProvideShadowMetrics(shadowSize, shadowTouchPoint);

            View view = getView();
            int height = view.getHeight() / 2;
            int width = view.getWidth() / 2;

            box.setBounds(0, 0, width, height);
            shadowSize.set(width, height);

            shadowTouchPoint.set(width / 2, height / 2);

        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            super.onDrawShadow(canvas);
            box.draw(canvas);
        }
    }
}
