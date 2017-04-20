package com.myflappybird.ui;

import javax.swing.JFrame;
import com.myflappybird.dto.GameDto;

public class GameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Frame宽度
	 */
	private static final int FRAME_WIDTH = 650;
	
	/**
	 * Frame高度
	 */
	private final int FRAME_HEIGHT = 650;
	
	/**
	 * FrameＸ坐标
	 */
	private final int FRAME_X = 350;
	
	/**
	 * FrameＹ坐标
	 */
	private final int FRAME_Y = 50;

	/**
	 * 游戏线程
	 */
	 Thread gamethread; 
	 
	/**
	 * 游戏panel 
	 */
	 GamePanel gamepanel;
	
	 /**
	  * 数据传输层
	  */
	 GameDto dto;
	
	public GameFrame(GamePanel gamepanel,GameDto dto) {
		this.gamepanel = gamepanel;
		this.dto = dto;
		//　设置pan内容
		this.setContentPane(gamepanel);
		//　设置位置
		this.setLocation(FRAME_X, FRAME_Y);
		//　frame大小
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//　标题
		this.setTitle("锟斤拷锟斤拷锟斤拷小锟斤拷");
		//　是否大小可调节
		this.setResizable(false);
		//　关闭按钮
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//　是否课件
		this.setVisible(true);
		//　刷新线程
		this.reFleshThread();
	}
	
	/**
	 * 刷新画面
	 */
	public void reFleshThread() {
		gamethread = new Thread() {
			//　多线程
			public void run(){
				while(true){
					try {
						Thread.sleep(50);
						gamepanel.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//锟斤拷锟斤拷锟竭筹拷
		gamethread.start();
	}
	
}
