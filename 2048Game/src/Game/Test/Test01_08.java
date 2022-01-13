package Game.Test;

import Game.Frame.MyFrame;
import Game.Utils.GameUtils;
import org.junit.jupiter.api.Test;

/**
 * @Author Tofweod
 * @PsnStudy
 * @Goal
 */
public class Test01_08 {
    @Test
    public void test01() {
        int[][] arrays = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrays[i][j] = i*4+j+1;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(arrays[i][j]);
            }
        }
    }

    @Test
    public void test02() {
        MyFrame mf = new MyFrame();
        mf.creatBlockObjs();
        GameUtils.blockObjArrayList.get(3).setValue(2);
        GameUtils.blockObjArrayList.get(6).setValue(2);
        System.out.println(GameUtils.blockObjArrayList);
        GameUtils.addToBlockObjs();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(GameUtils.blockObjs[i][j]);
            }
        }
    }

}
