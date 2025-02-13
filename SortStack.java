import java.util.Stack;
public class SortStack {
    public static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insertInSortedOrder(stack, temp);
        }
    }
    public static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}