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

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
       
        ListNode result = new ListNode();
        ListNode result_ptr = result;

        int noOfLists = lists.length;
            
        for (ListNode ln: lists) {
            if (ln == null) {
                noOfLists --;
            }
        }
        
        if (noOfLists == 0) {
            return null;
        }

        while (noOfLists > 0) {
            
            int next_min = Integer.MAX_VALUE;
            int listIndexWithNextMinVal = lists.length + 1;

            for (int i = 0; i < lists.length; i++) {

                ListNode ln = lists[i];

                if (ln == null) {
                    continue;
                }

                int list_min = ln.val;
                
                if (list_min < next_min) {
                    next_min = list_min;
                    listIndexWithNextMinVal = i;
                }
            }

            
            lists[listIndexWithNextMinVal] = (lists[listIndexWithNextMinVal]).next;
            
            if (lists[listIndexWithNextMinVal] == null) {
                noOfLists --;
            }

            result_ptr.val = next_min;

            if (noOfLists > 0) {
                result_ptr.next = new ListNode();
                result_ptr = result_ptr.next;
            }
        }

        return result;
    }
}