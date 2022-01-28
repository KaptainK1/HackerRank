package MergeSort;

//Time complexity of Merge Sort is θ(n Log n) in all 3 cases (worst, average and best)
//Merge sort algorithm requires an additional memory space of 0(n) for the temporary array.
public class MergeSort {

    public static void main(String[] args) {

        int[] array = new int[]{1,5,3,15,8,2,20};
        printArray(array);

        mergeSort(array,0, array.length -1);

        printArray(array);

    }

    private static void mergeSort(int[] array, int start, int end){

        if (end <= start){
            return;
        }
            int q = (start + end) / 2;
            mergeSort(array, start, q);
            mergeSort(array, q+1, end);
            merge(array,start,q,end);

    }

    private static void merge(int[] array, int start, int q, int end){

        int[] tempArray = new int[end - start +1];

        int leftSlot = start;
        int rightSlot = q+1;
        int k = 0;

        //loop while both the left slot is before the mid point and the right slot is before the end point
        while (leftSlot <= q && rightSlot <= end){
            //if the leftslot is smaller than the right slot, then put the left slot down in the array
            if (array[leftSlot] < array[rightSlot]){
                tempArray[k] = array[leftSlot];
                leftSlot++;
                //right slot is smaller so put that in the array next
            } else {
                tempArray[k] = array[rightSlot];
                rightSlot++;
            }
            //we need to increment k to keep track of where we are
            k++;
        }

        //if the left slot is less than or equal to the mid point
        //then that means we are missing some spaces in the temp array and need to be filled in with the
        //remaining values from the left side.
        // This can happen due to the right side is always smaller than the left side
        if (leftSlot <= q){
            while(leftSlot <= q){
                tempArray[k] = array[leftSlot];
                leftSlot++;
                k++;
            }
        //same as above but with the right side of the array
        } else if (rightSlot <= end){
            while(rightSlot <= end){
                tempArray[k] = array[rightSlot];
                rightSlot++;
                k++;
            }
        }

        //copy the temp array back into the original array that was passed in
        for (int i = 0; i < tempArray.length; i++) {
            array[start+i] = tempArray[i];
        }


    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print(array[array.length -1]);
        System.out.println();
    }

}
