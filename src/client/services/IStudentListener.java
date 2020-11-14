package client.services;

import model.Student;

public interface IStudentListener {

  void onReceivedStudent(Student student, String serverResponse);

  void onStudentSaved(boolean saved);
}
