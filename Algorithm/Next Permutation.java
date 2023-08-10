import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for (int i=0; i<N; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input); //오름차순으로 반드시 정렬

        do {
            //순열을 이용한 처리작업
            System.out.println(Arrays.toString(input));
        } while (np(input));
    }

    private static boolean np(int[] p) { // p : 다음 순열을 원하는 기존 순열의 배열
        //1. 꼭대기 찾기
        int N = p.length;
        int i = N-1;
        while(i>0 && p[i-1] >=p[i]) i--;

        if(i==0) return false;

        //2. 꼭대기 직전(i-1)위치에 교환할 한단계 큰 수를 뒤쪽부터 찾기
        int j = N-1;
        while(p[i-1] >= p[j]) j--;

        //3. 꼭대기 직전(i-1)위치의 수와 찾은 j를 교환
        swap(p, i-1, j);

        //4. 꼭대기부터 맨뒤까지를 오름차순 형태로 뒤집기
        int k = N-1;
        while(i<k) {
            swap(p, i++, k--);
        }

        return true;
    }

    private static void swap(int[] p, int a, int b) {
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
}
