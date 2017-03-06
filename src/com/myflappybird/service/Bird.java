package com.myflappybird.service;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import com.myflappybird.dto.GameDto;
import com.myflappybird.img.Img;
import com.myflappybird.music.Music;

public class Bird {
	
	/**
	 * ���ݴ����
	 */
	GameDto dto;
	
	/**
	 * С��ĳ���
	 */
	private static final int BIRD_WIDTH = 56;
	
	/**
	 * С��ĸ߶�
	 */
	private static final int BIRD_HEIGHT = 48;
	
	/**
	 * ���X����
	 */
	private int birdX;
	
	/**
	 * ���Y����
	 */
	private int birdY;
	
	/**
	 *���ͼƬid 
	 */
	private int birdID;
	
	/**
	 * ���췽��
	 */
	public Bird(GameDto dto,int birdX, int birdY){
		this.birdID = 0;
		this.dto = dto;
		this.birdX = birdX;
		this.birdY = birdY;
	}
	
	/**
	 * С�����ķ��������������˶��������˶���
	 */
	public void birdFly(){
		if(!this.dto.isGamestart() || this.dto.isGameover() ){
			return ;
		}
		double speed = this.dto.getSpeed() + 4.3;
		this.dto.setSpeed(speed);
		birdY += speed;
	}
	
	/**
	 * С�������Ĵ���
	 */
	public void birdDead(){
		//���С��ײ�ϵ��� ������С������  ��Ϸ����
		if(this.birdHitGround()){
			this.dieMusic();
			this.hitMusic();
			this.dto.setBirdDead(true);
			this.dto.setGameover(true);
		}
		//���С��ײ������������С������  ��������׹��
		if(this.birdHitPillars()){
			if(!this.dto.isBirdDead()){
				this.dieMusic();
				this.hitMusic();
			}
			this.dto.setBirdDead(true);
			birdY += 8;
		}
	}
	
	/**
	 * С��ɵ�����
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
	 * С������������
	 */
	public void dieMusic(){
		try {
			Music dieMusic = new Music("Music/die.wav");
			dieMusic.musicPlay();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * С��ײ�����������ʱ������
	 */
	public void hitMusic(){
		try {
			Music hitMusic = new Music("Music/hit.wav");
			hitMusic.musicPlay();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �õ���ľ��εķ���
	 */
	public Rectangle getRect(){
		return new Rectangle(birdX, birdY, BIRD_WIDTH, BIRD_HEIGHT);
	}
	
	/**
	 * ������ķ���
	 */
	public void drawBird(Graphics g){
		//���С�������ͻ���������С��
		if(this.dto.isBirdDead()){
			g.drawImage(Img.deadbird, birdX, birdY, null);
		} 
		//���С��δ�����ͻ��ƶ�̬С��
		else{
			//Graphics2D g2 = (Graphics2D)g;
			//g2.rotate(Math.toRadians(this.dto.getSpeed()*1.1),birdX+BIRD_WIDTH/2,birdY+BIRD_HEIGHT/2);
			if(birdID==8){
				birdID = 0;
			}
			g.drawImage(Img.birds[birdID++], birdX, birdY, null);
		}
		
	}

	/**
	 * �õ����X����
	 */
	public int getBirdX(){
		return birdX;
	}
	
	/**
	 * �������X����
	 */
	public void setBirdX(int birdX){
		this.birdX = birdX;
	}
	
	/**
	 * �õ����Y����
	 */
	public int getBirdY(){
		return birdY;
	}
	
	/**
	 * �������Y����
	 */
	public void setBirdY(int birdY){
		this.birdY = birdY;
	}
	
	/**
	 * С���Ƿ�ײ���˵���
	 */
	public boolean birdHitGround(){
		return (birdY > 500 - 48);
	}
	
	/**
	 * С���Ƿ�ײ����������
	 * @return
	 */
	public boolean birdHitPillars(){
		for(int i = 0;i<3;i++){
			if(this.getRect().intersects(this.dto.getPillars()[i].getRect1())||this.getRect().intersects(this.dto.getPillars()[i].getRect2())){
				return true;
			}
		}
		return false;
	}
}
