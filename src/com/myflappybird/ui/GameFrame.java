package com.myflappybird.ui;

import javax.swing.JFrame;
import com.myflappybird.dto.GameDto;

public class GameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Frame锟侥匡拷锟�
	 */
	private static final int FRAME_WIDTH = 650;
	
	/**
	 * Frame锟侥高讹拷
	 */
	private final int FRAME_HEIGHT = 650;
	
	/**
	 * Frame锟斤拷X锟斤拷锟斤拷
	 */
	private final int FRAME_X = 350;
	
	/**
	 * Frame锟斤拷Y锟斤拷锟斤拷
	 */
	private final int FRAME_Y = 50;

	/**
	 * 锟斤拷锟斤拷刷锟斤拷锟斤拷戏锟斤拷锟斤拷锟斤拷叱锟�
	 */
	 Thread gamethread; 
	 
	/**
	 * 锟斤拷戏锟斤拷panel锟斤拷锟斤拷 
	 */
	 GamePanel gamepanel;
	
	 /**
	  * 锟斤拷戏锟斤拷锟捷诧拷
	  */
	 GameDto dto;
	
	/**
	 * 锟斤拷锟届方锟斤拷
	 */
	public GameFrame(GamePanel gamepanel,GameDto dto){
		this.gamepanel = gamepanel;
		this.dto = dto;
		//锟斤拷锟斤拷frame锟斤拷锟斤拷锟斤拷锟角达拷锟斤拷锟絧anel
		this.setContentPane(gamepanel);
		//frame锟斤拷位锟斤拷
		this.setLocation(FRAME_X, FRAME_Y);
		//frame锟侥达拷小
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//锟斤拷锟矫达拷锟节的憋拷锟斤拷
		this.setTitle("锟斤拷锟斤拷锟斤拷小锟斤拷");
		//锟斤拷锟节的达拷小锟斤拷锟缴憋拷
		this.setResizable(false);
		//锟斤拷锟矫关闭帮拷钮锟斤拷锟斤拷锟斤拷
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//锟斤拷锟矫达拷锟节可硷拷
		this.setVisible(true);
		//锟斤拷锟斤拷刷锟铰伙拷锟斤拷姆锟斤拷锟�
		this.reFleshThread();
	}
	
	/**
	 * 锟斤拷锟斤拷刷锟铰伙拷锟斤拷锟竭程的凤拷锟斤拷
	 */
	public void reFleshThread(){
		gamethread = new Thread(){
			//锟斤拷写run锟斤拷锟斤拷
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
