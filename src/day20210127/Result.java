package day20210127;

import java.util.List;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    //https://www.hackerrank.com/challenges/diagonal-difference/problem
    public int diagonalDifference(List<List<Integer>> arr) {
        int leftToRight = 0;
        int rightToLeft = 0;
        int arrSize = arr.size();
        for (int i = 0; i < arrSize; i++) {
            leftToRight += arr.get(i).get(i);
            rightToLeft += arr.get(i).get(arrSize - 1 - i);
        }
        return Math.abs(leftToRight - rightToLeft);
    }

}