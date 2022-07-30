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
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        
        else if (head.next == null) {
            return head;
        }
        
        else {
            ListNode result = head;
            ListNode prev = head; 
            ListNode ls = head; 
            ListNode ls_ptr = head;
            
            int counter = 0;
            
            while (true) {
                if (counter == 0) {
                    ls_ptr = ls.next;
                    ls.next = ls_ptr.next;
                    ls_ptr.next = ls;
                    ls = ls_ptr;
                    result = ls;
                } else if (counter % 2 == 1) {
                    prev = ls;
                } else {
                    ls_ptr = ls.next;
                    ls.next = ls_ptr.next;
                    ls_ptr.next = ls;
                    ls = ls_ptr;
                    prev.next = ls;
                }
                
                ls_ptr = ls_ptr.next;
                ls = ls.next;
                counter ++;
                
                if (ls == null || ls.next == null) {
                    break;
                }
            }
            
            return result;
        }
    }
}