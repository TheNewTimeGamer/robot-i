package roboti.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Game;
import engine.gamestates.GameState;

public class MainMenu implements GameState {

    public void init(Game game) {
        
    }

    public void tick(Game game) {
        
    }

    public void render(Game game, Graphics2D graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, 33, 33);
    }

    public void deinit(Game game) {

    }
    
}
