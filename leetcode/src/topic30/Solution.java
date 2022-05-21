package topic30;


import java.util.*;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class Solution
{
    public int kthSmallest(TreeNode root, int k)
    {
        List<Integer> list = new ArrayList<>();
        innerOrder(root,list);
        Collections.sort(list);
       return list.get(k);


    }
    public void innerOrder(TreeNode root,List list)
    {

        if (root!=null)
        {
            innerOrder(root.left,list);
            list.add(root.val);
            innerOrder(root.right, list);
        }
    }
    //优化上面代码，让list不需要遍历子树的所有节点，只需要遍历前k个节点就行
    private int cnt = 0;
    private int val;

    public int kthSmallest1(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }
    //但是还是需要遍历前k节点，原因是不知道子树数量,知道每个根节点子树的数量
    /*
        设根节点为node
        如果node的左子树的left小于k-1,则最小的节点在该节点的右子树下方，查找右子树下方重复步骤
        如果node的左子树的left等于k-1，返回node
        如果node的左子树的left大于k-1 则最小节点在该节点的左子树下方，查找左子树下方重复步骤
        解题步骤：
        1，查找分支节点的下的节点数，存储起来
        2，比较left的大小与k-1大小
     */
    public int kthSmallest2(TreeNode root,int k)
    {
        MyBst myBst=new MyBst(root);
        return myBst.kthSmallest(k);
    }
    class MyBst
    {
        TreeNode root;
        Map<TreeNode,Integer> nodeNum=new HashMap<>();
        public MyBst(TreeNode root)
        {
            this.root=root;
            CountNodeNum(root);
        }

        public int kthSmallest(int k)
        {
            TreeNode node=root;
            while (node!=null)
            {
                int nodeNum = getNodeNum(node.left);
                if (nodeNum<k-1)
                {
                    node=node.right;
                    k=k-(nodeNum+1);    //左子树left+1个
                }
                else if (nodeNum==k-1)
                {
                    break;
                }
                else
                {
                    node=node.left;

                }
            }
            return node.val;
        }

        public int CountNodeNum(TreeNode node)
        {
            if (node==null)
            {
                return 0;
            }
            nodeNum.put(node,1+CountNodeNum(node.left)+CountNodeNum(node.right));
            return nodeNum.get(node);
        }

        // 获取以node为根结点的子树的结点数
        private int getNodeNum(TreeNode node)
        {
            return nodeNum.getOrDefault(node, 0);
        }

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

