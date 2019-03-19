package solution;

import java.util.ArrayList;
import java.util.List;

public class FindAllPath {
    private static final int FOOD = 2;   // Destination
    private static final int BLOCK = -1; // Obstacle
    
    public static void find_all_path(int[][] maze, List<List<Character>> paths){
        find_all_paths(maze, 0, 0, new ArrayList<Character>(), paths);
    }
    
    private static boolean is_food(int[][] maze, int row, int col) {
        return maze[row][col] == FOOD;
    }
    
    private static boolean can_move_right(int[][] maze, int row, int col) {
        return col+1 < maze[0].length && maze[row][col+1] != BLOCK;
    }
    
    private static boolean can_move_down(int[][] maze, int row, int col) {
        return row+1 < maze.length && maze[row+1][col] != BLOCK;
    }
    
    private static void find_all_paths(int[][] maze, int row, int col, List<Character> path,
                                          List<List<Character>> paths) {
        // base case: are we at destination?
        if (is_food(maze, row, col)) {
            paths.add(new ArrayList<>(path));
            path = new ArrayList<>();
        } else {
            // move right and check if there is a path to food
            if (can_move_right(maze, row, col)) {
                path.add('r');
                find_all_paths(maze, row, col + 1, path, paths);
                path.remove(path.size() - 1);
            }
    
            // move down and check if there is a path to food
            if (can_move_down(maze, row, col)) {
                path.add('d');
                find_all_paths(maze, row+1, col, path, paths);
                path.remove(path.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,1,1},{1,1,1},{1,1,2}};
        List<List<Character>> paths = new ArrayList<>(new ArrayList<>());
        find_all_path(maze, paths);
        System.out.println(paths);
        
        maze = new int[][]{{0,1,-1},{1,-1,1},{1,1,2}};
        paths = new ArrayList<>(new ArrayList<>());
        find_all_path(maze, paths);
        System.out.println(paths);
        
        maze = new int[][]{{0,1,1},{1,1,-1},{1,-1,2}};
        paths = new ArrayList<>(new ArrayList<>());
        find_all_path(maze, paths);
        System.out.println(paths);
    }
}
