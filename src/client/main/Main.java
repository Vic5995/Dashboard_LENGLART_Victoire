package client.main;

import java.util.Scanner;

public class Main {
  private static Scanner keyboard;

  public static final String HOST = "127.0.0.1";
  public static final int PORT = 2345;

  private static final int FORM_MODE = 1;
  private static final int DASHBOARD_MODE = 2;

  private static final String CHOOSE_STR = "Bienvenue sur le DashBoard Covid!\n\nVeuillez sélectionner un mode :\n1. Étudiant : accès au formulaire\n2. Professeur : accès au tableau de bord";
  private static final String INPUT_ERROR_MODE_STR = "Saisie incorrecte, vous devez saisir 1 ou 2 pour le choix du mode.\n";

  public static void main(String[] args) {
    init();
    int selectedMode = getMode();
    switch (selectedMode) {
      case FORM_MODE : {
        launchForm();
        break;
      }
      case DASHBOARD_MODE : {
        launchDashboard();
        break;
      }
    }
  }

  private static void init() {
    keyboard = new Scanner(System.in);
  }

  private static int getMode() {
    int selectedMode = 0;
    boolean inputAccepted = false;
    print(CHOOSE_STR);
    while (!inputAccepted){
      while (!keyboard.hasNextInt()) {
        print(INPUT_ERROR_MODE_STR);
        keyboard.next();
      }
      selectedMode = keyboard.nextInt();
      switch (selectedMode) {
        case DASHBOARD_MODE :
        case FORM_MODE: {
          inputAccepted = true;
          break;
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
    return selectedMode;
  }

  private static void launchForm() {
    Form form = new Form();
    form.authentification();
  }

  private static void launchDashboard() {
    print("not implmentd yet");
  }

  private static void print(String message) {
    System.out.println(message);
  }
}
