package Game.Object;

import Game.Frame.MyFrame;
import Game.Utils.GameUtils;

import java.awt.*;

/**
 * @Author Tofweod
 * @PsnStudy
 * @Goal
 */
public class blockObj extends GameObj{
    private int id;
    int value = 0;
    // 未含数字color-205 192 176
    Color color;


    public blockObj() {

    }

    public blockObj(int value) {
        this.value = value;
    }

    public blockObj(int x, int y, int width, int height, Image img, MyFrame mf, int id, int value, Color color) {
        super(x, y, width, height, img, mf);
        this.id = id;
        this.value = value;
        this.color = color;
    }

    public blockObj(int x, int y) {
        super(x, y);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void setImg(Image img) {
        super.setImg(img);
    }

    @Override
    public MyFrame getMf() {
        return super.getMf();
    }

    @Override
    public void setMf(MyFrame mf) {
        super.setMf(mf);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if (value == 0) {
            g.setColor(new Color(205 ,192 ,176));
            g.fillRect(x,y,140,140);
        }
        if (value == 2){
            g.setColor(new Color(238,229,222));
            g.fillRect(x,y,140,140);
            GameUtils.drawString01(g,x+35,y+110,120,"2");
        }
        if (value == 4) {
            g.setColor(new Color(238 ,216 ,174));
            g.fillRect(x,y,140,140);
            GameUtils.drawString01(g,x+35,y+110,120,"4");
        }
        if (value == 8) {
            g.setColor(new Color(238 ,154 ,0));
            g.fillRect(x,y,140,140);
            GameUtils.drawString02(g,x+35,y+110,120,"8");
        }
        // 位数变化字符串大小位置改变
        if (value == 16) {
            g.setColor(new Color(255 ,127 ,36));
            g.fillRect(x,y,140,140);
            GameUtils.drawString02(g,x+10,y+110,110,"16");
        }
        if (value == 32) {
            g.setColor(new Color(255 ,114 ,86));
            g.fillRect(x,y,140,140);
            GameUtils.drawString02(g,x+10,y+110,110,"32");
        }
        if (value == 64) {
            g.setColor(new Color(255 ,69 ,0));
            g.fillRect(x,y,140,140);
            GameUtils.drawString02(g,x+10,y+110,110,"64");
        }
        if (value == 128) {
            g.setColor(new Color(255 ,215 ,0));
            g.fillRect(x,y,140,140);
            GameUtils.drawString02(g,x+10,y+110,110,"128");
        }
    }

    @Override
    public String toString() {
        return "blockObj{" +
                "value=" + value +
                '}';
    }
}
