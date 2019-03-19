package lecture;

// Goal: count how many different paths one can take in order to get from
// the top left corner to the bottom right corner of a grid.
// Constraint: you can only move right or down.
// Parameters: height and width correspond the size of a rectangle grid.
public class CountPath {

    // REQUIRES: width >= 1 && height >= 1
    // EFFECTS: returns the count of paths
    public static int count_paths(int width, int height) {
        return 0; // stub
    }

    public static void main(String[] args) {
        System.out.println("count_path(1, 1) = " + count_paths(1, 1)); // 1
        System.out.println("count_path(3, 1) = " + count_paths(3, 1)); // 1
        System.out.println("count_path(1, 4) = " + count_paths(1, 4)); // 1
        System.out.println("count_path(3, 4) = " + count_paths(3, 4)); // 10
        System.out.println("count_path(3, 3) = " + count_paths(3, 3));  // 6
        System.out.println("count_path(7, 8) = " + count_paths(7, 8)); // 1716
    }
}
