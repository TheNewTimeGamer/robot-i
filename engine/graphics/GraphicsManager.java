package engine.graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class GraphicsManager {
    
    private static HashMap<String, Texture> textures = new HashMap<String, Texture>();

    public static boolean load(File file) {
        if(!file.exists() || !file.isFile()) {
            return false;
        }
        try{
            String baseFileName = file.getName().split("\\.")[0];
            Texture texture = new Texture(baseFileName, ImageIO.read(file));
            textures.put(baseFileName, texture);
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public static Texture getTexture(String name) {
        return textures.get(name);
    }

    public static Texture getTexture(String name, int width, int height) {
        String scaledTextureName = name + "_" + width + "x" + height;
        Texture texture = textures.get(scaledTextureName);
        if(texture != null) {
            return texture;
        }
        
        texture = textures.get(name);
        if(texture == null){
            System.err.println("Could not find texture with name: " + name);
            return null;
        }

        BufferedImage scaledImage = (BufferedImage) texture.image.getScaledInstance(width, height, Image.SCALE_FAST);
        Texture scaledTexture = new Texture(scaledTextureName, scaledImage);
        textures.put(scaledTextureName, scaledTexture);

        return scaledTexture;
    }

}
