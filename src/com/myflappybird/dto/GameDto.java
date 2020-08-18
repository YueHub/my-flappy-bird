package com.myflappybird.dto;

import com.myflappybird.dao.GameData;
import com.myflappybird.img.Img;
import com.myflappybird.service.Bird;
import com.myflappybird.service.Ground;
import com.myflappybird.service.Pillars;
import com.myflappybird.service.ScoreBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDto {

    /**
     * 小鸟对象
     */
    private Bird bird;

    /**
     * 地面对象
     */
    private Ground ground;

    /**
     * 柱子组数组
     */
    private Pillars[] pillars;

    /**
     * 游戏的数据对象
     */
    private GameData gamedata;

    /**
     * 分数面板对象
     */
    private ScoreBoard scoreboard;

    /**
     * 游戏是否开始
     */
    private boolean gamestart;

    /**
     * 小鸟运动的速度
     */
    private double speed;

    /**
     * 小鸟是否已经死亡
     */
    private boolean birdDead;

    /**
     * 游戏分数
     */
    private int score;

    /**
     * 是否暂停
     */
    private boolean pause;

    /**
     * 游戏是否结束
     */
    private boolean gameover;

    /**
     * 是否重新开始
     */
    private boolean restart;

    /**
     * 开始游戏的按钮
     */
    private JButton btnStart;

    /**
     * 构造方法
     */
    public GameDto() {
        this.InitDto();
    }

    /**
     * 初始化数据传输层
     */
    public void InitDto() {
        //初始化游戏没有开始
        this.gamestart = false;
        //初始化小鸟没有死
        this.birdDead = false;
        //初始化游戏没有暂停
        this.pause = false;
        //初始化游戏没有重新开始
        this.restart = false;
        //初始化游戏没有结束
        this.gameover = false;
        //初始化分数为0
        this.score = 0;
        //创建数据对象
        gamedata = new GameData(this);
        //创建小鸟对象
        bird = new Bird(this, 100, 250);
        //创建地面对象
        ground = new Ground(this, 0, 498);
        //创建分数面板对象
        scoreboard = new ScoreBoard(70, 500);
        //创建柱子组对象
        pillars = new Pillars[3];
        pillars[0] = new Pillars(this, 550);
        pillars[1] = new Pillars(this, 790);
        pillars[2] = new Pillars(this, 1030);
        this.InitBtn();
    }

    /**
     * 初始化按钮
     */
    public void InitBtn() {
        //创建按钮对象
        this.btnStart = new JButton(Img.btnBegin);
        //设置按钮的边框透明
        this.btnStart.setBorder(null);
        //设置内部透明
        this.btnStart.setContentAreaFilled(false);
        //设置按钮的位置和大小
        this.btnStart.setBounds(56, 415, 238, 89);
        //向按钮添加事件监听
        this.btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setGamestart(true);
            }
        });

    }

    /**
     * 得到按钮对象
     *
     * @return
     */
    public JButton getBtnStart() {
        return btnStart;
    }

    /**
     * 设置按钮对象
     *
     * @param btnStart
     */
    public void setBtnStart(JButton btnStart) {
        this.btnStart = btnStart;
    }

    /**
     * 得到小鸟对象
     */
    public Bird getBird() {
        return bird;
    }

    /**
     * 得到地面对象
     */
    public Ground getGround() {
        return ground;
    }

    /**
     * 得到柱子组数组对象
     *
     * @return
     */
    public Pillars[] getPillars() {
        return pillars;
    }

    /**
     * 得到游戏数据对象
     *
     * @return
     */
    public GameData getGamedata() {
        return gamedata;
    }

    /**
     * 设置游戏数据对象
     *
     * @param gamedata
     */
    public void setGamedata(GameData gamedata) {
        this.gamedata = gamedata;
    }

    /**
     * 得到游戏分数的面板对象
     *
     * @return
     */
    public ScoreBoard getScoreboard() {
        return scoreboard;
    }

    /**
     * 设置游戏分数的面板对象
     *
     * @param scoreboard
     */
    public void setScoreboard(ScoreBoard scoreboard) {
        this.scoreboard = scoreboard;
    }


    /**
     * 得到游戏是否开始
     */
    public boolean isGamestart() {
        return gamestart;
    }

    /**
     * 设置游戏是否开始
     */
    public void setGamestart(boolean gamestart) {
        this.gamestart = gamestart;
    }

    /**
     * 得到小鸟的速度
     *
     * @return
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * 设置小鸟的速度
     *
     * @param speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * 得到小鸟是否已经死亡
     */
    public boolean isBirdDead() {
        return birdDead;
    }

    /**
     * 设置小鸟是否死亡
     */
    public void setBirdDead(boolean birdDead) {
        this.birdDead = birdDead;
    }

    /**
     * 得到游戏分数
     */
    public int getScore() {
        return score;
    }

    /**
     * 设置游戏分数
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 得到游戏是否暂停
     */
    public boolean isPause() {
        return pause;
    }

    /**
     * 设置游戏是否暂停
     */
    public void setPause(boolean puase) {
        this.pause = puase;
    }

    /**
     * 得到游戏是否结束
     */
    public boolean isGameover() {
        return gameover;
    }

    /**
     * 设置游戏是否结束
     */
    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    /**
     * 得到游戏是否重新开始
     */
    public boolean isRestart() {
        return restart;
    }

    /**
     * 设置游戏是否重新开始
     */
    public void setRestart(boolean restart) {
        this.restart = restart;
    }
}