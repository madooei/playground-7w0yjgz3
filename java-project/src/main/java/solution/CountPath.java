package solution;

// Goal: count how many different paths one can take in order to get from
// the top left corner to the bottom right corner of a grid.
// Constraint: you can only move right or down.
// Parameters: height and width correspond the size of a rectangle grid.
public class CountPath {

    // REQUIRES: width >= 1 && height >= 1
    // EFFECTS: returns the count of paths
    public static int count_paths(int width, int height) {
        if (width == 1 || height == 1){
            return 1;
        } else {
            int go_right = count_paths(width - 1, height);
            int go_up = count_paths(width, height - 1);
            return go_right + go_up;
        }
    }
}
