package main;

import java.util.Scanner;

public class Launch {
  private static Scanner keyboard;

  private static final int DASHBOARD_MODE = 1;
  private static final int FORM_MODE = 2;

  private static final String CHOOSE_STR = "Bienvenue sur le DashBoard Covid!\n\nVeuillez sélectionner un mode :\n1. Étudiant : accès au formulaire\n2. Professeur : accès au tableau de bord";
  private static final String INPUT_ERROR_MODE_STR = "Saisie incorrecte, vous devez saisir 1 ou 2 pour le choix du mode.\n";

  public static void main(String[] args) {
    init();
    int selectedMode = getMode();
    print("" + selectedMode);
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



  private static void print(String message) {
    System.out.println(message);
  }
}
