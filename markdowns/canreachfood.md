Consider the followng arrangement where some cells are blocked (there may be no way to the food!)

![count_path](assets/can_reach_food.png)

Write a function `boolean can_reach_food(int[][]maze)`  which returns true if we can start at top left corner of the grid (`maze`) -- where _bugbug_ is --  and get to the bottom right corner -- where the _pawpaw_ leaves are -- while moving only one step down or right.

Note we represent the grid as a 2D array where  blocks are indicated by `-1`and the bottom right corner is marked as `2`:
```java
int[][] maze = new int[][]{{0,1,-1},{1,-1,1},{1,1,2}};
```

@[Implement can_reach_food]({"stubs": ["src/main/java/practice/CanReachFood.java"],"command": "practice.CanReachFoodTest#test"})

