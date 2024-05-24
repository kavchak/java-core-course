package javaCourse.homework.lesson3;

public class MyArrayListMain {

    public static void main(String[] args) {
        MyList arrayList = new MyArrayList();
        System.out.println(arrayList);

        arrayList.add(0, "element 1");
        arrayList.add(1, "element 2");
        System.out.println(arrayList);

        arrayList.remove(0);
        System.out.println(arrayList);

        arrayList.set(0, "new element");
        System.out.println(arrayList);

        String element = arrayList.get(0);
        System.out.println("Element at index 0: " + element);

        System.out.println(arrayList);
    }
}