import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.MarshalException;
import java.util.Scanner;


//AC
public class hiho1817chengshifenpei2 {
    int maxn = 101;

    public void solution() {
        long sum = 0;
        long[][][] dp = new long[maxn][maxn][maxn];
        int[] beijing = new int[maxn * 3];
        int[] shanghai = new int[maxn * 3];
        int[] niuyue = new int[maxn * 3];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bf.readLine());
            String sb = new String();
            for (int i = 1; i <= 3 * n; i++) {
                sb = bf.readLine();
                beijing[i] = Integer.parseInt(sb.split("\\s+")[0]);
                shanghai[i] = Integer.parseInt(sb.split("\\s+")[1]);
                niuyue[i] = Integer.parseInt(sb.split("\\s+")[2]);
            }
            for (int i = 1; i <= 3 * n; i++) {
                for (int j = 0; j <= i - 1 && j < n; j++) {
                    for (int k = 0; k <= i - 1 - j && k <= n; k++) {
                        if (i - j - 1 - k <= n)
                            // beijing shanghai niuyue
                            dp[j + 1][k][i - j - 1 - k] = Math.max(dp[j + 1][k][i - j - 1 - k], dp[j][k][i - 1 - j - k] + beijing[i]);
                    }

                }
                for (int j = 0; j <= i - 1 && j <= n; j++) {
                    for (int k = 0; k <= i - j - 1 && k < n; k++) {
                        if (i - j - k - 1 <= n)
                            dp[j][k + 1][i - j - 1 - k] = Math.max(dp[j][k + 1][i - j - 1 - k], dp[j][k][i - j - k - 1] + shanghai[i]);
                    }
                }
                for (int j = 0; j <= i - 1 && j <= n; j++) {
                    for (int k = 0; k <= i - j - 1 && k <= n; k++) {
                        if (i - j - k - 1 + 1 <= n)
                            dp[j][k][i - j - k - 1 + 1] = Math.max(dp[j][k][i - j - k], dp[j][k][i - j - k - 1] + niuyue[i]);
                    }
                }
            }
            System.out.println(dp[n][n][n]);
        } catch (Exception e) {
            System.out.println(e);
        }
        return;
    }

    public static void main(String[] args) {
        hiho1817chengshifenpei2 test = new hiho1817chengshifenpei2();
        test.solution();
    }
}
