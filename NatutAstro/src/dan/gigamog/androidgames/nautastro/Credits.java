package dan.gigamog.androidgames.nautastro;

import java.util.List;

import dan.gigamog.framework.Game;
import dan.gigamog.framework.Graphics;
import dan.gigamog.framework.Screen;
import dan.gigamog.framework.Input.TouchEvent;

public class Credits extends Screen {      
    public Credits(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
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
                if(event.x > 256 && event.y > 416 ) {
                    game.setScreen(new MainMenuScreen(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();      
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.help1, 64, 100);
        g.drawPixmap(Assets.Explode, 256, 416, 0, 64, 64, 64);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
