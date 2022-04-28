import java.io.*;
import java.util.*;


public class FordFulkerson {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static final int MAX_SIZE = 52;
	static int N, maxFlow, S, T = 25, capacity[][], flow[][];
	static boolean check[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		capacity = new int[MAX_SIZE][MAX_SIZE];
		flow = new int[MAX_SIZE][MAX_SIZE];
		check = new boolean[MAX_SIZE];
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = charToInt(st.nextToken().charAt(0));
			int end = charToInt(st.nextToken().charAt(0));
			int weight = Integer.parseInt(st.nextToken());
			// 여기서는 그냥 연결이기 때문에 무향 그래프라서 양방향으로 웨이트를 둘 다 더해줌
			capacity[start][end] += weight; 
			capacity[end][start] += weight;
		}
		
		// 더 이상 증가경로가 없을 때 까지 반복
		while(true) {
			// 방문 체크 초기화
			Arrays.fill(check, false);
			// DFS로 최대 유량 찾기
			int flowAmount = dfs(S, Integer.MAX_VALUE);
			if(flowAmount == 0) break;
			maxFlow += flowAmount;
		}
		
		System.out.println(maxFlow);
	}
	
	public static int dfs(int from, int amount) {
		// 증가경로가 완성되면 해당 증가경로의 최소 잔여용량 리턴
		if(from == T) return amount;

		// 방문한 곳이면 리턴
		if(check[from]) return 0;
		check[from] = true;
		
		for(int to = 0; to < MAX_SIZE; to++) {
			// 유량이 흐를 수 있으면
			if(capacity[from][to] > flow[from][to]) {
				// 현재 도달한 경로까지의 최소 잔여용량 저장
				int flowAmount = dfs(to, Math.min(amount, capacity[from][to]-flow[from][to]));
				if(flowAmount > 0) {
					// 잔여용량 갱신하고 리턴
					flow[from][to] += flowAmount;
					flow[to][from] -= flowAmount;
					return flowAmount;
				}
			}
		}
		
		return 0;
	}
	
	// 문자를 인덱스로 매핑하기 위해 변환
	public static int charToInt(char c) {
		if('a' <= c && c <= 'z') c -= 6;
		return c - 65;
	}
}