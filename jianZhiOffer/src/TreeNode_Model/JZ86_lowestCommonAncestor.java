package TreeNode_Model;

import java.util.*;

/**
 * @Author: yangbo
 * @Date: 2022-02-23-20:47
 * @Description:
 */
public class JZ86_lowestCommonAncestor {
    int MIN_VALUE = -1;
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        Map<Integer,Integer> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root.val,MIN_VALUE);
        queue.add(root);
        while(!parent.containsKey(o1)||!parent.containsKey(o2)){
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
        while(parent.containsKey(o1)){
            ancestors.add(o1);
            o1 = parent.get(o1);
        }
        //查看o1和他的祖先是否包含o2
        while(!ancestors.contains(o2)){
            o2 = parent.get(o2);
        }
        return o2;
    }
}
