package com.lhx.leetcode.editor.cn;

/**
 * @author lihongxiang
 * @title 852_山脉数组的峰顶索引
 * @data 2021-07-07 11:10:01
 */
public class PeakIndexInAMountainArray {

//问题描述
//符合下列属性的数组 arr 称为 山脉数组 ：
// 
// arr.length >= 3 
// 存在 i（0 < i < arr.length - 1）使得：
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 
//1] > ... > arr[arr.length - 1] 的下标 i 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [0,1,0]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：arr = [0,2,1,0]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,10,5,2]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：arr = [3,4,5,1]
//输出：2
// 
//
// 示例 5： 
//
// 
//输入：arr = [24,69,100,99,79,78,67,36,26,19]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 104 
// 0 <= arr[i] <= 106 
// 题目数据保证 arr 是一个山脉数组 
// 
//
// 
//
// 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 201 👎 0
public static void main(String[] args) {
    int[] arr = {3,5,3,2,0};
    System.out.println(new PeakIndexInAMountainArray().new Solution().peakIndexInMountainArray(arr));
}

    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 1, right = arr.length - 2, index;
            if (arr[0] > arr[1]) {
                return 0;
            }
            if (arr[arr.length-1] > arr[right]) {
                return arr.length-1;
            }
            while (left <= right) {
                index = left + (right - left) / 2;
                if (arr[index] < arr[index - 1]) {
                    right = index - 1;
                } else if (arr[index] < arr[index + 1]) {
                    left = index + 1;
                }else {
                    return index;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}