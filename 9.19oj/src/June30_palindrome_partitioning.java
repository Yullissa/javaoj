import java.util.ArrayList;

public class June30_palindrome_partitioning {
    private Boolean[][] huiwen;
    private ArrayList<ArrayList<String>> ans;

    public ArrayList<ArrayList<String>> partition(String s) {
        char[] stringArr = s.toCharArray();
        int len = stringArr.length;
        this.huiwen = new Boolean[len][len];

        for (int i = 0; i < len; i++) {
            huiwen[i][i] = Boolean.TRUE;
        }

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (stringArr[i] == stringArr[j] && (i - j < 2 || huiwen[i - 1][j + 1] == Boolean.TRUE)) {
                    huiwen[i][j] = Boolean.TRUE;
                }
            }
        }

        ArrayList<String> res = new ArrayList<String>();
        this.ans = new ArrayList<ArrayList<String>>();
        findHuiwen(res, s, s.length() - 1);
        System.out.println(ans);
        return ans;
    }
    //    kao!!!  java 传参 若在函数中没有new 一个参数的对象，则参数指向原来的地址，即传的是地址！！！！！
    private void findHuiwen(ArrayList<String> res, String s, int end) {
        if (end == 0) {
            ArrayList<String> result = new ArrayList<>();
            result.add(s.substring(0, 1));
            for (int j = res.size() - 1; j >= 0; j--) {
                result.add(res.get(j));
            }
            ans.add(result);
            return;
        }
        int i = end;
        for (int j = i; j >= 0; j++) {
            if (huiwen[i][j] == Boolean.TRUE) {
                res.add(s.substring(j, i + 1));
                if (j == 0) {
                    ArrayList<String> result = new ArrayList<>();
                    for (int k = res.size() - 1; k >= 0; k--) {
                        result.add(res.get(k));
                    }
                    ans.add(result);
                    // 这里需要删除添加的字符串 why？  因为java传参传的是地址！！！！！！
                    res.remove(res.size() - 1);
                    return;
                } else {
                    findHuiwen(res, s, j - 1);
                    // 递归的时候这一步非常重要！！！！！！！！！！！！！ 将状态还原到上一步的状态
                    res.remove(res.size() - 1);
                }
            }
        }
        return;
    }
}