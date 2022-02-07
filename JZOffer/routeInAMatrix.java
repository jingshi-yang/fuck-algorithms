package JZOffer;

/*

剑指 Offer 12. 矩阵中的路径

给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
 
提示：
1 <= board.length <= 200
1 <= board[i].length <= 200
board 和 word 仅由大小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class routeInAMatrix {
    // 猜测dfs+回溯，但是leetcode的tag打了个动规
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        if (m*n < len) return false;
        char[] chars = word.toCharArray();
        // 用一个boolean矩阵存储每一个格子是否已经走过
        boolean[][] visited = new boolean[m][n];
        // 从0，0开始依次对每一个格子dfs搜索
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 如果入口和单词第一个字母不同可以直接排除
                if (board[i][j] == chars[0]){
                    if(dfs(board, chars, visited, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int cur) {
        // 字母不符合要求直接false
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || chars[cur] != board[i][j]) {
            return false;
        }
        // 长度已经达到word长度则返回true
        if(cur == chars.length -1) return true;
        // 标记走过的格子
        visited[i][j] = true;
        // 对上下左右的格子递归搜索
        boolean ans = dfs(board, chars, visited, i+1, j, cur+1)
                    ||dfs(board, chars, visited, i-1, j, cur+1) 
                    ||dfs(board, chars, visited, i, j+1, cur+1)
                    ||dfs(board, chars, visited, i, j-1, cur+1);
        // 注意这里用了||来连接递归调用而不是分别赋值再连接结果，因为||是一种短路运算符，如果a||b||c||d这个表达式中a为true则不会继续判断bcd，因此可以节省一部分时间，相当于进行了剪枝处理
        // 一轮搜索后进行回溯时记得复位格子被走过的状态为false
        visited[i][j] = false;
        return ans;
    }

    // 时间复杂度：O(MN*3^K)，其中M,N为矩阵的长宽，K为word的长度
    // 空间复杂度：O(3^K)
    // 倾向于认为Leetcode标了动规是标错了，因为动规要求操作必须不具有后效性，但这个题目中要求走过的格子不能再次访问，因此具有后效性无法用动规解决
    // 可以看作是模板级别的dfs+回溯
}
