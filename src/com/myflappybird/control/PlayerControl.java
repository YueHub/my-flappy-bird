package com.myflappybird.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.myflappybird.dto.GameDto;

public class PlayerControl extends KeyAdapter {

	/**
	 * 数据传输层
	 */
	GameDto dto;
	
	/**
	 * 游戏控制器
	 */
	GameControl gamecontrol;
	
	/**
	 * 构造方法
	 */
	public PlayerControl(GameDto dto) {
		this.dto = dto;
		gamecontrol = new GameControl(this.dto);
	}
	
	/**
	 * 事件监听
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
			case KeyEvent.VK_UP:
				this.gamecontrol.birdUp();
				break;
			case KeyEvent.VK_ENTER:
				this.gamecontrol.pause();
				break;
			case KeyEvent.VK_F1:
				this.gamecontrol.gameStart();
				break;
			default:break;
		}	
	}
}