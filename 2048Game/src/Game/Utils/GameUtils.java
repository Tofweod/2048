package Game.Utils;

import Game.Object.blockObj;

import java.awt.*;
import java.util.ArrayList;

/**
 * @Author Tofweod
 * @PsnStudy
 * @Goal
 */
public class GameUtils {
  // 方块列表
  public static ArrayList<blockObj> blockObjArrayList = new ArrayList<>();

  // 矩阵方块结构
  public static blockObj[][] blockObjs = new blockObj[4][4];

  public static void addToBlockObjs() {

    int index = 0;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        blockObjs[i][j] = blockObjArrayList.get(index++);
      }
    }
  }

  public static void drawString01(Graphics g,int x,int y,int size,String str) {
    g.setColor(new Color(139,131,120));
    g.setFont(new Font("仿宋",Font.BOLD,size));
    g.drawString(str,x,y);
  }

  public static void drawString02(Graphics g,int x,int y,int size,String str) {
    g.setColor(new Color(255,255,255));
    g.setFont(new Font("仿宋",Font.BOLD,size));
    g.drawString(str,x,y);
  }
}
