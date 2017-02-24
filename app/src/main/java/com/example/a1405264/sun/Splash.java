package com.example.a1405264.sun;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Splash extends AppCompatActivity{

    RelativeLayout rlayout;
//	private final int SPLASH_DISPLAY_LENGTH = 15000;
	@Override
	protected void onCreate(Bundle icile) {
		super.onCreate(icile);
		setContentView(R.layout.activity_splash);

        rlayout = (RelativeLayout) findViewById(R.id.mainlayout);

		MyDesign md=new MyDesign(Splash.this);
		setContentView(md);



        rlayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                // action to do
                startActivity(new Intent(Splash.this,MainActivity.class));
                return true;//always return true to consume event
            }
        });
/*		rlayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

                Log.v("yoo ","poo");
                startActivity(new Intent(Splash.this,MainActivity.class));
			}

		});
*/
	/*	new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                MyDesign md=new MyDesign(Splash.this);
                setContentView(md);
                // Create an Intent that will start the Menu-Activity.
                Intent mainIntent = new Intent(Splash.this,Login.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);  */


	}

	
    class MyDesign extends View
    {
    	Context ct;
    	public MyDesign(Context context) {
    		super(context);
    		ct=context;
    		// TODO Auto-generated constructor stub
    	}
    	int y=500;
    	int x=0;
    	@Override
    	protected void onDraw(Canvas canvas) {
    		// TODO Auto-generated method stub
    		super.onDraw(canvas);
    		//canvas.drawColor(Color.WHITE);
    		Paint cp=new Paint();
    		//cp.setColor(Color.YELLOW);
    		int w=canvas.getWidth();
    		int h=canvas.getHeight();
    		Bitmap img=BitmapFactory.decodeResource(getResources(), R.drawable.kiitlogo);
    		canvas.drawBitmap(img, w/2,y, null);
    		if(x<w)
    		{
    			x++;
    		}
    		else
    		{
    			x=0;
    		}
    		if(y!=y/3){
    		y=y-4;
    		}
    		invalidate();
    	}
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {

            startActivity(new Intent(Splash.this,MainActivity.class));            // do your work here
            return true;
        } else {
            return false;
        }
    }
}




