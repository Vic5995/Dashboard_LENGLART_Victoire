package model;

import java.io.Serializable;

public class Student implements Serializable {
  private int id;
  private String login;
  private String lastName;
  private String firstName;
  private String password;
  private int promotion;
  private int englishGroup;
  private State state;
  private String comment;

  public Student(int id, String login, String lastName, String firstName, String password, int promotion, int englishGroup, State state, String comment) {
    this.id = id;
    this.login = login;
    this.lastName = lastName;
    this.firstName = firstName;
    this.password = password;
    this.promotion = promotion;
    this.englishGroup = englishGroup;
    this.state = state;
    this.comment = comment;
  }

  public int getId() {
    return id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPassword() {
    return password;
  }

  public int getPromotion() {
    return promotion;
  }

  public void setPromotion(int promotion) {
    this.promotion = promotion;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public boolean isFIL() {
    return this.promotion == Promotion.FILA1 || this.promotion == Promotion.FILA2 || this.promotion == Promotion.FILA3;
  }

  public  boolean isFIT() {
    return this.promotion == Promotion.FITA1;
  }

  public boolean isFISE() {
    return this.promotion == Promotion.FISEA1 || this.promotion == Promotion.FISEA2 || this.promotion == Promotion.FISEA3;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public int getEnglishGroup() {
    return englishGroup;
  }

  public void setEnglishGroup(int englishGroup) {
    this.englishGroup = englishGroup;
  }

  @Override
  public String toString() {
    return this.id + " | " + this.firstName + " | " + this.lastName + " | " + this.state.getState();
  }
}
