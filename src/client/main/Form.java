package client.main;

import client.services.IStudentListener;
import client.services.ServerServices;
import model.State;
import model.Student;

import java.util.Scanner;

/**
 * Classe Form
 *
 *  -> Son rôle est la saisie et l'envoi d'une saisie d'un étudiant sur sa situation
 *
 * @see Dashboard
 * @see ClientMain
 * @see ServerServices
 */
public class Form implements IStudentListener {
  private final String AUTHENTIFICATION_STR = "Veuillez vous identifiez :";
  private final String LOGIN_STR = "Login : ";
  private final String PASSWORD_STR = "Mot de passe : ";

  private final String NAV_FINAL = "Action suivante : 1.Deconnexion.";

  private Scanner keyboard;
  private Student currentStudent;

  public Form() {
    keyboard = new Scanner(System.in);
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
    State state = readPresentAbs();
    String comment = readComment();
    if (comment.equals("0")) comment = null;
    sendStudent(state, comment);
  }

  /* =================================================
      SERVER COMMUNICATION

      -> appels et envois au serveur
      -> pour le formulaire, on ne met à jour l'étudiant qu'une fois la saisie complète
   ================================================ */

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
      print("");
      print(student.toString());
      if (student.getState().isOnCampus()) {
        print("SUR CAMPUS");
      } else {
        print("HORS CAMPUS");
      }
      printForm();
    } else {
      print(serverResponse);
    }
  }

  @Override
  public void onStudentSaved(boolean saved) {
    if (saved) {
      print("Mise à jour effectuée");
      print("");
      print(currentStudent.toString());
      if (currentStudent.getState().isOnCampus()) {
        print("SUR CAMPUS");
      } else {
        print("HORS CAMPUS");
      }
      print("");
      print(NAV_FINAL);
      readNavFinal();
    } else {
      print("Erreur de sauvegarde");
    }
  }

  private void sendStudent(State newState, String comment) {
    currentStudent.setState(newState);
    currentStudent.setComment(comment);
    ServerServices.saveStudent(currentStudent, this);
  }

  /* =================================================
      CAPTURE SERVICES

      -> lecture des réponses pour les différents questionnaires utilisés
      -> chaque réponse met à jour l'étudiant courant
   ================================================ */

  private State readPresentAbs() {
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
          finalState = readAbsReason();
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

  private State readAbsReason() {
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
          finalState = readOnCampus(State.POSITIVE);
          break;
        }
        case 2 : {
          finalState = readOnCampus(State.CONTACT_CASE);
          break;
        }
        case 3 : {
          finalState = readOnCampus(State.PREVENTION);
          break;
        }
        case 4 : {
          finalState = readOnCampus(State.SICK);
          break;
        }
        case 5 : {
          finalState = readOnCampus(State.PRO);
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

  private State readOnCampus(State state) {
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

  private String readComment() {
    print(COMMENT_STR);
    keyboard.next();
    return keyboard.nextLine();
  }

  private void readNavFinal() {
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
          ClientMain.main(null);
          break;
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
  }

  /* =================================================
      UTILITY SERVICES
   ================================================ */

  private void print(String message) {
    System.out.println(message);
  }
}
