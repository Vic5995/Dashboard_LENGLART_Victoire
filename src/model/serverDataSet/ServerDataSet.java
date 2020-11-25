package model.serverDataSet;

import java.io.Serializable;

/**
 * Classe : ServerDataSet
 *
 *  -> permet la récupération des données statistiques depuis le serveur
 */
public class ServerDataSet implements Serializable {

  private int generalTotal;

  /* =================================================
      GENERAL STATE
   ================================================ */

  private int generalPresent;
  private int generalPositive;
  private int generalOther;
  private int generalCampus;

  private int generalContactCase;
  private int generalPrevention;
  private int generalSick;
  private int generalPro;

  public ServerDataSet() {}

  public int getGeneralTotal() {
    return generalTotal;
  }

  public void setGeneralTotal(int generalTotal) {
    this.generalTotal = generalTotal;
  }

  public int getGeneralPresent() {
    return generalPresent;
  }

  public void setGeneralPresent(int generalPresent) {
    this.generalPresent = generalPresent;
  }

  public int getGeneralPositive() {
    return generalPositive;
  }

  public void setGeneralPositive(int generalPositive) {
    this.generalPositive = generalPositive;
  }

  public int getGeneralOther() {
    return generalOther;
  }

  public void setGeneralOther(int generalOther) {
    this.generalOther = generalOther;
  }

  public int getGeneralCampus() {
    return generalCampus;
  }

  public void setGeneralCampus(int generalCampus) {
    this.generalCampus = generalCampus;
  }

  public int getGeneralContactCase() {
    return generalContactCase;
  }

  public void setGeneralContactCase(int generalContactCase) {
    this.generalContactCase = generalContactCase;
  }

  public int getGeneralPrevention() {
    return generalPrevention;
  }

  public void setGeneralPrevention(int generalPrevention) {
    this.generalPrevention = generalPrevention;
  }

  public int getGeneralSick() {
    return generalSick;
  }

  public void setGeneralSick(int generalSick) {
    this.generalSick = generalSick;
  }

  public int getGeneralPro() {
    return generalPro;
  }

  public void setGeneralPro(int generalPro) {
    this.generalPro = generalPro;
  }

  /* =================================================
      PROMOTIONS STATES
   ================================================ */
  private int totalFIL;
  private int presentFIL;
  private int covidFIL;
  private int otherFIL;

  private int totalFIT;
  private int presentFIT;
  private int covidFIT;
  private int otherFIT;

  private int totalFISE;
  private int presentFISE;
  private int covidFISE;
  private int otherFISE;

  public int getTotalFIL() {
    return totalFIL;
  }

  public void setTotalFIL(int totalFIL) {
    this.totalFIL = totalFIL;
  }

  public int getPresentFIL() {
    return presentFIL;
  }

  public void setPresentFIL(int presentFIL) {
    this.presentFIL = presentFIL;
  }

  public int getCovidFIL() {
    return covidFIL;
  }

  public void setCovidFIL(int covidFIL) {
    this.covidFIL = covidFIL;
  }

  public int getOtherFIL() {
    return otherFIL;
  }

  public void setOtherFIL(int otherFIL) {
    this.otherFIL = otherFIL;
  }

  public int getTotalFIT() {
    return totalFIT;
  }

  public void setTotalFIT(int totalFIT) {
    this.totalFIT = totalFIT;
  }

  public int getPresentFIT() {
    return presentFIT;
  }

  public void setPresentFIT(int presentFIT) {
    this.presentFIT = presentFIT;
  }

  public int getCovidFIT() {
    return covidFIT;
  }

  public void setCovidFIT(int covidFIT) {
    this.covidFIT = covidFIT;
  }

  public int getOtherFIT() {
    return otherFIT;
  }

  public void setOtherFIT(int otherFIT) {
    this.otherFIT = otherFIT;
  }

  public int getTotalFISE() {
    return totalFISE;
  }

  public void setTotalFISE(int totalFISE) {
    this.totalFISE = totalFISE;
  }

  public int getPresentFISE() {
    return presentFISE;
  }

  public void setPresentFISE(int presentFISE) {
    this.presentFISE = presentFISE;
  }

  public int getCovidFISE() {
    return covidFISE;
  }

  public void setCovidFISE(int covidFISE) {
    this.covidFISE = covidFISE;
  }

  public int getOtherFISE() {
    return otherFISE;
  }

  public void setOtherFISE(int otherFISE) {
    this.otherFISE = otherFISE;
  }
}

