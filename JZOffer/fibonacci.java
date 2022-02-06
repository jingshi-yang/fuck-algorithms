package JZOffer;

/*

剑指 Offer 10- I. 斐波那契数列

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：1

示例 2：
输入：n = 5
输出：5
 
提示：

0 <= n <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class fibonacci {
    // 经典递归
    public int originalFib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if(n == 2) return 1;
        else return originalFib(n-1) + originalFib(n-2);
    }
    
    // 啪的一个递归上去，很快啊，超时了
    // 因为递归方法处理斐波那契数列不经过优化会出现O(n^2)的时间复杂度，效率极低
    // 这里在Leetcode上输入为44的时候超时了
    // 优化：动态规划
    public int fibDP(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i<n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }
    // 时间复杂度: O(n), 空间复杂度: O(n)
    // 还能再优化一下
    // 观察动态规划的转移方程可以看出f(n)只与f(n-1)和f(n-2)有关
    // 因此可以只使用两个变量储存前两项
    public int fibDP1(int n) {
        if (n<2) return n;
        int p = 0, q = 0, ans = 1;
        for (int i=2; i<=n; i++){
            p=q;
            q=ans;
            ans=(p+q)%1000000007;
        }
        return ans;
    }
    // 时间复杂度: O(n), 空间复杂度: O(1)
    // 如果想要用递归解决的话同样可以，加入记忆化搜索即可，用一个static修饰的数组存储递推数据解决
}