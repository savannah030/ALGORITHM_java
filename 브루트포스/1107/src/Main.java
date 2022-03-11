import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Integer N = Integer.valueOf(br.readLine()); // 이동하려는 채널        
        Integer M = Integer.valueOf(br.readLine()); // 고장난 버튼의 개수
        int answer = Math.abs(N-100); // answer는 + 혹은 -만 눌러서 이동할 때로 초기화
        
        // 케이스 1: 고장난 버튼이 없는 경우
        if (M==0){ 
            System.out.println(Math.min(answer,N.toString().length())); // + 혹은 -만 눌러서 이동할 때와 바로 이동할 수 있는 경우 중 최소값
            return;
        }
        String[] arr = br.readLine().split(" "); // M!=0일 때만 입력받기

        // 케이스 2: 그 외 경우
        Boolean[] broken = new Boolean[10];
        Arrays.fill(broken,false); 
        for(String a: arr){ 
            broken[Integer.valueOf(a)]=true;
        }

        /**
         * N 근처 숫자를 순차적으로 탐색 
         * nexts = {N,N};
         * nexts = {N-1,N+1};
         * nexts = {N-2,N+2};
         * ...
         */
        for(int i=0; i<500000 ;i++ ){

            String[] nexts = {Integer.toString(N-i), Integer.toString(N+i)}; 
           
            for (String n: nexts){
                boolean check = false;
                if(Integer.valueOf(n)<0) continue; // 0<=N<=500000이고, 채널은 무제한
                for(int j=0; j<n.length(); j++){
                    if(broken[n.charAt(j)-'0']){ // 고장난 숫자면
                        check = true;
                        break;                
                    }
                }
                if (!check){ // s한테 고장난 버튼이 없으면
                    answer = Math.min( answer, n.length() + Math.abs(Integer.valueOf(n)-N) );
                }
            } 
        }
        System.out.print(answer);
    }
}
