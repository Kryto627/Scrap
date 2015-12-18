package com.kryto.scrap.util;

import java.util.ArrayList;
import java.util.Iterator;

public class WipingArrayList<T extends IWipeable> extends ArrayList<T> {

	private static final long serialVersionUID = 1L;

	public void clean() {
		
		Iterator<T> iterator = iterator();
		
		while (iterator.hasNext()) {
			
			T obj = iterator.next();
			
			if (obj.wiped()) {
				iterator.remove();
			}
		}
	}
}
