package y2021.mon04.day22.boj_IPv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.WildcardType;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_IPv6_이상현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String ipv6 = br.readLine();
		String[] ip = ipv6.split(":");

		int startWhiteSpace = -1; // 처음 공백이 나오는 index
		int notSpaceCnt = 0; // 공백이 아닌 숫자가 있는 ip 개수
		
		for(int i = 0; i < ip.length; i++) {
			if(!ip[i].equals("")) notSpaceCnt++;
			else if(startWhiteSpace == -1) startWhiteSpace = i; 
		}
				
		// 처음 ''(공백)이 나온 곳에서부터 최대 공백의 개수만큼 0000 넣어주기 
		for(int i = 0; i < ip.length; i++) {
			if(i == startWhiteSpace) {
				for(int j = 0; j < 8-notSpaceCnt; j++)
					sb.append("0000:");
			}else if(ip[i].equals("")) { // 첫 공백 시작 이후에 나오는 공백은 무시 
				continue;
			}else{
				for(int j = 0; j < 4-ip[i].length(); j++) { // 숫자가 나오면 빈 자리를 0으로 채움
					sb.append("0");
				}
				sb.append(ip[i] + ":");
			}
		}
		
		// 1:: -> 뒤에 공백이 들어가는 경우네는 split가 없애버림 (따로처리)
		if(ipv6.endsWith("::")) {
			for(int j = 0; j < 8-notSpaceCnt; j++)
				sb.append("0000:");
		}
		
		sb.setLength(sb.length()-1); // 맨 끝에 들어간 ':' 제거
		System.out.print(sb);
	}
}
