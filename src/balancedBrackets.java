/*
Function Description:	Write	a	function	named isBalanced.
isBalanced has	the	following	parameter(s):
• String s:	a	String	of	brackets
Returns
• String: either YES or NO
Input Format
A single	String s will	contain	only	a	sequence	of	brackets. Can	be	empty.
Constraints
• 1 ≤ |�| ≤ 10!,	where |�| is	the	length	of	the	sequence
• All	characters	in	the	sequences	∈	{ ‘{‘, ‘}’, ‘(‘, ‘)’, ‘[‘, ‘]’ }
• You	are	allowed	to	use	the	LinkedList	class	but	only	the	add(),	remove(),	and	peek()	methods
Output Format
For	each	String,	return YES or NO
 */


import java.util.LinkedList;
import java.util.Stack;

public class balancedBrackets {

    public static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    char tempChar = stack.pop();
                    if (current == ')' && tempChar != '(') {
                        return "NO";
                    }

                    if (current == ']' && tempChar != '[') {
                        return "NO";
                    }

                    if (current == '}' && tempChar != '{') {
                        return "NO";
                    }
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {

        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
}}
