import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
   
    static 
    class Tomato{
        int x;
        int y;
    
        Tomato(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] board = new int[1000][1000];
    static int M,N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Tomato> queue;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        queue = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1) queue.add(new Tomato(i,j));
            }
        }

        //bfs
        while(!queue.isEmpty()){
            Tomato t = queue.remove();
            int x = t.x;
            int y = t.y;
            for(int dir=0; dir<4; dir++){
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if (nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if (board[nx][ny]!=0) continue;
                board[nx][ny]=board[x][y]+1;
                queue.add(new Tomato(nx,ny));
            }
        }
        
        int ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                ans = (ans>board[i][j]) ?  ans : board[i][j]; 
            }
        }
        System.out.println(ans-1);
    }
}