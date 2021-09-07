import java.util.HashSet;

public class SumOfTwoIntegersTargetSum {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 8, 4, 3};
        int sum = 101;
        System.out.println(numbersExists(arr, sum));
    }

    private static boolean numbersExists(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(sum - i)) return true;
            else set.add(i);
        }
        return false;
    }
}
