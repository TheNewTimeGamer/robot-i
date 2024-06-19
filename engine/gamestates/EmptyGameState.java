package engine.gamestates;

import engine.Game;

import java.awt.Graphics2D;

public class EmptyGameState implements GameState {

    public void init(Game game) {}

    public void tick(Game game) {}

    public void render(Game game, Graphics2D graphics) {}

    public void deinit(Game game) {}
    
}
