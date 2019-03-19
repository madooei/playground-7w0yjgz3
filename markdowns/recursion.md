A *recursive* function is a function that calls itself. Here’s a recursive function:

```java
// REQUIRES: n >= 0
// EFFECTS: returns n!
public static long factorial (int n) {
    if (n == 0) {
        return 1L;
    } else {
        return factorial(n-1) * n;
    }
}
```

Recall, a recursive function is defined in terms of *base cases* and *recursive steps*.

As we go through the lecture, try to answer these questions:

* What is the base case in the `factorial` function?
* What is the recursive case in the `factorial` function?
* What is the relationship between the base case and recursive case? (hint: think stack overflow)
* What are the steps involved in writing recursive code to solve a problem?