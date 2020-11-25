package client.main;

import client.services.IDataSetListener;
import client.services.ServerServices;
import model.Promotion;
import model.State;
import model.Student;
import model.serverDataSet.FILDataSet;
import model.serverDataSet.FISEDataSet;
import model.serverDataSet.FITDataSet;
import model.serverDataSet.ServerDataSet;

import java.util.ArrayList;
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
  private final String NAV_3 = "Action suivante :\nDétails : 1. FIL. 2. FIT. 3. FISE.\n4. Retour. 5.Quitter.";
  private final String NAV_FIL = "Action suivante :\nDétails : 1. FIL A1. 2. FIL A2. 3. FIL A3.\n4. Retour. 5.Quitter.";
  private final String NAV_FIT = "Action suivante :\nDétails : 1. FIT A1.\n2. Retour. 3.Quitter.";
  private final String NAV_FISE = "Action suivante :\nDétails : 1. FISE A1. 2. FISE A2. 3. FISE A3.\n4. Retour. 5.Quitter.";
  private final String NAV_ONE_PROMOTION = "Action suivante : 1. Retour. 2.Quitter";

  private final String GENERAL_STATE = "État général de l'ensemble des étudiants : ";
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
    print("");
    print(NAV_1);
    readNav1();
  }

  public void displayGeneralDetails() {
    print(GENERAL_STATE);
    print("");
    print(GENERAL_PRESENT + writePercentage((double)_dataSet.getGeneralPresent() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_COVID + writePercentage((double)_dataSet.getGeneralPositive() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_CONTACT_CASE + writePercentage((double)_dataSet.getGeneralContactCase() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_PREVENTION + writePercentage((double)_dataSet.getGeneralPrevention() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_SICK + writePercentage((double)_dataSet.getGeneralSick() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_PRO + writePercentage((double)_dataSet.getGeneralPro() / (double)_dataSet.getGeneralTotal()));
    print("");
    print(GENERAL_ON_CAMPUS + writePercentage((double)_dataSet.getGeneralCampus() / (double)_dataSet.getGeneralTotal()));
    print(GENERAL_OUT_CAMPUS + writePercentage(1 - (double)_dataSet.getGeneralCampus() / (double)_dataSet.getGeneralTotal()));
    print("");
    print(NAV_2);
    readNav2();
  }

  public void loadPromotionsData() {
    ServerServices.getPromotionsDataSet(this);
  }

  public void displaysPromotions(ServerDataSet dataSet) {
    print("États généraux des promotions :");
    print("");
    print("FIL présents : " + writePercentage((double)dataSet.getPresentFIL() / (double)dataSet.getTotalFIL()));
    print("FIL absents Covid : " + writePercentage((double)dataSet.getCovidFIL() / (double)dataSet.getTotalFIL()));
    print("FIL absents autres : " + writePercentage((double)dataSet.getOtherFIL() / (double)dataSet.getTotalFIL()));
    print("");
    print("FIT présents : " + writePercentage((double)dataSet.getPresentFIT() / (double)dataSet.getTotalFIT()));
    print("FIT absents Covid : " + writePercentage((double)dataSet.getCovidFIT() / (double)dataSet.getTotalFIT()));
    print("FIT absents autres : " + writePercentage((double)dataSet.getOtherFIT() / (double)dataSet.getTotalFIT()));
    print("");
    print("FISE présents : " + writePercentage((double)dataSet.getPresentFISE() / (double)dataSet.getTotalFISE()));
    print("FISE absents Covid : " + writePercentage((double)dataSet.getCovidFISE() / (double)dataSet.getTotalFISE()));
    print("FISE absents autres : " + writePercentage((double)dataSet.getOtherFISE() / (double)dataSet.getTotalFISE()));
    print("");
    print(NAV_3);
    readNav3();
  }

  public void displayFIL(FILDataSet dataSet) {
    print("États généraux des FIL :");
    print("");
    print("A1 présents : " + writePercentage((double)dataSet.getPresentFILA1() / (double)dataSet.getTotalFILA1()));
    print("A1 absents Covid : " + writePercentage((double)dataSet.getCovidFILA1() / (double)dataSet.getTotalFILA1()));
    print("A1 absents autres : " + writePercentage((double)dataSet.getOtherFILA1() / (double)dataSet.getTotalFILA1()));
    print("");
    print("A2 présents : " + writePercentage((double)dataSet.getPresentFILA2() / (double)dataSet.getTotalFILA2()));
    print("A2 absents Covid : " + writePercentage((double)dataSet.getCovidFILA2() / (double)dataSet.getTotalFILA2()));
    print("A2 absents autres : " + writePercentage((double)dataSet.getOtherFILA2() / (double)dataSet.getTotalFILA2()));
    print("");
    print("A3 présents : " + writePercentage((double)dataSet.getPresentFILA3() / (double)dataSet.getTotalFILA3()));
    print("A3 absents Covid : " + writePercentage((double)dataSet.getCovidFILA3() / (double)dataSet.getTotalFILA3()));
    print("A3 absents autres : " + writePercentage((double)dataSet.getOtherFILA3() / (double)dataSet.getTotalFILA3()));
    print("");
    print(NAV_FIL);
    readNavFIL();
  }

  public void displayFIT(FITDataSet dataSet) {
    print("États généraux des FIT :");
    print("");
    print("A1 présents : " + writePercentage((double)dataSet.getPresentFITA1() / (double)dataSet.getTotalFITA1()));
    print("A1 absents Covid : " + writePercentage((double)dataSet.getCovidFITA1() / (double)dataSet.getTotalFITA1()));
    print("A1 absents autres : " + writePercentage((double)dataSet.getOtherFITA1() / (double)dataSet.getTotalFITA1()));
    print("");
    print(NAV_FIT);
    readNavFIT();
  }

  public void displayFISE(FISEDataSet dataSet) {
    print("États généraux des FISE :");
    print("");
    print("A1 présents : " + writePercentage((double)dataSet.getPresentFISEA1() / (double)dataSet.getTotalFISEA1()));
    print("A1 absents Covid : " + writePercentage((double)dataSet.getCovidFISEA1() / (double)dataSet.getTotalFISEA1()));
    print("A1 absents autres : " + writePercentage((double)dataSet.getOtherFISEA1() / (double)dataSet.getTotalFISEA1()));
    print("");
    print("A2 présents : " + writePercentage((double)dataSet.getPresentFISEA2() / (double)dataSet.getTotalFISEA2()));
    print("A2 absents Covid : " + writePercentage((double)dataSet.getCovidFISEA2() / (double)dataSet.getTotalFISEA2()));
    print("A2 absents autres : " + writePercentage((double)dataSet.getOtherFISEA2() / (double)dataSet.getTotalFISEA2()));
    print("");
    print("A3 présents : " + writePercentage((double)dataSet.getPresentFISEA3() / (double)dataSet.getTotalFISEA3()));
    print("A3 absents Covid : " + writePercentage((double)dataSet.getCovidFISEA3() / (double)dataSet.getTotalFISEA3()));
    print("A3 absents autres : " + writePercentage((double)dataSet.getOtherFISEA3() / (double)dataSet.getTotalFISEA3()));
    print("");
    print(NAV_FISE);
    readNavFISE();
  }

  public void displayOnePromotion(Promotion promotion) {
    switch (promotion.getId()) {
      case 1 -> print("État de la promotion FIL A1 :");
      case 2 -> print("État de la promotion FIL A2 :");
      case 3 -> print("État de la promotion FIL A3 :");
      case 4 -> print("État de la promotion FIT A1 :");
      case 5 -> print("État de la promotion FISE A1 :");
      case 6 -> print("État de la promotion FISE A2 :");
      case 7 -> print("État de la promotion FISE A3 :");
    }
    print("");
    ArrayList<Student> tmp = new ArrayList<>();
    print("Présents :");
    for (Student student : promotion.getStudents()) {
      if (student.getState().equals(State.PRESENT)) {
        print(student.toString());
        tmp.add(student);
      }
    }
    print("");
    promotion.removeAll(tmp);
    tmp.clear();
    print("Covid sur Campus :");
    for (Student student : promotion.getStudents()) {
      if (student.getState().equals(State.POSITIVE_CAMPUS)) {
        print(student.toString());
        tmp.add(student);
      }
    }
    print("");
    promotion.removeAll(tmp);
    tmp.clear();
    print("Covid hors Campus :");
    for (Student student : promotion.getStudents()) {
      if (student.getState().equals(State.POSITIVE)) {
        print(student.toString());
        tmp.add(student);
      }
    }
    print("");
    promotion.removeAll(tmp);
    tmp.clear();
    print("Autres sur Campus :");
    for (Student student : promotion.getStudents()) {
      if (student.getState().equals(State.CONTACT_CASE_CAMPUS)
        || student.getState().equals(State.PREVENTION_CAMPUS)
        || student.getState().equals(State.SICK_CAMPUS)
        || student.getState().equals(State.PRO_CAMPUS)) {
        print(student.toString());
        tmp.add(student);
      }
    }
    print("");
    promotion.removeAll(tmp);
    print("Autres hors Campus :");
    for (Student student : promotion.getStudents()) {
      if (student.getState().equals(State.CONTACT_CASE)
        || student.getState().equals(State.PREVENTION)
        || student.getState().equals(State.SICK)
        || student.getState().equals(State.PRO)) {
        print(student.toString());
      }
    }
    print("");
    print(NAV_ONE_PROMOTION);
    readOnePromotion(promotion.getId());
  }

  @Override
  public void onReceivedGeneralDataSet(ServerDataSet dataSet) {
    displayGeneralState(dataSet);
  }

  @Override
  public void onReveivedPromotionsDataSet(ServerDataSet dataSet) {
    displaysPromotions(dataSet);
  }

  @Override
  public void onReceivedFILDataSet(FILDataSet dataSet) {
    displayFIL(dataSet);
  }

  @Override
  public void onReceivedFITDataSet(FITDataSet dataSet) {
    displayFIT(dataSet);
  }

  @Override
  public void onReceivedFISEDataSet(FISEDataSet dataSet) {
    displayFISE(dataSet);
  }

  @Override
  public void onReceivedPromotion(Promotion promotion) {
    displayOnePromotion(promotion);
  }

  /* =================================================
      CAPTURE SERVICES
   ================================================ */

  private void readNav1() {
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
          loadPromotionsData();
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

  private void readNav2() {
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
          askServer();
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

  private void readNav3() {
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
          ServerServices.getFILDataSet(this);
          break;
        }
        case 2 : {
          ServerServices.getFITDataSet(this);
          break;
        }
        case 3 : {
          ServerServices.getFISEDataSet(this);
          break;
        }
        case 4 : {
          askServer();
          break;
        }
        case 5 : {
          System.exit(0);
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
  }

  private void readNavFIL() {
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
          ServerServices.getOnePromotion(this, Promotion.FILA1);
          break;
        }
        case 2 : {
          ServerServices.getOnePromotion(this, Promotion.FILA2);
          break;
        }
        case 3 : {
          ServerServices.getOnePromotion(this, Promotion.FILA3);
          break;
        }
        case 4 : {
          ServerServices.getPromotionsDataSet(this);
          break;
        }
        case 5 : {
          System.exit(0);
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
  }

  private void readNavFIT() {
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
          ServerServices.getOnePromotion(this, Promotion.FITA1);
          break;
        }
        case 2 : {
          ServerServices.getPromotionsDataSet(this);
          break;
        }
        case 3 : {
          System.exit(0);
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
  }

  private void readNavFISE() {
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
          ServerServices.getOnePromotion(this, Promotion.FISEA1);
          break;
        }
        case 2 : {
          ServerServices.getOnePromotion(this, Promotion.FISEA2);
          break;
        }
        case 3 : {
          ServerServices.getOnePromotion(this, Promotion.FISEA3);
          break;
        }
        case 4 : {
          ServerServices.getPromotionsDataSet(this);
          break;
        }
        case 5 : {
          System.exit(0);
        }
        default: {
          inputAccepted = false;
          print(INPUT_ERROR_MODE_STR);
        }
      }
    }
  }

  private void readOnePromotion(int promId) {
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
        case 1 -> {
          if (promId == Promotion.FILA1 || promId == Promotion.FILA2 || promId == Promotion.FILA3) {
            ServerServices.getFILDataSet(this);
          } else if (promId == Promotion.FITA1) {
            ServerServices.getFITDataSet(this);
          } else {
            ServerServices.getFISEDataSet(this);
          }
        }
        case 2 -> {
          System.exit(0);
        }
        default -> {
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
