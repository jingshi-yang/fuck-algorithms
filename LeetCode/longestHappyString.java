package LeetCode;

import java.util.PriorityQueue;

/*

LC1405. 最长快乐字符串

如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。

给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：

s 是一个尽可能长的快乐字符串。
s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
s 中只含有 'a'、'b' 、'c' 三种字母。
如果不存在这样的字符串 s ，请返回一个空字符串 ""。

示例 1：
输入：a = 1, b = 1, c = 7
输出："ccaccbcc"
解释："ccbccacc" 也是一种正确答案。

示例 2：
输入：a = 2, b = 2, c = 1
输出："aabbc"

示例 3：
输入：a = 7, b = 1, c = 0
输出："aabaa"
解释：这是该测试用例的唯一正确答案。
 
提示：
0 <= a, b, c <= 100
a + b + c > 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-happy-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class longestHappyString {
    // 三种字母有数量限制且不能连续出现三次，考虑用贪心算法处理
    // 优先放剩余数量最多的字母，如果连续出现两个再用第二多的字母把他隔开
    // 要实现找出剩余数量最多的字母可以通过维护一个优先队列（最大堆）
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(((x, y) -> y[1]-x[1]));
        if (a > 0) maxHeap.add(new int[]{0,a});
        if (b > 0) maxHeap.add(new int[]{1,b});
        if (c > 0) maxHeap.add(new int[]{2,c});
        StringBuilder sb = new StringBuilder();
        int pre = -1, count = 0; 
        while (!maxHeap.isEmpty()) {
            int[] maxChar = maxHeap.poll();
            if (pre != maxChar[0] || count < 2) { 
                sb.append((char) ('a' + maxChar[0]));
                if (maxChar[1] > 1) {
                    maxChar[1]--;
                    maxHeap.add(maxChar);
                }
                if (maxChar[0] == pre) {
                    count++;
                } else {
                    count = 1;
                }
                pre = maxChar[0];
            } else {
                int[] secondChar = maxHeap.poll();
                if (secondChar == null) break;
                maxHeap.add(maxChar);
                sb.append((char) ('a' + secondChar[0]));
                if (secondChar[1] > 1) {
                    secondChar[1]--;
                    maxHeap.add(secondChar);
                }
                count = 1;
                pre = secondChar[0];
            }
        }
        return sb.toString();
    }
}
