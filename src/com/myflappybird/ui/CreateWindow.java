package com.myflappybird.ui;

import java.awt.*;

public class CreateWindow {

    /**
     * 绘制窗口的方法(切割)
     *
     * @param g
     * @param img
     * @param X
     * @param Y
     * @param width
     * @param height
     */
    public static void drawWindow(Graphics g, Image img, int X, int Y, int width, int height) {
        //切割左上部分
        g.drawImage(img, X, Y, X + 9, Y + 9, 0, 0, 9, 9, null);
        //切割中上部分
        g.drawImage(img, X + 9, Y, X + width - 9, Y + 9, 9, 0, 55, 9, null);
        //切割右上部分
        g.drawImage(img, X + width - 9, Y, X + width, Y + 9, 55, 0, 64, 9, null);

        //切割左中部分
        g.drawImage(img, X, Y + 9, X + 9, Y + height - 9, 0, 9, 9, 55, null);
        //切割中中部分
        g.drawImage(img, X + 9, Y + 9, X + width - 9, Y + height - 9, 9, 9, 55, 55, null);
        //切割右中部分
        g.drawImage(img, X + width - 9, Y + 9, X + width, Y + height - 9, 55, 9, 64, 55, null);

        //切割下左部分
        g.drawImage(img, X, Y + height - 9, X + 9, Y + height, 0, 55, 9, 64, null);
        //切割下中部分
        g.drawImage(img, X + 9, Y + height - 9, X + width - 9, Y + height, 9, 55, 55, 64, null);
        //切割下右部分
        g.drawImage(img, X + width - 9, Y + height - 9, X + width, Y + height, 55, 55, 64, 64, null);
    }
}