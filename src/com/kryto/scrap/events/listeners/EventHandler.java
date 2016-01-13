package com.kryto.scrap.events.listeners;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.kryto.scrap.events.IEvent;

public class EventHandler {

	private static EventHandler instance = new EventHandler();
	
	public static EventHandler getInstance() {
		return instance;
	}
	
	private List<IEventListener> events;
	
	private EventHandler() {
		events = new ArrayList<IEventListener>();
		init();
	}
	
	private void init() {
		addEvent(new EventCruise());
		addEvent(new EventBoiler());
		addEvent(new EventFridged());
		
		addEvent(new EventElementIce());
		addEvent(new EventElementFire());
		
		addEvent(new EventEffectListener());
	}
	
	public void post(IEvent event) {
		
		for (IEventListener listerner : events) {
			
			for (Method method : listerner.getClass().getMethods()) {
				
				if (method.getParameterTypes().length == 1) {
					
					Class<?> c = method.getParameterTypes()[0];
					
					if (c.equals(event.getClass())) {
						
						try {
							method.invoke(listerner, event);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public void addEvent(IEventListener event) {
		events.add(event);
	}
}
