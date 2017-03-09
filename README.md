TransferWise - Java Technical Challenge
===============================
#Exercise 1
You have a rectangular apple orchard full of ripe apples. The orchard is divided into squares
and is represented by a 2 dimensional array. Each element in the array is an int, showing the
number of apples at the corresponding square in the orchard. </br>
Our goal is to collect as many apples as we can by walking from the bottom left corner of the
orchard to the top right corner, taking all apples in each square along the way. From a given
square you can only go either up, or to the right. </br>
For example consider that this is the orchard: </br>
[[4, 0, 1], </br>
[1, 0, 0], </br>
[0, 4, 0]] </br>
At most you can collect 6 apples, by going up (+1), up (+4), right (+0), right (+1). </br>
Write a method that takes a 2 dimensional int array as the argument, and returns an int. </br>
The returned int is the maximum number of apples that you can collect. Try to make sure that
the method runs fast. </br>
```shell
public int collectApples(int[][] orchard);
```
#Exercise 2
Let’s assume you also have 2 tokens. While you are walking in the orchard, you can use the
tokens to double the number of apples on the current square. You can only use one token on
any given square. </br>
Write another method which takes the tokens into account. The method signature should
be like: </br>
```shell
public int collectApplesWithTokens(int[][] orchard);
```
Please send a solution that you would release to production. </br>
Also, please feel free to include/add any considerations and/or assumptions regarding your
solution.
