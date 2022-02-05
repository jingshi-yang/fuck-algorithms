package JZOffer;

/*

剑指 Offer 05. 替换空格

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 
限制：

0 <= s 的长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class replaceSpace {
    // 没什么难度 不多说了
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        // 因为是单线程所以直接用StringBuilder就好，会更快一点点
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    // 时间复杂度O(n)，空间复杂度O(n)
    // 其实这个题目可以直接用库函数完成
    // return s.replace(" ","%20");
    // 除此之外似乎还可以用双指针不占用额外空间原地修改来做，有空慢慢研究了
}
