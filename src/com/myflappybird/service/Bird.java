package com.myflappybird.service;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import com.myflappybird.dto.GameDto;
import com.myflappybird.img.Img;
import com.myflappybird.music.Music;

public class Bird {
	
	GameDto dto;
	
	/**
	 * 小鸟的长度
	 */
	private static final int BIRD_WIDTH = 56;
	
	/**
	 * 小鸟的宽度
	 */
	private static final int BIRD_HEIGHT = 48;
	
	/**
	 * 小鸟的Ｘ坐标
	 */
	private int birdX;
	
	/**
	 * 小鸟的Ｙ坐标
	 */
	private int birdY;
	
	/**
	 *　小鸟的ID
	 */
	private int birdID;
	
	public Bird(GameDto dto,int birdX, int birdY) {
		this.birdID = 0;
		this.dto = dto;
		this.birdX = birdX;
		this.birdY = birdY;
	}
	
	/**
	 * 小鸟飞翔
	 */
	public void birdFly() {
		if (!this.dto.isGamestart() || this.dto.isGameover() ) {
			return ;
		}
		double speed = this.dto.getSpeed() + 4.3;
		this.dto.setSpeed(speed);
		birdY += speed;
	}
	
	/**
	 * 小鸟死亡
	 */
	public void birdDead() {
		//　判断小鸟是否撞地
		if (this.birdHitGround()) {
			this.dieMusic();
			this.hitMusic();
			this.dto.setBirdDead(true);
			this.dto.setGameover(true);
		}
		//　判断小鸟是否装柱子
		if (this.birdHitPillars()) {
			if (!this.dto.isBirdDead()) {
				this.dieMusic();
				this.hitMusic();
			}
			this.dto.setBirdDead(true);
			birdY += 8;
		}
	}
	
	/**
	 * 飞翔音效
	 */
	public void flyMusic() {
		try {
			Music  flyMusic = new Music("Music/wing.wav");
			flyMusic.musicPlay();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 死亡音效
	 */
	public void dieMusic() {
		try {
			Music dieMusic = new Music("Music/die.wav");
			dieMusic.musicPlay();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 撞击音效
	 */
	public void hitMusic() {
		try {
			Music hitMusic = new Music("Music/hit.wav");
			hitMusic.musicPlay();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用以碰撞检测
	 */
	public Rectangle getRect() {
		return new Rectangle(birdX, birdY, BIRD_WIDTH, BIRD_HEIGHT);
	}
	
	/**
	 * 绘制小鸟
	 */
	public void drawBird(Graphics g) {
		//　小鸟死亡　绘制死亡小鸟
		if (this.dto.isBirdDead()) {
			g.drawImage(Img.deadbird, birdX, birdY, null);
		} 
		//　未死亡　绘制飞翔小鸟
		else {
			//Graphics2D g2 = (Graphics2D)g;
			//g2.rotate(Math.toRadians(this.dto.getSpeed()*1.1),birdX+BIRD_WIDTH/2,birdY+BIRD_HEIGHT/2);
			if (birdID == 8) {
				birdID = 0;
			}
			g.drawImage(Img.birds[birdID++], birdX, birdY, null);
		}
		
	}

	/**
	 * 获取小鸟Ｘ坐标
	 */
	public int getBirdX() {
		return birdX;
	}
	
	/**
	 * 设置小鸟Ｘ坐标
	 */
	public void setBirdX(int birdX) {
		this.birdX = birdX;
	}
	
	/**
	 * 获取小鸟Y坐标
	 */
	public int getBirdY() {
		return birdY;
	}
	
	/**
	 * 设置小鸟Ｙ坐标
	 */
	public void setBirdY(int birdY) {
		this.birdY = birdY;
	}
	
	/**
	 * 判断小鸟是否撞地
	 */
	public boolean birdHitGround() {
		return (birdY > 500 - 48);
	}
	
	/**
	 * 判断小鸟是否撞柱子
	 * @return
	 */
	public boolean birdHitPillars() {
		for (int i = 0; i < 3; i++) {
			if (this.getRect().intersects(this.dto.getPillars()[i].getRect1()) || this.getRect().intersects(this.dto.getPillars()[i].getRect2())) {
				return true;
			}
		}
		return false;
	}
}
