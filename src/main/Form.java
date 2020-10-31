package main;

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

    print(currentStudent.getLogin());
    print(currentStudent.getFirstName());
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

  public void printForm() {

  }


  /* =================================================
      UTILITY SERVICES
   ================================================ */

  private  void print(String message) {
    System.out.println(message);
  }
}
