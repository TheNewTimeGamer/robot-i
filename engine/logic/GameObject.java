package engine.logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import engine.Game;
import engine.graphics.Renderable;
import engine.graphics.Texture;

public class GameObject implements Tickable, Renderable {
    
    public float x;
    public float y;
    public float width;
    public float height;

    public Texture texture;

    private boolean enabled;
    private boolean solid;
    private boolean visible;

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public GameObject(float x, float y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
    }

    public GameObject(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public GameObject(float x, float y, float width, float height, Texture texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
    }

    public void tick(Game game) {
        if(!this.enabled){return;}
    }

    public void render(Graphics2D graphics) {
        if(!this.visible){return;}
        if(this.texture == null){
            graphics.setColor(Color.PINK);
            graphics.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
            return;
        }
        if((int) this.width != this.texture.image.getWidth() || (int) this.height != this.texture.image.getHeight()) {
            graphics.drawImage(this.texture.image, (int)this.x, (int)this.y, (int)this.width, (int)this.height, null);
        }else{
            graphics.drawImage(this.texture.image, (int)this.x, (int)this.y, null);
        }
    }

    public boolean isEnabled(){
        return this.enabled;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public boolean isSolid(){
        return this.solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }
}
