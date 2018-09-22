//AC
public class leetcode905SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                B[j] = A[i];
                j++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                B[j] = A[i];
                j++;
            }
        }
        return B;
    }
}
