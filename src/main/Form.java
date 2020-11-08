package main;

import model.State;
import model.Student;
import server.ServerServices;

import java.util.Scanner;

public class Form {
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
    currentStudent = ServerServices.authentification(login, password);
    //WARNING null safety?
    printForm();
  }

  /* =================================================
      FORM
   ================================================ */

  private final String FORM_START_STR = "Veuillez remplir les informations suivantes :";
  private final String INPUT_PRESENT_ABS_STR = "Êtes-vous présent(e) ou absent(e) ? \n1. Présent(e)\n2. Absent(e)";
  private final String INPUT_ABS_REASON_STR = "Pour quel motif êtes-vous absent? \n" +
    "1. COVID\n2. Cas Contact COVID\n3. En attente de test ou de résultats de test COVID\n4. Malade autre\n5. Motif professionel";
  private final String INPUT_CAMPUS_STR = "Êtes-vous sur ou hors campus?\n1. Sur le Campus\n2. Hors campus";
  private final String COMMENT_STR = "Voulez-vous ajouter un commentaire à votre situation (si non, appuyez sur Entrée) ?";
  private  final String INPUT_ERROR_MODE_STR = "Saisie incorrecte";

  public void printForm() {
    print(FORM_START_STR);
    print(INPUT_PRESENT_ABS_STR);
    //WARNING null safety?
    State state = askPresentAbs();
    print(state.getState());
  }

  private State askPresentAbs() {
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

  private State askAbsReason() {
    print(INPUT_ABS_REASON_STR);
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


  /* =================================================
      UTILITY SERVICES
   ================================================ */

  private void print(String message) {
    System.out.println(message);
  }
}
