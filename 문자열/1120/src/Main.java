import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        String A = st.nextToken();
        String B = st.nextToken();
        int answer = A.length();

        // 완전탐색
        for(int i=0; i<B.length()-A.length()+1; i++){ // 글자수차이만큼 반복
            int count = 0;
            for(int j=0; j<A.length(); j++){ 
                if(A.charAt(j)!=B.charAt(i+j)) count++;
            }
            if (count<answer){
                answer = count;
            }
        }
        System.out.println(answer);

    }
}