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
        Queue<Integer> queue=new ArrayDeque<>();
        List<Set<Integer>> pq=new ArrayList<>();

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
            pq.add(new HashSet<>());
        }

        int[] indegree=new int[n];
        for(int[] p:prerequisites){
        List<Integer>list=map.get(p[1]);
        list.add(p[0]);
        indegree[p[0]]++;
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0)queue.add(i);
        }

        while(queue.isEmpty()==false){
            int node=queue.poll();
        
            for(int nbr:map.get(node)){
                
                Set<Integer> set=pq.get(nbr);
                set.add(node);
                Iterator itr=pq.get(node).iterator();
                while(itr.hasNext()){
                    set.add((Integer)itr.next());
                }
                indegree[nbr]--;
                if(indegree[nbr]==0)queue.add(nbr);
            }
        }
        for(int[] query:queries){
            if(pq.get(query[0]).contains(query[1]))res.add(true);
            else res.add(false);
        }
        
    
        return res;
    }
}