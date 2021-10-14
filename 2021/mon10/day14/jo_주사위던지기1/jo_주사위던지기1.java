package com.mon10.day14.jo_주사위던지기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jo_주사위던지기1 {

	static int N; // 주사위를 던진 횟수
	static int M; // 출력 모양 (1: 모든 경우, 2: 중복 제외 : 3: 모두 다른 수가 나올 경우)
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[7];
		
		// go1(0);
		//go2(0, 1);
		go3(0);
	}
	
	private static void go1(int depth) {
		if(depth == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = 1; i <= 6; i++) {
			arr[depth] = i;
			go1(depth+1);
			arr[depth] = 0;
		}
	}
	
	private static void go2(int depth, int start) {
		if(depth == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = start; i <= 6; i++) {
			arr[depth] = i;
			go2(depth+1, i);
			arr[depth] = 0;
		}
	}
	
	private static void go3(int depth) {
		if(depth == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = 1; i <= 6; i++) {
			if(visited[i]) continue;
			arr[depth] = i;
			visited[i] = true;
			go3(depth+1);
			visited[i] = false;
			arr[depth] = 0;
		}
	}
}
