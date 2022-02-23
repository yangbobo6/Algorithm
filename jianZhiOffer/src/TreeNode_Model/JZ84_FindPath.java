package TreeNode_Model;

/**
 * @Author: yangbo
 * @Date: 2022-02-23-10:31
 * @Description:
 */
public class JZ84_FindPath {

    private static int path = 0;

    public int FindPath (TreeNode root, int sum) {
        // write code here
        if(root==null) return path;
        //这是检查从根节点开始的路径
        dfs(root,sum);
        //从跟的下面，不包括根节点
        FindPath(root.left,sum);
        FindPath(root.right,sum);
        return path;
    }

    public void dfs(TreeNode root,int sum){
        if(root==null){
            return;
        }
        sum -= root.val;
        if(sum==0){
            path++;
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}
