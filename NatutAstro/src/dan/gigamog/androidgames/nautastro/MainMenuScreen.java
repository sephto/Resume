package dan.gigamog.androidgames.nautastro;

import java.util.List;

import dan.gigamog.framework.Game;
import dan.gigamog.framework.Graphics;
import dan.gigamog.framework.Pixmap;
import dan.gigamog.framework.Screen;
import dan.gigamog.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {
	
	World world;
	
	public MainMenuScreen(Game game) {
        super(game); 
       
        
    }   

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();       
        if(Settings.soundEnabled){
        	Assets.mainMusic.play();
        	Assets.mainMusic.setLooping(true);
        }
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 0, g.getHeight() - 64, 64, 64)) {
                    Settings.soundEnabled = !Settings.soundEnabled;
                    Assets.mainMusic.stop();
                   
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                   
                }
                if(inBounds(event, 64, 220, 192, 42) ) {
                    game.setScreen(new GameScreen(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
                if(inBounds(event, 64, 220 + 42, 192, 42) ) {
                    game.setScreen(new HighscoreScreen(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
                if(inBounds(event, 64, 220 + 84, 192, 42) ) {
                    game.setScreen(new Credits(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }
    
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }

    public void present(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.logo, 32, 20);
        g.drawPixmap(Assets.mainMenu, 64, 220);
        if(Settings.soundEnabled)
            g.drawPixmap(Assets.Explode, 0, 416, 0, 0, 64, 64);
        else
            g.drawPixmap(Assets.Explode, 0, 416, 64, 0, 64, 64);
    }

    public void pause() { 
    	 Assets.mainMusic.stop();
        Settings.save(game.getFileIO());
    }

    public void resume() {

    }

    public void dispose() {

    }
}

