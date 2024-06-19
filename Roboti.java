import engine.Game;
import engine.gamestates.GameState;
import engine.graphics.Screen;
import roboti.gamestates.MainMenu;

public class Roboti extends Game {

    public static void main(String[] args) {
        Screen screen = new Screen(1280, 720, 1280, 720);
        GameState[] gameStates = new GameState[16];
        gameStates[0] = new MainMenu();

        Roboti roboti = new Roboti(screen, gameStates);
        roboti.start();
    }

    public Roboti(Screen screen, GameState[] gameStates) {
        super(screen, gameStates);
    }

    public void tick() {
        super.tick();
    }

    public void render() {
        super.render();
    }
    
}