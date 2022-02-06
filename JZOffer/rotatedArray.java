package JZOffer;

/*

剑指 Offer 11. 旋转数组的最小数字

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  

示例 1：
输入：[3,4,5,1,2]
输出：1

示例 2：
输入：[2,2,2,0,1]
输出：0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class rotatedArray {
    // 题目所给数组属于部分有序，可以考虑用二分搜索解决
    // 当然直接return min(numbers)也行 但是面试官可能就再也不想看到你了
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int middle = (right + left) / 2;
            // 如果中值小于右值则说明旋转点一定在左侧
            if (numbers[middle] < numbers[right]) {
                right = middle;
            } 
            // 同样的，如果中值大于右值则说明旋转点一定在右侧
            else if (numbers[middle] > numbers[right]) {
                // 因为已经确定middle对应的不是最小元素了，所以可以令left=middle+1
                left = middle + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
    // 时间复杂度平均O(logN)，极端情况下会退化为O(n)，即数组内元素全部相同时
    // 空间复杂度O(1)
}
