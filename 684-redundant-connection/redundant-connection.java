class Solution {
      private static boolean dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int src,int des) {
        visited[src] = true;
        if (src==des) return true;
        
        for (int nbr : adj.get(src) ){
            if (visited[nbr]==true) continue;
            if (dfs(adj, visited, nbr, des))return true; 
            
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int n=edges.length;
        for(int edge[]:edges){
           int u=edge[0];
           int v=edge[1];
           boolean[] visted=new boolean[n+1];
           if(adj.containsKey(u)==true&& adj.containsKey(v)==true&&dfs(adj,visted,u,v)){
            return edge;
           }
         List<Integer> list= adj.getOrDefault(u,new ArrayList<>());
         list.add(v);
         adj.put(u,list);
         list=adj.getOrDefault(v,new ArrayList<>());
         list.add(u);
         adj.put(v,list);
          
        }
       System.out.println(adj);
        return new int[]{};

    }
}