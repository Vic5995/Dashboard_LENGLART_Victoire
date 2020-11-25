package client.main;

import client.services.IDataSetListener;
import client.services.ServerServices;
import model.ServerDataSet;

import java.util.Scanner;

public class Dashboard implements IDataSetListener {
  private Scanner keyboard;
  private ServerDataSet _dataSet;

  public Dashboard() {
    keyboard = new Scanner(System.in);
  }

  public void askServer() {
    ServerServices.getGeneralDataSet(this);
  }

  /* =================================================
      DISPLAY
   ================================================ */
  private  final String INPUT_ERROR_MODE_STR = "Saisie incorrecte";

  private final String NAV_1 = "Action suivante : 1. Détails absents autres. 2. Affichage par promotion. 3. Quitter";
  private final String NAV_2 = "Action suivante : 1. Retour. 2.Quitter";

  private final String GENERAL_STATE = "État général de la promotion : ";
  private final String GENERAL_PRESENT = "Étudiants présents : ";
  private final String GENERAL_COVID = "Absents covid : ";
  private final String GENERAL_OTHER = "Absents autres : ";
  private final String GENERAL_ON_CAMPUS = "Étudiants sur le campus : ";
  private final String GENERAL_OUT_CAMPUS = "Étudiants hors campus : ";

  private final String GENERAL_CONTACT_CASE = "Cas contact : ";
  private final String GENERAL_PREVENTION = "Prévention : ";
  private final String GENERAL_SICK = "Malade : ";
  private final String GENERAL_PRO = "Professionnel : ";

  public void displayGeneralState(ServerDataSet dataSet) {
    this._dataSet = dataSet;
    print(GENERAL_STATE);
    print(GENERAL_PRESENT + writePercentage((double)dataSet.getGeneralPresent() / (double)dataSet.getGeneralTotal()));
    print(GENERAL_COVID + writePercentage((double)dataSet.getGeneralPositive() / (double)dataSet.getGeneralTotal()));
    print(GENERAL_OTHER + writePercentage((double)dataSet.getGeneralOther() / (double)dataSet.getGeneralTotal()));
    print("");
    print(GENERAL_ON_CAMPUS + writePercentage((double)dataSet.getGeneralCampus() / (double)dataSet.getGeneralTotal()));
    print(GENERAL_OUT_CAMPUS + writePercentage(1 - (double)dataSet.getGeneralCampus() / (double)dataSet.getGeneralTotal()));
    print(NAV_1);
    readNav1();
  }

  public void displayGeneralDetails() {
    print(GENERAL_STATE);
    print(GENERAL_PRESENT + writePercentage((double)_dataSet.getGeneralPresent() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_COVID + writePercentage((double)_dataSet.getGeneralPositive() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_CONTACT_CASE + writePercentage((double)_dataSet.getGeneralContactCase() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_PREVENTION + writePercentage((double)_dataSet.getGeneralPrevention() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_SICK + writePercentage((double)_dataSet.getGeneralSick() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_PRO + writePercentage((double)_dataSet.getGeneralPro() / (double)_dataSet.getGeneralTotal()));
    print("");
    print(GENERAL_ON_CAMPUS + writePercentage((double)_dataSet.getGeneralCampus() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_OUT_CAMPUS + writePercentage(1 - (double)_dataSet.getGeneralCampus() / (double)_dataSet.getGeneralTotal()));
    print(NAV_2);
    readNav2();
  }

  public void displaysPromotions() {

  }

  @Override
  public void onReceivedGeneralDataSet(ServerDataSet dataSet) {
    displayGeneralState(dataSet);
  }

  /* =================================================
      CAPTURE SERVICES
   ================================================ */

  public void readNav1() {
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
          displayGeneralDetails();
          break;
        }
        case 2 : {
          displaysPromotions();
          break;
        }
        case 3 : {
          ClientMain.main(null);
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
  }

  public void readNav2() {
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
          displayGeneralState(_dataSet);
          break;
        }
        case 2 : {
          System.exit(0);
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

  private String writePercentage(double value) {
    StringBuilder percent = new StringBuilder();
    double newPercent = value * 20;
    for (int i = 0 ; i < 20 ; i++) {
      if (i < newPercent) {
        percent.append("◼︎");
      } else {
        percent.append("◻︎");
      }
    }
    percent.append(" ").append(String.format("%.2f",value * 100)).append("%");
    return percent.toString();
  }
}
