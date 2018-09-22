public class Aug01_valid_palindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        char[] sArr = s.toCharArray();
        int i, j;
        for (i = 0, j = sArr.length - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(sArr[i])) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(sArr[j])) {
                j--;
            }
            if (i < j && Character.toLowerCase(sArr[i]) != Character.toLowerCase(sArr[j])) {
//                System.out.println("flase");
                return false;
            }
        }
//        System.out.println("true");
        return true;
    }
}
