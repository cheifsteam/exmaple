package topic29;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 平衡AVLTree
 */
public class AVLTree<T extends Comparable<T>> {

    private AVLTreeNode<T> mRoot;   //根节点

    class AVLTreeNode<T extends Comparable<T>>{
     T key;

     int height;

     AVLTreeNode<T> left;

     AVLTreeNode<T> right;

     public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
         this.key = key;
         this.height = 0;
         this.left = left;
         this.right = right;
     }
    }
     /*
      * 获取树的高度
      */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null)
            return tree.height;

        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    /*
     * 比较两个值的大小
     */
    private int max(int a, int b) {
        return a>b ? a : b;
    }

    /*
     * LL旋转是围绕"失去平衡的AVL根节点"进行的，也就是节点k2；
     * 而且由于是LL情况，即左左情况，就用手抓着"左孩子，即k1"使劲摇。
     * 将k1变成根节点，k2变成k1的右子树，"k1的右子树"变成"k2的左子树"
     *
     * 返回值: 旋转后的根节点
     */
    public AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2)
    {
        AVLTreeNode<T> k1;
        k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=max(height(k2.left),height(k2.right))+1;
        k1.height=max(height(k1.left),k2.height)+1;
        return k1;

    }

    /*
     *  RR旋转是
     *  返回值: 旋转后的根节点
     */

    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k2)
    {
        AVLTreeNode<T> k1;
        k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;

        k2.height=max(height(k2.right),height(k2.left))+1;
        k1.height=max(height(k1.right),k2.height)+1;
        return k1;
    }

    /*
     *  LR旋转
     */

    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3)
    {
        k3.left=rightRightRotation(k3.left);

        return rightRightRotation(k3);
    }

    /*
     *  RL旋转
     *
     */
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k3)
    {
        k3.right=leftLeftRotation(k3.right);
        return rightRightRotation(k3);
    }


    private AVLTreeNode<T> insert(AVLTreeNode<T> tree,T key)
    {
        if (tree == null)
        {
            tree = new AVLTreeNode<T>(key, null, null);
            System.out.println("ERROR : create avltree node failed");
            return null;
        }else {
            int cmp = key.compareTo(tree.key);
            if (cmp<0)
            {
                tree.left= insert(tree.left, key);
                if (height(tree.left)-height(tree.right)==2)
                {
                    if (key.compareTo(tree.left.key)<0)
                    {
                        tree=rightRightRotation(tree);
                    }
                    else {
                        tree = leftRightRotation(tree);
                    }
                }
            }
            else if (cmp>0)
            {
                tree.right=insert(tree.right,key);
                if (height(tree.right)-height(tree.left)==2)
                {
                    if (key.compareTo(tree.right.key)<0)
                    {
                        tree=leftLeftRotation(tree);
                    }
                    else
                    {
                        tree=rightLeftRotation(tree);
                    }
                }
            }
            else {
                System.out.println("不允许加入相同节点");
            }
        }

        tree.height = max(height(tree.left),height(tree.right))+1;

        return tree;

    }

    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {

        if (tree==null||z==null)
        {
            return  null;
        }
        int cmp=z.key.compareTo(tree.key);
        if (cmp<0)
        {
            tree.left=remove(tree.left,z);
            if (height(tree.right)-height(tree.left) == 2)
            {
                AVLTreeNode<T> r=tree.right;
                if (height(r.left)>height(r.right))
                {
                    tree=rightLeftRotation(tree);

                }
                else {
                    tree=rightRightRotation(tree);
                }
            }
        }
        else if (cmp <0)
        {
            tree.right=remove(tree.right,z);
            if (height(tree.left)-height(tree.right) == 2)
            {
                AVLTreeNode<T> l=tree.left;
                if (height(l.right)>height(l.left))
                {
                    tree=leftRightRotation(tree);
                }
                else
                {
                    tree=leftLeftRotation(tree);
                }
            }
        }
        else {
            if ((tree.left!=null) && (tree.right !=null))
            {
                if (height(tree.left)>height(tree.right))
                {
                    AVLTreeNode<T> max=maximum(tree.left);
                    tree.key= max.key;
                    tree.left=remove(tree.left,max);
                }
                else
                {

                    AVLTreeNode<T> min = minimum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            }else {
                AVLTreeNode<T> tmp=tree;
                tree=(tree.left!=null)?tree.left:tree.right;
                tmp=null;
            }
        }
        tree.height = max(height(tree.left), height(tree.right)) + 1;

        return tree;
    }


    public AVLTreeNode<T> maximum(AVLTreeNode<T> key)
    {
        if (key==null)
        {
            return null;
        }
        while (key.right!=null)
        {
            key=key.right;
        }
        return key;
    }

    public AVLTreeNode<T> minimum(AVLTreeNode<T> key)
    {
        if (key==null)
        {
            return null;
        }
        while (key.right!=null)
        {
            key=key.right;
        }
        return key;
    }


    public AVLTreeNode<T> search(AVLTreeNode<T> mRoot,T key)
    {
        if (mRoot==null)
        {
            return null;
        }
        int cmp = key.compareTo(mRoot.key);
        if (cmp<0)
        {
           return search(mRoot.left,key);
        }
        else if (cmp>0)
        {
           return search(mRoot.right,key);
        }
        else
        {
            return mRoot;
        }

    }

    public void  remove(T key)
    {
        AVLTreeNode<T> z;
        if ((z =search(mRoot,key))!=null)
        {
            remove(mRoot,z);
        }
    }


}
