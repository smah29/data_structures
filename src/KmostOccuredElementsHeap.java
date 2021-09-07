import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KmostOccuredElementsHeap {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 4, 4, 4, 3, 3, 2};
        int k = 3;
        findKMostOccured(arr, arr.length, k);
    }

    private static void findKMostOccured(int[] arr, int length, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) ->
                a.getValue() == b.getValue() ?
                        Integer.compare(b.getKey(), a.getKey())
                        : Integer.compare(b.getValue(), a.getValue())
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);//O(d) creation of priority queue
        }
        for (int i = 0; i < k; i++) {
            System.out.println(queue.poll().getKey());//k log d
        }
    }
}
