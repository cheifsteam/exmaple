package topic34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class Solution {
    ListNode cur = null;
    public TreeNode sortedListToBST2(ListNode head) {
        int len=0;
        cur=head;
        while (head != null)
        {
            len++;
            head=head.next;
        }
        return sortedListToBST(0,len-1);
    }
    private TreeNode sortedListToBST(int left, int right) {
        if (left> right)
        {
            return  null;
        }
        int mid = left +(right - left +1);
        TreeNode leftNode=sortedListToBST(left,mid-1);  //递归遍历完所有的左子树
        TreeNode root = new TreeNode(cur.val);
        root.left=leftNode;
        cur=cur.next;
        root.right=sortedListToBST(right,mid);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head!=null)
        {
          list.add(head.val);
          head=head.next;
        }
        return   helper(0, list.size()-1,list);
    }

    public TreeNode helper(int left,int right,List<Integer> list)
    {
        if (left>right)
        {
            return  null;
        }
        int mid = (right+left)/2;
        TreeNode root = new TreeNode();
        root.val=list.get(mid);
        root.left=helper(left,mid-1,list);
        root.left=helper(mid+1,right,list);
        return root;
    }

    public TreeNode sortedListToBST1(ListNode head){
        if (head==null)
        {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while(fast!=null&&fast.next!=null)
        {
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode right=slow.next;
        pre.next=null;
        TreeNode root = new TreeNode(slow.val);
        root.left=sortedListToBST1(head);
        root.right=sortedListToBST1(right);
        return root;


    }




}
class TreeNode
{

    int val;

   TreeNode left;

   TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


