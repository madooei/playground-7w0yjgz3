package other;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void subset(List<Integer> set,  List<Integer> subset){

        if (set.isEmpty()) {
            System.out.println(subset);
        } else {
            Integer selected = set.remove(0);
            subset.add(selected);
            subset(set, subset);
            subset.remove(subset.lastIndexOf(selected));
            subset(set, subset);
            set.add(0,selected);
        }

    }

    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        subset(set,new ArrayList<>());
    }



}
