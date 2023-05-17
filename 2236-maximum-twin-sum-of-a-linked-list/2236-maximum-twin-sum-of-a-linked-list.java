/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        int halfDistance = (length / 2);
        int[] twinSum = new int[halfDistance];
        int currentIndex = 0;
        temp = head;
        while(currentIndex < halfDistance) {
            twinSum[currentIndex] = temp.val;
            temp = temp.next;
            currentIndex++;
        }
        currentIndex = halfDistance - 1;
        int maxTwinSum = 0;
        for(int i : twinSum) {
            System.out.println(i);
        }
        System.out.println(temp.val);
        while(temp != null) {
            twinSum[currentIndex] += temp.val;
            temp = temp.next;
            maxTwinSum = Math.max(twinSum[currentIndex], maxTwinSum);
            currentIndex--;
        }
        
        return maxTwinSum;
    }
}