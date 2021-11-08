package xyh.game.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 主程序
 * 用于游戏界面生成与输入响应
 * @author xyh
 * @version 1.0
 */
public class GameWin extends JFrame {
    /**
     * 游戏数据
     */
    bg bg=new bg();
    Line line =new Line(this);
    public static int state=0;
    Image offScreenImage;
    List<gameObject> objectList=new ArrayList<gameObject>();


    /**
     * 生成游戏物体并加入列表
     * @param list
     *
     */
    void createList(List<gameObject> list){
        int i;
        Boolean isPlace=true;
        list.add(new Gold());
        i=15- xyh.game.window.bg.Level*1;
        for( ;i>0;i--){
            double random =Math.random();
            Gold g;
            if (random<0.6+0.01* xyh.game.window.bg.Level) {
                g=new Gold();

            }else {
                g=new Gold2();
            }
            for (gameObject object:objectList){
                if(g.getRec().intersects((object.getRec()))){
                    isPlace =false;
                }
            }
            if(isPlace){
                objectList.add(g);
            }else{
                isPlace=true;
                i++;
            }

        }
        int j=0;
        if(xyh.game.window.bg.Level<5)
         j = xyh.game.window.bg.Level;
        else
             j=5;
        for(i=0;i<j;i++){
            Rock r=new Rock();
            for (gameObject object:objectList){
                if(r.getRec().intersects((object.getRec()))){
                    isPlace =false;
                }
            }
            if(isPlace){
                objectList.add(r);
            }else{
                isPlace=true;
                i--;
            }


        }

    }


    /**
     * 游戏界面生成与输入响应
     * @exception InterruptedException
     */
    void launch() {
        this.setVisible(true);
        this.setSize(768, 1000);
        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createList(objectList);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (state){
                    case 0:
                        if (e.getButton()==3){
                            bg.sTime=System.currentTimeMillis();
                            state=1;
                        }
                        break;
                    case 1:
                        if (e.getButton() == 1&&Line.stage==0) {
                            line.stage = 1;
                        }
                        if(e.getButton()==3&&Line.stage==0){
                            if(!xyh.game.window.bg.isbow) {
                                xyh.game.window.bg.isbow = true;
                                xyh.game.window.bg.bowChance -= 1;
                            }

                        }
                        break;
                    case 2:break;
                    case 3:break;
                    case 4:
                        if (e.getButton()==3){
                        bg.sTime=System.currentTimeMillis();
                        state=1;
                    }
                        break;

                    case 5:
                        if (e.getButton()==3){
                            bg.sTime=System.currentTimeMillis();
                            state=1;
                        }
                        break;


                    default:break;
                }

            }
        });

        while(true) {


                if(xyh.game.window.bg.point> bg.workpoint){
                        state=5;
                        xyh.game.window.bg.Level++;
                        if (xyh.game.window.bg.Level%5==0) {
                            state = 4;
                            xyh.game.window.bg.bowChance+=1;
                        }
                        dispose();


                        GameWin gameWin1=new GameWin();
                        gameWin1.launch();

            }else if(bg.gameTime()){
                    state=3;
            }
                repaint();


            try {

                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    /**
     * 界面绘制
     * @param g
     */
    public void paint (Graphics g){
        offScreenImage=this.createImage(768,1000);
        Graphics gImg =offScreenImage.getGraphics();

        bg.paintSelf(gImg);

if(state==1){
    for (gameObject obj:objectList)
    {
        obj.paintSelf(gImg);
    }
    line.paintSelf(gImg);
}

        g.drawImage(offScreenImage,0,0,null);
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args){
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}
