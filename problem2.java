//https://leetcode.com/problems/palindrome-linked-list/description/

// Time Complexity : O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//find mid of the list
//reverse the second half
//check value of node from begining with value of node from reversed second half
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //find mid of the list
        ListNode temp=head;
        ListNode half=head;
        while(temp!=null && temp.next != null){
            temp=temp.next.next;
            half=half.next;
        }
        //reverse the second half
        ListNode prev=null;
        while(half!=null){
            ListNode nextNode = half.next; 
            half.next = prev;              
            prev = half;                  
            half = nextNode;
        }
        //check value of node from begining with value of node from reversed second half
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
}
