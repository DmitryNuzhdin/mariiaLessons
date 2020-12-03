package leetcode.validParentheses;

import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        if (s != null && s.length() % 2 == 0) {
            Stack<Character> openedParenthesis = new Stack<>();
            openedParenthesis.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (openedParenthesis.empty()) {
                    openedParenthesis.push(s.charAt(i));
                    continue;
                }
                String pair = new String(new char[] {openedParenthesis.peek(), s.charAt(i)});
                if (pair.equals("()") || pair.equals("{}") || pair.equals("[]")) {
                    openedParenthesis.pop();
                } else {
                    openedParenthesis.push(s.charAt(i));
                }
            }
            return openedParenthesis.empty();
        } else {
            return false;
        }
    }
}
