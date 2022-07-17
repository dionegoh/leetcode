/* Add two numbers 

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example: 
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

*/ 


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



class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode();
        ListNode result_ptr = result;
        int carry = 0; 
        
        while (true) {
            
            int a;
            int b; 
      
            
            if (l1 == null) {
                 a = 0;
                 l1 = new ListNode(0);
            } else {
                 a = l1.val;
            }
            
            if (l2 == null) {
                b = 0;
                l2 = new ListNode(0);
            } else {
                b = l2.val;
            }
            
        
            int sum = a + b + carry;
            
            if (sum > 9) {
                carry = (int) Math.floor(sum / 10);
                sum = sum % 10; 
            } else {
                carry = 0;
            }
            
            result_ptr.val = sum; 
            
            l1 = l1.next;
            l2 = l2.next;
                
            if (l1 == null && l2 == null && carry == 0) {
                return result;
            }
            result_ptr.next = new ListNode();
            result_ptr = result_ptr.next;
        }
    }    
}