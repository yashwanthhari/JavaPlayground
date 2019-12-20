package LeetCode;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Type[] types = new Type[5];
        Map<Integer, Integer> map = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        }
    }

    private static boolean isOpen(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isClosed(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean isPair(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpen(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (isClosed(s.charAt(i))) {
                if (!stack.empty() && isPair(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.empty();
    }
}