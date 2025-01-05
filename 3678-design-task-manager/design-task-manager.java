class TaskManager {
     class Task{
        private int userId;
        private int taskId;
        private int priority;
        private boolean isRemoved =false;
        public Task(int userId,int taskId,int priority,boolean isRemoved){
            this.userId=userId;
            this.taskId=taskId;
            this.priority=priority;
            this.isRemoved=isRemoved;
        }
        public void setUserId(int userId){
            this.userId=userId;
        }
        public int getUserId(){
            return this.userId;
        }
        public void setTaskId(int taskId){
            this.taskId=taskId;
        }
        public int getTaskId(){
            return this.taskId;
        }
        public void setPriority(int priority){
            this.priority=priority;
        }
        public int getPriority(){
            return this.priority;
        }
        public void setIsRemoved(boolean isRemoved){
            this.isRemoved=isRemoved;
        }
        public boolean getIsRemoved(){
            return this.isRemoved;
        }

    }
    PriorityQueue<Task> priorityQueue=null;
    public HashMap<Integer,Task> map=null;
    public TaskManager(List<List<Integer>> tasks) {
        priorityQueue=new PriorityQueue<>((a,b)->{
            if(a.getPriority()>b.getPriority())return -1;
            else if(a.getPriority()<b.getPriority())return 1;
            else return b.getTaskId()-a.getTaskId();
        });
        map=new HashMap<>();
        for(List<Integer> task:tasks){
            add(task.get(0),task.get(1),task.get(2));
        }
        
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task=new Task(userId,taskId,priority,false);
        priorityQueue.add(task);
        map.put(taskId,task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task oldTask=map.get(taskId);
        if(oldTask!=null){
            oldTask.setIsRemoved(true);
            Task newTask=new Task(oldTask.getUserId(),oldTask.getTaskId(),newPriority,false);
            priorityQueue.add(newTask);
            map.put(taskId,newTask);
        }
    }
    
    public void rmv(int taskId) {
        Task oldTask=map.get(taskId);
        if(oldTask!=null){
            oldTask.setIsRemoved(true);
            map.remove(taskId);
        }
    }
    
    public int execTop() {
        if(priorityQueue.isEmpty())return -1;
        while(priorityQueue.isEmpty()==false&&priorityQueue.peek().getIsRemoved()==true){
            priorityQueue.poll();
        };
        if(priorityQueue.isEmpty())return -1;
        Task task=priorityQueue.poll();
         //priorityQueue.remove();
         task.setIsRemoved(true);
         map.remove(task.getTaskId());
         return task.getUserId();
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */