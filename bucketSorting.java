// Name: <Nevin Gutta>

// Class: CS 3305/Section#

// Term: Spring 2024

// Instructor: Umama Tasnim

// Assignment: 4
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bucketSorting {
    //method to sort the given ArrayList using the Bucket Sort algorithm
    private static void bucketSort(ArrayList<Integer> arr) {
        //finds the maximum value in the array to determine the number of buckets needed
        int max = Collections.max(arr);
        // The number of buckets is one more than the maximum value to include the max value itself
        int bucketCount = max + 1;

        //initializes the buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        //distributes the elements of the array into the appropriate buckets
        for (int item : arr) {
            buckets.get(item).add(item);
        }

        //sorts each bucket and update the original array with the sorted elements
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // Sort the current bucket
            for (int item : bucket) {
                //places the sorted elements back into the original array
                arr.set(index++, item);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //asks the user for the number of elements in the array
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        //reads the elements of the array from user input
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        //prints the unsorted array
        System.out.print("Unsorted Array: [");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + (i < arr.size() - 1 ? ", " : ""));
        }
        System.out.println("]");

        //performs the bucket sort on the array
        bucketSort(arr);

        //prints the sorted array
        System.out.print("Sorted Array: [");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + (i < arr.size() - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

}