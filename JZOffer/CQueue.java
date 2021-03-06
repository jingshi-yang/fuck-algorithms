package JZOffer;

import java.util.Stack;

/*

剑指Offer 09.用两个栈实现队列

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]

示例 2：
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
class CQueue {
    // 维护两个栈分别储存进入队列和弹出队列的元素
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;
    
    public CQueue() {
        // 初始化
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    public void appendTail(int value) {
        // 进入队列的元素直接压入储存进入队列元素的栈
        stackIn.push(value);
    }
    
    public int deleteHead() {
        // 若弹出队列元素的栈为空则将全部进入队列元素压入
        // 由于进入队列的元素遵循先进后出原则，因此最先进入队列的元素会位于弹出队列栈的最上方
        // 此时直接弹出即可
        if(stackOut.isEmpty()) {
            while(!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        // 若栈依然为空说明该队列为空，返回-1
        if (stackOut.isEmpty()) {
            return -1;
        }
        return stackOut.pop();
    }
}
// 谁闲的没事出的这种题啊，有好好的队列不去用

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */