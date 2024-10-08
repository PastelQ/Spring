package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	//MarioGame game;
	private GamingConsole game;
	
	public GameRunner(@Qualifier("SuperContraGameQualifier")GamingConsole game) {
		this.game = game;
	}
	
	public void run() {
		// 일반적으로는 로깅 프레임워크 사용
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}