package SubArraySorting;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void solution(String[] args) {
        List<Integer> startingList = new ArrayList<>();
        startingList.add(1);
        startingList.add(2);
        startingList.add(3);
        startingList.add(4);


        List<List<Integer>> operations = new ArrayList<>();
        List<Integer> firstOperations = new ArrayList();
        firstOperations.add(0);
        firstOperations.add(2);

        operations.add(firstOperations);

        System.out.println(startingList);
        System.out.println(performOperations(startingList, operations));

        // write your code here
    }

    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        // Write your code here

        //store array size
        int arraySize = arr.size();

        //init new array with the same size as the passed in array
        int[] finalArray = new int[arraySize];

        //populate the array
        for (int i = 0; i < arraySize; i++) {
            finalArray[i] = arr.get(i);
        }

        //loop through each list of operations
        for (int i = 0; i < operations.size(); i++) {

            //get the ith operation list
            List<Integer> ops = operations.get(i);

            //from that list, get the starting and ending index
            int startingIndex = ops.get(0);
            System.out.println("Starting Index: " + startingIndex);

            int endingIndex = ops.get(1);
            System.out.println("Ending Index: " + endingIndex);

            System.out.println("Printing array in current state...");
            for (int j2 = 0; j2 < arraySize; j2++) {
                System.out.print(finalArray[j2] + ",");
            }
            System.out.println();

            for (int j = 0; j < arraySize -1; j += endingIndex) {

                int left = j;
                //int right = Math.min(j + endingIndex, arraySize);
                int right = endingIndex;
                int temp;


                while(left < right) {
                    temp = finalArray[left];
                    finalArray[left] = finalArray[right];
                    finalArray[right]= temp;
                    left+=1;
                    right-=1;
                }

                System.out.println("Printing Array...");
                for (int k = 0; k < finalArray.length; k++) {
                    System.out.print(finalArray[k] + ",");
                }
            }

        }

        List<Integer> finalList = new ArrayList();
        for (int i = 0; i < arraySize; i++) {
            finalList.add(finalArray[i]);
        }

        return finalList;

    }
}
