package com.kryto.scrap.particle;

import java.util.Random;

import org.newdawn.slick.Color;

import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.util.IWipeable;
import com.kryto.scrap.util.Timer;

public class Particle implements IWipeable {

	Random random = new Random();
	
	public static final float GRAVITY = 0.1F;
	public static final float MAX_GRAVITY = 5F;
	
	public float x, y, width, height;
	public Timer timer;
	public Color color;
	
	public float dx, dy;
	public boolean useGravity;
	
	private boolean isDead;
	
	public Particle(float x, float y, float width, float height, Color color, long time, boolean useGravity) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.useGravity = useGravity;
		this.timer = new Timer(time + random.nextInt(300));
		this.isDead = false;
	}
	
	public void setVelcity(float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void update() {
		
		if (timer.isDoneAndReset()) {
			wipe();
		}
		
		x += dx;
		y += dy;
		
		if (useGravity && dy < MAX_GRAVITY) {
			dy += GRAVITY;
		}
	}
	
	public void render () {
		getBounds().fill(color);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	@Override
	public void wipe() {
		isDead = true;
	}

	@Override
	public boolean wiped() {
		return isDead;
	}
}
