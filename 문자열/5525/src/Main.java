import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

// 현재 칸까지 'OI'가 몇개 반복되었는지 mem에 저장하기 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); // S의 길이 M
        char[] S = br.readLine().toCharArray();
        int[] mem = new int[M]; // 현재 칸까지 'OI'가 몇개 반복되었는지
        int ans = 0;
        //mem[0] = 0;
        for(int i=1; i<M-1; i++){
            //mem[i] = 0;
            if(S[i]=='O' && S[i+1]=='I'){
                mem[i+1] = mem[i-1]+1;
                // i+1칸까지 OI가 N번 반복되고 첫글자가 I이면
                if(mem[i+1]>=N && S[i+1-2*N]=='I')  {ans++;}
            }
        }
        System.out.println(ans);

        // 정규표현식 쓸 수 없음
        // 겹치는 Pn을 찾을 수 없기 때문
        /*
        Pattern p = Pattern.compile("IO".repeat(N)+"I"); // 문자열 Pn 을 정규표현식으로 써서 패턴 만들기
        Matcher m = p.matcher(S);

        int ans = 0;
        while(m.find()) {
            ans++;
            System.out.println(m.start());
        }
        System.out.println(ans);
        */
        
    }

}
