package solution;

public class CanReachFood {
    private static final int FOOD = 2;   // Destination
    private static final int BLOCK = -1; // Obstacle

    // REQUIRES: maze is a 2D array where road blocks are indicated by -1
    //           and the bottom right corner is marked as 2
    // EFFECTS: returns true if we can start at top left corner of maze and
    //  get to the bottom right corner while moving only one step down or right.
    public static boolean can_reach_food(int[][] maze){
        return can_reach_food(maze, 0, 0);
    }

    // REQUIRES: maze is a 2D array where road blocks are indicated by -1
    //           and the bottom right corner is marked as 2
    // EFFECTS: returns true if we can start at top left corner of maze and
    //          get to the bottom right corner while moving only one step down or right.
    private static boolean can_reach_food(int[][] maze, int row, int col) {
        // base case: are we at destination?
        if (is_food(maze, row, col))
            return true;

        // move right and check if there is a path to food
        if (can_move_right(maze, row, col) &&
                can_reach_food(maze, row, col+1))
            return true;

        // move down and check if there is a path to food
        if (can_move_down(maze, row, col) &&
                can_reach_food(maze, row+1, col))
            return true;

        // there is no path to food :(
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
        System.out.println(can_reach_food(maze));
        
        maze = new int[][]{{0,1,-1},{1,-1,1},{1,1,2}};
        System.out.println(can_reach_food(maze));
        
        maze = new int[][]{{0,1,1},{1,1,-1},{1,-1,2}};
        System.out.println(can_reach_food(maze));
    }
}
