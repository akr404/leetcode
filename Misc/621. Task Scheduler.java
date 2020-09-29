class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        
        //calculate frequency all all the tasks
        for(char t: tasks)
            freq[t-'A']++;
        
        //calculate task with maximum freq
        int maxFreq = 0;
        for(int f: freq)
            maxFreq = Math.max(f, maxFreq);
        
        //calulate number of tasks with maximum freq
        int n_maxFreq = 0;
        for(int f: freq)
            if(f == maxFreq) n_maxFreq++;
        
        //maxfreq*coolingperiod + n 
        //A B C A B C A_ _ A (fill BC in cooling period)
        return Math.max(tasks.length, (maxFreq-1)*(n+1)+n_maxFreq);
    }
}