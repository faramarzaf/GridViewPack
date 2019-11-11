package com.faramarz.tictacdev.gridviewapp.sample3;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class SquareImageView3 extends AppCompatImageView {


    public SquareImageView3(Context context) {
        super(context);
    }

    public SquareImageView3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView3(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

}
