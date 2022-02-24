package TreeNode_Model;

import java.util.*;

/**
 * @Author: yangbo
 * @Date: 2022-02-23-21:32
 * @Description:
 */
public class JZ68_lowestCommonAncestor {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {

        // 随便给2个数，利用二叉搜索树的性质：

        // 如果两个值都小于根节点，说明祖先在左子树一侧
        if(p<root.val && q<root.val)
            return lowestCommonAncestor(root.left,p,q);
        // 如果两个值都大于根节点，说明祖先在右子树一侧
        if(p>root.val && q>root.val)
            return lowestCommonAncestor(root.right,p,q);
        // 剩最后一种情况：如果根节点的值恰好在两个给定值之间，这个根节点就是最近的公共祖先
        return root.val;
    }
}
