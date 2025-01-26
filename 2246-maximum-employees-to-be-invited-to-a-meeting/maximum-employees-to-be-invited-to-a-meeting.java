class Solution {
    public int khansTopologicalSort(int source,int[]adj,boolean[] visited,int[] indegree){
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(source);
        visited[source]=true;
        int lastNode=0;
        while(queue.isEmpty()==false){
            int node=queue.poll();
            
            lastNode=node;

            int nbr=adj[node];
            indegree[nbr]-=1;
            if(indegree[nbr]==0&&visited[nbr]==false){
                queue.add(nbr);
                visited[nbr]=true;
            }

        }
        return adj[lastNode];
    }
    public int maxDepth(int source,int avoid,int n,List<List<Integer>> adj, boolean[] org_visited){
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(source);
        visited[source]=true;
        visited[avoid]=true;
        int level=0;
        while(queue.isEmpty()==false){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int node=queue.poll();
                org_visited[node]=true;

                for(int nbr:adj.get(node)){
                    if(visited[nbr]==false){
                        visited[nbr]=true;
                        queue.add(nbr);
                    }
                }
                
            }
            level++;

        }

        return level;


    }
    private int bfs(int[] adj, boolean[] visited, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (!visited[adj[curr]]) {
                visited[adj[curr]] = true;
                queue.offer(adj[curr]);
            }
            count++;
        }
        return count;
    }
    public int maximumInvitations(int[] favorite) {
        int n=favorite.length;
       List<List<Integer>> rev_adj=new ArrayList<>();
       for(int i=0;i<n;i++)rev_adj.add(new ArrayList<>());
        int[] indegree=new int[n];

        for(int i=0;i<n;i++){
            rev_adj.get(favorite[i]).add(i);
            indegree[favorite[i]]++;
        }

        int total_tail_len=0;
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            if(indegree[i]==0&&visited[i]==false){
                int node=khansTopologicalSort(i,favorite,visited,indegree);
                if(favorite[favorite[node]]==node){
                    int len=maxDepth(node,favorite[node],n,rev_adj,visited)-1;
                    total_tail_len+=len;
                    visited[node]=false;
                }
            }
        }

        int two_size_cycle=0;
        int max_size_cycle=0;

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                int cycle_size=bfs(favorite,visited,i);
                if(cycle_size==2){
                two_size_cycle++;
                }
                else{
                    max_size_cycle=Math.max(max_size_cycle,cycle_size);
                }
            }
        }
        int people=total_tail_len+(2*two_size_cycle);
        return Math.max(max_size_cycle,people);
    }
}