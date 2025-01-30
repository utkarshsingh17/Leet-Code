class Solution {
    private static boolean isBipartite(Map<Integer,List<Integer>> adj, int src,int n,int[] colour){
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(src);
        colour[src]=1;
        while(queue.isEmpty()==false){
            int node=queue.poll();
            int curColour=colour[node];
           
            for(int nbr:adj.get(node)){
                if(colour[node]==colour[nbr]){
                    return false;
                }
                else if(colour[nbr]==-1){
                    colour[nbr]=1-curColour;
                    queue.add(nbr);
                }
            }
        }
        return true;
    }

    private static int bfs(Map<Integer,List<Integer>> adj,int src,int n){
        Queue<Integer> queue=new ArrayDeque<>();
        boolean visited[]=new boolean[n+1];
        queue.add(src);
        visited[src]=true;
        int level=1;
        while(queue.isEmpty()==false){
            int size=queue.size();
            while(size-- > 0){
                int node=queue.poll();
                
                for(int nbr:adj.get(node)){
                    if(visited[nbr]==false){
                        queue.add(nbr);
                        visited[nbr]=true;
                    }
                }
            }
            level++;
        }
        return level-1;
    }
    private static int maxGrpInEachComponent(Map<Integer,List<Integer>> adj,boolean[] visited,int[]levels,int src){
        int maxGrp=levels[src];
        visited[src]=true;
        for(int nbr:adj.get(src)){
            if(visited[nbr]==false){
                maxGrp=Math.max(maxGrp,maxGrpInEachComponent(adj,visited,levels,nbr));
            }
        }
        return maxGrp;
    }
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            List<Integer> list=adj.getOrDefault(u,new ArrayList<>());
            list.add(v);
            adj.put(u,list);
            list=adj.getOrDefault(v,new ArrayList<>());
            list.add(u);
            adj.put(v,list);
        }
        System.out.println(adj);
        int colour[]=new int[n+1];
        Arrays.fill(colour,-1);
        for(int i=1;i<=n;i++){
            if(colour[i]==-1)
            if(isBipartite(adj,i,n,colour)==false)return -1;
        }
      
        int levels[]=new int[n+1];
        for(int i=1;i<=n;i++){
            levels[i]=bfs(adj,i,n);
        }

        int res=0;
        boolean visited[]=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                res+=maxGrpInEachComponent(adj,visited,levels,i);
               
            }
        }
       
        return res;


    }
}