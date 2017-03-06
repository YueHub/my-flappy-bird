package com.myflappybird.ui;

import java.awt.Graphics;
import javax.swing.JPanel;
import com.myflappybird.control.PlayerControl;
import com.myflappybird.dto.GameDto;
import com.myflappybird.img.Img;

public class GamePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ϸ���ݴ����
	 */
	GameDto dto;
	
	/**
	 * ��Ϸ����ʱ��ʱ��
	 */
	long loadstart;
	
	/**
	 * ���췽��
	 */
	public GamePanel(GameDto dto){
		this.dto = dto;
		this.setLayout(null);// �����ò��ֹ�����Ϊ
		this.loadstart = System.currentTimeMillis();
	}
	
	/**
	 * ��װ��ҿ�����
	 */
	public void setPlayerControl(PlayerControl playercontrol){
		this.addKeyListener(playercontrol);
	}

	/**
	 * ����ˢ��
	 */
	public void paintComponent(Graphics g){	
		//�����Ϸ������ͻ�����Ϸ������Ľ���
		if(this.dto.isGameover()){
			this.reFleshGameOver(g);
			return ;
		}
		this.reFleshButton();
		this.reFleshPicture(g);
		this.reFleshPillars(g);
		this.reFleshGround(g);
		this.reFleshScore(g);
		this.reFleshBird(g);
		this.reFleshGameLoad(g);
		this.dto.getGamedata().saveData();
		//��ȡ����
		this.requestFocus();
	}
	
	/**
	 * ˢ�°�ť
	 */
	public void reFleshButton(){
		if(this.dto.isGamestart()){
			this.remove(this.dto.getBtnStart());
		}
	}
	
	/**
	 * ˢ�����뻭��
	 * @param g
	 */
	public void reFleshGameLoad(Graphics g){
		long loadend = System.currentTimeMillis();
		long space = loadend - loadstart;
		int x = (int )(space/5);
		if(space <= 2150){
			g.drawImage(Img.loading, 0, 0, null);
			CreateWindow.drawWindow(g, Img.windows[0], 100, 400, 430, 10);
			g.drawImage(Img.rect, 100, 400, 100+x, 400 + 10, 0, 0, x, 10, null);
		}
		else{
			if(!this.dto.isGamestart()){
				this.add(this.dto.getBtnStart());
			}
			return ;
		}
	}
	
	/**
	 * ˢ��ͼƬ
	 * @param g
	 */
	public void reFleshPicture(Graphics g){
		//���Ʊ���
		g.drawImage(Img.background, 0, 0, null);
		//��Ϸ�Ƿ�ʼ
		if(!this.dto.isGamestart()){
			g.drawImage(Img.start, 0, 0, null);
		}
		//��Ϸ��ͣ���ͼƬ
		if(this.dto.isPause()){
			g.drawImage(Img.pause, 180, 255, null);
		}
	}
	
	/**
	 * ���Ʒ����ķ���
	 */
	public void reFleshScore(Graphics g){
		int x = (int)this.dto.getScore()/100;
		int y = (this.dto.getScore()/10)%10;
		int z = this.dto.getScore()%10;
		g.drawImage(Img.num[x], 0, 0, null);
		g.drawImage(Img.num[y], 28, 0, null);
		g.drawImage(Img.num[z], 56, 0, null);
	}
	
	/**
	 * ˢ��С��
	 * @param g
	 */
	public void reFleshBird(Graphics g){
		//����С��
		this.dto.getBird().drawBird(g);
		if(this.dto.isGamestart()){
			//С��ͣ���µ�	
			this.dto.getBird().birdFly();
		}
		this.dto.getBird().birdDead();
	}
	
	/**
	 * ˢ�µ���
	 * @param g
	 */
	public void reFleshGround(Graphics g){
		//���Ƶ���
		this.dto.getGround().drawGround(g);
		//�����ƶ�
		this.dto.getGround().move();
	}
	
	/**
	 * ˢ��������
	 * @param g
	 */
	public void reFleshPillars(Graphics g){
		if(this.dto.isGamestart()){
		//��������
		for(int i = 0;i<3;i++){
			this.dto.getPillars()[i].drawPillars(g);
		}
		//�������ƶ�
		for(int i = 0;i<3;i++){
			this.dto.getPillars()[i].moveX();
			this.dto.getPillars()[i].moveY();
			}	
		}
		//ͨ��������ʱ������
		for(int i = 0;i < 3;i++){
			this.dto.getPillars()[i].throughMusic();
		}
	}
	
	/**
	 * ������Ϸ������Ľ���
	 */
	public void reFleshGameOver(Graphics g){
			//���Ʊ���
			g.drawImage(Img.background, 0, 0, null);
			//�������
			this.dto.getScoreboard().drawBoard(g);
			this.dto.getScoreboard().drawBoard(g);
			//�����ƶ�
			this.dto.getScoreboard().boardMove();
	}
	
	
}
