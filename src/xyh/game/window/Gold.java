package xyh.game.window;

import java.awt.*;
import java.util.Random;

/**
 * 黄金类1
 */
public class Gold extends gameObject {

    public Gold(){
        this.x= (int)(Math.random()*700);

        this.y=(int)(Math.random()*500+475);

        this.width=50;
        this.height=50;

        this.m=30;

        this.point=2;
        this.type=1;

        this.img= Toolkit.getDefaultToolkit().getImage("images/gold2.png");
    }

}

/**
 * 黄金类2
 */
class Gold2 extends Gold{
    Gold2(){
        this.x= (int)(Math.random()*700);

        this.y=(int)(Math.random()*500+600);
        this.width=100;
        this.height=100;
        this.m=80;
        this.point=4;
        this.type=1;
        this.img=Toolkit.getDefaultToolkit().getImage("images/gold1.png");
    }
}
