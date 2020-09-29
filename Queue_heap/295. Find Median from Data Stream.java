class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large ;
    /** initialize your data structure here. */
    public MedianFinder() {
            large = new PriorityQueue<>((a, b) -> b - a);
            small = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        if(large.isEmpty() || num <= large.peek())
            large.add(num);
        else
            small.add(num);
        
        if(large.size() > small.size()+1)
            small.add(large.poll());
        else if(small.size()>large.size())
            large.add(small.poll());
            
    }
    
    public double findMedian() {
        if(large.size() == small.size()) return large.peek()/2.0+small.peek()/2.0;
        else return large.peek();
            
    }
}


//Sliding window median
//extra step: removeing element if queue size is greater than window
 class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        MeanQueue queue = new MeanQueue();
        double[] result = new double[nums.length - k + 1];
        int index = 0;
        
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
            if(queue.size() == k){
                result[index++] = queue.getMedian();
                queue.remove(nums[i+1 - k]);
            }
        }

        return result;
    }
    
    class MeanQueue{
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());  //max is a Max-heap stores smaller half of nums
        PriorityQueue<Integer> min = new PriorityQueue<Integer>(); // min is a Min-heap stores larger half of nums
    
        // Adds a number into the data structure
        void offer(int num){
            max.offer(num);             // Add number
            min.offer(max.poll());      // Balancing step
            
            if(max.size() < min.size()){ // maintain size property
                max.offer(min.poll());
            }
        }
        
        double getMedian(){
            return max.size() > min.size() ? max.peek() : ((long)max.peek() + min.peek()) * 0.5;
        }
        //sum of both sizes
        int size(){
            return max.size() + min.size();
        }
        
        boolean remove(int x){
            return max.remove(x) || min.remove(x);
        }
     
    }
}