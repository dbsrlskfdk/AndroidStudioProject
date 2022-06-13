package com.example.week12_doyourself_9_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibBlur, ibEmbossing;
    MyGraphicView graphicView;
    static boolean blur = false, emboss = false;
    static float scaleX = 1, scaleY=1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("미니 포토샵");


        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }
    private void clickIcons(){
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });
        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                color = color + 0.2f;
                satur = satur + .5f;
                graphicView.invalidate();
            }
        });
        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                color = color - 0.2f;
                satur = satur - .5f;
                graphicView.invalidate();
            }
        });
        ibBlur = (ImageButton) findViewById(R.id.ibBlur);
        ibBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blur == true){
                    blur = false;
                }else{
                    blur = true;
                }
                graphicView.invalidate();
            }
        });
        ibEmbossing = (ImageButton) findViewById(R.id.ibEmbossing);
        ibEmbossing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emboss == true){
                    emboss = false;
                }else{
                    emboss = true;
                }
                graphicView.invalidate();
            }
        });
    }
    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // 이미지 확대 축소
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);

            // 이미지 회전
            canvas.rotate(angle, cenX, cenY);

            //이미지 밝기 조절
            Paint paint = new Paint();
            float[] array = {color      , 0     , 0     , 0     , 0 ,
                    0          , color , 0     , 0     , 0 ,
                    0          , 0     , color , 0     , 0 ,
                    0          , 0     , 0     , 1     , 0 };
            ColorMatrix cm = new ColorMatrix(array);
            cm.setSaturation(satur); // For ibGray method
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            //블러링
            if (blur == true){
                BlurMaskFilter bMask;
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(bMask);
            }

            // 엠보싱
            if (emboss == true){
                EmbossMaskFilter eMask;
                eMask = new EmbossMaskFilter(new float[]{3, 3, 3}, 0.5f, 5, 10);
                paint.setMaskFilter(eMask);
            }


            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.cat);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();

        }

    }

}