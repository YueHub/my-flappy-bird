package com.myflappybird.control;

import com.myflappybird.dto.GameDto;

public class GameControl {
	
	/**
	 * 数据传输层
	 */
	GameDto dto;
	
	/**
	 * 构造方法
	 */
	public GameControl(GameDto dto){
		this.dto = dto;
	}
	
	/**
	 * 游戏开始
	 */
	public void gameStart(){
		this.dto.setGamestart(true);
	}
	
	/**
	 * 调用逻辑层小鸟向上飞的方法
	 */
	public void birdUp(){
		if(this.dto.isBirdDead()){
			return ;
		}
		this.dto.setSpeed(-22.3);
		this.dto.getBird().flyMusic();
	}

	/**
	 * 设置游戏暂停为true
	 */
	public void pause() {
		this.dto.setPause(!this.dto.isPause());
	}
}
