package codechallange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        people.add(new Person("Vijay", "Patil", "India", 26));
        String[] string = {"firstName", "country","age"};
        sort(people, string);


    }


    static void sort(List<Person> personList, String[] sortBy) {
        Comparator<Person> personComparator = Comparator.comparing(Person::toString);
        for (String sort : sortBy) {
            if (sort.equalsIgnoreCase("firstName")) {
                personComparator = personComparator.thenComparing(Comparator.comparing(Person::getFirstName));
            }
            if (sort.equalsIgnoreCase("lastName")) {
                personComparator = personComparator.thenComparing(Comparator.comparing(Person::getFirstName));
            }
            if (sort.equalsIgnoreCase("age")) {
                personComparator = personComparator.thenComparing(Comparator.comparing(Person::getAge));
            }
            if (sort.equalsIgnoreCase("country")) {
                personComparator = personComparator.thenComparing(Comparator.comparing(Person::getCountry));
            }
        }
        personList = personList.stream().sorted(personComparator).collect(Collectors.toList());
        personList.forEach(person -> System.out.println(person));
    }

}

class Person implements Comparable<Person> {

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

    @Override
    public int compareTo(Person person) {
        return 0;
    }
}

