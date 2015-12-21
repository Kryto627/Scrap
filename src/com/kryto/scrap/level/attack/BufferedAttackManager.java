package com.kryto.scrap.level.attack;

import com.kryto.scrap.util.Timer;
import com.kryto.scrap.util.WipingArrayList;

public class BufferedAttackManager {

	private WipingArrayList<BufferedAttack> attacks;
	private Timer attackTime;
	
	public BufferedAttackManager() {
		attacks = new WipingArrayList<BufferedAttack>();
		attackTime = new Timer(1000);
	}
	
	public boolean isDone() {
		return attacks.size() == 0;
	}
	
	public void addAttack(BufferedAttack attack) {
		attacks.add(attack);
	}
	
	public void update() {
		
		if (attackTime.isDoneAndReset() && !isDone()) {
			
			getFastestAttack().attack();
		}
		
		attacks.clean();
	}
	
	private BufferedAttack getFastestAttack() {
		
		BufferedAttack fastest = null;
		
		for (BufferedAttack attack : attacks) {
			if (fastest == null || fastest.getSpeed() < attack.getSpeed()) {
				fastest = attack;
			}
		}
		
		return fastest;
	}
}
