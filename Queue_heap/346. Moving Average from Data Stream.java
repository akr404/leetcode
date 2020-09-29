class MovingAverage {
    Queue<Integer> qu ;
    int sum = 0;
    int maxSize;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        qu = new LinkedList<>();
        maxSize = size;
    }
    
    public double next(int val) {
        qu.offer(val);
        sum += val;
        while(qu.size() > maxSize){
            sum -= qu.poll();
        }
        return (double)sum/qu.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */