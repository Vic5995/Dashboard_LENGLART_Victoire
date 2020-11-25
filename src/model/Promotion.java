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


  public Promotion(int id) {
    this.id = id;
    this.students = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void add(Student student) {
    this.students.add(student);
  }

  public void removeAll(List<Student> students) {
    this.students.removeAll(students);
  }

}
