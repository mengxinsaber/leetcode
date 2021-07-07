package com.lhx.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author lihongxiang
 * @title 1346_检查整数及其两倍数是否存在
 * @data 2021-07-07 15:38:02
 */
public class CheckIfNAndItsDoubleExist {

    //问题描述
//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。 
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 37 👎 0
    public static void main(String[] args) {
        System.out.println(new CheckIfNAndItsDoubleExist().new Solution().checkIfExist(new int[]{1, 0, 5, 3, 0}));
    }

    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if (binarySearch(arr, i, arr[i] * 2) >= 0) {
                    return true;
                }
            }
            return false;
        }

        public int binarySearch(int[] nums, int nIndex, int m) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < m) {
                    left = mid + 1;
                } else if (nums[mid] > m) {
                    right = mid - 1;
                } else {
                    if (nIndex == mid) {
                        left = mid + 1;
                        continue;
                    }
                    return mid;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}