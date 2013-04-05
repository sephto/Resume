package dan.gigamog.androidgames.nautastro;


import dan.gigamog.androidgames.famework.impl.AndroidGame;
import dan.gigamog.framework.Screen;

public class NautAstro extends AndroidGame {
    public Screen getStartScreen() {
        return new LoadingScreen(this); 
    }
} 
