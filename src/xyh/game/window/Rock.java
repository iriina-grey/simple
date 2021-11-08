package xyh.game.window;

import java.awt.*;

public class Rock extends gameObject{
    public Rock(){
        this.x= (int)(Math.random()*700);

        this.y=(int)(Math.random()*500+500);

        this.width=75;
        this.height=75;

        this.m=60;


        this.type=2;

        this.img= Toolkit.getDefaultToolkit().getImage("images/Rock1.png");

    }
}
