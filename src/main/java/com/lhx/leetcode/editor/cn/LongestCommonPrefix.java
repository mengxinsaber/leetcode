package com.lhx.leetcode.editor.cn;

/**
 * @author lihongxiang
 * @title 14_最长公共前缀
 * @data 2021-01-06 16:33:12
 */
public class LongestCommonPrefix {

//问题描述
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1404 👎 0


    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String prefix = "";
            if (strs == null) {
                return prefix;
            }
            int i = 1, l = strs.length;
            if (l > 0) {
                prefix = strs[0];
            }
            int compareLength = 0, index = 0;
            for (; i < l; i++) {
                if (prefix.length() - strs[i].length() >= 0) {
                    compareLength = strs[i].length();
                } else {
                    compareLength = prefix.length();
                }
                while (index < compareLength && strs[i].charAt(index) == prefix.charAt(index)) {
                    index++;
                }
                prefix = strs[i].substring(0, index);
                if (index == 0) {
                    break;
                }
                index = 0;
            }

            return prefix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}