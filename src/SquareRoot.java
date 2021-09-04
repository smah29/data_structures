import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(squareRootStandard(N));
        System.out.println(squareRoot(N));
    }

    private static int squareRoot(int n) {
        int l = 1, h = n / 2;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (mid == n / mid) return mid;
            else if (mid * mid < n) {
                if ((mid + 1) * (mid + 1) > n) return mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int squareRootStandard(int n) {
        return (int) Math.sqrt((double) n);
    }
}
