package dan.gigamog.androidgames.nautastro;

import java.util.List;
import java.util.Random;

import android.graphics.Color;
import android.graphics.Matrix;

import android.util.Log;

import dan.gigamog.framework.Game;
import dan.gigamog.framework.Graphics;
import dan.gigamog.framework.Pixmap;
import dan.gigamog.framework.Screen;
import dan.gigamog.framework.Input.TouchEvent;

public class GameScreen extends Screen {
	enum GameState {
		Ready, Running, Paused, GameOver
	}

	GameState state = GameState.Ready;
	World world;
	int oldScore = 0;
	String score = "0";
	float minX = 0;
	float minY = 0;
	float eventX = 0;
	float eventY = 0;
	float p1X = 0;
	float p1Y = 0;
	float angle =0;

	int ship = 0;

	Astronaut astro;
	

	Pixmap AstroPixmap = Assets.Ship[0];
	Pixmap shipBoostPixmap = Assets.Ship[0];

	boolean up = false, down = false, left = false, right = false;
	
	boolean touched = false;

	public GameScreen(Game game) {
		super(game);
		world = new World();
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();

		if (Settings.soundEnabled) {
			Assets.gameMusic.play();
			Assets.gameMusic.setLooping(true);
		}

		if (state == GameState.Ready)
			updateReady(touchEvents);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (world.gameOver == true)
			updateGameOver(touchEvents);
	}

	private void updateReady(List<TouchEvent> touchEvents) {
		if (touchEvents.size() > 0)
			state = GameState.Running;
	}

	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
		int len = touchEvents.size();

		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (event.x < 64 && event.y < 64) {
					if (Settings.soundEnabled)
						Assets.click.play(1);
					state = GameState.Paused;
					
					return;
					
				}
			}

			
			 eventX = event.x;
			 eventY = event.y;
			 p1X = astro.x;
			 p1Y = astro.y;
			 angle = (float)(Math.atan2(eventY - p1Y, eventX - p1X ));
			 angle = (float)(angle * (180/Math.PI));
			 Matrix matrix = new Matrix();
			    matrix.preRotate(angle);
			 
			 


			switch (event.type) {

			case TouchEvent.TOUCH_DOWN:


			case TouchEvent.TOUCH_DRAGGED:
//				speed *=((astro.y-event.y)/100);
//				angle = Math.atan2(event.y-astro.y, event.x-astro.x);
//				angle = angle * (180/Math.PI);
//				
//				
//				astro.xSpeed = (float)(Math.cos((angle) * Math.PI /180) * (speed * deltaTime));
//				astro.ySpeed = (float)(Math.cos((angle) * Math.PI/180) * (speed * deltaTime));
				float smooth =0;
				if(astro.speedOn == false){
					smooth = .05f;
				}else{
					smooth = .1f;
				}
				
				
				
				astro.ySpeed=0;
				astro.xSpeed =0;
				astro.ySpeed = astro.ySpeed + (event.y-astro.y)*smooth;
				astro.xSpeed = astro.xSpeed + (event.x-astro.x)*smooth;

				
			
				
				
				
				if (event != null) {
					minX = eventX - p1X;
					minY = eventY - p1Y;
				}
				

				if (p1X > eventX) {
					astro.turnLeft();
					left = true;
					right = false;
				}

				if (p1X < eventX) {
					astro.turnRight();
					right = true;
					left = false;
				}

				if (p1Y < eventY) {
					astro.turnDown();
					down = true;
					up = false;
				}

				if (p1Y > eventY) {
					astro.turnUp();
					up = true;
					down = false;
				}
				

				if (minX < 10 && minX > -10) {
					astro.xSpeed = 0;
					left = false;
					right = false;
				}

				if (minY < 10 && minY > -10) {
					astro.ySpeed = 0;
					up = false;
					down = false;
				}
				break;
			case TouchEvent.TOUCH_UP:
				float tempX = event.x;
				float tempY = event.y;

				if(p1X - 32 <= tempX && p1X + 32 >= tempX
						&& p1Y - 32 <= tempY && p1Y + 32 >= tempY){
					astro.ySpeed=0;
					astro.xSpeed=0;
					
				}

//				if (p1X - 32 <= eventX && p1X + 32 >= eventX
//						&& p1Y - 32 <= eventY && p1Y + 32 >= eventY) {
//
//					astro.ySpeed = 0;
//					astro.xSpeed = 0;
//				}

				String msg = " where my finger is. " + event.x + " and "
						+ event.y;

				String player = " where astro is " + astro.x + " and " + astro.y;
				
				String min = " tempx: " + tempX + " tempy " + tempY;

				Log.d("location of touch", msg);

				Log.d("location of astro", player);
				
				Log.d("MINimum : ", min);

			}
		}

		world.update(deltaTime);
		if (world.hit == true) {
			world.hit = false;
			if (Settings.soundEnabled)
				Assets.bitten.play(1);
			// state = GameState.GameOver;

		}
		if (oldScore != world.score) {
			oldScore = world.score;
			score = "" + oldScore;
			if (Settings.soundEnabled)
				Assets.eat.play(1);
		}
	}
	
	
	

	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (event.x > 80 && event.x <= 240) {
					if (event.y > 100 && event.y <= 148) {
						if (Settings.soundEnabled)
							Assets.click.play(1);
						state = GameState.Running;
						return;
					}
					if (event.y > 148 && event.y < 196) {
						if (Settings.soundEnabled)
							Assets.click.play(1);
						game.setScreen(new MainMenuScreen(game));
						return;
					}
				}
			}
		}
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (event.x >= 128 && event.x <= 192 && event.y >= 200
						&& event.y <= 264) {
					// world.explode = false;
					if (Settings.soundEnabled)
						Assets.click.play(1);
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();

		g.drawPixmap(Assets.background, 0, 0);
		drawWorld(world);
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (world.gameOver == true)
			drawGameOverUI();

		drawText(g, score, g.getWidth() / 2 - score.length() * 20 / 2,
				g.getHeight() - 42);

		drawGas(g, 53 * 4, 118 * 4);
		Pixmap boostTextPixmap = Assets.fuelText;
		g.drawPixmap(boostTextPixmap, 53 * 4, 110 * 4);
	}

	private void drawWorld(World world) {

		// Classes and shit
		
		Graphics g = game.getGraphics();
		
//		MeteorShower mShower = world.meteorShower;
		
		
		astro = world.astro;
		Coin coin = world.coin;
		FireBall fire = world.fire;
		JetPack jPack = world.jPack;
		
		MeteorShower mShower = world.mShower;

		SpaceDust sDust = world.sDust;
		MotherShip motherShip = world.motherShip;

		// Pixmaps
		Pixmap firePixmap = Assets.fire;
		Pixmap coinPixmap = Assets.o2tank;
		Pixmap meteorPixmap = null;
		Pixmap jPackPixmap1 = Assets.JetPack1;
		Pixmap spaceDustPixmap = Assets.spaceDust;
		Pixmap motherShipPixmap = Assets.motherShip;
		
		
		
		//spaceDust
		for (int i = 0; i < sDust.x.length; i++)
			g.drawPixmap(spaceDustPixmap, (int) sDust.x[i]-16, (int) sDust.y[i]-16);

		// JetPack
		g.drawPixmap(jPackPixmap1, (int) jPack.x-16, (int) jPack.y-16);

		// fire
		for (int i = 0; i < fire.count; i++)
			g.drawPixmap(firePixmap, (int) fire.x[i]-16, (int) fire.y[i]-16);

		// coin
		int x = coin.x-16;
		int y = coin.y-16;
		g.drawPixmap(coinPixmap, x, y);

		// meteors

	       int len = mShower.meteorList.size();
	        for(int i = 0; i < len; i++) {
	            Meteor meteor = mShower.meteorList.get(i);
	            meteorPixmap = Assets.meteor[meteor.type];
	            g.drawPixmap(meteorPixmap, (int)meteor.x-16, (int)meteor.y-16);

	        }
	        

		// Ship
		if (astro.speedOn == false && world.explode == false) {
			if (up == true && left == false && right == false) {
				AstroPixmap = Assets.Ship[0];
			} else if (up == true && right == true) {
				AstroPixmap = Assets.Ship[1];
			} else if (right == true && down == false && up == false) {
				AstroPixmap = Assets.Ship[2];
			} else if (right == true && down == true) {
				AstroPixmap = Assets.Ship[3];
			} else if (down == true && right == false && left == false) {
				AstroPixmap = Assets.Ship[4];
			} else if (down == true && left == true) {
				AstroPixmap = Assets.Ship[5];
			} else if (left == true && down == false && up == false) {
				AstroPixmap = Assets.Ship[6];
			} else if (up == true && left == true) {
				AstroPixmap = Assets.Ship[7];
			}

			g.drawPixmap(AstroPixmap, (int) astro.x-16, (int) astro.y-16);

		} else if (astro.speedOn == true && world.explode == false) {

			if (up == true && left == false && right == false) {
				shipBoostPixmap = Assets.shipBoost[0];
			} else if (up == true && right == true) {
				shipBoostPixmap = Assets.shipBoost[1];
			} else if (right == true && down == false && up == false) {
				shipBoostPixmap = Assets.shipBoost[2];
			} else if (right == true && down == true) {
				shipBoostPixmap = Assets.shipBoost[3];
			} else if (down == true && right == false && left == false) {
				shipBoostPixmap = Assets.shipBoost[4];
			} else if (down == true && left == true) {
				shipBoostPixmap = Assets.shipBoost[5];
			} else if (left == true && down == false && up == false) {
				shipBoostPixmap = Assets.shipBoost[6];
			} else if (up == true && left == true) {
				shipBoostPixmap = Assets.shipBoost[7];

			}

			g.drawPixmap(shipBoostPixmap, (int) astro.x-16, (int) astro.y-16);

		} else if (world.explode == true && astro.speedOn == true) {
			shipBoostPixmap = Assets.shipBoost[8];
			g.drawPixmap(shipBoostPixmap, (int) astro.x, (int) astro.y);

		} else if (world.explode == true && astro.speedOn == false) {
			AstroPixmap = Assets.Ship[8];
			g.drawPixmap(AstroPixmap, (int) astro.x, (int) astro.y);
		}
		
		
		//motherShip
		
		
		g.drawPixmap(motherShipPixmap, (int)motherShip.x, (int)motherShip.y);
		
		
		
	}

	private void drawReadyUI() {
		Graphics g = game.getGraphics();

		g.drawPixmap(Assets.ready, 47, 100);
		g.drawLine(0, 416, 480, 416, Color.BLACK);
	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();

		g.drawPixmap(Assets.Explode, 0, 0, 64, 128, 64, 64);
		g.drawLine(0, 416, 480, 416, Color.BLACK);
		// g.drawPixmap(Assets.buttons, 0, 416, 64, 64, 64, 64);
		// g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
	}

	private void drawPausedUI() {
		Graphics g = game.getGraphics();

		g.drawPixmap(Assets.pause, 80, 100);
		g.drawLine(0, 416, 480, 416, Color.BLACK);
	}

	private void drawGameOverUI() {
		Graphics g = game.getGraphics();

		g.drawPixmap(Assets.gameOver, 62, 100);
		g.drawPixmap(Assets.Explode, 128, 200, 0, 128, 64, 64);
		// g.drawLine(0, 416, 480, 416, Color.BLACK);
	}

	public void drawText(Graphics g, String line, int x, int y) {
		int len = line.length();
		for (int i = 0; i < len; i++) {
			char character = line.charAt(i);

			if (character == ' ') {
				x += 20;
				continue;
			}

			int srcX = 0;
			int srcWidth = 0;
			if (character == '.') {
				srcX = 200;
				srcWidth = 10;
			} else {
				srcX = (character - '0') * 20;
				srcWidth = 20;
			}

			g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
			x += srcWidth;
		}
	}

	public void drawGas(Graphics g, int x, int y) {
		Pixmap gasPixmap = null;
		//jCounting is a 30 second countdown /2
		gasPixmap = Assets.fuel[world.jCounting/2];

		g.drawPixmap(gasPixmap, x, y);

	}

	@Override
	public void pause() {
		if (state == GameState.Running)
			state = GameState.Paused;
		Assets.gameMusic.stop();

		if (world.gameOver) {
			Settings.addScore(world.score);
			Settings.save(game.getFileIO());
			Assets.gameMusic.stop();
		}
	}
	
	

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
