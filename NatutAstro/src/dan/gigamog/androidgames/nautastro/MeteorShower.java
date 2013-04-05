package dan.gigamog.androidgames.nautastro;

import java.util.ArrayList;
import java.util.Random;

import android.util.Log;

public class MeteorShower  {

	ArrayList<Meteor> meteorList = new ArrayList<Meteor>();
	
	int multi = 1;
	
	float x =100;
	float y =100;
	float ySpeed;
	float xSpeed;
	int spawn =2;
	int count = 0;
	int type = 0;
	Meteor meteor;
	Random random = new Random();

	boolean spawned = false;
	
	public MeteorShower() {

		
	}

	public void moveObject() {
		
		for(int i=0; i<meteorList.size();i++){
		Meteor meteor = meteorList.get(i);
		
			meteor.x += meteor.xSpeed * multi;
			meteor.y += meteor.ySpeed * multi;

			if (meteor.x < 0)
				meteor.x = 320;
			if (meteor.x > 320)
				meteor.x = 0;
			if (meteor.y < 0)
				meteor.y = 400;
			if (meteor.y > 400)
				meteor.y = 0;
		}

	}

	public void spawnObject() {
		spawnPoint();
		type = random.nextInt(3);
		randomSpeed();
		meteorList.add(new Meteor(x, y, type, xSpeed, ySpeed));
		
	}
	
	private void spawnPoint(){

		spawn = random.nextInt(4);
		
		switch (spawn) {

		case 0:
			x = 0;
			y = 0;
			break;
		case 1:
			x = 0;
			y = 480;
			break;
		case 2:
			x = 320;
		 y = 0;
			break;
		case 3:
			x = 320;
			y = 480;
			break;

		}
	}

	private void randomSpeed() {
		
			

		float x = random.nextFloat();
		float y = random.nextFloat();
		
		
		xSpeed = (x * 6) - 3;
		ySpeed= (y * 6) - 3;
		
		
	}
}