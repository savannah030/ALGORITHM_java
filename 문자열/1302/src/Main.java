import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> books = new HashMap<>();
        
        for(int i=0;i<N;i++){
            String book = br.readLine();
            if(books.containsKey(book)){ 
                books.replace(book, books.get(book)+1);
            }
            else{
                books.put(book, 1);
            }
        }

        //System.out.println(books.toString()); //{top=4, kimtop=1}

        int max = 0;
        String ans = "";
        for(String book : books.keySet()){
            if(max<books.get(book)){ //최대값이면
                max = books.get(book);
                ans = book;
            }else if(max==books.get(book)){ //최대값과 같을 때 사전순으로 가장 앞서면
                if(ans.compareTo(book)>0){
                    ans = book;
                }
            }
        }
        System.out.println(ans);
    }
}
