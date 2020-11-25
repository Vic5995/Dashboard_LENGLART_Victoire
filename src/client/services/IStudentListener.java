package client.services;

import model.Student;

/**
 * Interface : IStudentListener
 *
 *  -> permet de signaler au formulaire la réception et l'envoie de nouvelles données pour qu'il puisse générer son affichage
 *
 * @see client.main.Form
 */
public interface IStudentListener {

  void onReceivedStudent(Student student, String serverResponse);

  void onStudentSaved(boolean saved);
}
