package model;

public enum State {
  PRESENT(1, true, true, "présent"),
  POSITIVE(2, false, false, "positif-ve"),
  POSITIVE_CAMPUS(3, false, true, "positif-ve"),
  CONTACT_CASE(4, false, false, "cas contact"),
  CONTACT_CASE_CAMPUS(5, false, true, "cas contact"),
  PREVENTION(6, false, false, "prévention"),
  PREVENTION_CAMPUS(7, false, true, "prévention"),
  SICK(8, false, false, "malade"),
  SICK_CAMPUS(9, false, true, "malade"),
  PRO(10, false, false, "professionnel"),
  PRO_CAMPUS(11, false, true, "professionnel");

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

  public State changeOnCampus() {
    switch (this) {
      case POSITIVE: return POSITIVE_CAMPUS;
      case PREVENTION: return PREVENTION_CAMPUS;
      case CONTACT_CASE: return CONTACT_CASE_CAMPUS;
      case SICK: return SICK_CAMPUS;
      case PRO: return PRO_CAMPUS;
    }
    return null;
  }
}
