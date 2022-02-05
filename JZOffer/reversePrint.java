package JZOffer;

import java.util.ArrayList;
import java.util.Stack;

/*

剑指 Offer 06. 从尾到头打印链表

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 
限制：

0 <= 链表长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class reversePrint {
    // 题目有多种思路可以完成
    // 思路一：递归，操作上类似链表反转
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    void recur(ListNode head){
        if(head == null) {
            return;
        }
        recur(head.next);
        list.add(head.val);
    }
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)

    // 思路二：利用辅助栈
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i <ans.length;i++){
            ans[i] = stack.pop();
        }
        return ans;
    }
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)

    // 思路三：反向填充数组
    public int[] reversePrint2(ListNode head) {
        int count = 0;
        ListNode tmp = head;
        while(tmp != null){
            count++;
            tmp = tmp.next;
        }
        int[] ans = new int[count];
        for (int i = count-1; i >= 0; i--){
            ans[i] = head.val;
            head = head.next;
        }
        return ans;
    }
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
}
