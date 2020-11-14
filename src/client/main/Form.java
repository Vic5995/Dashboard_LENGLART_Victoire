package client.main;

import model.State;
import model.Student;
import client.services.IStudentListener;
import client.services.ServerServices;

import java.util.Scanner;

public class Form implements IStudentListener {
  private final String AUTHENTIFICATION_STR = "Veuillez vous identifiez :";
  private final String LOGIN_STR = "Login : ";
  private final String PASSWORD_STR = "Mot de passe : ";

  private  Scanner keyboard;
  private Student currentStudent;

  public Form() {
    keyboard = new Scanner(System.in);
  }

  public void authentification() {
    print(AUTHENTIFICATION_STR);
    print(LOGIN_STR);
    String login = keyboard.nextLine();
    print(PASSWORD_STR);
    String password = keyboard.nextLine();
    ServerServices.authentification(login, password, this);
  }

  @Override
  public void onReceivedStudent(Student student, String serverResponse) {
    if (student != null) {
      currentStudent = student;
      print(student.getLogin());
      printForm();
    } else {
      print(serverResponse);
    }
  }

  @Override
  public void onStudentSaved(boolean saved) {
    if (saved) {
      print("Mise à jour effectuée");
    } else {
      print("Erreur de sauvegarde");
    }
  }

  /* =================================================
      FORM
   ================================================ */

  private final String FORM_START_STR = "Veuillez remplir les informations suivantes :";
  private final String INPUT_PRESENT_ABS_STR = "Êtes-vous présent(e) ou absent(e) ? \n1. Présent(e)\n2. Absent(e)";
  private final String INPUT_ABS_REASON_STR = "Pour quel motif êtes-vous absent? \n" +
    "1. COVID\n2. Cas Contact COVID\n3. En attente de test ou de résultats de test COVID\n4. Malade autre\n5. Motif professionel";
  private final String INPUT_CAMPUS_STR = "Êtes-vous sur ou hors campus?\n1. Sur le Campus\n2. Hors campus";
  private final String COMMENT_STR = "Voulez-vous ajouter un commentaire à votre situation (si non, appuyez sur 0 et Entrée) ?";
  private  final String INPUT_ERROR_MODE_STR = "Saisie incorrecte";

  public void printForm() {
    print(FORM_START_STR);
    print(INPUT_PRESENT_ABS_STR);
    State state = askPresentAbs();
    String comment = askComment();
    if (comment.equals("0")) comment = null;
    sendStudent(state, comment);
  }

  private State askPresentAbs() {
    State finalState = currentStudent.getState();
    boolean inputAccepted = false;
    int selectedState;
    while (!inputAccepted) {
      while (!keyboard.hasNextInt()) {
        print(INPUT_ERROR_MODE_STR);
        keyboard.next();
      }
      selectedState = keyboard.nextInt();
      inputAccepted = true;
      switch (selectedState) {
        case 1 : {
          finalState = State.PRESENT;
          break;
        }
        case 2 : {
          finalState = askAbsReason();
          break;
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
    return finalState;
  }

  /**
   * Permet de spécifier la raison de l'absence.
   * @return
   */
  private State askAbsReason() {
    print(INPUT_ABS_REASON_STR);
    State finalState = currentStudent.getState(); //on met l'état actuel comme état de départ pour éviter les NPE
    boolean inputAccepted = false;
    int selectedState;
    while (!inputAccepted) {
      while (!keyboard.hasNextInt()) {
        print(INPUT_ERROR_MODE_STR);
        keyboard.next();
      }
      selectedState = keyboard.nextInt();
      inputAccepted = true;
      switch (selectedState) {
        case 1 : {
          finalState = askOnCampus(State.POSITIVE);
          break;
        }
        case 2 : {
          finalState = askOnCampus(State.CONTACT_CASE);
          break;
        }
        case 3 : {
          finalState = askOnCampus(State.PREVENTION);
          break;
        }
        case 4 : {
          finalState = askOnCampus(State.SICK);
          break;
        }
        case 5 : {
          finalState = askOnCampus(State.PRO);
          break;
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
    return finalState;
  }

  private State askOnCampus(State state) {
    print(INPUT_CAMPUS_STR);
    State finalState = null;
    boolean inputAccepted = false;
    int selectedState;
    while (!inputAccepted) {
      while (!keyboard.hasNextInt()) {
        print(INPUT_ERROR_MODE_STR);
        keyboard.next();
      }
      selectedState = keyboard.nextInt();
      inputAccepted = true;
      switch (selectedState) {
        case 1 : {
          finalState = state.changeOnCampus();
          break;
        }
        case 2 : {
          finalState = state;
          break;
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
    return finalState;
  }

  private String askComment() {
    print(COMMENT_STR);
    keyboard.next();
    return keyboard.nextLine();
  }

  private void sendStudent(State newState, String comment) {
    currentStudent.setState(newState);
    currentStudent.setComment(comment);
    ServerServices.saveStudent(currentStudent, this);
  }

  /* =================================================
      UTILITY SERVICES
   ================================================ */

  private void print(String message) {
    System.out.println(message);
  }
}
