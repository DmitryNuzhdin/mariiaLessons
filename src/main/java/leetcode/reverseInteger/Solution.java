package leetcode.reverseInteger;

public class Solution {
    public static int reverse (int value) {
        int valueSign = (value > 0) ? 1 : -1;
        long reversedValue = 0;
        int intReversedValue = 0;
        int absValue = Math.abs(value);
        while (absValue > 0) {
            int remainderOfDivision = absValue % 10;
            reversedValue = reversedValue * 10 + remainderOfDivision;
            absValue /= 10;
        }
        if (reversedValue < 2147483648L) { intReversedValue = (int) reversedValue;}
        return intReversedValue * valueSign;
    }
}
