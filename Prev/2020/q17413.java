import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder tmp = new StringBuilder(); // 임시 저장용
		StringBuilder ans = new StringBuilder(); // answer
		boolean flag = false; // 태그가 시작되었는지 확인용
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
		
			if( c == '<' || c == '>' ) {
				if(flag == false) { // '<'
					ans.append(tmp.reverse()); // 이전에 입력된 일반 문자열 reverse해서 append
					tmp.setLength(0);
					tmp.append(c); // < 추가
					
					flag = true; // 태그 시작
				}
				else { // '>'
					tmp.append(c); // > 추가
					ans.append(tmp); // <문자열>을 ans에 추가
					tmp.setLength(0);
					
					flag = false; // 태그 종료
				}
			}
			else if(c == ' ') { 
				if(flag == false) { // 일반문자열에서의 빈칸이면 
					tmp = tmp.reverse(); // reverse하고
					tmp.append(c); // 빈칸도 더해서
					
					ans.append(tmp); // 거꾸로된 문자열을 ans에 추가
					tmp.setLength(0);
				}
				else // 태그안에 있는 빈 문자열이라면 그냥 append
					tmp.append(c);
			}
			else
				tmp.append(c);
		}
		ans.append(tmp.reverse()); // 만약 tmp에 값이 <>였으면 빈 문자열이 되었을 것이고, 일반 문자열이었으면 reverse
		
		System.out.println(ans);
	}
}
