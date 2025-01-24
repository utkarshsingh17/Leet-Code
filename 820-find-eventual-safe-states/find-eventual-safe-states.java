class Solution {
    public static boolean isCycle(int[][]graph,boolean[] vis, boolean[] pathvis,int node){
        if(pathvis[node]==true)return true;
        if(vis[node]==true)return false;
        vis[node]=true;
        pathvis[node]=true;
        for(int nbr:graph[node]){
                //pathvis[nbr]=true;
                //vis[nbr]=true;
                if(isCycle(graph,vis,pathvis,nbr)==true)return true;
            
            //else if(pathvis[nbr]==true)return true;
        }
        pathvis[node]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean vis[]=new boolean[graph.length];
        boolean pathvis[]=new boolean[graph.length];
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            isCycle(graph,vis,pathvis,i);
             
        }
        for(int i=0;i<pathvis.length;i++){
            if(!pathvis[i])res.add(i);
        }
        return res;
    }
}