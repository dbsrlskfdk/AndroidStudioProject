package com.example.week12_practice_8_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.compose.ui.graphics.Matrix;

public class myPictureView extends View {
    String imagePath = null;
    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            int w = bitmap.getWidth();
            int h = bitmap.getHeight();
            Rect src = new Rect(0, 0, w, h);
            Rect dst = new Rect(0, 0, w/2, 400+h/2);
            canvas.drawBitmap(bitmap, src, dst, null);
            bitmap.recycle();
        }
    }
}
