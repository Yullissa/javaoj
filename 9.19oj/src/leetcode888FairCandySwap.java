import java.util.HashSet;
import java.util.stream.IntStream;

public class leetcode888FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
//  自己写的，AC ! 但haolow啊
//  boolean[] Anum = new boolean[100001];
//        for (int i = 0; i < Anum.length; i++) {
//            Anum[i] = false;
//        }
//        boolean[] Bnum = new boolean[100001];
//        for (int i = 0; i < Bnum.length; i++) {
//            Bnum[i] = false;
//        }
//        long sumA = 0;
//        long sumB = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (Anum[A[i]] == false)
//                Anum[A[i]] = true;
//            sumA += A[i];
//        }
//        for (int i = 0; i < B.length; i++) {
//            if (Bnum[B[i]] == false)
//                Bnum[B[i]] = true;
//            sumB += B[i];
//        }
//        int diff = (int) ((sumA + sumB) / 2 - sumA);
//        int[] res = new int[2];
//        for (int i = 1; i < Anum.length; i++) {
//            if (i + diff >= 1 && i + diff < Bnum.length) {
//                if (Anum[i] == true && Bnum[i + diff] == true) {
//                    res[0] = i;
//                    res[1] = i + diff;
//                    break;
//                }
//
//            }
//        }
////        System.out.println(res[0]);
////        System.out.println(res[1]);
//        return res;
        int diff = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        HashSet<Integer> S = new HashSet<>();
        for (int a : A) S.add(a);
        for (int b : B) if (S.contains(b + diff)) return new int[]{b + diff, b};
        return new int[0];
    }
}
