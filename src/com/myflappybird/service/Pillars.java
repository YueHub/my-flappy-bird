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
	 * ���ݴ����
	 */
	GameDto dto;
	
	/**
	 * �ڲ��ࣨ�����ࣩ
	 */
	private class Pillar{
		/**
		 * ���ӵĿ��
		 */
		private static final int PILLAR_W = 70;
		
		/**
		 * ���ӵĸ߶�
		 */
		private static final int PILLAR_H = 500;
		
		/**
		 * ���ӵ�X����
		 */
		private int pillarX;
		
		/**
		 * ���ӵ�Y����
		 */
		private int pillarY;
		
		/**
		 * ���ӵĹ��췽��
		 */
		public Pillar(int pillarX,int pillarY){
			this.pillarX = pillarX;
			this.pillarY = pillarY;
		}
		
		/**
		 * �������ӵķ���
		 */
		public void drawPillar(Graphics g,Image img){
			g.drawImage(img, pillarX, pillarY, null);
		}
	}

	/**
	 * �������������
	 */
	private Pillar abovePillar;
	
	/**
	 * �������������
	 */
	private Pillar belowPillar;
	
	/**
	 * �������ƶ����ٶ�
	 */
	private final int PILLARS_SPEED = 8;  
	
	/**
	 * ������������������ӿ�϶�ĸߵ�
	 */
	private int y ;
	
	/**
	 *������Ĺ��췽�� 
	 */
	public Pillars(GameDto dto ,int pillarsX){
		this.dto = dto;
		y = 200+(int)(Math.random()*300);
		abovePillar = new Pillar(pillarsX,-y);
		belowPillar = new Pillar(pillarsX,700-y);
	}
	
	/**
	 * �ƶ����ӵķ���
	 */
	public void moveX(){
		//����Ƿ�Խ��С��
		this.calcScore();
		//�����Ϸ��ͣ�Ͳ����ƶ�
		if(this.dto.isPause()||this.dto.isBirdDead()){
			return ;
		}
		//���������ʧ�ڻ���֮��ͻص���ʼ��
		if(abovePillar.pillarX<-Pillar.PILLAR_W||belowPillar.pillarX<-Pillar.PILLAR_W){
			abovePillar.pillarX = 650;
			belowPillar.pillarX = 650;
			y = 200+(int)(Math.random()*300);
			abovePillar.pillarY = -y;
			belowPillar.pillarY = 700-y;
		}
		abovePillar.pillarX-=PILLARS_SPEED;
		belowPillar.pillarX-=PILLARS_SPEED;
	}
	
	public void moveY(){
		int i = 0;
		for(;abovePillar.pillarY>=(-y)&&abovePillar.pillarY<=(-y+50)&&i==0;i++){
			abovePillar.pillarY++;
		}
		
	}
	
	/**
	 * ��������ķ���
	 */
	public void calcScore(){
		if(this.goThroughBird()){
			int score = this.dto.getScore();
			score++;
			this.dto.setScore(score);
		}
	}
	
	/**
	 * �õ������ӵľ���
	 */
	public Rectangle getRect1(){
		return new Rectangle(abovePillar.pillarX,abovePillar.pillarY,Pillar.PILLAR_W,Pillar.PILLAR_H);
	}
	
	/**
	 * �õ������ӵľ���
	 */
	public Rectangle getRect2(){
		return new Rectangle(belowPillar.pillarX,belowPillar.pillarY,Pillar.PILLAR_W,Pillar.PILLAR_H);
	}
	
	/**
	 * С��ͨ������ʱ
	 */
	public void throughMusic(){
		if(this.goThroughBird()){
			try {
				Music throughMusic = new Music("Music/point.wav");
				throughMusic.musicPlay();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	/**
	 * ����������
	 */
	public void drawPillars(Graphics g){ 
		//����������
		abovePillar.drawPillar(g, Img.pillar0);
		//����������
		belowPillar.drawPillar(g, Img.pillar1);
	}
	
	/**
	 * С���Ƿ�ͨ�����ӵ��ж�
	 */
	public boolean goThroughBird(){
		return abovePillar.pillarX>=(100-PILLARS_SPEED/2)&&abovePillar.pillarX<=(100+PILLARS_SPEED/2);
}
}