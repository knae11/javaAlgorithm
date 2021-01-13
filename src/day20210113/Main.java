package day20210113;

import java.util.Arrays;
// leetcode
public class Main {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ( (nums[i] + nums[j]) == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
    /*
    다른풀이 O(n)
    public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
     */

    public static int reverse(int x) {
        String stringX = String.valueOf(x);
        StringBuilder temp = new StringBuilder();
        if (stringX.charAt(0) == '-'){
            stringX = stringX.substring(1);
            temp.append('-');
        }
        for(int i = stringX.length()-1; i>-1; i--){
            temp.append(stringX.charAt(i));
        }
        long tempAnswer = Long.parseLong(temp.toString());
        if(tempAnswer > Integer.MAX_VALUE || tempAnswer < Integer.MIN_VALUE){
            return 0;
        }
        return (int) tempAnswer;
    }
/* 10의 자리 수를 받아오는 다른 풀이 , integer 값 넘는 경우 체크하는 부분 확인!
(2^21-1) = 2147483647가 max 인데 214748364이면 끝에가 8부터는 overflow!
-2^31 = -2147483648가 min 인데 214748364이면 끝자리가 -9부터는 overflow!
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
 */

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
