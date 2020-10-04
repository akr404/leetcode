//Minimum window substring
//https://www.youtube.com/watch?v=0GOyCIJ2ajQ&ab_channel=AmellPeralta
public String minWindow(String s, String t) {
  int [] map = new int[128];
  //count char in t
  for (char c : t.toCharArray()) {
    map[c]++;
  }
  int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
  while (end < s.length()) {
    final char c1 = s.charAt(end);
    //if found a character, decreament the count
    if (map[c1] > 0) counter--;
    map[c1]--;
    end++;
    //if found all characters, start reducing widnow size from start
    while (counter == 0) {
      //get new min length
      if (minLen > end - start) {
        minLen = end - start;
        minStart = start;
      }
      //increament start to reduce window 
      final char c2 = s.charAt(start);
      map[c2]++;
      //if remove character in char array, increase count
      if (map[c2] > 0) counter++;
      start++;
    }
  }

  return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}

//Longest Substring - at most K distinct characters

public int lengthOfLongestSubstringKDistinct(String s, int k) {
  if(s == null || s.isEmpty()) return 0;
  int[] map = new int[256];
  int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

  while (end < s.length()) {
    final char c1 = s.charAt(end);
    if (map[c1] == 0) counter++;
    map[c1]++;
    end++;

    while (counter > k) {
      final char c2 = s.charAt(start);
      if (map[c2] == 1) counter--;
      map[c2]--;
      start++;
    }

    maxLen = Math.max(maxLen, end - start);
  }

  return maxLen;
}

//Longest Substring - at most 2 distinct characters

public int lengthOfLongestSubstringTwoDistinct(String s) {
  int[] map = new int[128];
  int start = 0, end = 0, maxLen = 0, counter = 0;

  while (end < s.length()) {
    final char c1 = s.charAt(end);
    if (map[c1] == 0) counter++;
    map[c1]++;
    end++;

    while (counter > 2) {
      final char c2 = s.charAt(start);
      if (map[c2] == 1) counter--;
      map[c2]--;
      start++;
    }

    maxLen = Math.max(maxLen, end - start);
  }

  return maxLen;
}

//LongestSubstring - without repeating characters

public int lengthOfLongestSubstring2(String s) {
  int[] map = new int[128];
  int start = 0, end = 0, maxLen = 0, counter = 0;

  while (end < s.length()) {
    final char c1 = s.charAt(end);
    if (map[c1] > 0) counter++;
    map[c1]++;
    end++;

    while (counter > 0) {
      final char c2 = s.charAt(start);
      if (map[c2] > 1) counter--;
      map[c2]--;
      start++;
    }

    maxLen = Math.max(maxLen, end - start);
  }

  return maxLen;
}