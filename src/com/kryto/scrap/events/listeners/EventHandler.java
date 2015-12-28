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
	
	private List<IEventListerner> events;
	
	private EventHandler() {
		events = new ArrayList<IEventListerner>();
		init();
	}
	
	private void init() {
		addEvent(new EventCruise());
		addEvent(new EventBoiler());
		addEvent(new EventFridged());
		
		addEvent(new EventElementIce());
		addEvent(new EventElementFire());
	}
	
	public void post(IEvent event) {
		
		for (IEventListerner listerner : events) {
			
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
	
	public void addEvent(IEventListerner event) {
		events.add(event);
	}
}
