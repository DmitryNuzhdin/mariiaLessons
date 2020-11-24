package leetcode.powerOfTwo;

public class Solution {
    public boolean isPowerOfTwo(int value) {
        return (Integer.bitCount(value) == 1); // you implementation here
    }
}
