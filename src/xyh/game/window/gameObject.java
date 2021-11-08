package xyh.game.window;

import java.awt.*;

/**
 * 游戏物体的父类
 * @author xyh
 * @version 1.0
 */
public class gameObject {
    int x;
    int y;

    int width;
    int height;

    Image img;

    int m;

    int point;

    int type;

    Boolean flag=false;

    /**
     * 物体绘制
     * @param g
     */
    void paintSelf(Graphics g){
        g.drawImage(img,x,y,null);
    }

    /**
     * 绘制矩形（碰撞检测）
     * @return
     */
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
