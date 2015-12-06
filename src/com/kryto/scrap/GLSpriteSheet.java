package com.kryto.scrap;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;
import org.newdawn.slick.util.ResourceLoader;

public class GLSpriteSheet {

	private BufferedImage image;
	
	public GLSpriteSheet(String path) {
		try {
			this.image = ImageIO.read(ResourceLoader.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public GLSprite getSubSprite(int x, int y, int w, int h) {
		
		BufferedImage subTile = image.getSubimage(x, y, w, h);
		
		try {
			Texture tileTexture = BufferedImageUtil.getTexture("", subTile, GL11.GL_NEAREST);
			return new GLSprite(tileTexture);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
