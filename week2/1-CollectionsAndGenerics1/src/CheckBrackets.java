import java.util.ArrayDeque;

public class CheckBrackets {

    public boolean checkBrackets(String input) {
        if (input.charAt(0) == ')' || input.charAt(input.length() - 1) == '(')
            return false;

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (char curChar : input.toCharArray()) {
            if (curChar == '(')
                stack.push(curChar);
            else {
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
