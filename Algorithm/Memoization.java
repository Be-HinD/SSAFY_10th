//피보나치를 통해 재귀와 메모이제이션을 적용했을 때의 차이를 보여줄 수 있는 코드
import java.util.*;

public class FibonacciTest {
	
	static long totalCnt1, totalCnt2, callCnt1[], callCnt2[], memo[];
	
	private static long fibo1(int n) { //피보나치 n항 구하기
		totalCnt1++;
		callCnt1[n]++;
		if(n<2) return n;
		return fibo1(n-1) + fibo1(n-2);
	}
	
	private static long fibo2(int n) { //피보나치 n항 구하기
		totalCnt2++;
		callCnt2[n]++;
		if(memo[n] == -1) { //메모 되어 있는지 확인하여 메모 안되어 있을 경우에만 수행 후 메모하기
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		totalCnt1 = totalCnt2 = 0;
		callCnt1 = new long[N+1];
		callCnt2 = new long[N+1];
		memo = new long[N+1];
		
		Arrays.fill(memo, -1); //메모되지 않은 상태를 나타내는 값으로 초기화
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println(fibo1(N));
		System.out.println("fibo1 : " + totalCnt1); //재귀방식의 호출횟수
		for(int i=0; i<= N; i++) { //n번째 Call횟수 출력
			System.out.println("fibo1[" + i + "] : " + callCnt1[i]);
		}
		System.out.println("======================================================");
		System.out.println(fibo2(N));
		System.out.println("fibo2 : " + totalCnt2); //메모이제이션 적용 후 호출횟수
		for(int i=0; i<= N; i++) {//n번째 Call횟수 출력
			System.out.println("fibo2[" + i + "] : " + callCnt2[i]);
		}
	}
}
