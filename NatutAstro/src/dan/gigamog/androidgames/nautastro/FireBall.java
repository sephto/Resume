package dan.gigamog.androidgames.nautastro;

import android.util.Log;


public class FireBall implements SpaceObjects {
	
	boolean done = false;
	int count = 0;
	int multi =1;
	
	  public float x[] = new float[10], y[] = new float[10];
		float xSpeed[] = { 1.2f, -1.3f, -3, 1.2f, 1.8f, 2, 2.8f, -5, 4.4f, 10f };
		float ySpeed[] = { 1.5f, -1.62f, 1.8f, 1.9f, -1.5f, .2f, 3.5f, -5f, -3.2f,0};
		

	  
	  
	  
	  public FireBall(){
		  spawnObject();
	  }
	  
		public void moveObject() {
			
			for (int i =0; i<count; i++){

				x[i] += xSpeed[i]*multi;
				y[i] += ySpeed[i]*multi;

				if (x[i] < 0)
					x[i] = 320;
				if (x[i] > 320)
					x[i] = 0;
				if (y[i] < 0)
					y[i] = 400;
				if (y[i] > 400)
					y[i] = 0;
				}
			

			

			
	}

	public void spawnObject() {
		
		int xtemp = random.nextInt(WORLD_WIDTH);
		int ytemp = random.nextInt(WORLD_HEIGHT);
		

		if (x[count] > y [count]){
			y[count] =0;
			x[count] =xtemp;
			y[count] =ytemp;
		}else if(x[count] < y [count]){
			x[count] =0;
			x[count] =xtemp;
			y[count] =ytemp;
		}
		

		count += 1;
		String msg = " how many meteors " + count;

		Log.d("DEBUGGING:", msg);
		

	}
	}
	  
	  
	  
	  

