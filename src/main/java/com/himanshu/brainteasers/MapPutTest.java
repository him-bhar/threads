package com.himanshu.brainteasers;

import java.util.HashMap;
import java.util.Map;

public class MapPutTest {
  public static void main(String[] args) {
    Map<PersonKey, Person> map = new HashMap<PersonKey, Person>();
    Person p1 = new Person();
    p1.setfName("Himanshu");
    p1.setlName("Bhardwaj");

    PersonKey p1Key = new PersonKey();
    p1Key.setName("test");

    Person p2 = new Person();
    p2.setfName("Tester");
    p2.setlName("NotMe");

    PersonKey p2Key = new PersonKey();
    p2Key.setName("test-1");

    map.put(p1Key, p1);
    map.put(p2Key, p2);

    System.out.println(map);

    p2Key.setName("test");
    System.out.println(map);
    System.out.println(map.get(p2Key));
  }

  private static class Person {
    private String fName;
    private String lName;

    public String getfName() {
      return fName;
    }

    public void setfName(String fName) {
      this.fName = fName;
    }

    public String getlName() {
      return lName;
    }

    public void setlName(String lName) {
      this.lName = lName;
    }

    @Override
    public String toString() {
      return "Person{" +
              "fName='" + fName + '\'' +
              ", lName='" + lName + '\'' +
              '}';
    }
  }

  private static class PersonKey {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "PersonKey{" +
              "name='" + name + '\'' +
              '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      PersonKey personKey = (PersonKey) o;

      return name.equals(personKey.name);
    }

    @Override
    public int hashCode() {
      return name.hashCode();
    }
  }
}
