package com.kryto.scrap.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
	
	public void call(Consumer<IEventListerner> con) {
		events.forEach(con);
	}
	
	public void addEvent(IEventListerner event) {
		events.add(event);
	}
}
