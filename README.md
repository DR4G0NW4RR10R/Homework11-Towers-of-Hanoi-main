# Tower of Hanoi Solver

Before a choral rehearsal or performance, vocalists practice vocal "warm-ups". These warm-ups stretch the vocalists' vocal cords (thus preventing injury). They also help to practice clear diction and to regulate breathing. Often, these warm-ups are silly and irritatingly catchy.

One such warm-up (that \*still\* gets stuck in my head frequently, 15+ years after learning it) deals with scales. The warm-up starts with just the first note, "DO", then pauses, then proceeds "DO RE DO", then pauses, then proceeds "DO RE MI RE DO", etc. After each pause, the song includes one additional note, playing the sequence forward and then backward. We will call these forward-and-backward sequences "phrases". The final phrase of the warm up is "DO RE MI FA SO LA TI LA SO FA MI RE DO". Very catchy. Check it out [in this video by YouTuber Janelle Doak](https://youtu.be/WTckI65BgHQ) (the relevant portion of the video is the first 40 seconds).

The format of this choral warm-up is very recursive. So, let's write a computer program that can play this and other similar choral warm-ups! You can even save the songs your code creates to listen to later. The code for playing and saving sound has been provided for you. You need to write the recursive code that generates the songs.

## Your Task

The number of lines of code required to complete this assignment is quite minimal, but each line of code has great impact. You may not write any loops outside of your unit tests. You will need to write three functions:

-   **A recursive function that plays one phrase, (a sequence of notes played forward, then backward).** For example, if the input of the function was the notes `[DO, RE, MI]`, the function should play DO RE MI RE DO.
-   **A recursive function that plays phrases of increasing length.** For example, if the input of the function was `[DO, RE, MI]`, the function should play DO REST DO RE DO REST DO RE MI RE DO REST. We will call this sequence of phrases a "song".
-   **A main method that writes a song from a unique sequence of notes and rests.** Play around with different sequences of notes as inputs to your song-making function and find one that represents your taste in music. Your sequence should be 10 notes or longer. After your song plays, save your masterpiece using the `MidiStudio.saveMasterpiece(String filename)` function (your filename should end with ".wav"). The `MidiStudio` class already records each note as it's played (you're welcome), so you don't need to do anything special to keep track of the notes that have been played in order to make the recording.
-   **Unit tests for your recursive functions.** Unit testing can be difficult for output-heavy applications. As such, you have been provided one sample unit test. Notice that the test disables the audio from playing and that MidiStudio is closed in the "teardown" portion of the test.

### Note About Array-Based Recursion

Recursing on arrays is very common. There are several techniques for keeping track of which part of the array is "in scope" at a given level of the recursion. The simplest technique is called "array slicing". Basically, "array slicing" is to arrays what "substring" is to Strings. You can "slice" an array to trim off indices at either the beginning or the end of the array (or both). In Java, slicing can be accomplished using the `Arrays.copyOfRange(array, inclusiveStartingIndex, exclusiveEndingIndex)` function. You can provide these array slices to subsequent recursive calls. If done correctly, the length of the Note array accepted by the function will change at each recursion level.

### Restrictions

In completing this assignment, you are not allowed to:

- Use loops of any kind (recursion and the `Arrays.copyOfRange` function is all you need to complete the assignment)
- Change the method signature (arguments or return type) of any methods
- Add any new methods
- Add any global variables

## Examples

Here is an example of program output for a traditional scale:

-   Notes: `DO, RE, MI, FA, SO, LA, TI`
-   Recording: [here](exampleMasterpieces/scale.wav)

Here is another example of a non-scale melody:

-   Notes: `TI SO MI REST LA DO FA`
-   Recording: [here](exampleMasterpieces/masterpiece.wav)

Given these same inputs, your code should produce the same songs.

## Extra Credit

Use recursion and MidiStudio to do something awesome and creative for extra credit. Visit TA Hours and demo it for any TA. (Extra credit will not be graded alongside the rest of your code.)

## Homework 11 Outcomes

- **Algorithm Design**: Author algorithms that correctly solve complex problems involving primitive types, objects, and/or recursion.
- **Exception Handling**: Potentially error-producing code is identified and handled appropriately, such as with try/catch blocks, graceful exits, and custom exceptions.
- **Meets Spec**: Write software that meets provided requirements and specifications.
- **Code Mechanics**: Choose appropriate data types and structures, use those types and structures effectively, and continue to make good choices over time.
- **Code Style**: Write code in an industry-standard coding style.
- **Software Engineering Skills**: Produce software by following industry-standard practices, including code reading, use of remote repositories, and software testing.