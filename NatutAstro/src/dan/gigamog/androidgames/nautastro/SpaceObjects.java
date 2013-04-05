package dan.gigamog.androidgames.nautastro;

import java.util.ArrayList;
import java.util.Random;

public interface SpaceObjects {
	

	static final int WORLD_WIDTH = 285;
	static final int WORLD_HEIGHT = 400;
	static final int SCORE_INCREMENT = 10;
	static final float TICK_INITIAL = 0.1f;
	static final float TICK_DECREMENT = 0.05f;
	Random random = new Random();


	boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
	
	
	
	public void moveObject();
	
	public void spawnObject();
	

}


