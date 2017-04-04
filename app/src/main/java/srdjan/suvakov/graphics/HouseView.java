package srdjan.suvakov.graphics;

/**
 * Created by Srdjan Suvakov on 4.4.100 BC. ...
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

public class HouseView extends View {

    private Paint mPaint;
    private Bitmap mCloud;
    private Bitmap mGrass;
    private Bitmap theSUN;
    private RectF mRect;
    private Path mPath;




    public HouseView(Context context){
        super(context);

        mPaint = new Paint();
        mGrass = BitmapFactory.decodeResource(getResources(),R.drawable.grass);
        mCloud =  BitmapFactory.decodeResource(getResources(),R.drawable.darkcloud);
        theSUN = BitmapFactory.decodeResource(getResources(),R.drawable.solaire);
        mRect = new RectF();
        mPath= new Path();

    }

    @Override
    protected void  onDraw(Canvas canvas){

        //set paint style
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);



        //draw sky
        mPaint.setColor(Color.rgb(126,192,238));
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);




        //draw sun
        float sunx = canvas.getWidth()/4;
        float suny = canvas.getHeight()/4;
        float sunRadius = sunx < suny ? sunx/2: suny/2;
        mPaint.setColor(Color.YELLOW);
        mRect.right = sunx +  sunRadius;
        mRect.bottom =suny +  sunRadius/ theSUN.getHeight() * theSUN.getWidth();
        mRect.left = sunx - 300;
        mRect.top = suny - 300;
        //canvas.drawCircle(sunx,suny,sunRadius,mPaint);
        canvas.drawBitmap(theSUN,null,mRect,null);

        //Draw Cloud
        float cloudWidth = 1 * sunRadius;
        float scaleFactor = cloudWidth/mCloud.getWidth();
        float cloudLeft= sunx +20 +  sunRadius;
        float cloutTop = suny -200 + sunRadius;
        mRect.left = cloudLeft; mRect.top = cloutTop;
        mRect.bottom = cloutTop + scaleFactor*mCloud.getHeight();
        mRect.right = cloudLeft + scaleFactor*mCloud.getWidth();
        canvas.drawBitmap(mCloud,null,mRect,null);


         cloudWidth = 4 * sunRadius;
         scaleFactor = cloudWidth/mCloud.getWidth();
         cloudLeft= sunx +20 + sunRadius;
         cloutTop = suny -400;
        mRect.left = cloudLeft ; mRect.top = cloutTop ;
        mRect.bottom = cloutTop + scaleFactor*mCloud.getHeight();
        mRect.right = cloudLeft + scaleFactor*mCloud.getWidth();
        canvas.drawBitmap(mCloud,null,mRect,null);



        //draw grass

        mRect.left = 0; mRect.top = 3 * canvas.getHeight()/4;
        mRect.right = canvas.getWidth(); mRect.bottom = canvas.getHeight();
        canvas.drawBitmap(mGrass,null,mRect,null);

        drawHouse(canvas,3 *canvas.getWidth()/4,3*canvas.getHeight()/4,canvas.getWidth()/4);


    }

    private void drawHouse(Canvas canvas, int i, int i1, int i2) {
    }
}
