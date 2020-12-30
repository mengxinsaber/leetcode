package editor.cn;

/**
 * @author lihongxiang
 * @title 7_整数反转
 * @data 2020-12-30 10:11:41
 */
public class ReverseInteger {

//问题描述
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2426 👎 0


    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int n = 0;
            int t, l;
            while (x != 0) {
                l = x % 10;
                t = n * 10 + l;
                if ((t - l) / 10 != n) {
                    return 0;
                }
                n = t;
                x = x / 10;
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}