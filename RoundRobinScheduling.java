class ProcessNode{
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;
    public ProcessNode(int processId,int burstTime,int priority){
        this.processId=processId;
        this.burstTime=burstTime;
        this.priority=priority;
        this.next=null;
    }
}
class RoundRobinScheduler{
    ProcessNode head;
    ProcessNode tail;
    int timeQuantum;
    public RoundRobinScheduler(int timeQuantum){
        this.head=null;
        this.tail=null;
        this.timeQuantum=timeQuantum;
    }
    public void addProcess(int processId,int burstTime,int priority){
        ProcessNode newProcess=new ProcessNode(processId,burstTime,priority);
        if(head==null){
            head=tail=newProcess;
            newProcess.next=head;
        }else{
            tail.next=newProcess;
            tail=newProcess;
            tail.next=head;
        }
    }
    public void removeProcessById(int processId){
        if(head==null){
            return;
        }
        ProcessNode current=head;
        ProcessNode previous=null;
        do{
            if(current.processId==processId){
                if(previous!=null){
                    previous.next=current.next;
                }else{
                    head=current.next;
                    tail.next=head;
                }
                if(current==tail){
                    tail=previous;
                }
                return;
            }
            previous=current;
            current=current.next;
        }while(current!=head);
    }
    public void scheduleProcesses(){
        if(head==null){
            return;
        }
        ProcessNode current=head;
        int totalWaitingTime=0;
        int totalTurnaroundTime=0;
        int processCount=0;
        do{
            if(current.burstTime>timeQuantum){
                current.burstTime-=timeQuantum;
                totalTurnaroundTime+=timeQuantum;
                current=current.next;
            }else{
                totalTurnaroundTime+=current.burstTime;
                totalWaitingTime+=totalTurnaroundTime-current.burstTime;
                removeProcessById(current.processId);
                current=current.next;
            }
            processCount++;
            displayProcesses();
        }while(head!=null&&processCount<10);
        if(processCount==10){
            System.out.println("Process terminated after 10 rounds.");
        }
        if(processCount>0){
            System.out.println("\nAverage Waiting Time: "+(double)totalWaitingTime/processCount);
            System.out.println("Average Turnaround Time: "+(double)totalTurnaroundTime/processCount);
        }
    }
    public void displayProcesses(){
        if(head==null){
            return;
        }
        ProcessNode current=head;
        System.out.print("Processes in the Queue: ");
        do{
            System.out.print("P"+current.processId+"(Burst: "+current.burstTime+") ");
            current=current.next;
        }while(current!=head);
        System.out.println();
    }
}
public class RoundRobinScheduling{
    public static void main(String[] args){
        RoundRobinScheduler scheduler=new RoundRobinScheduler(4);
        scheduler.addProcess(1,12,1);
        scheduler.addProcess(2,5,2);
        scheduler.addProcess(3,8,3);
        scheduler.addProcess(4,7,1);
        System.out.println("Starting Round Robin Scheduling...\n");
        scheduler.scheduleProcesses();
    }
}
