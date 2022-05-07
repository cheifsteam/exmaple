package topic26;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * 94. 二叉树的中序遍历
 * @project 中序遍历
 */
public class Solution {
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack =new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode pNode=root;

        while (pNode!=null|| !stack.isEmpty()){
           if (pNode!=null){
               stack.push(pNode);
               pNode=pNode.left;
           }
           else {
               pNode=(TreeNode) stack.pop();
               list.add(pNode.val);
               pNode=pNode.right;
           }

        }
        return list;


    }
    //递归法 前序排序
    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root,list);
        return list;

    }

    public void preorderTraversal(TreeNode root,List list){

        if(root ==null){
           return;
        }
        list.add(root.val);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
    }*/
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> treeNodes=new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (root!=null||!treeNodes.isEmpty()) {
            if (root!=null){
                list.add(root.val);
                treeNodes.push(root);
                root=root.left;

            }else {
                root=treeNodes.pop();
                root=root.right;

            }
        }

        return list;
    }
    //后序遍历递归
  /*  public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal1(root,list);
        return list;

    }
    public void preorderTraversal1(TreeNode root,List list){

        if(root ==null){
            return;
        }
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
        list.add(root.val);
    }
    */
    //后序排序的迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        Deque<TreeNode> treeNodes=new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode prev=null;
        while (root!=null||!treeNodes.isEmpty()) {
            if (root!=null){

                treeNodes.push(root);
                root=root.left;

            }
            root=treeNodes.pop();
            //节点不可以再分时
            if (root.right==null||root.right==prev){
                list.add(root.val);
                prev=root;
                root=null;

            }
            else {

                root=root.right;
                list.add(root.val);

            }
        }

        return list;
    }


}
class TreeNode {
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

