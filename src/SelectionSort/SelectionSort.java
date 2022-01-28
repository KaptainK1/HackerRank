package SelectionSort;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = new int[]{1,5,3,15,2,8,20};

        printArray(array);

        for (int i = 0; i < array.length; i++) {
            int smallestIndex = findSmallestInt(array, i);

            int temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
        printArray(array);
    }

    //return the position of the next smallest number
    private static int findSmallestInt(int [] array, int startingSpot){

        if (startingSpot > array.length -1){
            return array.length -1;
        }

        int smallestNumber = array[startingSpot];
        int index = startingSpot;

        for (int i = startingSpot; i < array.length -1; i++) {
            if (smallestNumber > array[i]){
                smallestNumber = array[i];
                index = i;
            }
        }
        return index;
    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print(array[array.length -1]);
        System.out.println();
    }


}
