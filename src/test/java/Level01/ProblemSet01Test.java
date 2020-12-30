package Level01;

import org.junit.Assert;
import org.junit.Test;

public class ProblemSet01Test {

    @Test
    public void wordCountTest01(){
        ProblemSet01 problemSet01 = new ProblemSet01();
        String input = "Hello World";

        String expected = "2";
        String actual = problemSet01.wordCount(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wordCountTest02(){
        ProblemSet01 problemSet01 = new ProblemSet01();
        String input = "one 22 three";

        String expected = "3";
        String actual = problemSet01.wordCount(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void firstReverseTest01(){
        ProblemSet01 problemSet01 = new ProblemSet01();
        String input = "Hello World and Coders";

        String expected = "sredoC dna dlroW olleH";
        String actual = problemSet01.firstReverse(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void firstReverseTest02(){
        ProblemSet01 problemSet01 = new ProblemSet01();
        String input = "Do you think you can code?";

        String expected = "?edoc nac uoy kniht uoy oD";
        String actual = problemSet01.firstReverse(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestWordTest01(){
        ProblemSet01 problemSet01 = new ProblemSet01();
        String input = "fun&!! time";

        String expected = "time";
        String actual = problemSet01.longestWord(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestWordTest02(){
        ProblemSet01 problemSet01 = new ProblemSet01();
        String input = "I love dogs";

        String expected = "love";
        String actual = problemSet01.longestWord(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapCaseyTest01(){
        ProblemSet01 problemSet01 = new ProblemSet01();
        String input = "Hello-LOL";

        String expected = "hELLO-lol";
        String actual = problemSet01.swapCase(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapCaseyTest02(){
        ProblemSet01 problemSet01 = new ProblemSet01();
        String input = "Sup DUDE!!?";

        String expected = "sUP dude!!?";
        String actual = problemSet01.swapCase(input);
        Assert.assertEquals(expected, actual);
    }

}
