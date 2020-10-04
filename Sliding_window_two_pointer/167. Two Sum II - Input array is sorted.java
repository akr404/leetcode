
// on traversal
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        
        
        while(low < high)
        {
            if(numbers[low] + numbers[high] > target) high--;
            else if(numbers[low] + numbers[high] < target) low++;
            else return new int[]{low+1, high+1};
        }
        return new int[]{-1, -1};
        
    }
}


//Binary search
class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int left = 0, right = numbers.length-1; 
       while (left < right){
           int mid = left + (right-left)/2; 
           int sum = numbers[left] + numbers[right]; 
           if (sum == target){
               return new int[]{left+1, right+1};
           }
           else if (sum < target){
               left = (numbers[mid] + numbers[right] < target)?mid:left+1;
           }else{
               right = (numbers[mid] + numbers[left] > target)?mid:right-1;
           }

       }
       return new int[]{-1,-1};
        
    }
}