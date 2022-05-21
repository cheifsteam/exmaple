package topic34;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class SubSolution {

    //使用快慢指针
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
        {
            return null;
        }
        if (head.next == null)
        {
            return new TreeNode(head.val);
        }
        ListNode slow = head;   //定义慢指针
        ListNode fast = head;   //定义快指针每次移动2步
        ListNode pre  = head;   //定义记录中点前一个指针
        //遍历链表，遍历完毕，慢指针正好在链表的中点
        while(fast!=null && fast.next!=null)
        {
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;

        }
        pre=slow;
        ListNode right= slow.next;  //中点的右边
        //利用链表中点去构建树
        TreeNode root=new TreeNode(slow.val);
        pre.next=null;  //切断链表左右的连接
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(right);
        return root;
    }
    //中序遍历策略带来的优化
    //使用中序遍历特性
    //BST 的中序遍历，打印的节点值正是这个有序链表的节点值顺序。
    //所以我们利用中序遍历特性来构建BST树
    //观察到链表的中点的正好是BST的树根节点,但是链表的中很难查找
    //所以我们把链表一直二分，二分到最后，就是左子树的左子节点为链表第一个元素
    //将链表不断二分，其中中点作为根节点

    ListNode cur;
    public TreeNode Sub_sortedListToBST(ListNode head){
        cur=head;
        int end=0;
        while (head!=null)
        {
            head=head.next;
            end++;
        }
        TreeNode binary = binary(0, end - 1);
        return binary;


    }
    public TreeNode binary(int left,int right)
    {
        if (left>right)
        {
            return null;
        }
        int mid = left +(right-left+1);
        TreeNode leftNode = binary(left, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur=cur.next;
        root.left= leftNode;
        root.right= binary(mid+1,right);
        return root;
    }
}
