package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-03-10-20:01
 * @Description:
 */
public class code236_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //先将每个孩子的父节点 存到map里面
        Map<TreeNode,TreeNode> hashMap = new HashMap();
        inorderTrav(root,hashMap);

        HashSet<Integer> set = new HashSet<>();
        while (p!=null){
            set.add(p.val);
            p = hashMap.get(p);
        }
        while (q!=null){
            if(set.contains(q.val)){
                return q;
            }
            q = hashMap.get(q);
        }
        return null;

    }

    public void inorderTrav(TreeNode root,Map<TreeNode,TreeNode> hashMap){
        if(root==null){
            return;
        }
        if(root.left!=null){
            hashMap.put(root.left,root);
        }
        inorderTrav(root.left,hashMap);
        if(root.right!=null){
            hashMap.put(root.right,root);
        }
        inorderTrav(root.right,hashMap);
    }
}
