
class Animal{
	String name;
	int age;
	public Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String makeSound(){
		return "some generic animal sound";
	}
}
class Dog extends Animal{
	public Dog(String name, int age) {
        super(name, age);
    }
	public String makeSound() {
        return "Woof! Woof!";
    }
}
class Cat extends Animal{
	public Cat(String name, int age) {
        super(name, age);
    }
	public String makeSound() {
        return "Meow Meow!";
    }
}
class Bird extends Animal{
	public Bird(String name, int age) {
        super(name, age);
    }
	public String makeSound() {
        return "Chirp Chirp!";
    }
}
public class MainAnimal{
	public static void main(String[] args){
		Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);
        Animal[] animals = {dog, cat, bird};
        for (Animal animal : animals) {
            System.out.println(animal.name +" (" + animal.getClass().getSimpleName() + ") is " +animal.age+ " year old and says: " + animal.makeSound());
        }
	}
}


