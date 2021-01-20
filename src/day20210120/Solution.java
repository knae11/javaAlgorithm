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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution.solution(board, moves));
    }

}
