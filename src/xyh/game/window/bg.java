package xyh.game.window;

import java.awt.*;

/**
 * 界面绘制的内容
 * @author xyh
 * @version 1.0
 */
public class bg {
    /**
     *数据（包括积分、关卡数和图片url）
     */
    public static int point=0;
    public static int bowChance=3;
    public static Boolean isbow=false;
    public static int Level=1;
    int workpoint=Level*3;
    long sTime;
    long eTime;
    long gametime=20;

    /**
     *用于游戏的时间判断
     * @return Boolean
     */
    Boolean gameTime(){
        long time=(eTime-sTime)/1000;
        if (time>20)
            return true;
            return false;
    }
    Image bgWall=Toolkit.getDefaultToolkit().getImage("images/bgwoll.png");
    Image bgSky=Toolkit.getDefaultToolkit().getImage("images/bgsky.png");
    Image player=Toolkit.getDefaultToolkit().getImage("images/playercar.png");

    /**
     * 界面绘制
     * @param g
     */
    void paintSelf(Graphics g){
        g.drawImage(bgSky,0,0,null);
        g.drawImage(bgWall,0,400,null);
        switch (GameWin.state){
            case 0:
                g.setColor(Color.white);
                g.setFont(new Font("微软雅黑",Font.BOLD,60));
                g.drawString("单击右键开始游戏",150,400);
                break;
            case 1:
                g.drawImage(player,320,300,null);

                g.setColor(Color.white);
                g.setFont(new Font("微软雅黑",Font.BOLD,30));
                g.drawString("积分："+point,350,200);
                g.drawString("爆破机会:"+bowChance,350,250);
                g.drawString("第"+Level+"关",150,200);
                g.drawString("目标分数:"+workpoint,100,250);
                eTime=System.currentTimeMillis();
                long tim=20-(eTime-sTime)/1000;

                g.drawString("时间:"+(tim>0?tim:0),50,75);
            case 2:break;
            case 3:
                g.setColor(Color.red);
                g.setFont(new Font("微软雅黑",Font.BOLD,60));
                g.drawString("游戏失败",150,400);
                break;

            case 4:
                g.setColor(Color.blue);
                g.setFont(new Font("微软雅黑",Font.BOLD,60));
                g.drawString("阶段目标达成",150,400);
                break;
            case 5:
                g.setColor(Color.red);
                g.setFont(new Font("微软雅黑",Font.BOLD,60));
                g.drawString("右键下一关",150,400);
                break;

            default:break;

        }

    }

}
