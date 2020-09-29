class TrieNode{
    Map<Character, TrieNode> children= new HashMap<>();
    boolean isWord = false;
    public TrieNode() {}
}

class WordDictionary {
    TrieNode trie;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode();    
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = trie;
        for(char ch: word.toCharArray())
        {
            //put key as charcater and value as new TrieNode
            if(!node.children.containsKey(ch))
                node.children.put(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchNode(word, trie);
    }
    public boolean searchNode(String word, TrieNode node) {
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch))
            {
                //if '.', skio matching this character 
                if(ch == '.')
                {
                    //get all children nodes
                    for(char c : node.children.keySet())
                    {
                        //search in those nodes
                        TrieNode child = node.children.get(c);
                        if(searchNode(word.substring(i+1), child))
                            return true;
                    }
                }
                return false;
            }
            else
            {
                //if node contains ch as key, go to next children node
                node = node.children.get(ch);
            }
        }
        return node.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */