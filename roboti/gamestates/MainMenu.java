package roboti.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Game;
import engine.gamestates.GameState;

public class MainMenu implements GameState {

    public void init(Game game) {
        System.out.println("sandbox");
    }

    public void tick(Game game) {
        
    }

    public void render(Game game, Graphics2D graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, 0, 33, 33);
    }

    public void deinit(Game game) {
        
    }
    
}
