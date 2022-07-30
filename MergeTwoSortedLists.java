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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode result = new ListNode();
        ListNode result_ptr = result;

        while (true) {

           int smallerVal;
           int listContainingSmallerVal; 

           if (list1.val < list2.val) {
               smallerVal = list1.val;
               listContainingSmallerVal = 1;
           } else {
               smallerVal = list2.val;
               listContainingSmallerVal = 2;
           }

           result_ptr.val = smallerVal;

           if (listContainingSmallerVal == 1) {
               list1 = list1.next;
           } else {
               list2 = list2.next;
           }

           if (list1 == null) {
               result_ptr.next = list2;
               break;
           } else if (list2 == null) {
               result_ptr.next = list1;
               break;
           } else {
               result_ptr.next = new ListNode();
               result_ptr = result_ptr.next;
           }
         
        }

        return result;
    }
}