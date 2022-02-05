package JZOffer;

import java.util.Arrays;

/*

剑指 Offer 07. 重建二叉树

输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

示例 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

示例 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

限制：

0 <= 节点个数 <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class rebuildBinaryTree {
    // 题目给出了二叉树前序遍历和中序遍历的结果，注意前序遍历的顺序是根->左->右，中序遍历的顺序是左->根->右
    // 因此前序遍历结果的第一个元素就是整个二叉树的根，同时对比前序遍历和中序遍历我们可以获得该二叉树根节点的左子树与右子树
    // 二叉树相关的题目自然想到递归来处理，将每一个子树当作一个全新的二叉树来重复以上处理，就可以重建整个二叉树

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        // 当遍历结果仅含1元素时说明该节点为叶，返回
        if(preorder.length == 1) {
            return new TreeNode(rootVal);
        }
        // 重建二叉树
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 找到前序和中序中左右子树序列范围
        for (int i = 0; i< inorder.length;i++) {
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        // 运用分治法，将树分为左子树和右子树分别处理并安回root上
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex+1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex+1, preorder.length), Arrays.copyOfRange(inorder, rootIndex+1, inorder.length));
        return root;
    }
    // 注意这个解法完全无法处理二叉树含有重复元素的情况
    // 这破题干脆直接背熟好了
}
