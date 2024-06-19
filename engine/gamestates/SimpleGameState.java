package engine.gamestates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import engine.Game;
import engine.logic.GameObject;

public abstract class SimpleGameState implements GameState {

    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public void tick(Game game) {
        for(GameObject gameObject: this.gameObjects) {
            gameObject.tick(game);
        }
    }

    public void render(Game game, Graphics2D graphics) {
        for(GameObject gameObject: this.gameObjects) {
            gameObject.render(graphics);
        }
    }
    
}
