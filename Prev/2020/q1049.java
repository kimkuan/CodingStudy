import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class q1049 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		ArrayList<Integer> setPrice = new ArrayList<>();
		ArrayList<Integer> onePrice = new ArrayList<>();
		
		int setMin, oneMin; // 최솟값
		int n, m; // 끊어진 기타줄 N, 기타줄 브랜드 M
		int ans = 0;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int set = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
		
			setPrice.add(set);
			setPrice.add(one*6);
			onePrice.add(one);
		}
		setMin = Collections.min(setPrice); // 최솟값 구하기
		oneMin = Collections.min(onePrice);		
		
		int setCount = n / 6;
		int oneCount = n % 6;
				
		if(setMin < oneMin * 6) { // 세트가격이 한 개짜리 6개 사는거 보다 쌀 때
			ans += setMin * setCount;		
			if(setMin < oneMin * oneCount)  // 나머지를 낱개로 사는 거 보다 세트가 더 쌀 때
				ans += setMin;
			else
				ans += oneMin * oneCount;
		}
		else // 낱개로 사는게 더 싸면 다 낱개로 구매
			ans += oneMin * n;
		
		System.out.print(ans);
	}
}

/*
	끊어진 기타줄 N, 기타줄 브랜드 M
	브랜드 마다 세트 가격(6줄), 낱개 가격(1줄)
	6개 이상 구매할 때, 세트 가격과 낱개로 6개 가격 비교 
	
	(현수씨 코드)
	res[0] = 세트 + 낱개 가격
	res[1] = 세트만
	res[2] = 낱개만
	
	sort(res, res+3); 해서 최솟값 구하기
*/