package com.myflappybird.service;

import java.awt.Graphics;
import com.myflappybird.img.Img;
import com.myflappybird.ui.CreateWindow;

public class ScoreBoard {
	
	/**
	 * 分数面板的X坐标
	 */
	private int boardX;
	
	/**
	 * 面板的运动的速度
	 */
	private final int BOARD_SPEED = 8;
	
	/**
	 * 面板的宽度
	 */
	private final int BOARD_WIDTH = 500;
	
	/**
	 * 面板的高度
	 */
	private final int BOARD_HEIGHT = 200;
	
	/**
	 * 分数面板的Y坐标
	 */
	private int boardY;
	
	/**
	 * 构造方法
	 * @param boardX
	 * @param boardY
	 */
	public ScoreBoard(int boardX, int boardY) {
		this.boardX = boardX;
		this.boardY = boardY;
	}
	
	/**
	 * 面板移动的方法
	 */
	public void boardMove() {
		if (boardY < 100) {
			return ;
		}
		boardY -= BOARD_SPEED;
	}
	
	/**
	 * 绘制面板的方法
	 * @param g
	 */
	public void drawBoard(Graphics g) {
		//绘制window
		CreateWindow.drawWindow(g, Img.windows[0], boardX, boardY, BOARD_WIDTH, BOARD_HEIGHT);
		//绘制死亡小鸟 
		g.drawImage(Img.deadbird, boardX, boardY, null);	
	}
	
}