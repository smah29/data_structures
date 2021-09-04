import java.util.HashSet;
import java.util.Scanner;

public class LongestSubStringNoRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(longestSubStringLength(sc.next()));
    }

    private static int longestSubStringLength(String text) {
        char[] arr = text.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int i = 0, maxlength = 0;
        for (char element : arr) {
            while (set.contains(element)) {
                set.remove(arr[i++]);
            }
            set.add(element);
            maxlength = Math.max(maxlength, set.size());
        }
        return maxlength;
    }
}
