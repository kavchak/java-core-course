package javaCourse.classwork.lesson4;

import java.util.*;

public class CollectionsTest {

    public static void main(String[] args) {

        // Linked List
        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 19; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);

        // Stack
        Stack<Integer> stack = new Stack<>();

        // add to stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        // Only view, don't remove
        System.out.println(stack.peek());
        System.out.println(stack);

        // Get and remove
        System.out.println(stack.pop());
        System.out.println(stack);

        Queue<String> queue = new PriorityQueue<>();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        queue.add("Four");
        System.out.println(queue);

        System.out.println(queue.element());

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer("One");
        deque.offer("Two");
        deque.offer("Three");
        deque.offer("Four");
        System.out.println(deque);
        System.out.println(deque.poll());
        System.out.println(deque);

        // створити мапу
        Map<String, Integer> map = new HashMap<>();

        // додати в мапу ключ та значення
        map.put("apples", 5);
        map.put("tomatoes", 10);
        System.out.println(map);

        // дістати по ключу
        System.out.println(map.get("apples"));
        System.out.println(map.get("invalid"));

        // перевірити чи є такий ключ
        System.out.println(map.containsKey("tomatoes"));
        System.out.println(map.containsKey("test"));

        // перевірити чи є таке значення
        System.out.println(map.containsValue(10));

        // отримати всі ключі
        Set<String> keys = map.keySet();
        System.out.println("ключі: " + keys);

        // отримати всі значення
        Collection<Integer> values = map.values();
        System.out.println("значення: " + values);

        // ітеруватись по мапі
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

            // видалення по значенню
            if (entry.getValue() == 5) {
                map.remove(entry.getKey());
            }
        }

        System.out.println(map);

        // видалити по ключу
        map.remove("apples");
        System.out.println(map);
    }
}
