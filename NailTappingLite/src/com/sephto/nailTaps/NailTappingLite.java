package com.sephto.nailTaps;

import java.io.IOException;


import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;


import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.TextView;



public class NailTappingLite extends Activity implements OnTouchListener {
	TextView textView;

	float[] x = new float[5];
	float[] y = new float[5];
	boolean[] touched = new boolean[5];
	int[] id = new int[5];
	

	SoundPool soundPool;
	SoundPool soundPool2;
	int nailId = -1;
	int nailId2 = -1;
	int nailId3 = -1;
	

	public void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setOnTouchListener(this);
		setContentView(textView);
		getWindow().setBackgroundDrawableResource(R.drawable.background);
		
		
		

		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		soundPool2 = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

		try {
			AssetManager assetManager = getAssets();
			AssetFileDescriptor descriptor = assetManager.openFd("NailTapping.ogg");
			AssetFileDescriptor descriptor2 = assetManager.openFd("NailTapping2.ogg");
			AssetFileDescriptor descriptor3 = assetManager.openFd("NailTapping3.ogg");
			nailId = soundPool.load(descriptor, 1);
			nailId2= soundPool.load(descriptor2, 1);
			nailId3 = soundPool.load(descriptor3, 1);
			
		} catch (IOException e) {
			
		}

		for (int i = 0; i < 5; i++) {
			id[i] = -1;
		}

	}


	@SuppressWarnings("deprecation")
	public boolean onTouch(View v, MotionEvent event) {
		

		int action = event.getAction() & MotionEvent.ACTION_MASK;
		int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK) >> MotionEvent.ACTION_POINTER_ID_SHIFT;
		int pointerCount = event.getPointerCount();

		for (int i = 0; i < 5; i++) {
			if (i >= pointerCount) {
				touched[i] = false;
				id[i] = -1;
				

				continue;
			}


			if (event.getAction() != MotionEvent.ACTION_MOVE
					&& i != pointerIndex) {
				// if it's an up/down/cancel/out event, mask the id to see if we
				// should process it for this touch point
				continue;
			}
			int pointerID = event.getPointerId(i);
			switch (action) {
			case MotionEvent.ACTION_DOWN:
			case MotionEvent.ACTION_POINTER_DOWN:
				
				
				
				touched[i] = true;
				id[i] = pointerID;
				x[i] = (int) event.getX(i);
				y[i] = (int) event.getY(i);
			
				
			 if (id[i]%2 != 0) {
					if (nailId != -1){
						soundPool.play(nailId, 1, 1, 0, 0, 1);
					}
			 }else if(id[i]%5 !=0){
					if (nailId2 != -1){
						soundPool.play(nailId2, 1, 1, 0, 0, 1);
					}
			}else{
				if (nailId3 != -1){
					soundPool.play(nailId3, 1, 1, 0, 0, 1);
				}
				
			}
				break;

			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_POINTER_UP:
			case MotionEvent.ACTION_OUTSIDE:
			case MotionEvent.ACTION_CANCEL:
				touched[i] = false;
				id[i] = -1;
				x[i] = (int) event.getX(i);
				y[i] = (int) event.getY(i);
				break;

			case MotionEvent.ACTION_MOVE:

				touched[i] = true;
				x[i] = (int) event.getX(i);
				y[i] = (int) event.getY(i);


				
				

			}
		}

		return true;

	}
	
	

		
	}
	
	


