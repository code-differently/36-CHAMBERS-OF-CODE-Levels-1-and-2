package Level01;

import static java.util.Collections.checkedCollection;
import static java.util.Collections.swap;
import java.util.*;
import java.io.*;

public class ProblemSet01 {

    /**
     * Have the wordCount(input) take the str string parameter being passed
     * and return the number of words the string contains
     * (e.g. "Never eat shredded wheat or cake" would return 6). Words will be
     * separated by single spaces.
     */
    public String wordCount(String input) {
        // code goes here
        //Method 1
        //Step 1: create a string array to hold array of strings
        //step 2: use split method to split the string and store in the3 string array
        //step 3: create integer variable to hold the count of items in the array
        //step 4: use the length of the string array to set the int variable
        //step 5: convert the int to string using toString() method
        //step 6: return string version of the number returned

        //Method 2
        //step 1: create a string array and name it wordsToCount
        //step 2: initialize wordsToCount equal to input.split(" ") to allow to split the the string stored inside the string[]
        //(" ") is to allow words to be separated by single space
        //step 3: return a string number that shows the number of words in the string array
        String[] wordToCount = input.split(" ");
        String result = "" + wordToCount.length;
        return result;
    }

    /**
     * Using the Java language, have the function firstReverse(String input) take the input parameter being passed and
     * return the string in reversed order. For example: if the input string is "Hello World and Coders" then your
     * program should return the string sredoC dna dlroW olleH.
     */

    public String firstReverse(String input) {
        //Method 1
        // step 1 - instantiate stringBuilder object named reverseString with the value of input
        // step 2 - call the .reverse() method on the string named input; assign the result to the reverseString variable using .toString() to cast to String
        // step 3 - return the reverseString

        //Method 2
        //step 1: initialize a blank string and name it reversed
        //step 2: loop through the input.length and decrementing the index
        //step 3: return reversed string
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }


    /**
     * Have the longestWord(String input) take the input parameter being passed and return the
     * largest word in the string. If there are two or more words that are the same length,
     * return the first word from the string with that length. Ignore punctuation and assume
     * input will not be empty.
     */
    public String longestWord(String input) {
        // code goes here

        //step 1: create string array and name it words
        //step 2: initiate string variable named longest and set it to blank string("")- this will be the longest word to return later
        //step 2: use split method to split the string input
        //step 3: use if statement inside for each loop to check if a word in words is the longest word
        //step 4: return string of longest
        String[] words = input.split("[^\\w]");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
    /**
     * Have the swapCase(String input) take the input parameter and swap the case of each
     * character. For example: if str is "Hello World" the output should be hELLO wORLD.
     * Let numbers and symbols stay the way they are.
     */
    public String swapCase(String str) {
        // code goes here
        //step 1: instantiate stringBuilder named strBuilder
        //step 2: create character array from the string str
        //step 3: loop through the charArray and swap char c
        //step 4: convert character toString
        //step 5: return string if uppercase by swapping to lowercase and if lowercase to uppercase.
       StringBuilder strBuilder = new StringBuilder();
           for(char c : str.toCharArray())
             strBuilder.append(swap(c));
             return strBuilder.toString();
        }
         public static char swap(char c){
            return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
        }
    }
