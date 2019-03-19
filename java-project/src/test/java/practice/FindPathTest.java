package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindPathTest {

    @Test
    public void test() {
        try {

            int[][] maze = new int[][]{{0,1,1},{1,1,1},{1,1,2}};
            List<Character> path = new ArrayList<>();
            FindPath.find_path(maze, path);
            List<List<Character>> paths = new ArrayList<>(new ArrayList<>());
            solution.FindAllPath.find_all_path(maze, paths);
            Assert.assertTrue("\nTry the maze: \n\t0,1,1\n\t1,1,1\n\t1,1,2\n", paths.contains(path));

            maze = new int[][]{{0,1,-1},{1,-1,1},{1,1,2}};
            path = new ArrayList<>();
            FindPath.find_path(maze, path);
            paths = new ArrayList<>(new ArrayList<>());
            solution.FindAllPath.find_all_path(maze, paths);
            Assert.assertTrue("\nTry the maze: \n\t0,1,-1\n\t1,-1,1\n\t1,1,2\n", paths.contains(path));

            maze = new int[][]{{0,1,1},{1,1,-1},{1,-1,2}};
            path = new ArrayList<>();
            FindPath.find_path(maze, path);
            paths = new ArrayList<>(new ArrayList<>());
            solution.FindAllPath.find_all_path(maze, paths);
            Assert.assertTrue("\nTry the maze: \n\t0,1,1\n\t1,1,-1\n\t1,-1,2\n", path.isEmpty());

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
