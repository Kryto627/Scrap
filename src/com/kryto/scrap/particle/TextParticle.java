package com.kryto.scrap.particle;

import org.newdawn.slick.Color;

import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLFont;

public class TextParticle extends Particle {

	private String text;
	
	public TextParticle(String text, float x, float y, Color color, long time) {
		super(x, y, 0, 0, color, time, false);
		this.text = text;
		setVelcity(0, -2);
	}

	@Override
	public void render() {
		GLFont font = Assets.PIXEL_OPERATOR_SMALL;
		font.renderCentered(text, x, y, color);
	}
}
