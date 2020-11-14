package model;

import java.io.Serializable;

public enum State implements Serializable {
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

  public static State getStateFromId(int id) {
    switch (id) {
      case 1: return PRESENT;
      case 2: return POSITIVE;
      case 3: return POSITIVE_CAMPUS;
      case 4: return CONTACT_CASE;
      case 5: return CONTACT_CASE_CAMPUS;
      case 6: return PREVENTION;
      case 7: return PREVENTION_CAMPUS;
      case 8: return SICK;
      case 9: return SICK_CAMPUS;
      case 10: return PRO;
      case 11: return PRO_CAMPUS;
      default: return PRESENT;
    }
  }
}
