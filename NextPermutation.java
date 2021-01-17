import java.util.*;
public class NextPermutation {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start) {
        int i = start, j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void nextPermutation(int[] arr) {
        //A strinctly decreasing sequence is the last permutation itself, we can't get the next permutation for that.
        //In the array, we find the position of a number(from the end) that disturbs this strictly decreasing sequence. 
        //We need to swap it with the number(right to it) that is just greater that it and reverse that strictly decreasing subsequence to get the next permutation.
        int i = arr.length - 2;
        while (i >= 0 && arr[i + 1] <= arr[i]) {
            i--;
        }
        //Here we find the position(from the end) where the strictly deecreasing sequence breaks
        if (i >= 0) {
            int j = arr.length - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);    //finding the next greater element and swapping
        }
        reverse(arr, i + 1);    //reversing the strictly decreasing sequence to get the next permutation
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        nextPermutation(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
