package topic31;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */

//吸取教训，注意递归函数的中局部变量会重置，调用自己属性会改变
public class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {

        if (root==null)
        {
            return null;
        }
        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
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

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
