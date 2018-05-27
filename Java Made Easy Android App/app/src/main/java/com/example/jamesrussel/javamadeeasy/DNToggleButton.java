/**
 * Copyright 2015, 2016 andy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jamesrussel.javamadeeasy;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Checkable;


public class DNToggleButton extends View implements Checkable {

    private static final String KEY_INSTANCE_STATE = "KEY_INSTANCE_STATE";
    private static final int DEFAULT_DURATION = 350;

    private static final int DEFAULT_WIDTH    = 80;
    private static final int DEFAULT_HEIGHT   = 40;
    private static final int DEFAULT_FLOOR_STROKE_WIDTH = 3;

    private static final int COLOR_CHECKED_FLOOR = Color.parseColor("#80CBC4");
    private static final int COLOR_UNCHECKED_FLOOR = Color.parseColor("#ffe5e5e5");
    private static final int COLOR_CHECKED_BALL = Color.parseColor("#FEDA5A");
    private static final int COLOR_UNCHECKED_BALL = Color.parseColor("#FFFFFF");
    private static final int COLOR_CHECKED_BALL_STROKE = Color.parseColor("#D9B939");
    private static final int COLOR_UNCHECKED_BALL_STROKE = Color.parseColor("#DCDEBB");
    private static final int COLOR_CHECKED_BALL_SHADOW = Color.parseColor("#D9B939");
    private static final int COLOR_UNCHECKED_BALL_SHADOW = Color.parseColor("#DCE2BB");
    private static final int COLOR_CHECKED_FLOOR_STROKE = Color.parseColor("#71B6CE");
    private static final int COLOR_UNCHECKED_FLOOR_STROKE = Color.parseColor("#000000");

    private int mDuration;
    private int mBallRadius;
    private int mFloorRadius;

    private float mProgress;
    private boolean mChecked;
    private RectF mFloorRect;
    private RectF mBallRect; // The shadow follow with the ball

    private Point mBallCenterPoint;
    private Paint mBallPaint, mFloorPaint, mShadowPaint, mCircleStrokePaint;

    private ValueAnimator mAnimator;
    private OnCheckedChangeListener mListener;

    public DNToggleButton(Context context) {
        this(context, null);
    }

    public DNToggleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DNToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DNToggleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putBoolean(KEY_INSTANCE_STATE, isChecked());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            boolean isChecked = bundle.getBoolean(KEY_INSTANCE_STATE);
            setChecked(isChecked);
            super.onRestoreInstanceState(bundle.getParcelable(KEY_INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.DNToggleButton);
        mDuration = ta.getInt(R.styleable.DNToggleButton_duration, DEFAULT_DURATION);
        ta.recycle();

        initValues();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnimator != null && mAnimator.isRunning()) {
                    return;
                }
                setChecked(!isChecked(), true);
            }
        });
    }

    private void initValues() {
        mBallPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBallPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mBallPaint.setStrokeCap(Paint.Cap.ROUND);
        mBallPaint.setStrokeWidth(3);
        mBallPaint.setColor(COLOR_UNCHECKED_BALL);

        mFloorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mFloorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mFloorPaint.setStrokeCap(Paint.Cap.ROUND);
        mFloorPaint.setColor(COLOR_UNCHECKED_FLOOR);

        mShadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mShadowPaint.setStyle(Paint.Style.FILL);
        mShadowPaint.setColor(COLOR_UNCHECKED_BALL_SHADOW);

        mCircleStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircleStrokePaint.setStyle(Paint.Style.STROKE);
        mCircleStrokePaint.setColor(COLOR_UNCHECKED_BALL_STROKE);

        mBallCenterPoint = new Point();
    }

    private void startCheckedAnim() {
        if (mAnimator != null) {
            mAnimator.cancel();
            mAnimator = null;
        }
        mAnimator = ValueAnimator.ofFloat(0f, 1.0f);
        mAnimator.setDuration(mDuration);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mBallCenterPoint.x = (int) (((mBallRadius + 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH))
                                     + (getMeasuredWidth() - 2 * (mBallRadius + 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH))) * mProgress));
                postInvalidate();
            }
        });
        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (mListener != null) {
                    mListener.onCheckedChanged(DNToggleButton.this, isChecked());
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        mAnimator.start();

    }

    private void startUnCheckedAnim() {
        if (mAnimator != null) {
            mAnimator.cancel();
            mAnimator = null;
        }
        mAnimator = ValueAnimator.ofFloat(1.0f, 0f);
        mAnimator.setDuration(mDuration);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mBallCenterPoint.x = (int) ((mBallRadius + 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH))
                        + (getMeasuredWidth() - 2 * (mBallRadius + 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH))) * mProgress);
                postInvalidate();
            }
        });
        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (mListener != null) {
                    mListener.onCheckedChanged(DNToggleButton.this, isChecked());
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        mAnimator.start();
    }

    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;
        mProgress = checked ? 1.0f : 0.0f;
        mBallCenterPoint.x = (int) ((mBallRadius + 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH))
                + (getMeasuredWidth() - 2 * (mBallRadius + 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH))) * mProgress);
        invalidate();

        if (mListener != null) {
            mListener.onCheckedChanged(DNToggleButton.this, isChecked());
        }
    }

    public void setChecked(boolean checked, boolean animate) {
        if (animate) {
            mChecked = checked;
            if (checked) {
                startCheckedAnim();
            } else {
                startUnCheckedAnim();
            }
        } else {
            this.setChecked(checked);
        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureSize(dp2px(DEFAULT_WIDTH), widthMeasureSpec);
        int height = measureSize(dp2px(DEFAULT_HEIGHT), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // initialization
        mBallRadius = (int) ((getMeasuredHeight() - dp2px(6)) * 0.5) - dp2px(DEFAULT_FLOOR_STROKE_WIDTH);
        mFloorRadius = (int) (Math.min(getMeasuredWidth(), getMeasuredHeight()) * 0.5);

        // ball initialization position
        mProgress = isChecked() ? 1.0f : 0.0f;

        mBallCenterPoint.x = (int) ((mBallRadius + 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH))
                + (getMeasuredWidth() - 2 * (mBallRadius + 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH))) * mProgress);
        mBallCenterPoint.y = (int) (getMeasuredHeight() * 0.5);

        mFloorRect = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());

        float ballRectLeft = 5.0f + dp2px(DEFAULT_FLOOR_STROKE_WIDTH);
        float ballRectTop = dp2px(3) + dp2px(DEFAULT_FLOOR_STROKE_WIDTH);
        float ballRectRight = 5 + dp2px(DEFAULT_FLOOR_STROKE_WIDTH) + 2 * mBallRadius;
        float ballRectBottom = getMeasuredHeight() - dp2px(3) - dp2px(DEFAULT_FLOOR_STROKE_WIDTH);
        mBallRect = new RectF(ballRectLeft, ballRectTop, ballRectRight, ballRectBottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawFloor(canvas);
        drawBall(canvas);
    }

    /**
     * draw floor
     * @param canvas canvas
     */
    private void drawFloor(Canvas canvas) {
        float floorProgress;
        if (isChecked()) {
            floorProgress = (mProgress * 4) < 1.0f ? (mProgress * 4) : 1.0f;
        } else {
            floorProgress = mProgress > 0.75f ? (1.0f - (1.0f - mProgress) * 4) : 0f;
        }
        mFloorPaint.setColor(isChecked() ? COLOR_CHECKED_FLOOR_STROKE : COLOR_UNCHECKED_FLOOR_STROKE);
        mFloorRect = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawRoundRect(mFloorRect, mFloorRadius, mFloorRadius, mFloorPaint);

        mFloorPaint.setColor(getGradientColor(COLOR_UNCHECKED_FLOOR, COLOR_CHECKED_FLOOR, floorProgress));
        mFloorRect.set(dp2px(DEFAULT_FLOOR_STROKE_WIDTH), dp2px(DEFAULT_FLOOR_STROKE_WIDTH),
                getMeasuredWidth() - dp2px(DEFAULT_FLOOR_STROKE_WIDTH), getMeasuredHeight() - dp2px(DEFAULT_FLOOR_STROKE_WIDTH));

        int radius = (int) (mFloorRadius - dp2px(DEFAULT_FLOOR_STROKE_WIDTH) * 0.5);
        canvas.drawRoundRect(mFloorRect, radius, radius, mFloorPaint);
    }

    /**
     * draw moving ball
     * @param canvas canvas
     */
    private void drawBall(Canvas canvas) {

        // The shadow follow the ball
        float ballRectLeft;
        float ballRectRight;
        if (isChecked()) {
            ballRectLeft = (float) ((mBallCenterPoint.x - mBallRadius) - (1 - 2 * Math.abs(0.5f - mProgress)) * 1.2 * mBallRadius);
            ballRectLeft = ballRectLeft < 5.0f + dp2px(DEFAULT_FLOOR_STROKE_WIDTH) ? 5.0f + dp2px(DEFAULT_FLOOR_STROKE_WIDTH) : ballRectLeft;
            ballRectRight = mBallCenterPoint.x + mBallRadius;
        } else {
            ballRectLeft = mBallCenterPoint.x - mBallRadius;
            ballRectRight = (float) ((mBallCenterPoint.x + mBallRadius) + (1 - 2 * Math.abs(0.5f - mProgress)) * 1.2 * mBallRadius);
            ballRectRight = ballRectRight > (getMeasuredWidth() - 5.0f - dp2px(DEFAULT_FLOOR_STROKE_WIDTH)) ? (getMeasuredWidth() - 5.0f - dp2px(DEFAULT_FLOOR_STROKE_WIDTH)) : ballRectRight;
        }
        mBallRect.set(ballRectLeft, mBallRect.top, ballRectRight, mBallRect.bottom);
        mShadowPaint.setColor(isChecked() ? COLOR_CHECKED_BALL_SHADOW : COLOR_UNCHECKED_BALL_SHADOW);
        canvas.drawRoundRect(mBallRect, mBallRadius, mBallRadius, mShadowPaint);

        // ball
        // stroke
        mCircleStrokePaint.setColor(getGradientColor(COLOR_CHECKED_BALL_STROKE, COLOR_UNCHECKED_BALL_STROKE, mProgress));
        canvas.drawCircle(mBallCenterPoint.x, mBallCenterPoint.y, mBallRadius, mCircleStrokePaint);

        // fill area
        mBallPaint.setColor(getGradientColor(COLOR_UNCHECKED_BALL, COLOR_CHECKED_BALL, mProgress));
        canvas.drawCircle(mBallCenterPoint.x, mBallCenterPoint.y, mBallRadius - dp2px(DEFAULT_FLOOR_STROKE_WIDTH), mBallPaint);
    }

    private int measureSize(int defaultSize, int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                result = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(defaultSize, specSize);
                break;
        }
        return result;
    }

    private int dp2px(int dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private static int getGradientColor(int startColor, int endColor, float percent) {
        int sr = (startColor & 0xff0000) >> 0x10;
        int sg = (startColor & 0xff00) >> 0x8;
        int sb = (startColor & 0xff);

        int er = (endColor & 0xff0000) >> 0x10;
        int eg = (endColor & 0xff00) >> 0x8;
        int eb = (endColor & 0xff);

        int cr = (int) (sr * (1 - percent) + er * percent);
        int cg = (int) (sg * (1 - percent) + eg * percent);
        int cb = (int) (sb * (1 - percent) + eb * percent);
        return Color.argb(0xff, cr, cg, cb);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener l) {
        this.mListener = l;
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(DNToggleButton toggleButton, boolean isChecked);
    }
}
