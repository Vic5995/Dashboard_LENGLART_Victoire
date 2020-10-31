package model;

public enum State {
  PRESENT(1, true, true, "présent"),
  CONTACT_CASE(2, false, false, "cas contact"),
  CONTACT_CASE_CAMPUS(3, false, true, "cas contact"),
  PREVENTION(4, false, false, "prévention"),
  PREVENTION_CAMPUS(5, false, true, "prévention"),
  POSITIVE(6, false, false, "positif-ve"),
  POSITIVE_CAMPUS(7, false, true, "positif-ve"),
  SICK(8, false, false, "malade"),
  SICK_CAMPUS(9, false, true, "malade");

  private final int id;
  private final boolean present;
  private final boolean onCampus;
  private final String state;

  State(int id, boolean present, boolean onCampus, String state) {
    this.id = id;
    this.present = present;
    this.onCampus = onCampus;
    this.state = state;
  }

  public int getId() {
    return id;
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
