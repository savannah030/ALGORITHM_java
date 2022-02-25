import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int zeroToOne=0,oneToZero=0;

        /* == 연산자(주소값을 비교) 
         * equals 연산자(대상의 내용 자체를 비교)
         * 단, 객체가 아닌 기본형은 == 로 비교
         * */
        for(int i=0; i<str.length()-1;i++){
            if(str.charAt(i)=='0' && str.charAt(i+1)=='1') zeroToOne += 1;
            else if(str.charAt(i)=='1' && str.charAt(i+1)=='0') oneToZero += 1;
        }
        System.out.println(zeroToOne>oneToZero ? zeroToOne : oneToZero);
    }
}