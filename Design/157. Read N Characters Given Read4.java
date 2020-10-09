/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int totalRead = 0, CurRead = 4;
        char[] buf4 = new char[4];
        while(totalRead < n && CurRead == 4)
        {
            CurRead = read4(buf4);
            for(int i = 0; i < CurRead; i++)
            {
                if(totalRead == n) return totalRead;
                buf[totalRead] = buf4[i];
                totalRead++;
            }
        }
        return totalRead;
    }
}