import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//AC
public class hiho1818paodekuai {
    public static void main(String[] args) {


        int maxn = 100001;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try

        {
            int n = Integer.parseInt(bf.readLine());

            for (int i = 0; i < n; i++) {
                int[] count = new int[maxn];
                int m = Integer.parseInt(bf.readLine());
                String[] s = bf.readLine().split("\\s+");

                for (int j = 0; j < m; j++) {
                    int num = Integer.parseInt(s[j]);
                    count[num]++;
                }

                boolean ans = true;
                int length1 = 0, length2 = 0, length3 = 0;
                for (int k = 0; k < maxn; k++) {
                    if (count[k] >= length1 + length2 + length3) {
                        int tlength1 = length1, tlength2 = length2, tlength3 = length3;
                        length3 = tlength2 + tlength3;
                        length2 = tlength1;
                        length1 = count[k] - tlength1 - tlength2 - tlength3;
                    } else if (count[k] >= length1 + length2) {
                        length3 = count[k] - length1;
                        length2 = length1;
                        length1 = 0;
                    } else {
                        ans = false;
                        break;
                    }
                }
                if (length1 > 0 || length2 > 0) ans = false;
                if (ans) System.out.println("YES");
                else System.out.println("NO");
            }
        } catch (
                Exception e)

        {
            System.out.println(e);
        }
        return;
    }
}
