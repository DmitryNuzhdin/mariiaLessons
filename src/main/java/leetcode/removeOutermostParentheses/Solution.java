package leetcode.removeOutermostParentheses;

public class Solution {
    public String removeOuterParentheses (String S) {
        char [] S_array = S.toCharArray();
        if ( S_array.length < 4) {return "";}
        StringBuilder SimplifiedS = new StringBuilder();
        int startOfParenthesesString = 0;
        int leftParenthesisCounter = 0;
        int rightParenthesisCounter = 0;
        for (int i = 0; i <= S_array.length - 1; i++ ) {
            if (S_array[i] == '(') {
                leftParenthesisCounter += 1;
            } else if (S_array[i] == ')') {
                rightParenthesisCounter += 1;
            }
            if (leftParenthesisCounter == rightParenthesisCounter) {
                leftParenthesisCounter = 0;
                rightParenthesisCounter = 0;
                if (startOfParenthesesString < i - 2) {
                    for (int j = startOfParenthesesString + 1; j <= i - 1; j++) {
                        SimplifiedS.append(S_array[j]);
                    }
                }
                startOfParenthesesString = i + 1;
            }
        }
        return SimplifiedS.toString();
    }
}
