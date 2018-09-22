import java.util.*;

public class june_k个最小数 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] s = str.split(" ");
            List<Integer> num = new ArrayList<>();
            for (int i = 0; i < s.length - 1; i++) {
                num.add(Integer.parseInt(s[i]));
            }
            int k = Integer.parseInt(s[s.length-1]);

            PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> o2.compareTo(o1));
            for (int i = 0; i < num.size(); i++) {
                if (pq.size() < k) {
                    pq.add(num.get(i));
                } else {
                    if (num.get(i) < pq.peek() ) {
                        pq.poll();
                        pq.add(num.get(i));
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            int len = pq.size();
            for (int i = 0; i < len; i++) {
                res.add(pq.poll());
            }
            res.sort((o1, o2) -> o1.compareTo(o2));
            for (int i = 0; i < res.size(); i++) {
                System.out.print(i==res.size()-1?res.get(i):res.get(i) + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
