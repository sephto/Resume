package dan.gigamog.androidgames.nautastro;

import java.util.Random;

import android.util.Log;

public class World {
	static final int WORLD_WIDTH = 75;
	static final int WORLD_HEIGHT = 114;
	static final int SCORE_INCREMENT = 100;
	static final float TICK_INITIAL = 0.08f;
	static final float TICK_DECREMENT = 0.05f;

	public Astronaut astro;
	MeteorShower mShower;
	Coin coin;
	FireBall fire;
	JetPack jPack;
	SpaceDust sDust;
	boolean hit = false;
	boolean explode = false;
	boolean gameOver = false;
	boolean gameStart = false;
	float tempX;
	float tempY;

	public int score = 0;

	float tickTime = 0;
	float tick = TICK_INITIAL;
	int meteorCount = 1;
	int coinCount;
	int timeCount;
	int jCounting = 0;
	int moveCount = 0;
	MotherShip motherShip;

	public World() {
		astro = new Astronaut();
		coin = new Coin();
		fire = new FireBall();
		jPack = new JetPack();
		sDust = new SpaceDust();
		motherShip = new MotherShip(130, 198);
		mShower = new MeteorShower();

	}

	// updates screen
	public void update(float deltaTime) {

		if (gameStart == true) {
			sDust.spawnObject();
			gameStart = false;
		}
		if (gameOver)
			return;

		tickTime += deltaTime;

		while (tickTime > tick) {
			tickTime -= tick;
			timeCount += 1;

			moveCount = timeCount;

			jPackCD();
			movingObjects();

			deathHit();

			speedBuff();
			if (timeCount % 300 == 0) {
				jPack.spawnObject();

			}
		}

		if (astro.x - 32 <= coin.x && astro.x + 32 >= coin.x
				&& astro.y - 32 <= coin.y && astro.y + 32 >= coin.y) {

			coin.spawnObject();
			coinCount += 1;
			
			if (coinCount % 3 == 0)
				mShower.spawnObject();
			if (coinCount % 5 == 0) {
				fire.spawnObject();

			}

			score += SCORE_INCREMENT;

		}

	}

	// private void Turbo(){
	// if (score==20000){
	// mShower.type+=3;
	// }
	// }

	private void relativeMove() {

		if (astro.wall == false) {
			tempX = astro.xSpeed;
			sDust.xSpeed = tempX * -1;
			

		}
		if (astro.wall == false) {
			tempY = astro.ySpeed;
			sDust.ySpeed = tempY * -1;

		}
	}

	private void movingObjects() {
		relativeMove();
		sDust.moveObject();
		astro.advance();
		fire.moveObject();
		mShower.moveObject();

	}

	private void deathHit() {

		
		for (int i = 0; i < mShower.meteorList.size(); i++) {
			Meteor meteor = mShower.meteorList.get(i);

			if (astro.x - 20 <= meteor.x && astro.x + 20 >= meteor.x
					&& astro.y - 20 <= meteor.y && astro.y + 20 >= meteor.y) {
				coinCount = 0;
				timeCount = 0;

				explode = true;
				hit = true;
				gameOver = true;

				return;

			}

				if (motherShip.x - 50 <= meteor.x
						&& motherShip.x + 50 >= meteor.x
						&& motherShip.y - 50 <= meteor.y
						&& motherShip.y + 50 >= meteor.y) {

					String msg = "mother ship hp" + motherShip.hp;
					
					mShower.meteorList.remove(i);
					Log.d("hp check", msg);
					motherShip.hp -= 1;
					motherShip.hit = true;
					if (motherShip.hp == 0) {
						coinCount = 0;
						timeCount = 0;

						gameOver = true;
						return;
					
				}

			}
		}

	}

	private void speedBuff() {
		if (astro.x - 32 <= jPack.x && astro.x + 32 >= jPack.x
				&& astro.y - 32 <= jPack.y && astro.y + 32 >= jPack.y) {
			jCounting = 30;
			astro.speedOn = true;
			jPack.y = 500;
			jPack.x = 500;

		}

	}

	private void jPackCD() {

		if (astro.speedOn == true) {
			if (timeCount % 10 == 0) {

				jCounting -= 1;

			}

			if (jCounting == 0) {

				astro.speedOn = false;

			}

		}

	}
}
