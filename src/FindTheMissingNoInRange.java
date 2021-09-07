import java.util.stream.IntStream;

public class FindTheMissingNoInRange {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 2, 8, 4, 5};
        int l = 1, r = 8;
        int sum = findSum(arr);
        int dsum = desiredSum(r);
        System.out.println(dsum - sum);
    }

    private static int desiredSum(int r) {
        if ((r & 1) == 0)
            return (r / 2) * (r + 1);
        else
            return r * ((r + 1) / 2);
        //return IntStream.range(l, r + 1).sum();
    }

    private static int findSum(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }
}
