import java.util.Arrays;
import java.util.Scanner;

public class LeftRotateRecursive {
    public static void leftRotate(int[] arr, int k, int n) {
        if (k == 0)
            return;

        int first = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = first;

        leftRotate(arr, k - 1, n);
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

        leftRotate(arr, k % n, n);
        System.out.println("Array after " + k + " left rotations: " + Arrays.toString(arr));
    }
}
