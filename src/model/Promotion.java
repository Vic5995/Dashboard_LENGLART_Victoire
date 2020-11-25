package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Promotion implements Serializable {
  public static final int FILA1 = 1;
  public static final int FILA2 = 2;
  public static final int FILA3 = 3;
  public static final int FITA1 = 4;
  public static final int FISEA1 = 5;
  public static final int FISEA2 = 6;
  public static final int FISEA3 = 7;

  private int id;
  private List<Student> students;

  public Promotion(List<Student> students) {
    this.students = students;
  }

  public Promotion(int id, List<Student> students) {
    this.id = id;
    this.students = students;
  }

  public Promotion(int id) {
    this.id = id;
    this.students = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public boolean add(Student student) {
    return this.students.add(student);
  }

  public boolean addAll(List<Student> students) {
    return this.students.addAll(students);
  }

  public boolean remove(Student student) {
    return this.students.remove(student);
  }

  public boolean removeAll(List<Student> students) {
    return this.students.removeAll(students);
  }

  public boolean contains(Student student) {
    return this.students.contains(student);
  }

}
