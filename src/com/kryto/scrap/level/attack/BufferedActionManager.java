package com.kryto.scrap.level.attack;

import com.kryto.scrap.util.Timer;
import com.kryto.scrap.util.WipingArrayList;

public class BufferedActionManager {

	private WipingArrayList<IBufferedAction> attacks;
	private Timer attackTime;
	
	public BufferedActionManager() {
		attacks = new WipingArrayList<IBufferedAction>();
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
			
			IBufferedAction action = getFastestAttack();
			action.onAction();
			action.wipe();
		}
		
		attacks.clean();
	}
	
	private IBufferedAction getFastestAttack() {
		
		IBufferedAction fastest = null;
		
		for (IBufferedAction attack : attacks) {
			if (fastest == null || fastest.getSpeed() < attack.getSpeed()) {
				fastest = attack;
			}
		}
		
		return fastest;
	}
}
