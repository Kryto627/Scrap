package com.kryto.scrap.level.attack;

import java.util.ArrayList;
import java.util.List;

import com.kryto.scrap.util.Timer;

public class BufferedAttackManager {

	private List<BufferedAttack> attacks;
	private Timer attackTime;
	
	public BufferedAttackManager() {
		attacks = new ArrayList<BufferedAttack>();
		attackTime = new Timer(1000);
	}
	
	public void next() {
		attacks.remove(0);
	}
	
	public boolean isDone() {
		return attacks.size() == 0;
	}
	
	public void addAttack(BufferedAttack attack) {
		attacks.add(attack);
	}
	
	public void update() {
		
		if (attackTime.isDoneAndReset() && !isDone()) {
			
			BufferedAttack attack = attacks.get(0);
			
			attack.attack();
			
			next();
		}
	}
}
