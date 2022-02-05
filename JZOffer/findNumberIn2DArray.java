package JZOffer;
/*

剑指 Offer 04. 二维数组中的查找

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

给定 target = 5，返回 true。

给定 target = 20，返回 false。

限制：

0 <= n <= 1000

0 <= m <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 观察题目，可以发现如果我们从给定的矩阵右上角出发，可以观察到一个类似二叉搜索树的结构，因此我们在查找中可以从右上角入手。
        if (matrix.length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while(row<matrix.length && col>=0){
            // 在查询中，若矩阵当前值小于目标值则将游标下移，若大于目标值则将游标左移
            // 这里利用了题目所给出的数组的性质，可以类比二叉搜索树的操作
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target){
                col--;
            } else if (matrix[row][col]<target){
                row++;
            }
        }
        return false;
    }
    // 复杂度：
    // 游标最多向下移动m次，向左移动n次，因此时间复杂度为O(m+n)，相比之下暴力搜索遍历整个数组的时间复杂度为O(mn)
    // 空间复杂度：O(1)
}
// 一开始对着发了半天楞没想到怎么高效处理，倒了杯水回来瞟了一眼示例顿悟了
