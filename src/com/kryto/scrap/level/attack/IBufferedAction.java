package com.kryto.scrap.level.attack;

import com.kryto.scrap.util.IWipeable;

public interface IBufferedAction extends IWipeable {

	public void onAction();
	
	public int getSpeed();
}
