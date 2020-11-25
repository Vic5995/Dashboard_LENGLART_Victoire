package model.serverDataSet;

import java.io.Serializable;

/**
  * Classe : FISEDataSet
  *
  *  -> permet la récupération des données statistiques depuis le serveur
  */
public class FISEDataSet implements Serializable {

  public FISEDataSet() {
  }

  private int totalFISEA1;
  private int presentFISEA1;
  private int covidFISEA1;
  private int otherFISEA1;
  private int totalFISEA2;
  private int presentFISEA2;
  private int covidFISEA2;
  private int otherFISEA2;
  private int totalFISEA3;
  private int presentFISEA3;
  private int covidFISEA3;
  private int otherFISEA3;

  public int getTotalFISEA1() {
    return totalFISEA1;
  }

  public void setTotalFISEA1(int totalFISEA1) {
    this.totalFISEA1 = totalFISEA1;
  }

  public int getPresentFISEA1() {
    return presentFISEA1;
  }

  public void setPresentFISEA1(int presentFISEA1) {
    this.presentFISEA1 = presentFISEA1;
  }

  public int getCovidFISEA1() {
    return covidFISEA1;
  }

  public void setCovidFISEA1(int covidFISEA1) {
    this.covidFISEA1 = covidFISEA1;
  }

  public int getOtherFISEA1() {
    return otherFISEA1;
  }

  public void setOtherFISEA1(int otherFISEA1) {
    this.otherFISEA1 = otherFISEA1;
  }

  public int getTotalFISEA2() {
    return totalFISEA2;
  }

  public void setTotalFISEA2(int totalFISEA2) {
    this.totalFISEA2 = totalFISEA2;
  }

  public int getPresentFISEA2() {
    return presentFISEA2;
  }

  public void setPresentFISEA2(int presentFISEA2) {
    this.presentFISEA2 = presentFISEA2;
  }

  public int getCovidFISEA2() {
    return covidFISEA2;
  }

  public void setCovidFISEA2(int covidFISEA2) {
    this.covidFISEA2 = covidFISEA2;
  }

  public int getOtherFISEA2() {
    return otherFISEA2;
  }

  public void setOtherFISEA2(int otherFISEA2) {
    this.otherFISEA2 = otherFISEA2;
  }

  public int getTotalFISEA3() {
    return totalFISEA3;
  }

  public void setTotalFISEA3(int totalFISEA3) {
    this.totalFISEA3 = totalFISEA3;
  }

  public int getPresentFISEA3() {
    return presentFISEA3;
  }

  public void setPresentFISEA3(int presentFISEA3) {
    this.presentFISEA3 = presentFISEA3;
  }

  public int getCovidFISEA3() {
    return covidFISEA3;
  }

  public void setCovidFISEA3(int covidFISEA3) {
    this.covidFISEA3 = covidFISEA3;
  }

  public int getOtherFISEA3() {
    return otherFISEA3;
  }

  public void setOtherFISEA3(int otherFISEA3) {
    this.otherFISEA3 = otherFISEA3;
  }
}
