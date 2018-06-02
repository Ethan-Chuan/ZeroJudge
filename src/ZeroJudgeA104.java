
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scanner.nextInt();
            }
            sort(arr, 0, n-1);
            printArray(arr);
        }
    }
    
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
/* Modify code getting from greeksforgreeds. Thanks for Rajat Mishra. */

/*
    幫我排個數字謝謝QQ
--------------------------------------------------------------------------------
輸入說明
    有多筆測資以EOF為結束
    第一行有一個正整數n(1<=n<=1000)，代表有幾個數字要請你幫忙排
    第二行有n個可以用int儲存的正整數
範例輸入
    6
    7 9 0 4 1 8
    8
    1 9 9 0 0 9 2 8
--------------------------------------------------------------------------------
輸出說明
    輸出n個已由小到大排序好的正整數
範例輸出
    0 1 4 7 8 9
    0 0 1 2 8 9 9 9
*/