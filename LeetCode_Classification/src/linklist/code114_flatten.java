package linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-04-07-12:01
 * @Description:  二叉树转 单链表（先序遍历 ）
 */
public class code114_flatten {
    List<TreeNode> list = new ArrayList<>();
    
    public void flatten(TreeNode root) {
        TreeNode pre,cur;
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        
        dfs(root);
        for (int i = 1; i < list.size(); i++) {
            pre = list.get(i-1);
            cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }
    
    //先序遍历放入 数组
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
