package engine;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import engine.gamestates.EmptyGameState;
import engine.gamestates.GameState;
import engine.graphics.Screen;

public class Game implements Runnable {
    
    public final Screen screen;

    public int gameState = 0;
    public final GameState[] gameStates;

    private Thread thread = new Thread(this);
    private boolean running = false;

    public boolean[] mouse = new boolean[64];
    public boolean[] keyboard = new boolean[2048];

    public Point mousePosition = new Point(0,0);
    public Point scaledMousePosition = new Point(0,0);

    public Game(Screen screen, GameState[] gameStates) {
        this.screen = screen;
        this.gameStates = gameStates;
        if(this.gameStates[this.gameState] == null) {
            this.gameStates[this.gameState] = new EmptyGameState();
            System.err.println("No initial gamestate, added empty gamestate to prevent crash.");
        }

        this.screen.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                keyboard[e.getKeyCode()] = true;                
            }

            public void keyReleased(KeyEvent e) {
                keyboard[e.getKeyCode()] = false;
            }
        });

        this.screen.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouse[e.getButton()] = true;
            }

            public void mouseReleased(MouseEvent e){
                mouse[e.getButton()] = false;
            }
        });

    }

    public void start() {
        this.running = true;
        this.thread.start();
    }

    public void stop() {
        this.running = false;
    }

    public void run() {
        long last = 0;
        while(this.running){
            if(System.currentTimeMillis() - last > (1000 / 60)) {
                this.tick();
                last = System.currentTimeMillis();
            }
            this.render();
        }
        onExitGame();
    }

    public void tick(){
        Point newMousePosition = screen.getMousePosition();
        if(newMousePosition != null) {
            this.mousePosition = newMousePosition;
            this.scaledMousePosition = screen.getScaledPosition(newMousePosition);
        }
        this.gameStates[this.gameState].tick(this);
    }

    public void render(){
        this.screen.render((Graphics2D graphics) -> {
            this.gameStates[this.gameState].render(this, graphics);
        });
    }

    public void setGameState(int gameState) {
        this.gameStates[this.gameState].deinit(this);
        this.gameState = gameState;
        this.gameStates[this.gameState].init(this);
    }

    public void onExitGame(){
        
    }

}
