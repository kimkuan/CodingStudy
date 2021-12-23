package mon12.day23.prog_짝지어제거하기;

import java.util.*;

/*
 * 풀이 시간 : 18분
 * 시간복잡도 : O(N)
 * IDE 사용 : X
*/

public class prog_짝지어제거하기 {

	public static void main(String[] args) {
		String s = "baabaa"; // 입력으로 주어지는 문자열
		
		int answer = checkRemoveAll(s);
		System.out.println(answer);
	}
	
	private static int checkRemoveAll(String s){
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            char alpha = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == alpha){
                stack.pop();
            }
            else{
                stack.add(alpha);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}
