package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

// @Component : Spring 컨테이너에 의해 자동으로 빈으로 등록
@Component
public class PacmanGame implements GamingConsole {

	public void up() {
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("down");
	}
	
	public void left() {
		System.out.println("left");
	}
	
	public void right() {
		System.out.println("right");
	}
}
