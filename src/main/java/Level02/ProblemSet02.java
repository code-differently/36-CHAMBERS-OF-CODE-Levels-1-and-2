package Level02;

public class ProblemSet02 {
    /**
     * Have the function TimeConvert(num) take the num parameter being passed and return
     * the number of hours and minutes the parameter converts to (ie. if num = 63 then
     * the output should be 1:3). Separate the number of hours and minutes with a colon.
     */
    public String timeConvert(int num){
        //code goes here
        //step 1:initiate int variable named hour and set it equal to num divided by 60
        //step 2:And initiate another int variable named minutes set it equal to num modulus by 60
        //step 2: initiate a string variable to contain the string format of hours and minutes separated by ":" and name it result
        //step 3: return result

        int hour = num/60;
        int minutes = num%60;
        String result = hour + ":" + minutes;
        return result;
    }

    /**
     * Have the function CountingMinutesI(str) take the str parameter being passed which
     * will be two times (each properly formatted with a colon and am or pm) separated
     * by a hyphen and return the total number of minutes between the two times.
     * The time will be in a 12 hour clock format.
     * For example: if str is 9:00am-10:00am then the output should be 60.
     * If str is 1:00pm-11:00am the output should be 1320.
     */
    public String countingMinutes(String str) {
        // code goes here
        //step 1: create string array that contains a string of times named times
        //step 2: use split method to split string str to split by ("-")
        //step 3: initiate int variable for starting time named startTime
        //step 4: initiate int variable for ending time named endTime
        //step 5 use a static int get method to get time in minutes
        //step 6: use a parameter of string type time inside the getTimeInMinutes method
        //step 7: initiate a boolean to check if it is AM and set it to false
        //step 8:
        String[] times = str.split("-");
        int startTime = getTimeInMinutes(times[0]);
        int endTime = getTimeInMinutes(times[1]);
        if(endTime < startTime)
            endTime += 24 * 60;

        return String.valueOf(endTime - startTime);
    }

    static int getTimeInMinutes(String time){
        boolean isAm = false;
        int index = time.indexOf("am");

        if(index > 0){
            isAm = true;
        }

        time = time.substring(0, time.length() - 2);
        String[] times = time.split(":");

        int minutes = 60 * Integer.valueOf(times[0]) + Integer.valueOf(times[1]);
        if(!isAm){
            minutes += 12 * 60;
        }

        return minutes;
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
        // code goes here
        //step 1:instantiate stringBuilder named result
        //step 2:initialize int variable index
        //step 3:create string array named strNum1 and another string array named strNum2
        //step 4:use replace all and split methods on both the string arrays
        //step 5:loop through the length of strNum1
        //step 6:use if statement to check if the string arrays has the same number of elements
        //step 7:if they don't have equal number of elements then we append the remaining elements
        //step 8in oder to add strNum1[i] and strNum[2] we use Integer.parsaeInt to change both string arrays to int arrays
        //step 9:use append method to append the sum of the two converted int arrays to "-" to have 6-7-13-17 format
        //step10:convert result toString.substring and set it to finalResult
        //step11:return finalResult

        StringBuilder result = new StringBuilder();
        int index = strArr[0].length() > strArr[1].length() ? 0 : 1;
        String[] strNum1 = strArr[index].replaceAll("[^0-9,]", "").split(",");
        String[] strNum2 = strArr[Math.abs(index - 1)].replaceAll("[^0-9,]", "").split(",");
        String finalResult = null;
        for (int i = 0; i < strNum1.length; i++) {
            if (i < strNum2.length) {
                result.append(Integer.parseInt(strNum1[i]) + Integer.parseInt(strNum2[i])).append("-");
            } else {
                result.append(strNum1[i]).append("-");
            }
            finalResult = result.toString().substring(0, result.length() - 1);

        }
        return finalResult;
    }
}