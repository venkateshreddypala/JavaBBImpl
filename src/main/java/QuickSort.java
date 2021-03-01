import java.util.Arrays;

/**
 * The objective of this class is to provide quicksort implementation using Java
 * The algorithm takes an input of array and divides into two sublists
 * Let's consider the element which divides as index and call it pivotIndex.
 * Reorder the elements around the pivot recursively until there's nothing left on both sides;
 */
public class QuickSort {
    public static void main(String[] args) {
        //Unsorted array
        int[] arr = new int[]{28, 3, 4, 845, 943, 54, 224, 245};
        //Applying qicksort
        quickSort(arr, 0, arr.length - 1);
        //print sorted array
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {
        //check if parameters are empty
        if (arr.length == 0) {
            return;
        }
        //check if already sorted
        if (low >= high) {
            return;
        }
        //Get the pivot element
        int pivotIndex = arr[high];
        int i = low, j = high;
        while (i <= j) {
            //check until all the elements until the left side is less than pivotIndex
            while (arr[i] < pivotIndex) {
                i++;
            }
            //check until all the elements on the right side of the array are greater than pivot.
            while (arr[j] > pivotIndex) {
                j--;
            }
            //compare the int on both sides
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two subarrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

/**
 * Using streams
 */


/*
  An attempt to implement quickSort using Java 8 as close as possible to
  the elegant Haskell implementation:
  quicksort [] = []
  quicksort (x:xs) =
    let smallerSorted = quicksort [a | a <- xs, a <= x]
        biggerSorted = quicksort [a | a <- xs, a > x]
    in  smallerSorted ++ [x] ++ biggerSorted
*/


//public class QuickSort{
//
//    public static List<Integer> quickSort(List<Integer> xs){
//
//        if(xs.size() <= 1){
//            return xs;
//        }
//
//        int x = xs.get(0); //choosing the first element as the pivot
//
//        //smallerSorted = quicksort [a | a <- xs, a <= x]
//        List<Integer> smallerSorted = quickSort(
//                xs.stream()
//                        .skip(1) //removing pivot
//                        .filter(i -> i <= x) //filter the elements <= x
//                        .collect(Collectors.toList())); //convert the stream back to List
//
//        //biggerSorted = quicksort [a | a <- xs, a > x]
//        List<Integer> biggerSorted = quickSort(
//                xs.stream()
//                        .skip(1) //removing pivot
//                        .filter(i -> i > x) //filter the elements > x
//                        .collect(Collectors.toList())); //convert the stream back to List
//
//        //smallerSorted ++ [x] ++ biggerSorted
//        return Stream.concat(Stream.concat(smallerSorted.stream(), Stream.of(x)),biggerSorted.stream())
//                .collect(Collectors.toList());
//    }
//
//    public static void main(String[] args) {
//        System.out.println(QuickSort.quickSort(new ArrayList<Integer>(Arrays.asList(3,1,2,4,5,3,4,6,7,4,6)))); //[1, 2, 3, 3, 4, 4, 4, 5, 6, 6, 7]
//    }
//}

