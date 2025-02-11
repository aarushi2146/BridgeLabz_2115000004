class Item{
    String itemName;
    int itemId,quantity;
    double price;
    Item next;
    public Item(String itemName,int itemId,int quantity,double price){
        this.itemName=itemName;
        this.itemId=itemId;
        this.quantity=quantity;
        this.price=price;
        this.next=null;
    }
}
class InventoryManagementSystem{
    Item head;
    public InventoryManagementSystem(){
        head=null;
    }
    public void addItemAtBeginning(String itemName,int itemId,int quantity,double price){
        Item newItem=new Item(itemName,itemId,quantity,price);
        newItem.next=head;
        head=newItem;
    }
    public void addItemAtEnd(String itemName,int itemId,int quantity,double price){
        Item newItem=new Item(itemName,itemId,quantity,price);
        if(head==null){
            head=newItem;
            return;
        }
        Item temp=head;
        while(temp.next!=null) temp=temp.next;
        temp.next=newItem;
    }
    public void addItemAtPosition(int position,String itemName,int itemId,int quantity,double price){
        if(position==1) addItemAtBeginning(itemName,itemId,quantity,price);
        else{
            Item newItem=new Item(itemName,itemId,quantity,price);
            Item temp=head;
            for(int i=1;i<position-1;i++) temp=temp.next;
            newItem.next=temp.next;
            temp.next=newItem;
        }
    }
    public void removeItemById(int itemId){
        if(head==null) return;
        if(head.itemId==itemId){
            head=head.next;
            return;
        }
        Item temp=head;
        while(temp.next!=null&&temp.next.itemId!=itemId) temp=temp.next;
        if(temp.next!=null) temp.next=temp.next.next;
    }
    public void updateItemQuantity(int itemId,int newQuantity){
        Item temp=head;
        while(temp!=null){
            if(temp.itemId==itemId){
                temp.quantity=newQuantity;
                return;
            }
            temp=temp.next;
        }
    }
    public Item searchItemByIdOrName(int itemId,String itemName){
        Item temp=head;
        while(temp!=null){
            if(temp.itemId==itemId||temp.itemName.equalsIgnoreCase(itemName)) return temp;
            temp=temp.next;
        }
        return null;
    }
    public double calculateTotalValue(){
        double totalValue=0;
        Item temp=head;
        while(temp!=null){
            totalValue+=temp.price*temp.quantity;
            temp=temp.next;
        }
        return totalValue;
    }
    public void sortInventoryByNameAscending(){
        if(head==null||head.next==null) return;
        Item temp=head;
        Item index=null;
        String tempName;
        while(temp!=null){
            index=temp.next;
            while(index!=null){
                if(temp.itemName.compareTo(index.itemName)>0){
                    tempName=temp.itemName;
                    temp.itemName=index.itemName;
                    index.itemName=tempName;
                }
                index=index.next;
            }
            temp=temp.next;
        }
    }
    public void sortInventoryByPriceAscending(){
        if(head==null||head.next==null) return;
        Item temp=head;
        Item index=null;
        double tempPrice;
        while(temp!=null){
            index=temp.next;
            while(index!=null){
                if(temp.price>index.price){
                    tempPrice=temp.price;
                    temp.price=index.price;
                    index.price=tempPrice;
                }
                index=index.next;
            }
            temp=temp.next;
        }
    }
    public void displayInventory(){
        if(head==null){
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp=head;
        while(temp!=null){
            System.out.println("Item Name: "+temp.itemName+" Item ID: "+temp.itemId+" Quantity: "+temp.quantity+" Price: "+temp.price);
            temp=temp.next;
        }
    }
}
public class InventoryApp{
    public static void main(String[] args){
        InventoryManagementSystem system=new InventoryManagementSystem();
        system.addItemAtEnd("Laptop",101,50,50000);
        system.addItemAtEnd("Phone",102,100,20000);
        system.addItemAtEnd("Tablet",103,30,30000);
        system.addItemAtBeginning("Smartwatch",104,150,5000);
        system.addItemAtPosition(3,"Headphones",105,75,1500);
        system.displayInventory();
        system.removeItemById(102);
        system.displayInventory();
        system.updateItemQuantity(103,50);
        system.displayInventory();
        Item item=system.searchItemByIdOrName(101,"Smartwatch");
        if(item!=null) System.out.println("Item Found: Item Name: "+item.itemName+" Item ID: "+item.itemId+" Quantity: "+item.quantity+" Price: "+item.price);
        System.out.println("Total Inventory Value: "+system.calculateTotalValue());
        system.sortInventoryByNameAscending();
        system.displayInventory();
        system.sortInventoryByPriceAscending();
        system.displayInventory();
    }
}
