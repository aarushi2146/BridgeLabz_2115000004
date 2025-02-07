interface Worker {
    void performDuties();
}
class Person {
    private String name;
    private int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
class Chef extends Person implements Worker {
    private String specialty;
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public void performDuties() {
        System.out.println("Chef " + getName() + " is preparing dishes in the kitchen. Specialty: " + specialty);
    }
}
class Waiter extends Person implements Worker {
    private String section;
    public Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }
    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public void performDuties() {
        System.out.println("Waiter " + getName() + " is serving customers in section " + section);
    }
}
public class RestrauntMain {
    public static void main(String[] args) {
        Chef chef = new Chef("Aarushi", 101, "Indian");
        Waiter waiter = new Waiter("Priya", 102, "A");
        chef.performDuties();
        waiter.performDuties();
    }
}
