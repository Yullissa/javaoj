import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.MarshalException;
import java.util.Scanner;

//AC
public class hiho1816chengshifenpei {
    int maxn = 1001;

    public void solution() {
        long sum = 0;
        long[][] dp = new long[maxn][maxn];
        int[] beijing = new int[maxn * 2];
        int[] shanghai = new int[maxn * 2];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bf.readLine());
            String sb = new String();
            for (int i = 1; i <= 2 * n; i++) {
                sb = bf.readLine();
                beijing[i] = Integer.parseInt(sb.split("\\s+")[0]);
                shanghai[i] = Integer.parseInt(sb.split("\\s+")[1]);
            }
            for (int i = 1; i <= 2 * n; i++) {
                for (int j = 0; j <= i - 1 && j < n; j++) {
                    if (i - j - 1 <= n)
                        dp[j + 1][i - j - 1] = Math.max(dp[j + 1][i - j - 1], dp[j][i - j - 1] + beijing[i]);

                }
                for (int j = 0; j <= i - 1 && j <= n; j++) {
                    if (i - j <= n)
                        dp[j][i - j] = Math.max(dp[j][i - j], dp[j][i - j - 1] + shanghai[i]);
                }
            }
            System.out.println(dp[n][n]);
        } catch (Exception e) {
            System.out.println(e);
        }
        return;
    }

    public static void main(String[] args) {
//        Main test = new Main();
//        test.solution();
    }
}
