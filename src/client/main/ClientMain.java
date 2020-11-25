package client.main;

import java.util.Scanner;

/**
 * Classe  ClientMain
 *
 *  -> démarre l'application côté client
 *
 * @see Form
 * @see Dashboard
 */
public class ClientMain {
  private static Scanner keyboard;

  public static final String HOST = "127.0.0.1";
  public static final int PORT = 2345;

  private static final int FORM_MODE = 1;
  private static final int DASHBOARD_MODE = 2;
  private static final int QUIT = 3;

  private static final String CHOOSE_STR = "Bienvenue sur le DashBoard Covid!\n\nVeuillez sélectionner un mode :\n1. Étudiant : accès au formulaire\n2. Professeur : accès au tableau de bord\n3. Quitter";
  private static final String INPUT_ERROR_MODE_STR = "Saisie incorrecte, vous devez saisir 1 ou 2 pour le choix du mode.\n";

  /**
   * Après inititalisation, on attend la saisie du mode par le client avant de lancer l'affichage en conséquence ou de quitter l'application
   * @param args
   */
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
      case QUIT: {
        System.exit(0);
      }
    }
  }

  /**
   * Initialisation du clavier pour l'ensemble des saisies
   */
  private static void init() {
    keyboard = new Scanner(System.in);
  }

  /**
   * Méthode pour la saisie et le contrôle de cette sernière pour obtenir le mode su client
   * @return (int) le mode sélectionné par l'utilisateur
   */
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
        case FORM_MODE:
        case QUIT:{
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
    Dashboard dashboard = new Dashboard();
    dashboard.askServer();
  }

  private static void print(String message) {
    System.out.println(message);
  }
}
