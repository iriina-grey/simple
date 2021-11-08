package xyh.game.window;

import java.awt.*;

/**
 * 拉索类
 * @
 */
public class Line {
    int x=370;
    int y=380;

    int endx=500;
    int endy=500;

    double length=100;
    double  round=0;

    int decline=1;

    static int stage=0;

    GameWin frame;

    Image img=Toolkit.getDefaultToolkit().getImage("images/gouzi.png");

    public Line(GameWin frame){
        this.frame=frame;
    }


    void catchLogic(){
        for(gameObject obj:this.frame.objectList){
            if(endx>obj.x&&endx<obj.x+obj.width
                    && endy>obj.y&&endy<obj.y+obj.height){
                stage=3;

                obj.flag=true;

            }

        }
    }

    void pLines(Graphics g){
        endx= (int)(x+length*Math.cos(round*Math.PI));
        endy=(int)(y+length*Math.sin(round*Math.PI));
        g.setColor(Color.red);
        g.drawLine(x,y,endx,endy);
        g.drawImage(img,endx-36,endy-2,null);

    }
    void paintSelf(Graphics g){
        catchLogic();
        switch (stage){
            case 0:if(round<0.1)
        decline=1;
        else if(round>0.9)
        decline=-1;
        round=round+0.005*decline;
        pLines(g);
        break;

            case 1:
                if(length<=600){
                    length+=5;
                    pLines(g);
                }else{
                    stage=2;
                }
                break;
            case 2:
                if(length>=100){
                    length-=5;
                    pLines(g);
                }else{
                    stage=0;
                }
                break;
            case 3:
                int m=0;
                if(length>100){
                    length=length-5;
                    pLines(g);
                    if(this.frame.objectList!=null) {
                        for (gameObject obj : this.frame.objectList) {
                            if (obj.flag) {
                                if (bg.isbow){

                                    obj.x=-150;
                                    obj.y=-300;
                                    obj.flag=false;
                                    stage = 2;
                                    bg.isbow=false;
                                }else {
                                    if (obj.type==1) {
                                        m = obj.m;
                                        obj.x = endx - obj.width / 2;
                                        obj.y = endy;
                                        if (length <= 100) {
                                            bg.point += obj.point;
                                            obj.x = -150;
                                            obj.y = -300;
                                            obj.flag = false;
                                            stage = 0;
                                        }
                                    }else{
                                        obj.flag=false;
                                        stage=2;
                                    }
                                }

                            }
                        }
                    }
                }else{
                    stage=0;
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:break;

        }

    }
}
