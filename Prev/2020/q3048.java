import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Info{
	public char ant;
	public int group;

	public Info(char ant, int group){
		this.ant = ant;
		this.group = group;
	}
}

public class q3048 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Info> arr = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder str1 = new StringBuilder(br.readLine());
		StringBuilder str2 = new StringBuilder(br.readLine());
		int sec = Integer.parseInt(br.readLine());
	
		str1 = str1.reverse();
		
		for(int i = 0; i < n; i++) 
			arr.add(new Info(str1.charAt(i), 1)); // A그룹 = 1
		
		for(int i = 0; i < m; i++) 
			arr.add(new Info(str2.charAt(i), 0)); // B그룹 = 0
	
		for(int i = 0; i < sec; i++) {
			for(int j = 0; j < n+m-1; j++) {
				if(arr.get(j).group == 1 && arr.get(j+1).group == 0) {
					Info tmp = arr.get(j);
					arr.set(j, arr.get(j+1));
					arr.set(j+1, tmp);
					j++;
				}
			}
		}
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).ant);
		}
	}
}
