// https://leetcode.com/problems/add-two-numbers-ii/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int[] a = new int[100];
        int[] b = new int[100];

        int i=0, j=0;
        ListNode c1 = l1, c2 = l2;

        while(c1 != null){
            a[i++] = c1.val;
            c1 = c1.next;
        }
        
        while(c2!= null) {
            b[j++] = c2.val;
            c2 = c2.next;
        }

        i = i - 1;
        j = j - 1;

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        int carry = 0;
        while( i >= 0 && j>=0){
            int val = a[i] + b[j] + carry;
            
            ListNode newNode = new ListNode(val%10, current.next);
            current.next = newNode;

            carry = val/10;
            i-=1;
            j-=1;
        }

        while( i >= 0){
            int val = a[i] + carry;
            
            ListNode newNode = new ListNode(val%10, current.next);
            current.next = newNode;

            carry = val/10;
            i-=1;
        }

        while( j>=0){
            int val = b[j] + carry;
            
            ListNode newNode = new ListNode(val%10, current.next);
            current.next = newNode;

            carry = val/10;
            j-=1;
        }

        while(carry != 0){
            ListNode newNode = new ListNode(carry%10, current.next);
            current.next = newNode;

            carry/=10;
        }

        
        return dummy.next;
    }
}



// ----------------------------------------------------------------------------

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int[] a = new int[100];
        int[] b = new int[100];

        int i=0, j=0;
        ListNode c1 = l1, c2 = l2;

        while(c1 != null){
            a[i++] = c1.val;
            c1 = c1.next;
        }
        
        while(c2!= null) {
            b[j++] = c2.val;
            c2 = c2.next;
        }

        i = i - 1;
        j = j - 1;

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        int carry = 0;
        while( i >= 0 || j>=0 || carry != 0){
            int sum = carry;
            if(i >= 0) sum += a[i];
            if(j >= 0) sum += b[j] ;
            
            ListNode newNode = new ListNode(sum%10, current.next);
            current.next = newNode;

            carry = sum/10;
            i-=1;
            j-=1;
        }
        
        return dummy.next;
    }
}