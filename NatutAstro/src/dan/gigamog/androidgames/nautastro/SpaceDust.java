package dan.gigamog.androidgames.nautastro;

import android.util.Log;

public class SpaceDust implements SpaceObjects {
	
	boolean done = false;

	
	  public float x[] = new float[100], y[] = new float[100];
		float xSpeed=0;
		float ySpeed=5;
		

	  
	  
	  
	  public SpaceDust(){
		  spawnObject();
	  }
	  
		public void moveObject() {
			
			for (int i =0; i<x.length; i++){

				x[i] += xSpeed;
				y[i] += ySpeed;

				if (x[i] < 0)
					x[i] = 320;
				if (x[i] > 320)
					x[i] = 0;
				if (y[i] < 0)
					y[i] = 420;
				if (y[i] > 420)
					y[i] = 0;
				}
			

			

			
	}

	public void spawnObject() {
		
		for (int i =0; i<x.length; i++){
	
		
		x[i] = random.nextInt(320);
		y[i] = random.nextInt(480);
		}
	}


}
