package leetcode;

import net.weever.interview.MineSweeper;
import org.junit.Test;

public class MineSweeperTest {

    MineSweeper mineSweeper = new MineSweeper();

    @Test
    public void test() {
        mineSweeper.game(5, 5, 2);
    }
}
