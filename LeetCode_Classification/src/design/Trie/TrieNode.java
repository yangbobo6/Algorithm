package design.Trie;

/**
 * @Author: yangbo
 * @Date: 2022-06-04-22:34
 * @Description:
 */
public class TrieNode {
    public boolean isEnd;
    TrieNode[] next;
    
    public TrieNode(){
        isEnd = false;
        next = new TrieNode[26];
    }
}
