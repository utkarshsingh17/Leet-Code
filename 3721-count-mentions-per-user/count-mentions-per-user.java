class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        PriorityQueue<List<String>>queue=new PriorityQueue<>((a,b)->{
            if(Integer.parseInt(a.get(1))<Integer.parseInt(b.get(1)))return -1;
            else if(Integer.parseInt(a.get(1))>Integer.parseInt(b.get(1)))return 1;
            else{
                if(a.get(0).equals("MESSAGE")&&b.get(0).equals("OFFLINE"))return 1;
                else if(a.get(0).equals("OFFLINE")&&b.get(0).equals("MESSAGE"))return -1;
                else return 0;
            }
            
        });
        int[] offUntil=new int[numberOfUsers];
        int[] mentions=new int[numberOfUsers];
       
        for(List<String> event:events){
            queue.add(event);
            
        }
        System.out.println("queue::"+queue);
        while(queue.isEmpty()==false){
            List<String> event=queue.poll();
            if(event.get(0).equals("OFFLINE")){
                    offUntil[Integer.parseInt(event.get(2))]=Integer.parseInt(event.get(1))+60;
            }
            else if(event.get(0).equals("MESSAGE")){
                if(event.get(2).equals("ALL")){
                    for(int i=0;i<numberOfUsers;i++){
                        mentions[i]+=1;
                    }
                }
                else if(event.get(2).equals("HERE")){
                    for(int i=0;i<numberOfUsers;i++){
                        
                        if(offUntil[i]<=Integer.parseInt(event.get(1))){
                            mentions[i]+=1;
                        }
                    }
                }
                else{
                    System.out.println(event);
                    String[] id=event.get(2).split(" ");
                    for(int i=0;i<id.length;i++){
                        mentions[Integer.parseInt(id[i].substring(2))]+=1;
                    }
                }
            }
           
        }
        return mentions;
    }
}