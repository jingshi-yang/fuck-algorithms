package JZOffer;

import java.util.HashSet;

/*

剑指 Offer 03. 数组中重复的数字

找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
 
限制：
2 <= n <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
class findRepeatNumbers {
    // 方法一：哈希表，时间O(n)，空间O(n)
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashes = new HashSet<Integer>();
        for (int i = 0; i < nums.length;i++){
            if (hashes.contains(nums[i])){
                return nums[i];
            }
            hashes.add(nums[i]);
        } 
        return -1;
    }
    // 方法二：创建一个辅助数组，在原数据对应的下标处储存boolean，时间O(n)，空间O(n)
    // 与方法一类似，不赘述

    // 方法三：原地对数组元素进行交换，修改原数据，时间O(n)，空间O(1)
    /*
    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length;i++){
            while(nums[i]!=i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i]= nums[temp];
                nums[temp] = temp; 
            }
        } 
        return -1;
    }
    */
}
