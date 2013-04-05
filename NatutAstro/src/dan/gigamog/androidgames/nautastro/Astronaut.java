package dan.gigamog.androidgames.nautastro;

import android.util.Log;

public class Astronaut {
	public  int x = 130;
	public  int y = 198;


	
	public float xSpeed = 0;
	public float ySpeed = 0;
	public int stepsTaken = 0;
	
	boolean speedOn = false;
	
	boolean wall = false;


	
	String loc;
	
	World world;
	

	public Astronaut() {


	}

	public void turnLeft() {
		wall = false;
		
//		xSpeed = -4;
//		if(speedOn == true)
//			xSpeed = -7;

	}

	public void turnRight() {
		wall = false;
//		xSpeed = 4;
//		if(speedOn == true)
//			xSpeed = 7;


	}

	public void turnUp() {
		wall = false;
//		ySpeed = -3;
//		
//		if(speedOn == true)
//			ySpeed = -5;

	}

	public void turnDown() {
		wall = false;
//		ySpeed = 3;
//		if(speedOn == true)
//			ySpeed = 5;

	}




	public void advance() {



			 
		
		 x += xSpeed;
		 y += ySpeed;

		 
			if (x < 2){
				wall = true;
				xSpeed=0;
			}
			if (x > 290 ){
				wall = true;
				xSpeed =0;
			}
				
			if (y < 2 ){
				wall = true;
				ySpeed =0;
			}
			
			if (y > 400 ){
				wall = true;
				ySpeed =0;
			}
			



	}
	

	
	



	// public boolean checkBitten() {
	// int len = parts.size();
	// SnakePart head = parts.get(0);
	// for (int i = 1; i < len; i++) {
	// SnakePart part = parts.get(i);
	// if (part.x == head.x && part.y == head.y)
	// return true;
	// }
	// return false;
	// }
}
