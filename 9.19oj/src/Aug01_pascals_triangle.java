import java.util.ArrayList;

public class Aug01_pascals_triangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        /*
         * calcBinomialCoeff: 计算二项式展开的系数
         * C(n,k) = C(n,n-k)
         * C(n,k) = C(n-1,k) + C(n-1, k-1)
         * C(n,0) = C(n,n) = 1
         *
         */
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> binomialCoeffs = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                binomialCoeffs.add(1);
            }
            for (int k = 1; k < i; k++) {
                binomialCoeffs.set(k, res.get(i - 1).get(k - 1) + res.get(i - 1).get(k));
            }
            res.add(binomialCoeffs);
        }
        return res;
    }
}
