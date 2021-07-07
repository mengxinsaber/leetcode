package com.lhx.leetcode.editor.cn;

/**
 * @author lihongxiang
 * @title 441_排列硬币
 * @data 2021-07-06 17:29:58
 */
public class ArrangingCoins {

//问题描述
//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。 
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。 
//
// n 是一个非负整数，并且在32位有符号整型的范围内。 
//
// 示例 1: 
//
// 
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
// 
//
// 示例 2: 
//
// 
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
// 
// Related Topics 数学 二分查找 
// 👍 109 👎 0

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().new Solution().arrangeCoins(1804289383));
    }

    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            //n=k*(k+1)/2
            long left = 0, right = n, l = 0;
            long r;
            while (left <= right) {
                long mid = (right - left) / 2 + left;
                r = mid * (mid + 1) / 2;
                if (r > n) {
                    right = mid - 1;
                } else {
                    l = mid;
                    left = mid + 1;
                }
            }
            return (int) l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}