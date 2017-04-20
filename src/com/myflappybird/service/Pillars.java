package com.myflappybird.service;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import com.myflappybird.dto.GameDto;
import com.myflappybird.img.Img;
import com.myflappybird.music.Music;

public class Pillars {
	
	/**
	 * 数据传输层
	 */
	GameDto dto;
	
	/**
	 * 柱子内部类
	 */
	private class Pillar {
		/**
		 * 柱子的长度
		 */
		private static final int PILLAR_W = 70;
		
		/**
		 * 柱子的宽度
		 */
		private static final int PILLAR_H = 500;
		
		/**
		 * 柱子的Ｘ坐标
		 */
		private int pillarX;
		
		/**
		 * 柱子的Ｙ坐标
		 */
		private int pillarY;
		
		public Pillar(int pillarX,int pillarY) {
			this.pillarX = pillarX;
			this.pillarY = pillarY;
		}
		
		/**
		 * 绘制柱子
		 */
		public void drawPillar(Graphics g,Image img) {
			g.drawImage(img, pillarX, pillarY, null);
		}
	}

	/**
	 * 上方柱子
	 */
	private Pillar abovePillar;
	
	/**
	 * 下方柱子
	 */
	private Pillar belowPillar;
	
	/**
	 * 柱子移动的速度
	 */
	private final int PILLARS_SPEED = 8;  
	
	/**
	 * 柱子的
	 */
	private int y ;
	
	public Pillars(GameDto dto ,int pillarsX) {
		this.dto = dto;
		y = 200+(int)(Math.random()*300);
		abovePillar = new Pillar(pillarsX,-y);
		belowPillar = new Pillar(pillarsX,700-y);
	}
	
	/**
	 * 左移
	 */
	public void moveX() {
		//　计算分数
		this.calcScore();
		//　是否暂停或小鸟是否死亡
		if (this.dto.isPause()||this.dto.isBirdDead()) {
			return ;
		}
		//　柱子的上下移动
		if (abovePillar.pillarX<-Pillar.PILLAR_W||belowPillar.pillarX<-Pillar.PILLAR_W) {
			abovePillar.pillarX = 650;
			belowPillar.pillarX = 650;
			y = 200+(int)(Math.random()*300);
			abovePillar.pillarY = -y;
			belowPillar.pillarY = 700-y;
		}
		abovePillar.pillarX-=PILLARS_SPEED;
		belowPillar.pillarX-=PILLARS_SPEED;
	}
	
	public void moveY() {
		int i = 0;
		for (;abovePillar.pillarY>=(-y) && abovePillar.pillarY<=(-y+50) && i==0; i++) {
			abovePillar.pillarY++;
		}
		
	}
	
	/**
	 * 计算分数
	 */
	public void calcScore() {
		if (this.goThroughBird()) {
			int score = this.dto.getScore();
			score++;
			this.dto.setScore(score);
		}
	}
	
	/**
	 * 用以上柱子碰撞检测
	 */
	public Rectangle getRect1() {
		return new Rectangle(abovePillar.pillarX,abovePillar.pillarY,Pillar.PILLAR_W,Pillar.PILLAR_H);
	}
	
	/**
	 *　用以下柱子碰撞检测
	 */
	public Rectangle getRect2() {
		return new Rectangle(belowPillar.pillarX,belowPillar.pillarY,Pillar.PILLAR_W,Pillar.PILLAR_H);
	}
	
	/**
	 * 通过柱子的音效
	 */
	public void throughMusic() {
		if (this.goThroughBird()) {
			try {
				Music throughMusic = new Music("Music/point.wav");
				throughMusic.musicPlay();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	/**
	 * 绘制柱子
	 */
	public void drawPillars(Graphics g) { 
		//　绘制上柱子
		abovePillar.drawPillar(g, Img.pillar0);
		//　绘制下柱子
		belowPillar.drawPillar(g, Img.pillar1);
	}
	
	/**
	 *　小鸟是否穿过 
	 */
	public boolean goThroughBird() {
		return abovePillar.pillarX>=(100-PILLARS_SPEED/2)&&abovePillar.pillarX<=(100+PILLARS_SPEED/2);
}
}