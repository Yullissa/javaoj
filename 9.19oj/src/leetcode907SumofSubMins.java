//AC

import java.util.Stack;

public class leetcode907SumofSubMins {
    public int sumSubarrayMins(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int sum = 0;
        int MOD = 1000000007;
        Stack<int[]> s = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            left[i] = 1;
            while (!s.empty() && A[i] < s.peek()[0]) {
                left[i] += s.pop()[1];
            }
            s.push(new int[]{A[i], left[i]});
        }
        s.clear();
        for (int i = A.length - 1; i >= 0; i--) {
            right[i] = 1;
            while (!s.empty() && A[i] <= s.peek()[0]) {
                right[i] += s.pop()[1];
            }
            s.push(new int[]{A[i], right[i]});
        }
        for (int i = 0; i < A.length; i++) {
            sum = (sum + left[i] * right[i] * A[i]) % MOD;
        }
        return sum;
    }

    public static void main(String[] args) {
        new leetcode907SumofSubMins().sumSubarrayMins(new int[]{71, 55, 82, 55});
    }
}
