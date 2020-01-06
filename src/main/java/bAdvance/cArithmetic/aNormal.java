package bAdvance.cArithmetic;

/**
 * <pre>
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2020/1/2 12:19
 */
public class aNormal {

    /*
    * 最长回文
    * */
    public static String longestPalindrome(String s){
        if(s == null || s == "") return "";
        if(s.length() == 1) return s;
        if(s.length() == 2){
            if(s.substring(0,1).equals(s.substring(1))) return s;
        }
        String result = "";

        for(int i = 1 ; i < s.length() ; i ++){
            int wide = 1;
            int left = i - wide;
            int right = i + wide;

        }

        return result;
    }
}
