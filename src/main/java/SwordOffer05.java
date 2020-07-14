/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class SwordOffer05 {

    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceSpace(str));
        System.out.println(replaceSpaceChar(str));
    }

    public static String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        return s.replace(" ", "%20");
    }

    public static String replaceSpaceChar(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
