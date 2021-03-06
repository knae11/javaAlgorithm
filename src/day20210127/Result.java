package day20210127;

import java.util.List;

class Result {

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

    //https://www.hackerrank.com/challenges/time-conversion/problem
    public String timeConversion(String s) {
        String AMOrPM = s.substring(s.length() - 2);
        String[] parsed = s.split(":");
        int hour = Integer.parseInt(parsed[0]);
        if (AMOrPM.equals("PM")) {
            if (hour < 12) {
                return (hour + 12) + s.substring(2, s.length() - 2);
            }
        } else {
            if (hour == 12) {
                return "00" + s.substring(2, s.length() - 2);
            }
        }
        return s.substring(0, s.length() - 2);
    }

    //https://www.hackerrank.com/challenges/kangaroo/problem
    public String kangaroo(int x1, int v1, int x2, int v2) {
        if (v2 > v1 || v1 == v2) {
            return "NO";
        }
        if ((x1 - x2) % (v2 - v1) == 0) {
            return "YES";
        }
        return "NO";
    }

    //https://www.hackerrank.com/challenges/save-the-prisoner/problem
    public static int saveThePrisoner(int n, int m, int s) {
        int index = m % n != 0 ? m % n - 1 : n - 1;
        return (index + s) % n == 0 ? n : (index + s) % n;
    }

    public static void main(String[] args) {
        System.out.println(saveThePrisoner(2, 8, 2));
    }

}