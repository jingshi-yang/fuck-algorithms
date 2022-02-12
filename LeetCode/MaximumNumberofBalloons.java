package LeetCode;

/*

1189. “气球” 的最大数量
给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。

字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。

示例 1：
输入：text = "nlaebolko"
输出：1

示例 2：
输入：text = "loonbalxballpoon"
输出：2

示例 3：
输入：text = "leetcode"
输出：0

提示：
1 <= text.length <= 10^4
text 全部由小写英文字母组成

*/

public class MaximumNumberofBalloons {
    // 简单题我重拳出击
    // 很简单不多说了 遍历一遍text存储balon五个字母的数量
    // 注意把l和o的数量除以2, 因为balloon单词含有2个l和o
    // 答案要取最小值
    public int maxNumberOfBalloons(String text) {
        int[] dic = new int[5]; // b,a,l,o,n
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == 'b') dic[0]++;
            else if (text.charAt(i) == 'a') dic[1]++;
            else if (text.charAt(i) == 'l') dic[2]++;
            else if (text.charAt(i) == 'o') dic[3]++;
            else if (text.charAt(i) == 'n') dic[4]++;
        }
        dic[2] /= 2;
        dic[3] /= 2;
        int ans = dic[0];
        for (int i = 1; i < dic.length; i++){
            ans = dic[i] < ans ? dic[i] :ans;
        }
        return ans;
    }
}
