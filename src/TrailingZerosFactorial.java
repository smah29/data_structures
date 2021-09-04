import java.util.Scanner;

public class TrailingZerosFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(trailingZerosFactorial(n));
    }

    private static int trailingZerosFactorial(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }

}
