import java.util.*;

public class KmostOccuredElements {//dlogd where d is distinct elements
    public static void main(String[] args) {
        int[] arr = {5,5,5, 4, 4, 4, 3, 3, 2};
        int k = 3;
        findKMostOccured(arr, arr.length, k);
    }

    private static void findKMostOccured(int[] arr, int length, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {// here is sorting dlogd
            if (o1.getValue() == o2.getValue()) return o2.getKey() - o1.getKey();
            return o2.getValue() - o1.getValue();
        });
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i).getKey());
        }
    }
}
