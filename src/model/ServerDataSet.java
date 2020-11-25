package model;

import java.io.Serializable;

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

  public ServerDataSet(int generalTotal, int generalPresent,
                       int generalPositive, int generalOther, int generalCampus,
                       int generalContactCase, int generalPrevention,
                       int generalSick, int generalPro) {
    this.generalTotal = generalTotal;
    this.generalPresent = generalPresent;
    this.generalPositive = generalPositive;
    this.generalOther = generalOther;
    this.generalCampus = generalCampus;
    this.generalContactCase = generalContactCase;
    this.generalPrevention = generalPrevention;
    this.generalSick = generalSick;
    this.generalPro = generalPro;
  }

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

  @Override
  public String toString() {
    return "total : " + this.generalTotal + "\ntotal covid : " + this.generalPositive;
  }
}
