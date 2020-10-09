//it takes 26 * l * m time.
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);
        Queue<String> qu = new LinkedList<>();
        int count = 1;
        qu.add(beginWord);
        while(!qu.isEmpty())
        {
            int size = qu.size();
            for(int i = 0; i<size; i++)
            {
                char[] word = qu.poll().toCharArray();
                for(int j = 0; j < word.length; j++)
                {
                    char tmp = word[j];
                    //repace character at position j with all characters, and match
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        word[j] = c;
                        String next = new String(word);
                        if(hs.contains(next))
                        {
                            if(next.equals(endWord)) return count+1;
                            qu.add(next);
                            hs.remove(next);
                        }
                    }
                    word[j] = tmp;
                }
               
            }
             count++;
        }
        return 0;
    }
}