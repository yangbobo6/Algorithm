package com.jianzhiOffer;

//检查 一个树是不是 其他树的子树
public class JZ17_ContainSubTree {
    //方法
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        //若两个节点有一个为空，则不是
        if(root1!=null&&root2!=null){
            //两个节点不为空，并且值相等（有可能是），进入下个方法，判断整体是不是
            if(root1.val == root2.val){
                result = doTree1HasTree2(root1,root2);
            }
            //两个值不相等，result还是最开始定义的值，为false，直接结束

            //下个左节点 与此比较
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    public boolean doTree1HasTree2(TreeNode node1, TreeNode node2) {
        // 递归结束，node2为空，说明是
        if(node2 == null){
            return true;
        }
        //node2没有结束，node1提前结束，说明不匹配，该节点开始的不存在，找下个结点开始值
        if(node1==null){
            return false;
        }
        //节点都存在  值不相等  说明不匹配，该节点开始的不存在，找下个结点开始值
        if(node1.val != node2.val){
            return false;
        }
        //该节点都存在，并且值相等     递归比较
        return doTree1HasTree2(node1.left,node2.left)&&doTree1HasTree2(node1.right,node2.right);
    }
}
