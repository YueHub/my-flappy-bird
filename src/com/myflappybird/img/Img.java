package com.myflappybird.img;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Img {
	
	/**
	 * 背景图片
	 */
	public static Image background = new ImageIcon("skin/Graphics01/background.png").getImage();
	
	public static Image background1 = new ImageIcon("skin/Graphics01/background1.png").getImage();
	
	
	
	/**
	 * 游戏最初的欢迎界面
	 */
	public static Image loading = new ImageIcon("skin/Graphics01/loading.png").getImage();
	
	public static Image rect = new ImageIcon("skin/Graphics01/rect.png").getImage();
	
	/**
	 * 游戏开始时的图片
	 */
	public static Image start = new ImageIcon("skin/Graphics01/start.png").getImage();
	
	/**
	 * 开始游戏的按钮的图片
	 */
	public static ImageIcon btnBegin = new ImageIcon("skin/Graphics01/begin.png");
	
	/**
	 * 游戏准备就绪图片
	 */
	public static Image ready = new ImageIcon("skin/Graphics01/ready.png").getImage();
	
	/**
	 * 地面图片
	 */
	public static Image ground = new ImageIcon("skin/Graphics01/ground.png").getImage();
	
	/**
	 * 上方柱子图片
	 */
	public static Image pillar0 = new ImageIcon("skin/Graphics01/8.png").getImage();
	
	/**
	 * 下方柱子图片
	 */
	public static Image pillar1 = new ImageIcon("skin/Graphics01/9.png").getImage();
	
	/**
	 * 暂停图片
	 */
	public static Image pause = new ImageIcon("skin/Graphics01/pause.png").getImage();
	
	/**
	 * 死亡小鸟的图片
	 */
	public static Image deadbird = new ImageIcon("skin/Graphics01/deadbird.png").getImage();
	
	/**
	 *游戏结束后图片 
	 */
	public static Image gameover = new ImageIcon("skin/Graphics01/gameover.png").getImage();
	
	/**
	 * 游戏面板的图片
	 */
	public static Image scoreboard = new ImageIcon("skin/Graphics01/scoreboard.png").getImage();
	
	/**
	 * 窗口框架的图片
	 */
	public static Image[] windows;
	static {
		windows = new Image[3];
		for(int i = 0; i < 3;i++){
			windows[i] = new ImageIcon("skin/Graphics01/Window0"+i+".png").getImage();
		}
		
	}
	
	/**
	 * 数字图片
	 */
	public static Image[] num;
	static {
		num = new Image[10];
		for(int i = 0;i<10;i++){
			num[i] = new ImageIcon("skin/Graphics01/0"+i+".png").getImage();
		}
		
	}
	
	/**
	 * 动态小鸟的图片
	 */
	public static Image[] birds;
	static{
		birds = new Image[8];
		for(int i = 0;i<8;i++){
			birds[i] = new ImageIcon("skin/Graphics01/"+i+".png").getImage();
		}
	}
	
}
