import java.util.HashMap;

class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
}
 
public class leetcode1_3 {
  public static void main(String [] args){
    System.out.printf("hello");
  }
    public int maxPoints(Point[] points) {
        if (points.length <= 1)
            return points.length;
        int maxUniv = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point cur = points[i];
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int howManyCur = 1, maxLocal = 0;
            for (int j = i + 1; j < points.length; j++) {   //������Դ�i+1��ʼ��֮ǰ�Ķ������
                    Point iter = points[j];
                    if (iter.x == cur.x && iter.y == cur.y) {//ͬһ����
                        howManyCur += 1;
                    } 
                    else {
                        String key = getSlopeInString(cur, iter);
                        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
                        maxLocal = Math.max(maxLocal, map.get(key));
                    }
            }
            maxLocal = howManyCur + maxLocal;
            maxUniv = Math.max(maxLocal, maxUniv);
        }
        return maxUniv;
    }
    public String getSlopeInString(Point cur, Point iter) {
        int numerator = iter.y - cur.y;
        int denominator = iter.x - cur.x;
        String sign = getSign(numerator, denominator);
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));//0������һ��������'a'��gcdΪ'a',0��0��gcdΪ0,����б��Ϊ����������ĸΪ0
        return sign + Math.abs(numerator)/gcd + "/" + Math.abs(denominator)/gcd;
    }
    //a��bΪ�Ǹ����� �� a��b��ͬʱΪ0
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public String getSign(int a, int b) {
        if (a <= 0 && b <= 0 || a >= 0 && b >= 0)
            return "+";
        else 
            return "-";
    }
}