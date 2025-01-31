package com.lhx.leetcode.editor.cn;

/**
 * @author lihongxiang
 * @title 374_猜数字大小
 * @data 2021-07-06 17:00:22
 */
public class GuessNumberHigherOrLower {
//问题描述
//猜数字游戏的规则如下： 
//
// 
// 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。 
// 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。 
// 
//
// 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）： 
//
// 
// -1：我选出的数字比你猜的数字小 pick < num 
// 1：我选出的数字比你猜的数字大 pick > num 
// 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num 
// 
//
// 返回我选出的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10, pick = 6
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 1, pick = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：n = 2, pick = 1
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：n = 2, pick = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 1 <= pick <= n 
// 
// Related Topics 二分查找 交互 
// 👍 154 👎 0


    //实现
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Forward declaration of guess API.
     *
     * @param n your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1, right = n;
            while (true) {
                int mid = left + (right - left) / 2;
                if (guess(mid) == -1) {      //mid > target
                    right = mid;
                } else if (guess(mid) == 1) { // mid < target
                    left = mid + 1;
                } else {                      //mid = target
                    return mid;
                }
            }
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    class GuessGame {
        int guess(int num) {
            return 0;
        }
    }
}