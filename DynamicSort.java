package codechallange;

import java.util.*;
import java.util.stream.Collectors;

public class DynamicSort {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Vijay", "Patil", "India", 28));
        people.add(new Person("Akash", "Jain", "India", 30));
        people.add(new Person("Arjun", "Ekkad", "India", 28));
        people.add(new Person("Tejas", "Sumbha", "India", 27));
        people.add(new Person("Anand", "Sarda", "India", 27));
        people.add(new Person("Aditya", "Gupta", "India", 28));
        people.add(new Person("Vijay", "Patil", "US", 28));
        people.add(new Person("Vijay", "Patil", "UK", 28));
        people.add(new Person("Pratik", "Patil", "India", 28));
        people.add(new Person("Vijay", "Anask", "India", 26));
        String[] string = {"firstName", "country","lastName"};
        sort(people, string);


    }


    static void sort(List<Person> personList, String[] sortBy) {
        Comparator<Person> personComparator = getComparator(sortBy[0]);

        for (int i = 1; i < sortBy.length; i++) {
            personComparator = personComparator.thenComparing(getComparator(sortBy[i]));
        }
        personList = personList.stream().sorted(personComparator).collect(Collectors.toList());
        personList.forEach(person -> System.out.println(person));
    }

    private static Map<String, Comparator> stringComparatorMap = new HashMap<>();

    static {
        stringComparatorMap.put("firstName", Comparator.comparing(Person::getFirstName));
        stringComparatorMap.put("lastName", Comparator.comparing(Person::getLastName));
        stringComparatorMap.put("age", Comparator.comparing(Person::getAge));
        stringComparatorMap.put("country", Comparator.comparing(Person::getCountry));
    }

    private static Comparator getComparator(String byType) {
        return stringComparatorMap.get(byType);
    }

}

class Person {

    String firstName;
    String lastName;
    String country;
    int age;

    public Person(String firstName, String lastName, String country, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + country + "|" + age;
    }

}

