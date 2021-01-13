package day20210113;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// leetcode
public class Main {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
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
        if (stringX.charAt(0) == '-') {
            stringX = stringX.substring(1);
            temp.append('-');
        }
        for (int i = stringX.length() - 1; i > -1; i--) {
            temp.append(stringX.charAt(i));
        }
        long tempAnswer = Long.parseLong(temp.toString());
        if (tempAnswer > Integer.MAX_VALUE || tempAnswer < Integer.MIN_VALUE) {
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
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 남의 코드를 보고 풀었다. next로 넘기는 작업을 어떻게 해야 하는지 모르겠다. head를 복사해서 그 자체의 연결고리를 바꿔주고 처음 시작인 head를 반환해주면 되었다.
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            while (next != null && temp.val == next.val) {
                next = next.next;
            }
            temp.next = next;
            temp = next;
        }
        return head;
    }
    /*
    리츠코드 풀이
public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
     */

    public static boolean isPalindrome(int x) {
        String original = String.valueOf(x);
        StringBuilder reversed = new StringBuilder();
        for (int i = original.length() - 1; i > -1; i--) {
            reversed.append(original.charAt(i));
        }
        return original.equals(reversed.toString());
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String prefix = "";
        while (strs[0].length() > -1) {
            prefix = strs[0];
            int count = strs.length;
            for (String word : strs) {
                if (word.startsWith(prefix)) {
                    count--;
                }
            }
            if (count == 0) {
                break;
            } else {
                strs[0] = strs[0].substring(0, strs[0].length() - 1);
            }
        }
        return prefix;
    }
    /*
    왜 오래걸려..ㅠㅠ

    다른 풀이

     public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    return prefix;
}
     */

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    // https://leetcode.com/problems/linked-list-cycle/ 에서 실행됨
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        if(head == null || head.next == null){
            return false;
        }
        while( head.next != null){
            if( nodes.contains(head)){
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
