package engine.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import engine.Game;

public class Screen extends Canvas {
    
    public final JFrame frame;

    private Color clearColor = Color.BLACK;

    private int renderWidth, renderHeight;

    public Screen(int renderWidth, int renderHeight, int screenWidth, int screenHeight) {
        this.renderWidth = renderWidth;
        this.renderHeight = renderHeight;

        this.frame = new JFrame();
        this.frame.setSize(screenWidth, screenHeight);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(this);
        this.frame.setVisible(true);
    }

    public void render(Renderable renderAction) {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D graphics = (Graphics2D) bs.getDrawGraphics();

        graphics.setColor(this.clearColor);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

        graphics.scale((double) this.getWidth() / this.renderWidth, (double) this.getHeight() / this.renderHeight);

        renderAction.render(graphics);

        graphics.dispose();
        bs.show();
    }

    public Color getClearColor() {
        return this.clearColor;
    }

    public void setClearColor(Color color) {
        this.clearColor = color;
    }

    public void setRenderSize(int width, int height) {
        this.renderWidth = width;
        this.renderHeight = height;
    }

    public Point getScaledPosition(Point p) {
        double scaleX = (double) this.getWidth() / this.renderWidth;
        double scaleY = (double) this.getHeight() / this.renderHeight;
        return new Point((int) (p.x * scaleX), (int) (p.y * scaleY));
    }

}
