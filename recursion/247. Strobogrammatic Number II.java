//DFS
ublic List<String> findStrobogrammatic(int n) {
    this.n = n;//use n to avoid append 0 in the first recursion
    List<String> result = new ArrayList<String>();
    DFS(result, "", "", n);
    return result;
}

int n;
public void DFS(List<String> list, String left, String right, int k){
    //we try to fill the list from two-side and converage at mid
    if(k == 0){
        //we have even length, so the remaining length is 0
        list.add(left + right);
        return;
    }
    
    if(k == 1){
        //we have odd length, so we need add a single mid, which could only be 0, 1, 8 
        list.add(left + 0 + right);
        list.add(left + 1 + right);
        list.add(left + 8 + right);
    
        return;
    }
    
    //otherwise we will append char pair in left and right part
    
    //0 is boundary case, we couldn't add 0 two the right and left bound, which would make num be 0...0
    //and we don't have a valid num has len > 1, and starts with 0
    if(k != n) DFS(list, left + 0, 0 + right, k-2);
    
    //for other pairs, we can add it freely
    
    DFS(list, left + 1, 1 + right, k - 2);
    DFS(list, left + 6, 9 + right, k - 2);
    DFS(list, left + 9, 6 + right, k - 2);
    DFS(list, left + 8, 8 + right, k - 2);
}

//simple recursion
class Solution {
    public List<String> findStrobogrammatic(int n) {
         return helper(n,n);    
    }
    private List<String> helper(int curLen, int n){
        if(curLen == 0) return new ArrayList(Arrays.asList(""));
        if(curLen == 1) return new ArrayList(Arrays.asList("1","8","0"));
        List<String> sub = helper(curLen-2, n);
        System.out.println(sub.toString());
        List<String> cur = new ArrayList();
        for(String s: sub){
            if(curLen != n){
                cur.add("0" + s + "0");
            }
            cur.add("6" + s + "9");
            cur.add("9" + s + "6");
            cur.add("8" + s + "8");
            cur.add("1" + s + "1");	
        }
        return cur;
    }
}