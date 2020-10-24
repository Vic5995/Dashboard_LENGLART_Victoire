package model;

public enum State {
  PRESENT(true, true, "présent"),
  CONTACT_CASE(false, false, "cas contact"),
  CONTACT_CASE_CAMPUS(false, true, "cas contact"),
  PREVENTION(false, false, "prévention"),
  PREVENTION_CAMPUS(false, true, "prévention"),
  POSITIVE(false, false, "positif-ve"),
  POSITIVE_CAMPUS(false, true, "positif-ve"),
  SICK(false, false, "malade"),
  SICK_CAMPUS(false, true, "malade");

  private final boolean present;
  private final boolean onCampus;
  private final String state;

  State(boolean present, boolean onCampus, String state) {
    this.present = present;
    this.onCampus = onCampus;
    this.state = state;
  }

  public boolean isPresent() {
    return present;
  }

  public boolean isOnCampus() {
    return onCampus;
  }

  public String getState() {
    return state;
  }
}
