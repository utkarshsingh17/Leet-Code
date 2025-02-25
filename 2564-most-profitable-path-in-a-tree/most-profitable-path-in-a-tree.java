class Solution {
    private static boolean dfsBob(int cur,Map<Integer,List<Integer>> adj,boolean[] visited, Map<Integer,Integer> bobMap,int time){
        visited[cur]=true;
        bobMap.put(cur,time);
        if(cur==0) return true;
        for(int nbr:adj.get(cur)){
            if(visited[nbr]==false){
              if(dfsBob(nbr,adj,visited,bobMap,time+1)){
                        return true;
                }
            }
        }
        bobMap.remove(cur);
        return false;
    }
    private static void dfsAlice(int cur, Map<Integer,List<Integer>>adj,int[]amount,boolean[]visited,Map<Integer,Integer> bobMap,int time,int[] score,int income){
        visited[cur]=true;
        if(bobMap.containsKey(cur)==false||time<bobMap.get(cur)){
            income+=amount[cur];
        }else if(time==bobMap.get(cur)){
            income+=(amount[cur]/2);
        }

        if(adj.get(cur).size()==1&&cur!=0){
            score[0]=Math.max(score[0],income);
        }

        for(int nbr:adj.get(cur)){
            if(visited[nbr]==false){
                dfsAlice(nbr,adj,amount,visited,bobMap,time+1,score,income);
            }
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        
        Map<Integer, List<Integer>> adj=new HashMap<>();
        Map<Integer,Integer> bobMap=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int time=0;
        boolean visited[]=new boolean[n];
        dfsBob(bob,adj,visited,bobMap,0);
        Arrays.fill(visited,false);
        int[] score=new int[1];
        score[0]=Integer.MIN_VALUE;
        dfsAlice(0,adj,amount,visited,bobMap,0,score,0);
        return score[0];



    }
}