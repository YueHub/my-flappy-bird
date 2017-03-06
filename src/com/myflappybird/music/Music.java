package com.myflappybird.music;

import sun.audio.*; // 引 入sun.audio 包
import java.io.*;

public class Music {

	/**
	 * 声音输入流
	 */
	InputStream in ;
	
	/**
	 * AudioStream对象
	 */
	AudioStream as ; 
	
	/**
	 * 构造方法
	 */
	public Music(String filename) throws IOException{
		//打开一个声音文件作为输入流
		in = new FileInputStream (filename);
		//根据输入流创建AudioStream对象
		as = new AudioStream(in); 
	}
	
	/**
	 * 声音播放
	 */
	public void musicPlay(){ 
		//用AudioPlayer中的静态成员player控制播放
		AudioPlayer.player.start(as); 
	}
	
	
}
