package model.serverDataSet;

import java.io.Serializable;

public class FITDataSet implements Serializable {

  public FITDataSet() {
  }

  private int totalFITA1;
  private int presentFITA1;
  private int covidFITA1;
  private int otherFITA1;

  public int getTotalFITA1() {
    return totalFITA1;
  }

  public void setTotalFITA1(int totalFITA1) {
    this.totalFITA1 = totalFITA1;
  }

  public int getPresentFITA1() {
    return presentFITA1;
  }

  public void setPresentFITA1(int presentFITA1) {
    this.presentFITA1 = presentFITA1;
  }

  public int getCovidFITA1() {
    return covidFITA1;
  }

  public void setCovidFITA1(int covidFITA1) {
    this.covidFITA1 = covidFITA1;
  }

  public int getOtherFITA1() {
    return otherFITA1;
  }

  public void setOtherFITA1(int otherFITA1) {
    this.otherFITA1 = otherFITA1;
  }
}
