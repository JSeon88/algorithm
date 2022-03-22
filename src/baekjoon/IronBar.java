package baekjoon;

import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10799
 * [쇠막대기]
 * <p>
 * 입력 : ()(((()())(())()))(())
 * 출력 : 17
 * <p>
 * 입력 : (((()(()()))(())()))(()())
 * 출력 : 24
 */
public class IronBar {

    public static void main(String[] args) {
        IronBar ironBar = new IronBar();
//        System.out.println(ironBar.solution("()(((()())(())()))(())"));
        System.out.println(ironBar.solution("(((()(()()))(())()))(()())"));
    }

    public int solution(String brackets) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < brackets.length(); ++i) {
            char c = brackets.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                int index = stack.peek();
                if (index == i-1) {
                    stack.pop();
                    result +=stack.size();
                }else {
                    stack.pop();
                    result +=1;
                }
            }
        }
        return result;
    }
}
