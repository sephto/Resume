package dan.gigamog.androidgames.nautastro;

import android.util.Log;

public class Meteor  {
	
    public float x, y;
    int type;
	float xSpeed;
	float ySpeed;
    public Meteor(float x, float y, int type,float xSpeed, float ySpeed) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
}       





