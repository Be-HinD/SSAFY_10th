import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Edge[] edgeList;
	static int V, E;
	static int[] parents;
	
	static void make() { //초기화 메서드
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) { //root노드 찾아주는 메서드
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) { //b의 root 변경 메서드
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E]; //그래프 배열선언
		
		for(int i=0; i<E; i++) { //간선 및 가중치 입력
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		//간선리스트를 가중치 기준으로 오름차순 정렬
		Arrays.sort(edgeList);
		
		//V개의 정점으로 make set 작업
		make();
		
		int result = 0; //MST 비용
		int cnt = 0; //연결된 간선 개수
		for(Edge edge : edgeList) { //비용이 작은 간선순으로 꺼내어서 처리
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == V-1) break; //정점개수 V-1만큼의 간선이 연결되었다면 종료
			}
		}
		System.out.println(result);
	}
}
