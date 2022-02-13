package LeetCode;

/*

5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"
 
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母组成

*/
public class LongestPalindromicSubstring {
    // 回文串类问题，中心扩散法
    // 遍历字符串将1个或2个字符作为回文中心向两侧扩散
    public String longestPalindrome(String s) {
        String str = "";
        if (s == null || s.length() == 0) return str;
        if (s.length() == 1) return s;

        for (int i = 0; i < s.length()-1; i++) {
            String s1 = findPalindrome(s,i,i);  // 奇数长度
            String s2 = findPalindrome(s,i,i+1);    // 偶数长度
            str = s1.length()>str.length()?s1:str;
            str = s2.length()>str.length()?s2:str;
        }
        return str;
    }
    private String findPalindrome(String s,int left, int right){
        // 扩散
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
