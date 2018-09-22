import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode890FindandReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Integer> pat = new HashMap<>();
        int[] patArr = new int[20];
        int patChindex = 0;
        int patCount = 1;
        for (Character ch : pattern.toCharArray()) {
            if (!pat.containsKey(ch)) {
                pat.put(ch, patCount++);
            }
            patArr[patChindex++] = pat.get(ch);
        }
        List res = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            boolean wordJudge = true;
            HashMap<Character, Integer> temp = new HashMap<>();
            int[] tempArr = new int[20];
            patChindex = 0;
            patCount = 1;
            for (Character ch : words[i].toCharArray()) {
                if (!temp.containsKey(ch)) {
                    temp.put(ch, patCount++);
                }
                tempArr[patChindex++] = temp.get(ch);
            }
            for (int j = 0; j < patArr.length; j++) {
                if (patArr[j] != tempArr[j]) {
                    wordJudge = false;
                    break;
                }
            }
            if(wordJudge == true){
                res.add(words[i]);
            }
        }
        return res;
    }
}
