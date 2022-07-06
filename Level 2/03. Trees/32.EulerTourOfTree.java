import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] edge = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                edge[i][j] = scn.nextInt();
            }
        }

        int Q = scn.nextInt();
        int[][] Query = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < 2; j++) {
                Query[i][j] = scn.nextInt();
            }
        }

        int[] ans = solve(n, Q, edge, Query);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        scn.close();
    }

    static int[][] dis;
    static int index;
    static boolean[] vis;
    static Map<Integer,ArrayList<Integer>> graph;
    static Map<Integer,int[]> map;
    
    public static int[] solve(int N, int Q, int[][] Edge, int[][] query) {
        graph=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<N;i++){
            graph.put(i,new ArrayList<Integer>());
        }
        for(int[] e:Edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        dis=new int[2*N][4]; // cty ,level,prefmax,suffixmax
        index=0;
        vis=new boolean[N];
        map=new HashMap<Integer,int[]>();
        dfs(0,0);
        
        //prefmax
        dis[0][2]=dis[0][1];
        for(int i=1;i<2*N;i++){
            dis[i][2]=Math.max(dis[i][1],dis[i-1][2]);
        }
        
        //surmax
        dis[2*N-1][3]=dis[2*N-1][1];
        for(int i=2*N-2;i>=0;i--){
            dis[i][3]=Math.max(dis[i][1],dis[i+1][3]);
        }
        
        for(int i=0;i<dis.length;i++){
            System.out.println(dis[i][0]+" "+dis[i][1]+" "+dis[i][2]+" "+dis[i][3]);
        }
        
        int[] ans=new int[Q];
        int i=0;
        for(int[] q:query){
            int node=q[0];
            int l1=dis[map.get(q[0])[0]][1];
            int l2=dis[map.get(q[1])[0]][1];
            
            if(l1<l2) node=q[1];
            
            ans[i]=Math.max(dis[map.get(node)[0]-1][2],dis[map.get(node)[1]+1][3]);
            i++;
        }
        
        
        return ans;
    }
    
    public static void dfs(int start,int level){
        vis[start]=true;
        dis[index][0]=start;
        dis[index][1]=level;
        map.put(start,new int[]{index++,-1});
        for(int nbr : graph.get(start)){
            if(!vis[nbr]){
                dfs(nbr,level+1);
            }
        }
        dis[index][0]=start;
        dis[index][1]=level;
        map.get(start)[1]=index++;
    }
}
