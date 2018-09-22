import java.util.ArrayList;

public class Aug01_pascals_triangle_ii {
    public class Solution {
        public ArrayList<Integer> getRow(int rowIndex) {
            /*
             * calcBinomialCoeff: 计算二项式展开的系数
             * C(n,k) = C(n,n-k)
             * C(n,k) = C(n-1,k) + C(n-1, k-1)
             * C(n,0) = C(n,n) = 1
             *
             */
            ArrayList<Integer> binomialCoeffs = new ArrayList<>(rowIndex + 1);
            for (int i = 0; i < rowIndex + 1; i++) {
                binomialCoeffs.add(1);
            }
            for (int i = 0; i <= rowIndex; i++) {
                for (int k = i; k >= 0; k--) {
                    //边界
                    if (k == 0 || i == k)
                        binomialCoeffs.set(k, 1);
                        //i为偶数，第i行的个数为i+1，k为正中间的数
                    else if (2 * k == i) {
                        binomialCoeffs.set(k, binomialCoeffs.get(k - 1) * 2);
                    } else {
                        binomialCoeffs.set(k, binomialCoeffs.get(k - 1) + binomialCoeffs.get(k));
                    }
                }
            }
            return binomialCoeffs;
        }
    }
}
