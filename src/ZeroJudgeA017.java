
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA017 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String[] str = scanner.nextLine().split(" ");
			String strPostfix = infixToPostfix(str);
			int answer = evaluatePostfix(strPostfix.split(" "));
			System.out.println(answer);
		}
	}

	// A utility function to return precedence of a given operator
	// Higher returned value means higher precedence
	static int Prec(char ch) {
		switch (ch) {
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
			case '%':
				return 2;
		}
		return -1;
	}

	// The main method that converts given infix expression
	// to postfix expression. 
	static String infixToPostfix(String[] exp) {
		// initializing empty String for result
		String result = "";

		// initializing empty stack
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length; ++i) {
			String s = exp[i];
			
			if (s.matches("\\d+")) {
				// If the scanned character is an operand, add it to output.
				result += s + " ";
			} else if (s.toCharArray()[0] == '(') {
				// If the scanned character is an '(', push it to the stack.
				stack.push(s.toCharArray()[0]);
			} else if (s.toCharArray()[0] == ')') {
				//  If the scanned character is an ')', pop and output from the stack 
				// until an '(' is encountered.
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop() + " ";
				}
				if (!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression"; // invalid expression                
				} else {
					stack.pop();
				}
			} else {
				// an operator is encountered
				while (!stack.isEmpty() && Prec(s.toCharArray()[0]) <= Prec(stack.peek())) {
					result += stack.pop() + " ";
				}
				stack.push(s.toCharArray()[0]);
			}
		}

		// pop all the operators from the stack
		while (!stack.isEmpty()) {
			result += stack.pop() + " ";
		}
		return result;
	}

	// Method to evaluate value of a postfix expression
	static int evaluatePostfix(String[] exp) {
		//create a stack
		Stack<Integer> stack = new Stack<>();
		
		// Scan all characters one by one
		for (int i = 0; i < exp.length; i++) {
			String s = exp[i];
			
			if (s.matches("\\d+")) {
				// If the scanned character is an operand (number here),
				// push it to the stack.
				stack.push(Integer.parseInt(s));
			} else {
				//  If the scanned character is an operator, pop two
				// elements from stack apply the operator
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (s) {
					case "+":
						stack.push(val2 + val1);
						break;

					case "-":
						stack.push(val2 - val1);
						break;

					case "/":
						stack.push(val2 / val1);
						break;

					case "*":
						stack.push(val2 * val1);
						break;
						
					case "%":
						stack.push(val2 % val1);
						break;
				}
			}
		}
		return stack.pop();
	}
}

/*
    計算五則運算式的結果，包含加、減、乘、除、餘
--------------------------------------------------------------------------------
輸入說明
    輸入一個字串，其中包含運算元及運算子，為了方便讀取，所有的運算子及運算元均以空格區隔。
    運算元為 0 ~2^31 - 1 的整數
    運算子則包含 + - * / % 及 ( )
    運算時請注意先乘除後加減及() 優先運算的計算規則
範例輸入
    2 + 3 * 4
    2 * ( 3 + 4 ) * 5
--------------------------------------------------------------------------------
輸出說明
    輸出結果。為了避免小數點誤差，所有的運算過程都不會產生小數點，可以放心使用整數進行運算
範例輸出
    14
    70
*/