package lewis.com.zhaopin.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import java.util.List;

public class PieChart extends View {

    private Paint paint;            //圆画笔

    private Paint piePaint;        //扇形画笔
    private Paint outerLinePaint;       //轮廓画笔
    private Paint linePaint;            //指示线
    private Paint textPaint;                //文字画笔

    private float radius;           //半径

    private static final int PAINT_COLOR = 0xed3535;
    private static final float OUTER_LINE_WIDTH = 3f;
    private static final float START_DEGREE = -90f;         //开始绘制角度

    //饼状图动画效果
    private float X;
    private float Y;
    private RectF rectF;
    private Float mSweep[];
    //饼状图动画效果
    private PieChartAnimation mAnimation;
    private Context context;
    private List<PieChartBean> list;
    public PieChart(Context context) {
        this(context,null);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        radius = Math.min(getMeasuredWidth(),getMeasuredHeight()) / 3;

        X = getMeasuredWidth() / 2;
        Y = getMeasuredHeight() / 2;
        rectF.left = X  - radius;
        rectF.top = Y - radius;
        rectF.right = X + radius;
        rectF.bottom = Y +  radius;
    }

    private void init() {

        paint = new Paint();
        paint.setColor(PAINT_COLOR);
        paint.setAntiAlias(true);
        paint.setAlpha(110);
        paint.setStyle(Paint.Style.FILL);
        piePaint = new Paint();
        piePaint.setStyle(Paint.Style.FILL);
        piePaint.setAntiAlias(true);
        piePaint.setAlpha(255);
        outerLinePaint = new Paint();
        outerLinePaint.setAntiAlias(true);
        outerLinePaint.setAlpha(255);
        outerLinePaint.setStyle(Paint.Style.STROKE);
        outerLinePaint.setStrokeWidth(OUTER_LINE_WIDTH);
        outerLinePaint.setColor(Color.WHITE);
        rectF = new RectF();
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth(4);
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStrokeWidth(30);
        textPaint.setTextSize(25);
        mAnimation = new PieChartAnimation();
        mAnimation.setDuration(2000);
    }

    public void setDate(List<PieChartBean> list){
        this.list = list;
        if (mSweep == null){
            mSweep = new Float[list.size()];
        }
        if (mAnimation != null)
         setAnimation(mAnimation);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPie(canvas);
    }
    /**
     * 画扇形
     * @param canvas
     */
    private void initPie(Canvas canvas) {
        int anglesSize = list.size();
        if (list != null && anglesSize > 0){
            float pieStart = START_DEGREE;
            if (mSweep == null) {
                mSweep = new Float[list.size()];
            }
            for (int i = 0;i < anglesSize; i++){
                piePaint.setColor(getResources().getColor(list.get(i).getColor()));
                canvas.drawArc(rectF, pieStart, mSweep[i], true, piePaint);             //扇形
                canvas.drawArc(rectF, pieStart, mSweep[i], true, outerLinePaint);           //边框线
                initLineAndText(canvas, pieStart, mSweep[i], list.get(i).getColor(), list.get(i).getValuer());
                pieStart +=  mSweep[i];
            }
        }
    }
    /**
     * 画指示线 和文字
     * @param canvas
     * @param text
     */
    private void initLineAndText(Canvas canvas, float statrAngles, float angles, int color, String text) {
        float stopX,stopY;
        float ceterX = getMeasuredWidth() / 2;
        float ceterY = getMeasuredHeight() / 2;
        linePaint.setColor(getResources().getColor(color));
        textPaint.setColor(getResources().getColor(color));
        //  半径加上多出的20个像素的位置，去根据角度算出 转点的X,Y轴
        float cosX = (float) Math.cos(( 2 * statrAngles + angles) /  2 * Math.PI /180 );
        float sinY = (float) Math.sin((2 * statrAngles + angles) / 2 * Math.PI /180 );
        stopX =  (radius + dip2px(10)) * cosX;
        stopY =  (radius + dip2px(10)) * sinY;
        //扇形弧边的中点的X,Y 为起点，然后算出中间点的角度，加上半径+10个像素 得出终点的XY轴，
        canvas.drawLine(ceterX + (radius - dip2px(10)) * cosX, ceterY + (radius - dip2px(10))* sinY,stopX+ceterX,stopY+ceterY,linePaint);
        Rect rect = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), rect);
        int h = rect.height();
        int w = rect.width();
        //画第二根线，第二个根线的起点是第一根线的终点，然后终点，根据X轴来定直接加25个像素
        //如果是右边，减去25个像素
        //文字的位置，Y轴根据第二根线的Y轴+文字的高度的一半，这样就能居中  X轴，左边加30个像素，根第二个线的有5个像素的距离
        //文字如果在右边，减去文字的宽度 - 30个像素
        if (stopX > 0) {
            //50为横线的长度 60 为文字的偏移量
            canvas.drawLine(ceterX +stopX, ceterY +stopY, ceterX +stopX + dip2px(15), ceterY +stopY, linePaint);
            canvas.drawText(text, 0, text.length(), ceterX +stopX +dip2px(20)  ,ceterY +stopY + h/2, textPaint);

        } else {
            canvas.drawLine(ceterX +stopX, ceterY +stopY, ceterX +stopX - dip2px(15), ceterY +stopY, linePaint);
            canvas.drawText(text, 0, text.length(), ceterX +stopX - w - dip2px(20)  ,ceterY+stopY + h/2 , textPaint);

        }




    }
    /**
     * dip转为 px
     */
    private  int dip2px(float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }



    private float PIE_ANIMATION_VALUE = 100;
    private class PieChartAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            mSweep = new Float[list.size()];
            if (interpolatedTime < 1.0f) {
                for (int i = 0; i < list.size(); i++) {
                    //根据传进来的比例，算出在圆中所占的角度
                    mSweep[i] = list.get(i).getAngle()  * interpolatedTime / PIE_ANIMATION_VALUE * 360;
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    mSweep[i] = list.get(i).getAngle()  /PIE_ANIMATION_VALUE * 360;
                }
            }
            invalidate();
        }
    }




}