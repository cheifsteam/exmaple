package topic33;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode helper = helper(0, nums.length - 1, nums);
        return helper;

    }

    public TreeNode helper(int left,int right,int[] nums){
        if (left>right)
        {
            return null;
        }
        int mid= (right+left)/2;
        TreeNode treeNode = new TreeNode();
        treeNode.val=nums[mid];
        treeNode.left=helper(left,mid,nums);
        treeNode.right=helper(mid,right,nums);
        return treeNode;
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
