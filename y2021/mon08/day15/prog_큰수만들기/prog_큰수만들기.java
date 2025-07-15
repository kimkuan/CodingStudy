package y2021.mon08.day15.prog_큰수만들기;

import java.util.Stack;

public class prog_큰수만들기 {

	static String number = "8";
	static int k = 1;
	
	public static void main(String[] args) {
		
		Stack<Character> before = new Stack<>();
		Stack<Character> after = new Stack<>();
		StringBuilder sb = new StringBuilder(); // ���� �� �ִ� ���� ū ����

		for(int i = number.length()-1; i >= 0; i--) { // �� �� ���ڰ� ���� �� ���� �ö��
			before.push(number.charAt(i));
		}
		
		while(!before.isEmpty() && k > 0) {
			char pop = before.pop(); // �� ���� �ִ� ���� �ϳ� ����

			// after�� �ִ� ���� �߿��� �ڽź��� �������̸� out 
			while(!after.isEmpty() && k > 0) {
				if(after.peek() < pop) { // ���� ���� ���� �� ũ�� after�� �ִ� ���� ��
					after.pop();
					k--;
				}
				else
					break;
			}
			after.push(pop);
		}
		
		// before�� �����ִ� ���� ��� push
		while(!before.isEmpty()) {
			after.push(before.pop());
		}
		
		while(!after.isEmpty() && k > 0) {
			after.pop();
            k--;
		}
		
		while(!after.isEmpty()) {
			sb.append(after.pop());
		}
		System.out.println(sb.reverse().toString());
		
	}
}
