package com.lhx.leetcode.editor.cn;

/**
 * @author lihongxiang
 * @title 1351_统计有序矩阵中的负数
 * @data 2021-07-07 16:26:30
 */
public class CountNegativeNumbersInASortedMatrix {

//问题描述
//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
//
// 请你统计并返回 grid 中 负数 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,-1],[-1,-1]]
//输出：3
// 
//
// 示例 4： 
//
// 
//输入：grid = [[-1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
//
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 70 👎 0


    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNegatives(int[][] grid) {
            int count = 0;
            for (int[] nums : grid) {
                count += binarySearch(nums);
            }
            return count;
        }

        public int binarySearch(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < 0) {
                    if (mid == 0 || nums[mid - 1] >= 0) {
                        return nums.length - mid;
                    }
                    right = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] < 0) {
                        return nums.length - 1 - mid;
                    }
                    left = mid + 1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}