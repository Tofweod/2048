package Game.Frame;


import Game.Object.blockObj;
import Game.Utils.GameUtils;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author Tofweod
 * @PsnStudy
 * @Goal
 * 游戏框架
 * 使用java.awt构建框架
 */
public class MyFrame extends Frame{
    private final int width = 665;

    private final int height = 680;

    // 双缓存图像
    private Image bfImg = null;

    // 初始block位置
    final int firRandom = (int)(Math.random()*16);
    final int secRandom = (int)(Math.random()*16);


    int valueCount = 2;


    /**
     * 构造器
     */
    public MyFrame() {

    }

    public void launch() {
        // 初始化窗口
        this.setSize(width,height);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("2048");

        this.setBackground(new Color(205,192,176));

        // 退出监听
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!isGameOver()) {
                    if (e.getKeyCode() == KeyEvent.VK_W) {
                        blockChange(GameUtils.blockObjs,0);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_S) {
                        blockChange(GameUtils.blockObjs,1);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_A) {
                        blockChange(GameUtils.blockObjs,2);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_D) {
                        blockChange(GameUtils.blockObjs,3);
                    }
                    setRandomBlock();
                    repaint();
                }
            }
        });

        // 创建block序列 顺序--从左往右从上往下
        creatBlockObjs();
        GameUtils.blockObjArrayList.get(firRandom).setValue(2);
        GameUtils.blockObjArrayList.get(secRandom).setValue(2);
        GameUtils.addToBlockObjs();



    }

    public static void main(String[] args) {
        new MyFrame().launch();
    }


    @Override
    public void paint(Graphics g) {
        if (bfImg == null) {
            bfImg = createImage(width,height);
        }
        Graphics bg = bfImg.getGraphics();
        // 背景设置
        bg.setColor(new Color(139 ,126 ,102));
        bg.fillRect(0,0,width,height);

        if (!isGameOver()) {
            for (blockObj boj:
                    GameUtils.blockObjArrayList) {
                boj.paintSelf(bg);
            }
        }
        else {
            bg.setColor(new Color(205,192,176));
            bg.setFont(new Font("黑体",Font.BOLD,120));
            bg.drawString("GameOver",90,350);
        }


        g.drawImage(bfImg,0,0,null);
    }

    public void creatBlockObjs() {
        // 应该就是16个吧
        for (int i = 0; i < 4; i++) {
            GameUtils.blockObjArrayList.add(new blockObj(20*(i+1)+140*i,40));
            for (int j = 1; j < 4; j++) {
                GameUtils.blockObjArrayList.add(new blockObj(20*(i+1)+140*i,20*(j+1)+140*j+20));
            }
        }
    }

    public void setRandomBlock() {
        // 随机block位置
        int randomBlock = (int)(Math.random()*16);

        while (GameUtils.blockObjArrayList.get(randomBlock).getValue()!= 0 && valueCount < 16) {
            randomBlock = (int)(Math.random()*16);
        }

        GameUtils.blockObjArrayList.get(randomBlock).setValue(2);
        valueCount++;
    }

    public boolean blockChange(blockObj[][] boj, int dir) {

        boolean hasChanged = false;

        // w键
        if (dir == 0) {
           // 两两配对 block改值
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = j+1; k < 4; k++) {
                        if (toChangeBlockValue(boj, i, j, k,0)) {
                            hasChanged = true;
                        }
                        if (boj[i][k].getValue() != boj[i][j].getValue() && boj[i][k].getValue() != 0) {
                            break;
                        }
                    }
                }
            }
            // block移位
            for (int i = 0; i < 4; i++) {
                // 移位数组
                blockObj[] blockObjs = new blockObj[4];
                for (int k =  0; k < 4; k++) {
                    blockObjs[k] = new blockObj(0);
                }
                int t = 0;
                for (int j = 0; j < 4; j++) {
                    if (boj[i][j].getValue() != 0) {
                        blockObjs[t].setValue(boj[i][j].getValue());
                        t++;
                    }
                }
                for (int m = 0; m < 4; m++) {
                    boj[i][m].setValue(blockObjs[m].getValue());
                }
            }
        }


        // s键
        if (dir == 1) {
            for (int i = 3; i >= 0 ; i--) {
                for (int j = 3; j > 0; j--) {
                    for (int k = j-1; k >= 0; k--) {
                        if (toChangeBlockValue(boj, i, j, k,0)) {
                            hasChanged = true;
                        }
                        if (boj[i][k].getValue() != boj[i][j].getValue() && boj[i][k].getValue() != 0) {
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                // 移位数组
                blockObj[] blockObjs = new blockObj[4];
                for (int k =  0; k < 4; k++) {
                    blockObjs[k] = new blockObj(0);
                }
                int t = 3;
                for (int j = 3; j >= 0; j--) {
                    if (boj[i][j].getValue() != 0) {
                        blockObjs[t].setValue(boj[i][j].getValue());
                        t--;
                    }
                }
                for (int m = 3; m >= 0; m--) {
                    boj[i][m].setValue(blockObjs[m].getValue());
                }
            }
        }


        // a键
        if (dir == 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = j+1; k < 4; k++) {
                        if (toChangeBlockValue(boj, j, i, k,1)) {
                            hasChanged = true;
                        }
                        if (boj[k][i].getValue() != boj[j][i].getValue() && boj[k][i].getValue() != 0) {
                            break;
                        }
                    }
                }
            }
            // block移位
            for (int i = 0; i < 4; i++) {
                // 移位数组
                blockObj[] blockObjs = new blockObj[4];
                for (int k =  0; k < 4; k++) {
                    blockObjs[k] = new blockObj(0);
                }
                int t = 0;
                for (int j = 0; j < 4; j++) {
                    if (boj[j][i].getValue() != 0) {
                        blockObjs[t].setValue(boj[j][i].getValue());
                        t++;
                    }
                }
                for (int m = 0; m < 4; m++) {
                    boj[m][i].setValue(blockObjs[m].getValue());
                }
            }
        }


        // d键
        if (dir == 3) {
            for (int i = 3; i >= 0 ; i--) {
                for (int j = 3; j > 0; j--) {
                    for (int k = j-1; k >= 0; k--) {
                        if (toChangeBlockValue(boj, j, i, k,1)) {
                            hasChanged= true;
                        }
                        if (boj[k][i].getValue() != boj[j][i].getValue() && boj[k][i].getValue() != 0) {
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                // 移位数组
                blockObj[] blockObjs = new blockObj[4];
                for (int k =  0; k < 4; k++) {
                    blockObjs[k] = new blockObj(0);
                }
                int t = 3;
                for (int j = 3; j >= 0; j--) {
                    if (boj[j][i].getValue() != 0) {
                        blockObjs[t].setValue(boj[j][i].getValue());
                        t--;
                    }
                }
                for (int m = 3; m >= 0; m--) {
                    boj[m][i].setValue(blockObjs[m].getValue());
                }
            }
        }

        return hasChanged;
    }


    public boolean toChangeBlockValue(blockObj[][] boj, int i, int j, int k, int dir) {
        if (dir == 0) {
            if (boj[i][j].getValue() == boj[i][k].getValue() && boj[i][j].getValue() != 0) {
                boj[i][j].setValue(2*boj[i][k].getValue());
                boj[i][k].setValue(0);
                valueCount--;
                return true;
            }
        }
        if (dir == 1) {
            if (boj[i][j].getValue() == boj[k][j].getValue() && boj[i][j].getValue() != 0) {
                boj[i][j].setValue(2*boj[k][j].getValue());
                boj[k][j].setValue(0);
                valueCount--;
                return true;
            }
        }
        return false;
    }

    // 判断游戏是否结束
    @SuppressWarnings("all")
    public boolean isGameOver() {
        if (valueCount == 16) {
            blockObj[][] Tboj = new blockObj[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Tboj[i][j] = GameUtils.blockObjs[i][j];
                }
            }
            if (!(blockChange(Tboj,0) ||
                    blockChange(Tboj,1) ||
                     blockChange(Tboj,2) ||
                      blockChange(Tboj,3))) {
                return true;
            }
        }
        return false;
    }


}

