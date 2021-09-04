public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 4, 3, 9, 2, 2};
        sort(arr);
        for (int i : arr) System.out.println(i);
    }

    private static void sort(int[] arr) {
        int n = arr.length;
        int[] out = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            ++count[arr[i]];
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < n; i++) {
            out[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = out[i];
        }
    }
}
