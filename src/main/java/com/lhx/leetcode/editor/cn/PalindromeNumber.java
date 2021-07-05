package com.lhx.leetcode.editor.cn;

/**
 * @author lihongxiang
 * @title 9_回文数
 * @data 2020-12-30 10:12:08
 */
public class PalindromeNumber {

    //问题描述
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1351 👎 0
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(121));
    }

    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public static boolean isPalindrome(int x) {
            //首先排除负数和
            if (x < 0 || (x % 10 == 0) && x != 0) {
                return false;
            }
            int num = 0;
            while (x > num) {
                num = num * 10 + x % 10;
                x /= 10;
            }
            return num == x || x == num / 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}