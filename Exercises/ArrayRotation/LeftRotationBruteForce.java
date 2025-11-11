import java.util.Arrays;
import java.util.Scanner;

public class LeftRotationBruteForce {

    public static void leftRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        for (int i = 0; i < k; i++) {
            int first = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = first;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of rotations (k): ");
        int k = sc.nextInt();

        leftRotate(arr, k);
        System.out.println("Array after " + k + " left rotations: " + Arrays.toString(arr));
    }
}
