# Tower of Hanoi Solver

Invented by French mathematician Édouard Lucask, the Tower of Hanoi is a math puzzle consisting of rings of increasing diameter stacked on one of three large pillars, with the objective being to transfer a stack of rings from the first pillar to the last. There are, of course, some rules to make this challenging.
- A ring can only be moved if it is at the top of its pillar
- A ring can only be placed onto an empty pillar, or a ring smaller than it

Lucask purported that the puzzle came from an ancient temple where monks would work on a Tower of Hanoi puzzle made of sixty four golden rings, and that the world would end when the puzzle is solved. The process for solving this puzzle is actually quite straightforward:
- Since we can only move the top ring of a pillar, first move all but the last (biggest) ring out of the way
- Now that the ring is free, move the biggest ring into place
- Finally, move the displaced stack onto the new location of the biggest ring

An example solution for three rings would look like this:
- Start with the rings on the left pillar
- Move the small ring from the left pillar to the right pillar
- Move the medium ring from the left pillar to the middle pillar
- Move the small ring from the right pillar to the middle pillar
- Move the large ring from the left pillar to the right pillar
- Move the small ring from the middle pillar to the left pillar
- Move the medium ring from the middle pillar to the right pillar
- Move the small ring from the left pillar to the right pillar
- All done!

Solving a Tower of Hanoi puzzle very recursive, and due to this, it is possible to calculate the minimum number of moves needed to solve a puzzle as `2^n - 1`, where `n` is the number of rings. So, let's write a computer program that can solve this puzzle! You can even see a visualization of the steps along the way. The code for printing a puzzle and moving rings has been provided for you. You need to write the recursive code that executes the solution to the puzzle.

## Your Task

The number of lines of code required to complete this assignment is quite minimal, but each line of code has great impact. You may not write any loops outside of your unit tests. You will need to write three functions:

-   **A recursive function that moves a stack of rings from one pillar to another.** This function should move all but the biggest ring out of the way, move the biggest ring into place, then move the stack of rings back onto the biggest ring. The `depth` parameter will be useful to indicate how deep of a stack to move. This function should, if enabled via the `doPrint` parameter, also print the puzzle after every move to the console by using HanoiStudio's `toString()` function.
-   **A function that calls your recursive function and passes in any necessary context.** For example, given a Tower of Hanoi puzzle, this function should find out what pillar needs to go where, and call your recursive function with appropriate arguments. When solving your Tower of Hanoi puzzle, you should do so in the minimum possible number of moves
-   **A main method that asks the user for how many rings to solve for, then solves that puzzle** Ask the user for how many rings they would like to put on their Tower of Hanoi puzzle, then call yoru solver function to solve the puzzle! After doing so, check to see if the puzzle was solved in the minimum number of moves. (Hint: you can check how many moves have been executed with HanoiStudio's `getMoves()` function)
-   **Unit tests for your recursive functions.** Unit testing can be difficult for output-heavy applications. As such, you have been provided one sample unit test. Notice that the test disables printing uses HanoiStudio's `getPillar()` function to get the information of the rings in a pillar of the puzzle.

### Restrictions

In completing this assignment, you are not allowed to:

- Use loops of any kind (recursion is all you need to complete the assignment)
- Change the method signature (arguments or return type) of any methods
- Add any new methods
- Add any global variables

### Moving a Ring
HanoiStudio provides a function to move rings in a Tower of Hanoi puzzle:
```java
public boolean moveRing(int sourcePillar, int destinationPillar, int ringNumber) throws HanoiException
```
This function accepts integers for source and destination pillars, as well as which ring to move from the source to the destination. This function throws a `HanoiException` if something goes wrong, for example if you try to:
- Move a ring onto its own pillar
- Move a ring that is not on the top of its pillar
- Move a ring from an empty pillar
- Move a ring onto a ring that is smaller than it

If everything is good, it will move the ring from the source to the destination, and will return `true` to indicate a move was successful

These exceptions must be caught in your recursive function.

## Examples

Here is an example of program output for a solution for one ring: <!-- and in the darkness bind them -->
```
Welcome to the Tower of Hanoi solver!
How many rings would you like to solve for? 1
    |     |     | 
   [1]    |     | 
----┴-----┴-----┴----
    |     |     | 
    |     |    [1]
----┴-----┴-----┴----

I was able to solve the puzzle!
Rings: 1
Moves: 1
Par: 1
Solved in par moves!
```
Here is an example of program output for a solution for three rings:
```
Welcome to the Tower of Hanoi solver!
How many rings would you like to solve for? 3
      |         |         |   
     [1]        |         |   
    [=2=]       |         |   
   [==3==]      |         |   
------┴---------┴---------┴------
      |         |         |   
      |         |         |   
    [=2=]       |         |   
   [==3==]      |        [1]  
------┴---------┴---------┴------

      |         |         |   
      |         |         |   
      |         |         |   
   [==3==]    [=2=]      [1]  
------┴---------┴---------┴------
      |         |         |   
      |         |         |   
      |        [1]        |   
   [==3==]    [=2=]       |   
------┴---------┴---------┴------

      |         |         |   
      |         |         |   
      |        [1]        |   
      |       [=2=]    [==3==]
------┴---------┴---------┴------
      |         |         |   
      |         |         |   
      |         |         |   
     [1]      [=2=]    [==3==]
------┴---------┴---------┴------

      |         |         |   
      |         |         |   
      |         |       [=2=] 
     [1]        |      [==3==]
------┴---------┴---------┴------
      |         |         |   
      |         |        [1]  
      |         |       [=2=] 
      |         |      [==3==]
------┴---------┴---------┴------

I was able to solve the puzzle!
Rings: 3
Moves: 7
Par: 7
Solved in par moves!
```

## Homework 11 Outcomes

- **Algorithm Design**: Author algorithms that correctly solve complex problems involving primitive types, objects, and/or recursion.
- **Exception Handling**: Potentially error-producing code is identified and handled appropriately, such as with try/catch blocks, graceful exits, and custom exceptions.
- **Meets Spec**: Write software that meets provided requirements and specifications.
- **Code Mechanics**: Choose appropriate data types and structures, use those types and structures effectively, and continue to make good choices over time.
- **Code Style**: Write code in an industry-standard coding style.
- **Software Engineering Skills**: Produce software by following industry-standard practices, including code reading, use of remote repositories, and software testing.