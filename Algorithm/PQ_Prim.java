import java.io.*;
import java.util.*;

public class MSTPrimPQTest {

    static class Vertex {
        int no;
        int w;

        public Vertex(int no, int w) {
            this.no = no;
            this.w = w;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int V, adjMaxtrix[][];

    public static void main(String[] args) throws IOException {

        V = Integer.parseInt(br.readLine());
        adjMaxtrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++)
                adjMaxtrix[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[] vis = new boolean[V];
        int[] minEdge = new int[V];
        PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> a.w - b.w);

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        minEdge[0] = 0;
        pq.offer(new Vertex(0, minEdge[0]));

        int result = 0, min = 0, minIdx = 0, cnt = 0;
        while(!pq.isEmpty()) {
            // step1 : 미방문 트리중 최소 간선 비용 정점 선택
            Vertex cur = pq.poll();
            minIdx = cur.no;
            min = cur.w;
            if(vis[minIdx])
                continue;
            
            // step2 : 방문 정점에 추가
            vis[minIdx] = true;
            result += min;
            if(++cnt == V) break;
            
            // step3 : 트리에 추가된 새로운 정점을 기준으로 비트리 정점과 간선비용고려(a.k.a 영업타임)
            for (int i = 0; i < V; i++)
                if (!vis[i] && adjMaxtrix[minIdx][i] > 0 && minEdge[i] > adjMaxtrix[minIdx][i]) {
                    minEdge[i] = adjMaxtrix[minIdx][i];
                    pq.offer(new Vertex(i, minEdge[i]));
                }
        }

        if(cnt != V)
            System.out.println("MST 구성 실패");
        else
            System.out.println(result);
    }

}
