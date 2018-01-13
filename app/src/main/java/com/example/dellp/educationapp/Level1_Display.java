package com.example.dellp.educationapp;

import android.view.View;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Pierre on 13/1/2018.
 */

public class Level1_Display  extends View{


    private static final float DP_PER_SECONDS = 10;

    private final float mBallCirfumference;
    private final float mBallRadius;
    private final Bitmap mBallBitmap;
    private final Paint mBallBitmapPaint;
    private final Matrix mBallTransformMatrix = new Matrix();
    private final float mPxPerSecond;

    private long mStartTime = -1;

    public Level1_Display(Context context) {
        super(context);
        final Resources res = getResources();

        // Load the ball bitmap. You probably want to use a better bitmap ;)
        mBallBitmap = BitmapFactory.decodeResource(res, R.drawable.small_ball);

        // We need the radius and circumference of the ball for our calculations
        // later
        mBallRadius = mBallBitmap.getHeight() / 2;
        mBallCirfumference = mBallRadius * 2 * (float)Math.PI;

        // Create ourself a paint object so we can adjust the quality of the
        // bitmap drawing
        mBallBitmapPaint = new Paint();

        // Significantly improves quality when drawing transformed bitmaps. Compare
        // with when you disable this, which is the default
        mBallBitmapPaint.setFilterBitmap(true);

        // Calculate speed of ball in pixels
        mPxPerSecond = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DP_PER_SECONDS,
                res.getDisplayMetrics());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Calculate how far into the animation we are
        if (mStartTime == -1) {
            mStartTime = getDrawingTime();
        }
        long currentTime = getDrawingTime();
        float secondsPassed = (currentTime - mStartTime) / 1000.0f;

        // Calculate how far the ball has moved and how many degrees it has been
        // rotated as a consequence of the movement
        float movedDistance = secondsPassed * mPxPerSecond;
        float fullRotationsMade = movedDistance / mBallCirfumference;
        float rotationInDegrees = fullRotationsMade * 360;

        // Setup the transformation matrix to simulate a rolling ball
        mBallTransformMatrix.reset();
        mBallTransformMatrix.postRotate(rotationInDegrees, mBallRadius, mBallRadius);
        mBallTransformMatrix.postTranslate(movedDistance, 0);
        canvas.drawBitmap(mBallBitmap, mBallTransformMatrix, mBallBitmapPaint);

        // Force redraw so we get an animation
        invalidate();
    }

}
