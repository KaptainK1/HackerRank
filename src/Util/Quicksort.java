package Util;

public class Quicksort {

    /**
     * quick sort algorithm to sort an array of integers
     * this is a recursive algorithm, so the first step is to check if the starting point p is less than r
     * if so, then we get the partition point in the array where we check the value of the ending point
     * against all the other values. Once we do that we will return the position of where this partition value belongs
     * we then call quick sort again for the left half of that partition point (hence we use p (0) and q -r for the range)
     * then we call quick sort again for the right half of that partition point (q+1 and r)
     * once all of the recursive calls are done, the array is sorted!
     * @param array the inital array to be sorted
     * @param p the starting point of the array, usually 0
     * @param r the ending point of the array, ie the size -1
     */
    public static void quicksort(int[] array, int p, int r){
        if (p < r){
            int q = partition(array, p, r);
            quicksort(array, p ,q -1);
            quicksort(array, q+1, r);
        }
    }

    /**
     * this is the crucial partition function
     * that looks at the value of the last point in the array
     * and checks all of the values less than or equal to this value
     * if so, then we swap values. Once all of the swapping is done
     * we will return the index value of where the pivot point belongs in the array
     * which is a guarantee that the values less than this value is on the left and values greater are on the right
     * @param array the array to be sorted
     * @param p the starting point in the array
     * @param r the ending point in the array
     * @return we will return the index value of where the pivot point belongs in the array
     */
    private static int partition(int[] array, int p, int r){
        //x is the pivot point value, typically the last index item is picked
        int x = array[r];

        //set the i index variable to 1 less than the starting point
        int i = p -1;

        //loop for each item until the last one
        //starting at the starting point p
        for(int j = p; j <= r-1; j++){
            //if the value in the jith index is less than our pivot value, then it belongs in the left half so
            if (array[j] <= x){
                //increment 1 then swap i and j spots in the array
                i = i+1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //finally, do one last swap and return i + 1 as the partition point
        int temp = array[i+1];
        array[i+1] = array[r];
        array[r] = temp;
        return i+1;
    }


}
