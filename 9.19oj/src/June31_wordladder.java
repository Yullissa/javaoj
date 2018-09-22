import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;

public class June31_wordladder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        HashSet<String> visit = new HashSet<>();
        ConcurrentLinkedQueue<ArrayList<String>> q = new ConcurrentLinkedQueue<>();
        ArrayList<String> startArr = new ArrayList<>();
        dict.add(end);
        startArr.add(start);
        q.add(startArr);
        Boolean flag = false;
        int step = dict.size() + 3;
        int maxstep = step;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                ArrayList<String> cur = q.peek();
                q.poll();
                ArrayList<String> newAdd = addword(cur.get(cur.size() - 1), dict);
                for (int j = 0; j < newAdd.size(); j++) {
                    ArrayList<String> newline = new ArrayList<>(cur.subList(0, cur.size()));
                    newline.add(newAdd.get(j));
                    if (newAdd.get(j).equals(end)) {
                        flag = true;
                        step = newline.size();
                        break;
                    }
                    visit.add(newAdd.get(j));
                    q.add(newline);
                }
            }
            for (String temp : visit) {
                dict.remove(temp);
            }
            if (flag) break;
            visit.clear();
        }
//        System.out.println(step);
        if (step == maxstep) step = 0;
        return step;
    }

    ArrayList<String> addword(String word, HashSet wordlist) {
        ArrayList<String> res = new ArrayList<>();
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char s = wordChar[i];
            for (char c = 'a'; c <= 'z'; c++) {
                wordChar[i] = c;
                String temp = new String(wordChar);
                if (wordlist.contains(temp)) res.add(temp);
            }
            wordChar[i] = s;
        }
        return res;
    }
}
