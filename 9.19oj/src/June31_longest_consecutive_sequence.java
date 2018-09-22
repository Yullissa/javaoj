import java.util.HashSet;

public class June31_longest_consecutive_sequence {
        public int longestConsecutive(int[] num) {
            HashSet hset = new HashSet();
            for (int n : num) {
                hset.add(n);
            }
            int res = 0;
            for (int n : num) {
                if (hset.contains(n)) {
                    hset.remove(n);
                    int prev = n - 1;
                    int post = n + 1;
                    while (hset.contains(prev)) {
                        hset.remove(prev--);
                    }
                    while (hset.contains(post)) {
                        hset.remove(post++);
                    }
                    res = Math.max(res, post - prev - 1);
                }
            }
            return res;
        }
}
