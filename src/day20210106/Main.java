package day20210106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
/* 제출용 template

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String args[]) throws IOException {

	     int[][] remains = {
            {10},
            {1},
            {6, 2, 4, 8},
            {1, 3, 9, 7},
            {6, 4},
            {5},
            {6},
            {1, 7, 9, 3},
            {6, 8, 4, 2},
            {1, 9}
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ts = Integer.parseInt(br.readLine());
        for (int i = 0; i < ts; i++) {
            String[] pair = br.readLine().split(" ");
            int a = Integer.parseInt(pair[0]) % 10;
            int b = Integer.parseInt(pair[1]);
            if (a == 0 || a == 1 || a == 5 || a == 6) {
                System.out.println(remains[a][0]);
            } else if (a == 4 || a == 9) {
                System.out.println(remains[a][b % 2]);
            } else {
                System.out.println(remains[a][b % 4]);
            }

        }

	}
}

 */

    private static void bj1009() throws IOException {
        int[][] remains = {
            {10},
            {1},
            {6, 2, 4, 8},
            {1, 3, 9, 7},
            {6, 4},
            {5},
            {6},
            {1, 7, 9, 3},
            {6, 8, 4, 2},
            {1, 9}
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ts = Integer.parseInt(br.readLine());
        for (int i = 0; i < ts; i++) {
            String[] pair = br.readLine().split(" ");
            int a = Integer.parseInt(pair[0]) % 10;
            int b = Integer.parseInt(pair[1]);
            if (a == 0 || a == 1 || a == 5 || a == 6) {
                System.out.println(remains[a][0]);
            } else if (a == 4 || a == 9) {
                System.out.println(remains[a][b % 2]);
            } else {
                System.out.println(remains[a][b % 4]);
            }

        }
    }


    public static void main(String[] args) throws IOException {
        bj1009();
    }


}
