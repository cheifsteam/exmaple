package topic28;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 669.裁剪二叉查找树
 */
public class Solution{
    public TreeNode trimBST(TreeNode root, int low, int high){
        if (root == null)
        {
            return null;
        }
        if (root.val<low)
        {
           root.left=trimBST(root.left,low,high);
        }
        if (root.val>high)
        {
            root.right=trimBST(root.right,low,high);
        }
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }
}
class TreeNode{

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
