import java.util.ArrayList;
class FriendNode{
    int friendId;
    FriendNode next;
    public FriendNode(int friendId){
        this.friendId=friendId;
        this.next=null;
    }
}
class UserNode{
    int userId;
    String name;
    int age;
    FriendNode friendList;
    UserNode next;
    public UserNode(int userId,String name,int age){
        this.userId=userId;
        this.name=name;
        this.age=age;
        this.friendList=null;
        this.next=null;
    }
    public void addFriend(int friendId){
        FriendNode newFriend=new FriendNode(friendId);
        if(friendList==null){
            friendList=newFriend;
        }else{
            FriendNode temp=friendList;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newFriend;
        }
    }
    public void removeFriend(int friendId){
        if(friendList==null) return;
        if(friendList.friendId==friendId){
            friendList=friendList.next;
            return;
        }
        FriendNode current=friendList;
        while(current.next!=null&&current.next.friendId!=friendId){
            current=current.next;
        }
        if(current.next!=null){
            current.next=current.next.next;
        }
    }
    public ArrayList<Integer> getFriends(){
        ArrayList<Integer> friends=new ArrayList<>();
        FriendNode current=friendList;
        while(current!=null){
            friends.add(current.friendId);
            current=current.next;
        }
        return friends;
    }
    public boolean isFriend(int friendId){
        FriendNode current=friendList;
        while(current!=null){
            if(current.friendId==friendId) return true;
            current=current.next;
        }
        return false;
    }
}
class SocialMediaSystem{
    UserNode head;
    public SocialMediaSystem(){
        this.head=null;
    }
    public void addUser(int userId,String name,int age){
        UserNode newUser=new UserNode(userId,name,age);
        if(head==null){
            head=newUser;
        }else{
            UserNode temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newUser;
        }
    }
    public UserNode findUserById(int userId){
        UserNode current=head;
        while(current!=null){
            if(current.userId==userId) return current;
            current=current.next;
        }
        return null;
    }
    public UserNode findUserByName(String name){
        UserNode current=head;
        while(current!=null){
            if(current.name.equalsIgnoreCase(name)) return current;
            current=current.next;
        }
        return null;
    }
    public void addFriendConnection(int userId1,int userId2){
        UserNode user1=findUserById(userId1);
        UserNode user2=findUserById(userId2);
        if(user1!=null&&user2!=null){
            user1.addFriend(userId2);
            user2.addFriend(userId1);
        }
    }
    public void removeFriendConnection(int userId1,int userId2){
        UserNode user1=findUserById(userId1);
        UserNode user2=findUserById(userId2);
        if(user1!=null&&user2!=null){
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
        }
    }
    public ArrayList<Integer> findMutualFriends(int userId1,int userId2){
        UserNode user1=findUserById(userId1);
        UserNode user2=findUserById(userId2);
        ArrayList<Integer> mutualFriends=new ArrayList<>();
        if(user1!=null&&user2!=null){
            ArrayList<Integer> user1Friends=user1.getFriends();
            ArrayList<Integer> user2Friends=user2.getFriends();
            for(Integer friendId:user1Friends){
                if(user2.isFriend(friendId)){
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }
    public void displayAllFriends(int userId){
        UserNode user=findUserById(userId);
        if(user!=null){
            ArrayList<Integer> friends=user.getFriends();
            System.out.println("User "+userId+" has friends: "+friends);
        }
    }
    public void countFriends(int userId){
        UserNode user=findUserById(userId);
        if(user!=null){
            int count=user.getFriends().size();
            System.out.println("User "+userId+" has "+count+" friends.");
        }
    }
}
public class SocialMediaApp{
    public static void main(String[] args){
        SocialMediaSystem system=new SocialMediaSystem();
        system.addUser(1,"Aarushi",25);
        system.addUser(2,"Pratyaksh",28);
        system.addUser(3,"Aditya",22);
        system.addUser(4,"Priyangi",30);
        system.addFriendConnection(1,2);
        system.addFriendConnection(1,3);
        system.addFriendConnection(2,4);
        system.addFriendConnection(3,4);
        system.displayAllFriends(1);
        system.displayAllFriends(2);
        system.displayAllFriends(3);
        system.countFriends(1);
        system.countFriends(2);
        System.out.println("Mutual Friends between 1 and 2: "+system.findMutualFriends(1,2));
        System.out.println("Mutual Friends between 3 and 4: "+system.findMutualFriends(3,4));
        system.removeFriendConnection(1,2);
        system.displayAllFriends(1);
        system.displayAllFriends(2);
    }
}