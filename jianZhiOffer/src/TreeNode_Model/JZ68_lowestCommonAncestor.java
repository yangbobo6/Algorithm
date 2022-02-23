package TreeNode_Model;

import java.util.*;

/**
 * @Author: yangbo
 * @Date: 2022-02-23-21:32
 * @Description:
 */
public class JZ68_lowestCommonAncestor {
    int MIN_VALUE = -1;
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        Map<Integer,Integer> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root.val,MIN_VALUE);
        queue.add(root);
        while(!parent.containsKey(p)||!parent.containsKey(q)){
            TreeNode node = queue.poll();
            if(node.left!=null){
                parent.put(node.left.val,node.val);
                queue.add(node.left);
            }
            if(node.right!=null){
                parent.put(node.right.val,node.val);
                queue.add(node.right);
            }

        }
        Set<Integer> ancestors = new HashSet<>();
        //如果包含o1
        while(parent.containsKey(p)){
            ancestors.add(p);
            p = parent.get(p);
        }
        //查看o1和他的祖先是否包含o2
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}
