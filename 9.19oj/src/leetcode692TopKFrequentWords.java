import java.util.*;


//Time Complexity: O(N \log{k})O(Nlogk), where NN is the length of words. We count the frequency of each word in O(N)O(N) time, then we add NN words to the heap, each in O(\log {k})O(logk) time. Finally, we pop from the heap up to kk times. As k \leq Nk≤N, this is O(N \log{k})O(Nlogk) in total.
public class leetcode692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        //niubi
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2));

        //keyide
        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
