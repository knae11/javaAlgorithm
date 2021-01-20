package day20210120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int boardSize = board.length;
        List<Integer> stack = new ArrayList<>();
        for (int move : moves) {
            for (int i = 0; i < boardSize; i++) {
                int item = board[i][move - 1];
                if (item != 0) {
                    // 초기에 stack에 0을 추가하고 사용하면 stack.size() != 0 을 체크하지 않아도 됨
                    if (stack.size() != 0 && stack.get(stack.size() - 1) == item) {
                        stack.remove(stack.size() - 1);
                        answer += 2;
                    } else {
                        stack.add(item);
                    }
                    board[i][move - 1] = 0;
                    // break 안 해주면 끝까지 탐색함
                    break;
                }

            }
        }
        return answer;
    }

    public List<Integer> solution42840(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] supo1 = new int[]{1, 2, 3, 4, 5};
        // 문제 제대로 읽자!!
        int[] supo2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // 배열로 하면 시간이 더 늘어난다고 한다!
        int[] correct = new int[]{0,0,0};
        for (int i = 0; i < answers.length; i++) {
            // index bound 확인하기!
            if (supo1[i % supo1.length] == answers[i]) {
                correct[0] += 1;
            }
            if (supo2[i % supo2.length] == answers[i]) {
                correct[1] += 1;
            }
            if (supo3[i % supo3.length] == answers[i]) {
                correct[2] += 1;
            }
        }
        int max = Math.max(correct[0], Math.max(correct[1], correct[2]));
        for (int i = 0; i < 3; i++) {
            if (correct[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution programmers = new Solution();
        int[] answer = new int[]{1, 2, 3, 4, 5};
        System.out.println(programmers.solution42840(answer));
    }

}
