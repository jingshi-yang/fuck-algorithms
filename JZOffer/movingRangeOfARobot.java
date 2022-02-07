package JZOffer;

/*

剑指 Offer 13. 机器人的运动范围

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：
输入：m = 2, n = 3, k = 1
输出：3

示例 2：
输入：m = 3, n = 1, k = 0
输出：1

提示：
1 <= n,m <= 100
0 <= k <= 20

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class movingRangeOfARobot {
    // 初看觉得只要遍历一遍所有的格子判断坐标位数之和是否大于k就好了，但是仔细想想这样是不行的
    // 因为题目要求的是机器人从0,0出发，所以实际上会遇到有的格子虽然符合要求但是因为邻接的格子不符合要求无法通过所以不能到达的情况
    // 所以要用到的算法实际上应该是搜索
    // 这里用bfs和dfs应该都是可以的，但是我对dfs更熟悉所以还是先写个dfs，bfs有时间再补个
    public int movingCount(int m, int n, int k) {
        // 二维数组标记访问状态
        boolean visited[][] = new boolean[m][n];
        // 只有一个入口，所以只需要从0，0开始搜索
        return dfs(0,0,m,n,k,visited);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        // 不符合条件或数过了直接返回0
        if (i < 0 || j < 0 || i >= m || j >= n || (i / 10) + (i % 10) + (j / 10) + (j % 10) > k || visited[i][j] ) {
            return 0;
        }
        // 标记格子
        visited[i][j] = true;
        // 递归调用，返回这一个格子加上这一个格子下面和右面可走的格子数量以及后续的格子数量
        return 1 + dfs(i+1, j, m, n, k, visited) + dfs(i, j+1, m, n, k, visited);
    }

    // 时间复杂度：O(MN)
    // 空间复杂度：O(MN)
}
