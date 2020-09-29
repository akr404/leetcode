/*question:


Input:

Given an array A of
-positive
-sorted
-no duplicate
-integer

A positive integer k


Output:

Count of all such subsets of A,
Such that for any such subset S,
Min(S) + Max(S) = k
subset should contain atleast two elements

1. Backtracking approach to get subsets
2. Get min and max of subset
3. Add min and max and put them in Hashmap (or update the count)
4. repeat this process for all subsets
5. search for k in hashmap and return count of k

input: {1,2,3,4,5}

subsets: 
1, 2, 3, 4, 5, {1,2},{1,3}
k = 5

count = 5

{1, 4},{2,3} {1,2,4}, {1,2,3,4} {1,3,4}

*/


public int subsetOfArray(int[] array, int target) {

    int count = 0;
    int start = 0;
    int end = array.length - 1;

    while (start < end) {

        int sum = array[start] + array[end];

        if (sum == target) {

            // 1. count the element in between first and last (first + last = sum)
            // 2.  Generate the combination of that then
            count += Math.pow(2,(end - start) - 1);
            start++;
            end--;

            continue;
        }
        if (sum > target) {
            end--;
        } else {
            start++;
        }
    }
    return count;
}