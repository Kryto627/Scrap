package com.kryto.scrap.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage getImage(String imagePath) {
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(ImageLoader.class.getResourceAsStream(imagePath));
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
}
