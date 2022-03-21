/**
 * https://www.acmicpc.net/problem/17413
 * [단어뒤집기2]
 * <p>
 * 문제
 * 문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
 * <p>
 * 먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
 * <p>
 * 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
 * 문자열의 시작과 끝은 공백이 아니다.
 * '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
 * 태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
 * 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
 * <p>
 * 입력
 * 첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.
 * <p>
 * 출력
 * 첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.
 */
package baekjoon;

import java.util.Stack;

public class WordFlipping {

    public static void main(String[] args) {
        WordFlipping wordFlipping = new WordFlipping();
//        wordFlipping.solution("baekjoon online judge");
        //noojkeab enilno egduj
//        wordFlipping.solution("<open>tag<close>");
        // <open>gat<close>
//        wordFlipping.solution("<ab cd>ef gh<ij kl>");
        // <ab cd>fe hg<ij kl>
        wordFlipping.solution("one1 two2 three3 4fourr 5five 6six");
        // 1eno 2owt 3eerht rruof4 evif5 xis6
    }

    public void solution(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean isTag = false;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '<') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                isTag = true;
                result.append(c);
            } else if (c == '>') {
                isTag = false;
                result.append(c);
            } else if (isTag) {
                result.append(c);
            } else {
                if (c != ' ') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()) {
                        result.append(stack.pop());
                    }
                    result.append(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result);
    }
}
