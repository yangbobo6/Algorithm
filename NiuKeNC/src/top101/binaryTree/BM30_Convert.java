package top101.binaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-07-17-13:17
 * @Description:
 */
public class BM30_Convert {
    //将树中按照中序遍历放在 list中
    List<TreeNode> list = new ArrayList<>();
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        orderDfs(pRootOfTree);
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }
    
    //放到数组里面  ， 然后在调整 做右指针
    public void orderDfs(TreeNode root){
        if(root==null){
            return;
        }
        orderDfs(root.left);
        list.add(root);
        orderDfs(root.right);
    }
    
    //方法二
    TreeNode preNode = null;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        TreeNode p = pRootOfTree;
        while (p.left!=null){
            p = p.left;
        }
        inorderDfs(pRootOfTree);
        return p;
    }
    
    public void inorderDfs(TreeNode root){
        if(root==null){
            return;
        }
        inorderDfs(root.left);
        
        //当前左指针指向
        root.left = preNode;
        if(preNode!=null){
            //前 右指向
            preNode.right = root;
        }
        //跟随递归移动
        preNode = root;
        
        inorderDfs(root.right);
    }
}
