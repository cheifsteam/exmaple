package topic32;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 二叉搜索树的最近公共祖先
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

           if (p.val < root.val && q.val < root.val) {
              return lowestCommonAncestor(root.left,p,q);
           }
           if (q.val> root.val&& p.val == root.val) {
             return  lowestCommonAncestor(root.right,p,q);
           }
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
