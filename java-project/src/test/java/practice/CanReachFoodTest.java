package practice;

import org.junit.Assert;
import org.junit.Test;

public class CanReachFoodTest {
    @Test
    public void test() {
        try {
            int[][] maze = new int[][]{{0,1,1},{1,1,1},{1,1,2}};
            boolean result = CanReachFood.can_reach_food(maze);
            Assert.assertEquals("Running can_reach_food(new int[][]{{0,1,1},{1,1,1},{1,1,2}})...", true, result);

            maze = new int[][]{{0,1,-1},{1,-1,1},{1,1,2}};
            result = CanReachFood.can_reach_food(maze);
            Assert.assertEquals("Running can_reach_food(new int[][]{{0,1,-1},{1,-1,1},{1,1,2}})...", true, result);

            maze = new int[][]{{0,1,1},{1,1,-1},{1,-1,2}};
            result = CanReachFood.can_reach_food(maze);
            Assert.assertEquals("Running can_reach_food(new int[][]{{0,1,1},{1,1,-1},{1,-1,2}})...", false, result);
            success(true);
        } catch (AssertionError ae) {
            success(false);
            msg("Oops! 🐞", ae.getMessage());
        }
    }

    private static void msg(String channel, String msg) {
        System.out.println(String.format("TECHIO> message --channel \"%s\" \"%s\"", channel, msg));
    }

    private static void success(boolean success) {
        System.out.println(String.format("TECHIO> success %s", success));
    }
}
