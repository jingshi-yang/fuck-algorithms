package JZOffer;

/*

剑指 Offer 14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1

示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

提示：
2 <= n <= 58

*/

public class CuttingRope1 {
    // 最优解+看不明白用什么->动规
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 3; i<=n; i++) {    
            for (int j = 1; j <= i/2 ; j++) {    // 这里写i/2是因为把绳子剪成1,4和4,1或2,3和3,2是一样的
                dp[i] = Math.max(dp[i], j*dp[i-j]);
                // j*dp[i-j]：剪下长度为j的一段
            }
        }
        return dp[n];
    }

    // 另外一个更好的解法是贪心
    // 过程省略，详细见LC本题目题解
    // 结论：多凑3结果更大, 只剩4时乘4
    public int cuttingRope1(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int result = 1;
        while (n>4) {
            n-=3;
            result*=3;
        }
        result *= n;
        return result;
    }
}

