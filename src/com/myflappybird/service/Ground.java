package com.myflappybird.service;

import java.awt.Graphics;
import java.awt.Rectangle;
import com.myflappybird.dto.GameDto;
import com.myflappybird.img.Img;

public class Ground {
	
	/**
	 * 数据传输层
	 */
	GameDto dto;
	
	/**
	 * 地面的长度
	 */
	private final int GROUND_WIDTH = 800;
	
	/**
	 * 地面的高度
	 */
	private final int GROUND_HEIGHT = 150;
	
	/**
	 * 地面的X坐标
	 */
	private int groundX;
	
	/**
	 * 地面的Y坐标
	 */
	private int groundY;
	
	/**
	 * 地面的移动的速度
	 */
	private final int SPEED = 8;
	
	/**
	 * 地面的构造方法
	 */
	public Ground(GameDto dto ,int groundX,int groundY) {
		this.dto = dto;
		this.groundX = groundX;
		this.groundY = groundY;
	}
	
	/**
	 * 地面移动的方法
	 */
	public void move() {
		//如果游戏暂停或小鸟死亡地面就不再移动
		if (this.dto.isPause() || this.dto.isBirdDead()) {
			return ;
		}
		if (groundX <-100) {
			groundX=0;
		}
		groundX-=SPEED;
	}
	
	/**
	 * 得到地面的矩形
	 */
	public Rectangle getRect() {
		return new Rectangle(groundX,groundY,GROUND_WIDTH,GROUND_HEIGHT);
	}
	
	/**
	 * 绘制地面的方法
	 */
	public void drawGround(Graphics g) {
		g.drawImage(Img.ground, groundX, groundY, null);
	}
	
	/**
	 * 得到地面X坐标的方法
	 */
	public int getGroundX() {
		return groundX;
	}
	
	/**
	 * 设置地面X坐标的方法
	 */
	public void setGroundX(int groundX) {
		this.groundX = groundX;
	}
	
	/**
	 * 得到地面Y坐标的方法
	 */
	public int getGroundY() {
		return groundY;
	}
	
	/**
	 * 设置地面X坐标的方法
	 */
	public void setGroundY(int groundY) {
		this.groundY = groundY;
	}
}