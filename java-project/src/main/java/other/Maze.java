package other;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private static final int D = 2;  // destination
    private static final int S = 0;  // start
    private static final int O = -1; //obstacle
    private static final int P = 1;  // path

    private static int[][]maze = {
            {S, P, O},
            {P, P, O},
            {O, P, D}};

    public static void solve(int[][]maze) {
        solve(maze, 0, 0, new ArrayList<>());
    }

    private static void solve(int[][]maze, int row, int col, List<Character> solution) {
        if (maze[row][col] == D) {
            System.out.println(solution);
        } else {
            // move down
            solution.add('d');
            if (row+1 < maze.length &&  maze[row+1][col] != O) {
                solve(maze, row+1, col, solution);
            }
            solution.remove(solution.size()-1);

            // move right
            solution.add('r');
            if (col+1 < maze[0].length && maze[row][col+1] != O) {
                solve(maze, row, col+1, solution);
            }
            solution.remove(solution.size()-1);
        }
    }

    public static boolean solvable(){
        return solvable_helper(0, 0);
    }

    public static boolean solvable_helper(int row, int col){

        if (isValid(row, col))
            return false;

        if (isDestination(row,col))
            return true;

        if (isObstacle(row, col))
            return false;

        if ( solvable_helper(row+1, col) )
            return true;

        if ( solvable_helper(row, col+1) )
            return true;

        return false;
    }

    private static boolean isDestination(int row, int col){
        return maze[row][col]==D;
    }

    private static boolean isObstacle(int row, int col) {
        return maze[row][col]==O;
    }

    private static boolean isValid (int row, int col) {
        return row >= maze.length || col >= maze[0].length;
    }

    public static void main(String[] args) {
        // solve(maze);

        // solve(new int[][]{{S,P,P},{P,P,P},{P,P,D}});
        maze = new int[][]{{S,P,P},{P,P,P},{P,P,D}};
        System.out.println(solvable());

        maze = new int[][]{{S,P,P},{P,P,O},{P,O,D}};
        System.out.println(solvable());

        maze = new int[][]{{S, P, O}, {P, P, O}, {O, P, D}};
        System.out.println(solvable());
    }

}
