import java.io.BufferedReader;
import java.io.InputStreamReader;

//LTE
public class hiho1815中位数 {
    private static void search(int[] arr, int count) {
        int midindex1 = 0, midindex2 = 0;
        if (count == 0) {
            System.out.println("0");
            return;
        }
        if (count % 2 == 0) {
            midindex1 = count / 2;
            midindex2 = count / 2 + 1;
        } else {
            midindex1 = count / 2 + 1;
        }
        int sum = 0;
        int mid1 = -1, mid2 = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sum = sum + arr[i];
                if (mid1 == -1 && sum >= midindex1) {
                    mid1 = i;
                }
                if (midindex2 != 0 && mid2 == -1 && sum >= midindex2) {
                    mid2 = i;
                }
                if (mid1 != -1 && (count % 2 != 0 || mid2 != -1)) {
                    break;
                }
            }
        }
        if (count % 2 != 0) {
            System.out.println(mid1);
        } else {
            if ((mid1 + mid2) % 2 == 0) System.out.println((int) (mid1 + mid2) / 2);
            else {
                System.out.println((float) (mid1 + mid2) / 2);
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bf.readLine());
            String[] s;
            int[] arr = new int[1000001];
            int count = 0;
            for (int i = 0; i < n; i++) {
                int a;
                s = bf.readLine().split("\\s+");
                if (s[0].equals("A")) {
                    a = Integer.parseInt(s[1]);
                    arr[a]++;
                    count++;
                    search(arr, count);
                }
                if (s[0].equals("R")) {
                    a = Integer.parseInt(s[1]);
                    if (arr[a] != 0) {
                        arr[a]--;
                        count--;
                    }
                    search(arr, count);

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return;
    }
}


