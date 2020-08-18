package com.myflappybird.ui;

import com.myflappybird.control.PlayerControl;
import com.myflappybird.dto.GameDto;
import com.myflappybird.img.Img;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据传输层
     */
    GameDto dto;

    /**
     * 开始进度
     */
    long loadstart;

    public GamePanel(GameDto dto) {
        this.dto = dto;
        this.setLayout(null);// �����ò��ֹ�����Ϊ
        this.loadstart = System.currentTimeMillis();
    }

    /**
     * 设置游戏控制器
     */
    public void setPlayerControl(PlayerControl playercontrol) {
        this.addKeyListener(playercontrol);
    }

    /**
     * 绘制
     */
    public void paintComponent(Graphics g) {
        // 游戏是否结束
        if (this.dto.isGameover()) {
            this.reFleshGameOver(g);
            return;
        }
        this.reFleshButton();
        this.reFleshPicture(g);
        this.reFleshPillars(g);
        this.reFleshGround(g);
        this.reFleshScore(g);
        this.reFleshBird(g);
        this.reFleshGameLoad(g);
        this.dto.getGamedata().saveData();
        //　获取焦点
        this.requestFocus();
    }

    /**
     * 刷新按钮
     */
    public void reFleshButton() {
        if (this.dto.isGamestart()) {
            this.remove(this.dto.getBtnStart());
        }
    }

    /**
     * 刷新游戏载入
     *
     * @param g
     */
    public void reFleshGameLoad(Graphics g) {
        long loadend = System.currentTimeMillis();
        long space = loadend - loadstart;
        int x = (int) (space / 5);
        if (space <= 2150) {
            g.drawImage(Img.loading, 0, 0, null);
            CreateWindow.drawWindow(g, Img.windows[0], 100, 400, 430, 10);
            g.drawImage(Img.rect, 100, 400, 100 + x, 400 + 10, 0, 0, x, 10, null);
        } else {
            if (!this.dto.isGamestart()) {
                this.add(this.dto.getBtnStart());
            }
            return;
        }
    }

    /**
     * 绘制图片
     *
     * @param g
     */
    public void reFleshPicture(Graphics g) {
        //　绘制背景图片
        g.drawImage(Img.background, 0, 0, null);
        //　游戏开始并绘制开始图片
        if (!this.dto.isGamestart()) {
            g.drawImage(Img.start, 0, 0, null);
        }
        //　游戏暂停并绘制暂停图片
        if (this.dto.isPause()) {
            g.drawImage(Img.pause, 180, 255, null);
        }
    }

    /**
     * 刷新分数
     */
    public void reFleshScore(Graphics g) {
        int x = (int) this.dto.getScore() / 100;
        int y = (this.dto.getScore() / 10) % 10;
        int z = this.dto.getScore() % 10;
        g.drawImage(Img.num[x], 0, 0, null);
        g.drawImage(Img.num[y], 28, 0, null);
        g.drawImage(Img.num[z], 56, 0, null);
    }

    /**
     * 刷新小鸟
     *
     * @param g
     */
    public void reFleshBird(Graphics g) {
        //　绘制小鸟
        this.dto.getBird().drawBird(g);
        if (this.dto.isGamestart()) {
            //　游戏开始　小鸟飞翔
            this.dto.getBird().birdFly();
        }
        this.dto.getBird().birdDead();
    }

    /**
     * 刷新地面
     *
     * @param g
     */
    public void reFleshGround(Graphics g) {
        //　刷新地面
        this.dto.getGround().drawGround(g);
        //　地面移动
        this.dto.getGround().move();
    }

    /**
     * 刷新柱子
     *
     * @param g
     */
    public void reFleshPillars(Graphics g) {
        if (this.dto.isGamestart()) {
            //　绘制柱子
            for (int i = 0; i < 3; i++) {
                this.dto.getPillars()[i].drawPillars(g);
            }
            //　移动柱子
            for (int i = 0; i < 3; i++) {
                this.dto.getPillars()[i].moveX();
                this.dto.getPillars()[i].moveY();
            }
        }
        //ͨ　小鸟通过音效
        for (int i = 0; i < 3; i++) {
            this.dto.getPillars()[i].throughMusic();
        }
    }

    /**
     * 刷新游戏结束画面
     */
    public void reFleshGameOver(Graphics g) {
        //　背景图片
        g.drawImage(Img.background, 0, 0, null);
        //　绘制分数面板
        this.dto.getScoreboard().drawBoard(g);
        this.dto.getScoreboard().drawBoard(g);
        // 分数面板移动
        this.dto.getScoreboard().boardMove();
    }


}
