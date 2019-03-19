package solution;

import java.util.ArrayList;
import java.util.List;

public class FindPath {
    private static final int FOOD = 2;   // Destination
    private static final int BLOCK = -1; // Obstacle

    // REQUIRES: maze is a 2D array where road blocks are indicated by -1
    //           and the bottom right corner is marked as 2
    // MODIFIES: path
    // EFFECTS: generates a path (if one exists) from top left corner of maze
    //          to the bottom right corner while moving only one step down or right.
    public static void find_path(int[][] maze, List<Character> path){
        find_path(maze, 0, 0, path);
    }

    // REQUIRES: maze is a 2D array where road blocks are indicated by -1
    //           and the bottom right corner is marked as 2
    // EFFECTS: returns true and generates a path (if one exists) from top left corner of maze
    //          to the bottom right corner while moving only one step down or right.
    private static boolean find_path(int[][] maze, int row, int col, List<Character> path) {
        // base case: are we at destination?
        if (is_food(maze, row, col)) {
            return true;
        }
        // move right and check if there is a path to food
        if (can_move_right(maze, row, col)) {
            path.add('r');
            if (find_path(maze, row, col+1, path))
                return true;
            path.remove(path.size()-1);
        }

        // move down and check if there is a path to food
        if (can_move_down(maze, row, col)) {
            path.add('d');
            if (find_path(maze, row+1, col, path))
                return true;
            path.remove(path.size()-1);
        }

        return false;
    }

    // REQUIRES: row and col are valid indices of maze
    //           maze is a 2D array where road blocks are indicated by -1
    //           and the bottom right corner is marked as 2
    // EFFECTS: returns true if maze[row][col] is the destination (bottom right corner is marked as 2)
    private static boolean is_food(int[][] maze, int row, int col) {
        return maze[row][col] == FOOD;
    }

    // REQUIRES: maze is a 2D array where road blocks are indicated by -1
    //           and the bottom right corner is marked as 2
    // EFFECTS: returns true if col+1 is within maze bound and is not blocked
    private static boolean can_move_right(int[][] maze, int row, int col) {
        return col >= 0 && col+1 < maze[0].length && maze[row][col+1] != BLOCK;
    }

    // REQUIRES: maze is a 2D array where road blocks are indicated by -1
    //           and the bottom right corner is marked as 2
    // EFFECTS: returns true if row+1 is within maze bound and is not blocked
    private static boolean can_move_down(int[][] maze, int row, int col) {
        return row >= 0 && row+1 < maze.length && maze[row+1][col] != BLOCK;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,1,1},{1,1,1},{1,1,2}};
        List<Character> path = new ArrayList<>();
        find_path(maze, path);
        System.out.println(path);

        maze = new int[][]{{0,1,-1},{1,-1,1},{1,1,2}};
        path = new ArrayList<>();
        find_path(maze, path);
        System.out.println(path);

        maze = new int[][]{{0,1,1},{1,1,-1},{1,-1,2}};
        path = new ArrayList<>();
        find_path(maze, path);
        System.out.println(path);
    }
}
