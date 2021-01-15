package com.lhx.leetcode.editor.cn;

import java.util.*;

/**
 * @author lihongxiang
 * @title 20_有效的括号
 * @data 2021-01-07 09:38:05
 */
public class ValidParentheses {

//问题描述
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2079 👎 0


    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) {
                return false;
            }

            Map<Character, Character> map = new HashMap<Character, Character>() {
                {
                    put(')', '(');
                    put('}', '{');
                    put(']', '[');
                }
            };

            Deque<Character> deque = new LinkedList<>();
            char c;
            int i = 0;
            for (; i < s.length(); i++) {
                c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (deque.isEmpty() || !deque.peek().equals(map.get(c))) {
                        return false;
                    }
                    deque.pop();
                } else {
                    deque.push(c);
                }
            }
            return deque.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        System.out.println(new ValidParentheses().new Solution().isValid("()"));
    }
}