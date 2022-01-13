package Game.Object;

import Game.Frame.MyFrame;

import java.awt.*;

/**
 * @Author Tofweod
 * @PsnStudy
 * @Goal
 * 实体类父类Object
 */
@SuppressWarnings("all")
public class GameObj {
    int x;
    int y;
    private int width;
    private int height;
    private Image img;
    private MyFrame mf;

    public GameObj() {}

    public GameObj(int x, int y, int width, int height, Image img, MyFrame mf) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
        this.mf = mf;
    }

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public MyFrame getMf() {
        return mf;
    }

    public void setMf(MyFrame mf) {
        this.mf = mf;
    }


    public void paintSelf(Graphics g) {
    }
}
