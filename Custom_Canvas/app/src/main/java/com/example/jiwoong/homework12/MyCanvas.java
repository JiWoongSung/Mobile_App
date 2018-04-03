package com.example.jiwoong.homework12;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


/**
 * Created by jiwoong on 2017. 5. 18..
 */


public class MyCanvas extends View {

    CheckBox checkbox;
    String operationType = "";
    Bitmap mBitmap;
    Canvas mCanvas;


    Paint mPaint = new Paint();


    public MyCanvas(Context context) {
        super(context);
        this.setLayerType(LAYER_TYPE_SOFTWARE, null); // 이거 해줘야 블러링 먹음
    }


    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888); // 메모리상
        mCanvas = new Canvas();
        mCanvas.setBitmap(mBitmap);
        mCanvas.drawColor(Color.YELLOW);

    }

    private void drawStamp() {  // 스템프 모양을 그림

        Bitmap img = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher);
        Paint paint = new Paint();


        if (operationType.equals("rotate")) {
            Toast.makeText(getContext(), "회전", Toast.LENGTH_SHORT).show();

            Matrix matrixRotate = new Matrix();
            matrixRotate.postRotate(30);
            Bitmap imgRotate = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrixRotate, false);
            mCanvas.drawBitmap(imgRotate, startX - imgRotate.getWidth() / 2, startY - imgRotate.getHeight() / 2, paint);
            imgRotate.recycle();


        } else if (operationType.equals("move")) {
            Toast.makeText(getContext(), "move", Toast.LENGTH_SHORT).show();

            mCanvas.drawBitmap(img, (startX - img.getWidth() / 2) + 100, (startY - img.getHeight() / 2) + 100, mPaint);
            img.recycle();

        } else if (operationType.equals("scale")) {
            Toast.makeText(getContext(), "scale", Toast.LENGTH_SHORT).show();

            Bitmap imgBig = Bitmap.createScaledBitmap(img, img.getWidth() * 3 / 2, img.getHeight() * 3 / 2, false);
            mCanvas.drawBitmap(imgBig, startX - imgBig.getWidth() / 2, startY - imgBig.getHeight() / 2, mPaint);
            imgBig.recycle();

        } else if (operationType.equals("skew")) {
            Toast.makeText(getContext(), "skew", Toast.LENGTH_SHORT).show();

            Matrix matrixSkew = new Matrix();
            matrixSkew.postSkew(0.2f, 0);
            Bitmap imgSkew = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrixSkew, false);
            mCanvas.drawBitmap(imgSkew, startX - imgSkew.getWidth() / 2, startY - imgSkew.getHeight() / 2, mPaint);
            imgSkew.recycle();
        }

        else{
            mCanvas.drawBitmap(img, startX - img.getWidth() / 2, startY - img.getHeight() / 2, mPaint);



        }
    }

    @Override
    protected void onDraw(Canvas canvas) {  //캔버스에 그리고자 하는것
        super.onDraw(canvas);

        if (mBitmap != null)
            canvas.drawBitmap(mBitmap, 0, 0, null);

        if(operationType.equals("eraser")){

            clear();

        }



        if(operationType.equals("save")){

        }




        if (operationType.equals("coloring")) {

            Toast.makeText(getContext(), "coloring", Toast.LENGTH_SHORT).show();
            float[] array = {

                    2, 0, 0, 0, -25f,
                    0, 2, 0, 0, -25f,
                    0, 0, 2, 0, -25f,
                    0, 0, 0, 2, 0

            };

            ColorMatrix matrix = new ColorMatrix(array);
            mPaint.setColorFilter(new ColorMatrixColorFilter(matrix));

        }

        if (operationType.equals("nocoloring")) {

            Toast.makeText(getContext(), "nocoloring", Toast.LENGTH_SHORT).show();
            float[] array = {

                    1, 0, 0, 0, -25f,
                    0, 1, 0, 0, -25f,
                    0, 0, 1, 0, -25f,
                    0, 0, 0, 1, 0

            };

            ColorMatrix matrix = new ColorMatrix(array);
            mPaint.setColorFilter(new ColorMatrixColorFilter(matrix));

        }


        if (operationType.equals("bluring")) {

            Toast.makeText(getContext(), "bluring", Toast.LENGTH_SHORT).show();
            BlurMaskFilter blur = new BlurMaskFilter(100, BlurMaskFilter.Blur.INNER); //블러링
            mPaint.setMaskFilter(blur);  // 블러링

        }

        if (operationType.equals("nobluring")) {

            Toast.makeText(getContext(), "nobluring", Toast.LENGTH_SHORT).show();
            BlurMaskFilter blur = new BlurMaskFilter(1, BlurMaskFilter.Blur.INNER); //블러링
            mPaint.setMaskFilter(blur);


        }

        if (operationType.equals("big")) {

            Toast.makeText(getContext(), "big", Toast.LENGTH_SHORT).show();

            mPaint.setStrokeWidth(5);


        }

        if (operationType.equals("nobig")) {

            Toast.makeText(getContext(), "nobig", Toast.LENGTH_SHORT).show();

            mPaint.setStrokeWidth(3);

        }

        if (operationType.equals("red")) {

            mPaint.setColor(Color.RED);

        }

        if (operationType.equals("blue")) {

            mPaint.setColor(Color.BLUE);

        }


    }


    float startX = -1, startY = -1;
    int oldX = -1;
    int oldY = -1;


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int X = (int) event.getX();
        int Y = (int) event.getY();


        if (MainActivity.check == true) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                startX = X;
                startY = Y;
                drawStamp();
                invalidate();  //화면을 무효화하여 onDraw함수를 호출
            }
        } else {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {


                oldX = X;
                oldY = Y;

            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                if (oldX != -1) {
                    mCanvas.drawLine(oldX, oldY, X, Y, mPaint);
                    invalidate();
                    oldX = X;
                    oldY = Y;
                }

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                if (oldX != -1) {
                    mCanvas.drawLine(oldX, oldY, X, Y, mPaint);
                    invalidate();
                }
                oldX = -1;
                oldY = -1;
            }
            mPaint.setStrokeWidth(3);

        }
        return true;

    }


    public void setOperationType(String operationType) {
        this.operationType = operationType;
        invalidate();

    }

    public void clear() {
        mBitmap.eraseColor(Color.WHITE);
        invalidate();
    }

}

