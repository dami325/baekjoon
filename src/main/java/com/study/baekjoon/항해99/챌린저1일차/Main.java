package com.study.baekjoon.항해99.챌린저1일차;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    private static Stack<Bag> stack = new Stack<>();

    private static int[] answer;

    public static int[] solution(int[] numbers) {
        int length = numbers.length;

        answer = new int[length];

        Arrays.fill(answer, -1);

        for (int i = 0; i < length-1; i++) {
            int left = numbers[i];
            int right = numbers[i + 1];
            if (left < right) {
                answer[i] = right;
                while (!stack.isEmpty() && stack.peek().value < right) {
                    Bag bag = stack.pop();
                    answer[bag.index] = right;
                }
            } else {
                stack.push(new Bag(i, left));
            }
        }

        return answer;
    }

    private static class Bag{

        private int index;
        private int value;

        public Bag(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[]{2, 3, 3, 5});
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

}
