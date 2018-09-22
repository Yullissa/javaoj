import java.util.Scanner;

// 数据结构： Tire 树
public class june_字典序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(solve(n, m));
        }
    }

    private static long solve(long n, long m) {
        long ans = 1;
        while (m != 0) {
            long cnt = getCntOfPre(ans, n);
            if (cnt >= m) {
                m--;             //不懂
                if (m == 0)
                    break;
                ans *= 10;  //最左子孩子
            } else {
                m -= cnt;
                ans++;   //右兄弟
            }
        }
        return ans;
    }

    private static long getCntOfPre(long pre, long n) {
        long cnt = 1;  // pre这个数自己
        long p = 10; //判断孩子节点是否符合n的要求
        // 类似DFS，深度搜索，判断孩子节点是否符合n的要求
        // 每次分支最小的一个数在<=n，至少有一个孩子节点符合要求
        for (; pre * p <= n; p *= 10) {
            if (pre * p - 1 + p < n)         //判断是不是包含pre*p/10分支的所有节点
                cnt += p;                    //包含，则加上该分支的所有个数
            else
                cnt += n - pre * p + 1;            //不懂
        }
        return cnt;  // 以Pre开头的数的个数 pre=1/2/3/4/5/6/7/8/9
    }
}