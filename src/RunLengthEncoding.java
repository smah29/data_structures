public class RunLengthEncoding {
    public static void main(String[] args) {
        String text = "aabc";
        System.out.println(encodeText(text));
    }

    private static String encodeText(String text) {
        char[] arr = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        char prev = 0;
        int count = 0;
        for (char letter : arr) {
            if (letter == prev) {
                count++;
            } else {
                if (prev != 0) {
                    sb.append(count).append(prev);
                    count = 1;
                } else {
                    count++;
                }
                prev = letter;
            }

        }
        sb.append(count).append(prev);
        return sb.toString();
    }
}
