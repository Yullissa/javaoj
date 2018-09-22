import java.util.ArrayList;
//从最后一排往第一排思考，简单的~

public class Aug01_triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] res = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            res[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[j] = triangle.get(i).get(j) + Math.min(res[j], res[j + 1]);
            }
        }
        return res[0];
    }
}
