/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Complexity: O(n)
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
        	int sum = carry;
        	if (l1 != null) {
        		sum += l1.val;
        		l1 = l1.next;
        	}

        	if (l2 != null) {
        		sum += l2.val;
        		l2 = l2.next;
        	}

        	carry = sum / 10;
        	sum %= 10;
        	ListNode node = new ListNode(sum);
        	cur.next = node;
        	cur = cur.next;
        }

        return dummy.next;
    }
}