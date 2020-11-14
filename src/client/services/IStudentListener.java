package client.services;

import model.Student;

public interface IStudentListener {

  void onReceivedStudent(Student student);

  void onStudentSaved(boolean saved);
}
