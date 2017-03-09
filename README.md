# test_task_transferwise
Find max sum of 2d array going from bottom-left to top-right. The same having two tokens (double numbers).

TransferWise - Java Technical Challenge
Exercise 1
You have a rectangular apple orchard full of ripe apples. The orchard is divided into squares
and is represented by a 2 dimensional array. Each element in the array is an int, showing the
number of apples at the corresponding square in the orchard.
Our goal is to collect as many apples as we can by walking from the bottom left corner of the
orchard to the top right corner, taking all apples in each square along the way. From a given
square you can only go either up, or to the right.
For example consider that this is the orchard:
[[4, 0, 1],
[1, 0, 0],
[0, 4, 0]]
At most you can collect 6 apples, by going up (+1), up (+4), right (+0), right (+1).
Write a method that takes a 2 dimensional int array as the argument, and returns an int.
The returned int is the maximum number of apples that you can collect. Try to make sure that
the method runs fast.
public int collectApples(int[][] orchard);
Exercise 2
Let’s assume you also have 2 tokens. While you are walking in the orchard, you can use the
tokens to double the number of apples on the current square. You can only use one token on
any given square.
Write another method which takes the tokens into account​ . The method signature should
be like:
public int collectApplesWithTokens(int[][] orchard);
Please send a solution that you would release to production.
Also, please feel free to include/add any considerations and/or assumptions regarding your
solution.
