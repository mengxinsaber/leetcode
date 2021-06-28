package com.lhx.leetcode.editor.cn;

/**
 * @author lihongxiang
 * @title 28_实现 strStr()
 * @data 2021-01-15 15:01:56
 */
public class ImplementStrstr {

//问题描述
//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 669 👎 0


    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            //BM
            int hayLen = haystack.length();
            int needLen = needle.length();
            char[] hayCharArr = haystack.toCharArray();
            char[] needCharArr = needle.toCharArray();
            int charNum = 256;
            //
            int[] bc = new int[charNum];
            for (int i = 0; i < charNum; ++i) {
                bc[i] = -1;
            }

            for (int i = 0; i < needLen; ++i) {
                int ascii = needCharArr[i];
                bc[ascii] = i;
            }

            int[] suffixIndex = new int[needLen];
            boolean[] isPre = new boolean[needLen];
            for (int i = 0; i < needLen; ++i) {
                suffixIndex[i] = -1;
                isPre[i] = false;
            }


            for (int i = 0; i < needLen - 1; ++i) {
                int j= i, k = 0;
                while (j >= 0 && needCharArr[j] == needCharArr[needLen - 1 - k]) {
                    --j;
                    ++k;
                    suffixIndex[k] = j + 1;
                }
                if (j == -1) {
                    isPre[k] = true;
                }
            }

            int a = 0;
            while (a <= hayLen - needLen) {
                int n;
                for (n = needLen - 1; n >= 0; --n) {
                    if (hayCharArr[a + n] != needCharArr[n]) {
                        break;
                    }
                }

                if (n < 0) {
                    return a;
                }

                int x = n - bc[hayCharArr[a + n]], y = 0;

                int goodSuffixLength = needLen - 1 - n;
                if (y < needLen - 1 && goodSuffixLength > 0) {
                    if (suffixIndex[goodSuffixLength] != -1) {
                        y = n - suffixIndex[goodSuffixLength] + 1;
                    } else {
                        y = needLen;
                        for (int i = n + 2; i < needLen - 1; ++i) {
                            if (isPre[needLen - i]) {
                                y = i;
                                break;
                            }
                        }
                    }
                }

                a = a+Math.max(x,y);
            }


            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new ImplementStrstr().new Solution().strStr("abcaa","bc"));
    }
}