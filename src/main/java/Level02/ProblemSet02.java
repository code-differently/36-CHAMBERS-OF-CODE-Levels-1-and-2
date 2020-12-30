package Level02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProblemSet02 {
    /**
     * Have the function TimeConvert(num) take the num parameter being passed and return
     * the number of hours and minutes the parameter converts to (ie. if num = 63 then
     * the output should be 1:3). Separate the number of hours and minutes with a colon.
     */
    public String timeConvert(int num){
        //ask if num > 60, if not return '0:' + num
        //if it is...
        //create hours variable = num/60
        //create min variable = num - (hours * 60)
        //return hours + ":" + min
        if(num > 60) {
            int hours = num / 60;
            int min = num - (hours * 60);
            return hours + ":" + min;
        }
        return "0:" + num;
    }

    /**
     * Have the function CountingMinutesI(str) take the str parameter being passed which
     * will be two times (each properly formatted with a colon and am or pm) separated
     * by a hyphen and return the total number of minutes between the two times.
     * The time will be in a 12 hour clock format.
     * For example: if str is 9:00am-10:00am then the output should be 60.
     * If str is 1:00pm-11:00am the output should be 1320.
     */
    public String countingMinutes(String str) throws ParseException {
        // create variables for totalMin, totalHr, min
        // split the time on ("-")
        // create SimpleDateFormat sdf with ("hh:mma")
        // sdf.parse(first time section)
        // sdf.parse(second time section)
        // calculate total time with time1 - time2
        //

        Integer totalMinutes, totalHr, min;

        String[] split = str.split("-");
        String time1 = split[0];
        String time2 = split[1];

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
        Date date1 = sdf.parse(time1);
        Date date2 = sdf.parse(time2);

        Long totalTime = date1.getTime() - date2.getTime();

        if(date2.getTime() < date1.getTime()) {
            Integer hr = (int) Math.floor(totalTime / 3600000);
            totalHr = 24 - hr;
            min = (int) Math.floor((totalTime - hr * 3600000) / 60000);
        }
        else {
            totalHr = (int) Math.floor(totalTime / 3600);
            min = (int) Math.floor((totalTime - totalHr * 3600000) / 60000);
        }

        totalMinutes = (totalHr * 60) - min;
        return totalMinutes.toString();
    }

    /**
     * Have the function ArrayMatching(strArr) read the array of strings stored in strArr
     * which will contain only two elements, both of which will represent an array of
     * positive integers. For example: if strArr is ["[1, 2, 5, 6]", "[5, 2, 8, 11]"],
     * then both elements in the input represent two integer arrays, and your goal for
     * this challenge is to add the elements in corresponding locations from both arrays.
     * For the example input, your program should do the following additions:
     * [(1 + 5), (2 + 2), (5 + 8), (6 + 11)] which then equals [6, 4, 13, 17].
     * Your program should finally return this resulting array in a string format with
     * each element separated by a hyphen: 6-4-13-17.
     *
     * If the two arrays do not have the same amount of elements, then simply append the
     * remaining elements onto the new array (example shown below).
     * Both arrays will be in the format: [e1, e2, e3, ...] where at least one element will
     * exist in each array.
     */
    public String arrayMatching(String[] strArr) {
        // strArr is a multi dimensional array, containing two String elements (sub arrays)
        // we need to unfreeze the arrays, and add elements at each corresponding location (arr1[0] + arr2[0])
        // we need to return a string, of summed up pairs in like this 6-4-13-17
        // if one array is longer than another - use 0 as the number to add.
        // 1 create an Integer[] finalValues for summed pairs.
        // split both string elements into arrays using split(^0-9)
        // find out which array is longer and even make them the same length
        // replace empty spaces or null values with "0";
        // loop and add two numbers together, skip if both are 0s.

        StringBuilder sb = new StringBuilder();
        List<Integer> finalValues = new ArrayList<>();
        String[] numOne = strArr[0].split("[^0-9]");
        String[] numTwo = strArr[1].split("[^0-9]");

        if(numOne.length > numTwo.length) numTwo = Arrays.copyOf(numTwo, numOne.length);
        else numOne = Arrays.copyOf(numOne, numTwo.length);

        for(int i = 0; i < numOne.length; i++) {
            if(numOne[i] == null || numOne[i].equals("")) numOne[i] = "0";
            if(numTwo[i] == null || numTwo[i].equals("")) numTwo[i] = "0";
        }

        for(int i = 1; i < numOne.length; i++) {
            if(numOne[i].equals("0") && numTwo[i].equals("0")) continue;
            else sb.append(Integer.parseInt(numOne[i]) + Integer.parseInt(numTwo[i]) + "-");
        }
        sb.deleteCharAt(sb.length() -1);
        System.out.println(sb.toString());
        return sb.toString();
    }
}
