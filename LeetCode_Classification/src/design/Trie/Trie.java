package design.Trie;

/**
 * @Author: yangbo
 * @Date: 2022-06-04-22:38
 * @Description:
 */
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(node.next[c-'a']==null){
                node.next[c-'a']=new TrieNode();
            }
            node = node.next[c-'a'];
        }
        node.isEnd = true;
        
    }
    
    public boolean search(String word){
        TrieNode node = root;
        for (char c:word.toCharArray()
             ) {
            node = node.next[c-'a'];
            if(node == null){
                return false;
            }
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix){
        TrieNode node = root;
        for (char c:prefix.toCharArray()
             ) {
            node = node.next[c-'a'];
            if(node == null){
                return false;
            }
        }
        return true;
    }
}
