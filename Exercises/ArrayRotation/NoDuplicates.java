import java.util.*;

public class NoDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        System.out.println("Array after removing duplicates: " + set);
    }
}
