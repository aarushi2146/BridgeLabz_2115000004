
class TextState{
    String text;
    TextState next,prev;
    public TextState(String text){
        this.text=text;
        this.next=null;
        this.prev=null;
    }
}
class TextEditor{
    TextState head,tail,current;
    int maxHistorySize,count;
    public TextEditor(int maxHistorySize){
        this.maxHistorySize=maxHistorySize;
        this.head=null;
        this.tail=null;
        this.current=null;
        this.count=0;
    }
    public void addState(String text){
        TextState newState=new TextState(text);
        if(count==maxHistorySize){
            head=head.next;
            head.prev=null;
            count--;
        }
        if(head==null){
            head=newState;
            tail=newState;
            current=newState;
        }else{
            tail.next=newState;
            newState.prev=tail;
            tail=newState;
            current=tail;
        }
        count++;
    }
    public void undo(){
        if(current!=null&&current.prev!=null){
            current=current.prev;
        }
    }
    public void redo(){
        if(current!=null&&current.next!=null){
            current=current.next;
        }
    }
    public void displayCurrentState(){
        if(current!=null){
            System.out.println("Current text: "+current.text);
        }else{
            System.out.println("No text state available.");
        }
    }
}
public class TextEditorApp{
    public static void main(String[] args){
        TextEditor editor=new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}

