class Task{
    int taskId,priority;
    String taskName,dueDate;
    Task next;
    public Task(int taskId,String taskName,int priority,String dueDate){
        this.taskId=taskId;
        this.taskName=taskName;
        this.priority=priority;
        this.dueDate=dueDate;
        this.next=null;
    }
}
class TaskScheduler{
    Task head;
    public TaskScheduler(){
        head=null;
    }
    public void addTaskAtBeginning(int taskId,String taskName,int priority,String dueDate){
        Task newTask=new Task(taskId,taskName,priority,dueDate);
        if(head==null){
            head=newTask;
            newTask.next=head;
        }else{
            Task temp=head;
            while(temp.next!=head) temp=temp.next;
            temp.next=newTask;
            newTask.next=head;
            head=newTask;
        }
    }
    public void addTaskAtEnd(int taskId,String taskName,int priority,String dueDate){
        Task newTask=new Task(taskId,taskName,priority,dueDate);
        if(head==null){
            head=newTask;
            newTask.next=head;
        }else{
            Task temp=head;
            while(temp.next!=head) temp=temp.next;
            temp.next=newTask;
            newTask.next=head;
        }
    }
    public void addTaskAtPosition(int position,int taskId,String taskName,int priority,String dueDate){
        if(position==1) addTaskAtBeginning(taskId,taskName,priority,dueDate);
        else{
            Task newTask=new Task(taskId,taskName,priority,dueDate);
            Task temp=head;
            for(int i=1;i<position-1;i++) temp=temp.next;
            newTask.next=temp.next;
            temp.next=newTask;
        }
    }
    public void removeTaskById(int taskId){
        if(head==null) return;
        if(head.taskId==taskId){
            Task temp=head;
            while(temp.next!=head) temp=temp.next;
            if(head.next==head) head=null;
            else{
                temp.next=head.next;
                head=head.next;
            }
            return;
        }
        Task temp=head;
        while(temp.next!=head&&temp.next.taskId!=taskId) temp=temp.next;
        if(temp.next!=head){
            temp.next=temp.next.next;
        }
    }
    public void viewAndMoveToNextTask(){
        if(head==null) return;
        Task temp=head;
        System.out.println("Task ID: "+temp.taskId+" Task Name: "+temp.taskName+" Priority: "+temp.priority+" Due Date: "+temp.dueDate);
        head=temp.next;
    }
    public void displayAllTasks(){
        if(head==null){
            System.out.println("No tasks available.");
            return;
        }
        Task temp=head;
        do{
            System.out.println("Task ID: "+temp.taskId+" Task Name: "+temp.taskName+" Priority: "+temp.priority+" Due Date: "+temp.dueDate);
            temp=temp.next;
        }while(temp!=head);
    }
    public Task searchTaskByPriority(int priority){
        Task temp=head;
        do{
            if(temp.priority==priority) return temp;
            temp=temp.next;
        }while(temp!=head);
        return null;
    }
}
public class TaskSchedulerApp{
    public static void main(String[] args){
        TaskScheduler scheduler=new TaskScheduler();
        scheduler.addTaskAtEnd(101,"Complete Assignment",3,"2025-02-15");
        scheduler.addTaskAtEnd(102,"Prepare Presentation",2,"2025-02-16");
        scheduler.addTaskAtBeginning(103,"Team Meeting",1,"2025-02-14");
        scheduler.addTaskAtPosition(2,104,"Code Review",4,"2025-02-17");
        scheduler.displayAllTasks();
        scheduler.removeTaskById(102);
        scheduler.displayAllTasks();
        scheduler.viewAndMoveToNextTask();
        Task task=scheduler.searchTaskByPriority(4);
        if(task!=null) System.out.println("Task Found: Task ID: "+task.taskId+" Task Name: "+task.taskName+" Priority: "+task.priority+" Due Date: "+task.dueDate);
    }
}
