package javaCourse.homework.lesson4.task1;

public class MyLinkedList implements MyLinkedListInterface {

    private Node head;
    private int size;

    @Override
    public void addFirst(int element) {
        head = new Node(element, head);
        size++;
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        if (index == 0) {
            addFirst(element);
        } else {
            Node prev = node(index - 1);
            prev.next = new Node(element, prev.next);
            size++;
        }
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        return node(index).element;
    }

    @Override
    public void set(int index, int element) {
        checkIndex(index);
        node(index).element = element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = node(index - 1);
            Node toRemove = prev.next;
            prev.next = toRemove.next;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        sb.append("[");
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    }

    private static class Node {
        Integer element;
        Node next;

        Node(Integer element) {
            this.element = element;
            this.next = null;
        }

        Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node node(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}