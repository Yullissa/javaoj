import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//AC
//class Point {
//    long dist;
//    long w;
//
//    Point(long dist, long w) {
//        this.dist = dist;
//        this.w = w;
//    }
//}

//public class hiho1812圆的最大值 {
//    public static void main(String[] args) {
//        int maxn = 100001;
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            int n = Integer.parseInt(bf.readLine());
//            ArrayList<Point> parr = new ArrayList();
//            String[] s;
//            for (int i = 0; i < n; i++) {
//                s = bf.readLine().split("\\s+");
//                long x = Long.parseLong(s[0]);
//                long y = Long.parseLong(s[1]);
//                long w = Long.parseLong(s[2]);
//                Point temp = new Point(x * x + y * y, w);
//                parr.add(temp);
//            }
//            Collections.sort(parr, (a, b) -> Long.compare(a.dist, b.dist));
//            long sum = 0;
//            long maxsum = Long.MIN_VALUE;
//            int i = 0;
//            while (i < n) {
//                long temp = 0;
//                int j = i;
//                while (j < n - 1 && parr.get(j).dist == parr.get(j + 1).dist) {
//                    temp += parr.get(j).w;
//                    j++;
//                }
//                i = j;
//                temp += parr.get(i).w;
//                sum += temp;
//                maxsum = maxsum < sum ? sum : maxsum;
//                i++;
//            }
//            System.out.println(maxsum);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return;
//    }
//}



