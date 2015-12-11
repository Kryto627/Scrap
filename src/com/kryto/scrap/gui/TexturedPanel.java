package com.kryto.scrap.gui;

import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.GLSprite;

public class TexturedPanel extends Component {

	private GLSprite sprite;
	
	public TexturedPanel(Rectangle bounds, GLSprite sprite) {
		super(bounds);
		this.sprite = sprite;
	}
	
	public TexturedPanel(float x, float y, GLSprite sprite) {
		super(new Rectangle(x, y, sprite.getWidth(), sprite.getHeight()));
		this.sprite = sprite;
	}

	@Override
	public void render() {
		sprite.render(bounds);
	}
	
	public GLSprite getSprite() {
		return sprite;
	}
}
