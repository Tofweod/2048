package Game.Test;

import Game.Frame.MyFrame;
import Game.Utils.GameUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @Author Tofweod
 * @PsnStudy
 * @Goal
 */
public class Test12_27 {
    @Test
    public void test01() {
        double rand = 0;
        for (int i = 0; i < 5; i++) {
            rand = Math.random();
            System.out.println(rand);
        }
    }

    @Test
    public void test02() {
        MyFrame myFrame = new MyFrame();
        myFrame.creatBlockObjs();
        GameUtils.addToBlockObjs();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(GameUtils.blockObjs[i][j]);
            }
        }
    }


}
