class Solution {
    private static boolean bfs(int n,Map<Integer,List<Integer>> adj,int source,int dest){
        Queue<Integer> queue=new ArrayDeque<>();
        boolean[] visited=new boolean[n];
        queue.add(source);
        visited[source]=true;

        while(queue.isEmpty()==false){
            int node=queue.poll();
            if(node==dest)return true;
            for(int nbr:adj.get(node)){
                if(visited[nbr]==false){
                    queue.add(nbr);
                    visited[nbr]=true;
                }
            }
        }
        return false;
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        List<Boolean> res=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++) map.put(i,new ArrayList<>());

        for(int[] p:prerequisites){
        List<Integer>list=map.get(p[1]);
        list.add(p[0]);
        }
        for(int[] query:queries){
            res.add(bfs(n,map,query[1],query[0]));
        }
        
    
        return res;
    }
}