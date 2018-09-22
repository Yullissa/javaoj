public class Aug02_distinct_subsequences {
    public int numDistinct(String S, String T) {
        int len = T.length();
        int[] arr = new int[len + 1];
        arr[0] = 1;
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();
        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = Math.min(i, len); j > 0; j--) {
                if (sArr[i - 1] == tArr[j - 1]) arr[j] = arr[j] + arr[j - 1];
            }
        }
        return arr[len];
    }
}
