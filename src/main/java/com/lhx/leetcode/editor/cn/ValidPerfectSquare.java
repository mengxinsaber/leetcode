package com.lhx.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author lihongxiang
 * @title 367_有效的完全平方数
 * @data 2021-07-06 16:24:53
 */
public class ValidPerfectSquare {

//问题描述
//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 229 👎 0

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().new Solution().isPerfectSquare(82));
    }

    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            // 1的情况
            if (num == 1) {
                return true;
            }
            long left = 2;
            long right = num / 2;
            while (left <= right) {
                long mid = (right - left) / 2 + left;
                if (mid * mid > num) {
                    right = mid - 1;
                } else if (mid * mid < num) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}