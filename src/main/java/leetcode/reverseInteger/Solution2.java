package leetcode.reverseInteger;

public class Solution2 {
    public int reverse (int value) {
        int reversedValue = 0;
        if (value == -2147483648) {return 0;}
        int valueSign = (value > 0) ? 1 : -1;
        String StringValue = Integer.toString(Math.abs(value));
        System.out.println(StringValue);
        String reversedString = new StringBuilder(StringValue).reverse().toString();
        long reversedLongValue = Long.parseLong(reversedString);
        if (reversedLongValue < 2147483648L) {reversedValue = Integer.parseInt(reversedString);}
        return reversedValue * valueSign;
    }
}
