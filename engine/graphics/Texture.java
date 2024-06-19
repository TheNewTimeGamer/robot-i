package engine.graphics;

import java.awt.image.BufferedImage;

public class Texture {
 
    public final String name;
    public final BufferedImage image;

    public Texture(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    }
    
}
