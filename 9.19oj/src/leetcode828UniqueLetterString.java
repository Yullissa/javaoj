import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//AC
public class leetcode828UniqueLetterString {
    public int uniqueLetterString(String S) {
        HashMap<Integer, Integer> Last = new HashMap<>();
        int MOD = 1000000007;

        int len = S.length();
        int[] Prev = new int[len];
        int[] Next = new int[len];
        Arrays.fill(Prev, -1);
        Arrays.fill(Next, len);
        for (int i = 0; i < len; i++) {
            int index = S.charAt(i) - 'A';
            if (Last.containsKey(index)) {
                Prev[i] = Last.get(index);
                Next[Last.get(index)] = i;
                Last.replace(index, i);
            } else {
                Last.put(index, i);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = (res + (i - Prev[i]) * (Next[i] - i) % MOD) % MOD;
        }
        return res;
    }
}
