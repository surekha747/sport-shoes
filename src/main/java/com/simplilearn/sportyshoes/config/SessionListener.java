package com.simplilearn.sportyshoes.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener  implements HttpSessionListener {
	private static int totalActiveSessions;
	
	public static int getTotalActiveSession(){
		return totalActiveSessions;
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		event.getSession().setMaxInactiveInterval(30*60);
		totalActiveSessions++;
		System.out.println("sessionCreated - add one session into counter");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		totalActiveSessions--;
		System.out.println("sessionDestroyed - deduct one session from counter");
	}
	
}
