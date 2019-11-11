package com.faramarz.tictacdev.gridviewapp.sample1;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class SquareImageView extends AppCompatImageView {


    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

       /* if (widthMeasureSpec > heightMeasureSpec)
            setMeasuredDimension(heightMeasureSpec, heightMeasureSpec);
        else
            setMeasuredDimension(widthMeasureSpec, widthMeasureSpec);
*/


        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

}
