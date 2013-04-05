package dan.gigamog.androidgames.nautastro;

import dan.gigamog.framework.Game;
import dan.gigamog.framework.Graphics;
import dan.gigamog.framework.Screen;
import dan.gigamog.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.ARGB8888);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        Assets.Explode = g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
        
        Assets.motherShip = g.newPixmap("spaceship.png", PixmapFormat.ARGB4444);

        Assets.Ship[0] = g.newPixmap("shipup.png", PixmapFormat.ARGB4444);
        Assets.Ship[1] = g.newPixmap("shipupright.png", PixmapFormat.ARGB4444);
        Assets.Ship[2] = g.newPixmap("shitright.png", PixmapFormat.ARGB4444);
        Assets.Ship[3] = g.newPixmap("shipdownright.png", PixmapFormat.ARGB4444);
        Assets.Ship[4] = g.newPixmap("shipdown.png", PixmapFormat.ARGB4444);
        Assets.Ship[5] = g.newPixmap("shipdownleft.png", PixmapFormat.ARGB4444);
        Assets.Ship[6] = g.newPixmap("shipleft.png", PixmapFormat.ARGB4444);
        Assets.Ship[7] = g.newPixmap("shitpupleft.png", PixmapFormat.ARGB4444);
        Assets.Ship[8] = g.newPixmap("explotion.png", PixmapFormat.ARGB4444);

        Assets.shipBoost[0] = g.newPixmap("shipboostup.png", PixmapFormat.ARGB4444);
        Assets.shipBoost[1] = g.newPixmap("shipboostupright.png", PixmapFormat.ARGB4444);
        Assets.shipBoost[2] = g.newPixmap("shipboostright.png", PixmapFormat.ARGB4444);
        Assets.shipBoost[3] = g.newPixmap("shipboostdownright.png", PixmapFormat.ARGB4444);
        Assets.shipBoost[4] = g.newPixmap("shipboostdown.png", PixmapFormat.ARGB4444);
        Assets.shipBoost[5] = g.newPixmap("shipboostdownleft.png", PixmapFormat.ARGB4444);
        Assets.shipBoost[6] = g.newPixmap("shipboostleft.png", PixmapFormat.ARGB4444);
        Assets.shipBoost[7] = g.newPixmap("shipboostupleft.png", PixmapFormat.ARGB4444);
        Assets.shipBoost[8] = g.newPixmap("explotion.png", PixmapFormat.ARGB4444);
        
        Assets.spaceDust = g.newPixmap("stars.png", PixmapFormat.ARGB4444);
        
        
        
        Assets.tail = g.newPixmap("tail.png", PixmapFormat.ARGB4444);
        Assets.o2tank = g.newPixmap("02tank.png", PixmapFormat.ARGB4444);
        Assets.o2tank2 = g.newPixmap("02tank2.png", PixmapFormat.ARGB4444);
        Assets.o2tank3 = g.newPixmap("02tank3.png", PixmapFormat.ARGB4444);
        
  
        Assets.fire = g.newPixmap("fireball.png", PixmapFormat.ARGB4444);
        
        
        
        		//in retrospect I should have used a sprite sheet....
   	 Assets.fuel[15] = g.newPixmap("fullfuel.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[14] = g.newPixmap("fuel1.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[13] = g.newPixmap("fuel2.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[12] = g.newPixmap("fuel3.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[11] = g.newPixmap("fuel4.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[10] = g.newPixmap("fuel5.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[9] = g.newPixmap("fuel6.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[8] = g.newPixmap("fuel7.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[7] = g.newPixmap("fuel8.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[6] = g.newPixmap("fuel9.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[5] = g.newPixmap("fuel10.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[4] = g.newPixmap("fuel12.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[3] = g.newPixmap("fuel13.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[2] = g.newPixmap("fuel14.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[1] = g.newPixmap("fuel15.png", PixmapFormat.ARGB4444);
   	 Assets.fuel[0] = g.newPixmap("fuele.png", PixmapFormat.ARGB4444);
   	 Assets.fuelText = g.newPixmap("BoostFuel.png", PixmapFormat.ARGB4444);
       
      Assets.meteor[0] = g.newPixmap("meteor.png", PixmapFormat.ARGB4444);  
      Assets.meteor[1] = g.newPixmap("meteor2.png", PixmapFormat.ARGB4444);
      Assets.meteor[2] = g.newPixmap("meteor3.png", PixmapFormat.ARGB4444);
      Assets.meteor[3] = g.newPixmap("meteor4.png", PixmapFormat.ARGB4444);  
      Assets.meteor[4] = g.newPixmap("meteor5.png", PixmapFormat.ARGB4444);
      Assets.meteor[5] = g.newPixmap("meteor6.png", PixmapFormat.ARGB4444);


        Assets.JetPack1 = g.newPixmap("jetpack.png", PixmapFormat.ARGB4444);
        Assets.JetPack2 = g.newPixmap("jetpack2.png", PixmapFormat.ARGB4444);
        Assets.JetPack3 = g.newPixmap("jetpack3.png", PixmapFormat.ARGB4444);
        
        
        Assets.click = game.getAudio().newSound("click.ogg");
        Assets.eat = game.getAudio().newSound("eat.ogg");
        Assets.bitten = game.getAudio().newSound("music.ogg");
        
        Assets.mainMusic = game.getAudio().newMusic("underpass.ogg");
        Assets.gameMusic = game.getAudio().newMusic("humblerain.ogg");
        
        
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }
    
    public void fuel(){

    	
    }
    
    public void present(float deltaTime) {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
