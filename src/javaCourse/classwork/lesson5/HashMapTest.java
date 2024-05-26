package javaCourse.classwork.lesson5;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {

        HashMap<String, Integer> employees = new HashMap<>();
        employees.put("HR", 20);
        employees.put("DEV", 50);
        employees.put("MANAGEMENT", 10);
        employees.put(null, 1);

        Set<String> deps = employees.keySet();
        System.out.println(deps);

        Collection<Integer> values = employees.values();
        System.out.println(values);

        for (Map.Entry<String, Integer> entry: employees.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(employees.get("HR"));

        Set<String> departments = new HashSet<>();
        departments.add("HR");
        departments.add("DEV");
        departments.add("MANAGEMENT");
        for (String department : departments) {
            System.out.println(department);
        }

        departments.remove("DEV");

        for (String department : departments) {
            System.out.println(department);
        }

        if (departments.contains("DEV")) {
            System.out.println("developers are here");
        } else {
            System.out.println("There are no developers in company");
        }
    }
}
