package com.kryto.scrap.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

public class ImageLoader {

	public static int loadTexture(BufferedImage image) {
		
		int textureID = glGenTextures();
		
		glBindTexture(GL_TEXTURE_2D, textureID);
		
		int[] pixels = new int[image.getWidth() * image.getHeight()];

		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
		
        ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);
        
        for(int y = 0; y < image.getHeight(); y++){
        	
            for(int x = 0; x < image.getWidth(); x++){
            	
                int pixel = pixels[x + y * image.getWidth()];
                
                buffer.put((byte) ((pixel >> 16) & 0xFF));
                buffer.put((byte) ((pixel >> 8) & 0xFF));
                buffer.put((byte) (pixel & 0xFF)); 
                buffer.put((byte) ((pixel >> 24) & 0xFF));
            }
        }

        buffer.flip();
        
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, image.getWidth(), image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
        
        glBindTexture(GL_TEXTURE_2D, 0);
        
        return textureID;
	}
	
	public static BufferedImage loadImage(String path) {
		
		try {
			return ImageIO.read(ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
