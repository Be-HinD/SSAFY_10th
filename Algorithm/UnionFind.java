import java.util.Arrays;

public class DisjointSetTest {

	static int N; //초기 집합의 개수
	static int parents[]; //root를 저장하는 배열

	public static void main(String[] args) {
		N = 5;
		MakeSet();
		Union(0,1);
		Union(2,1);
		Union(3,2);
		Union(4,3);
		System.out.println(Arrays.toString(parents));
		System.out.println("Find(0) : " + FindSet(0));
		System.out.println("Find(1) : " + FindSet(1));
		System.out.println("Find(2) : " + FindSet(2));
		System.out.println("Find(3) : " + FindSet(3));
		System.out.println("Find(4) : " + FindSet(4));
	}
	
	private static void MakeSet() {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i; //모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다.(자신이 곧 대표자인 루트로 표현)
		}
	}
	
	private static int FindSet(int x) {
		if(x == parents[x]) return x; //기저조건
		return parents[x] = FindSet(parents[x]); //root를 계속 변경
	}
	
	private static boolean Union(int x, int y) { //x가 속한 집합과 y가 속한집합을 합칠 수 있다면 합치고 true 반환, 아니면 false 반환
		int xRoot = FindSet(x);
		int yRoot = FindSet(y);
		
		if(xRoot == yRoot) return false; //서로의 대표자가 같은 즉, 같은 집합의 상황이므로 union하지 않음
		//두 집합의 대표자가 다를 경우 Union 처리(yRoot를 xRoot 아래로 붙이기)
		parents[yRoot] = xRoot;
		return true;
	}
}
