package model;

public class Student {
  private int id;
  private String login;
  private String lastName;
  private String firstName;
  private String password;
  private int prom;
  private State state;
  private String comment;

  public Student(int id, String login, String lastName, String firstName, String password, int prom, State state, String comment) {
    this.id = id;
    this.login = login;
    this.lastName = lastName;
    this.firstName = firstName;
    this.password = password;
    this.prom = prom;
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

  public int getProm() {
    return prom;
  }

  public void setProm(int prom) {
    this.prom = prom;
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
    return this.prom == Prom.FILA1 || this.prom == Prom.FILA2 || this.prom == Prom.FILA3;
  }

  public  boolean isFIT() {
    return this.prom == Prom.FITA1;
  }

  public boolean isFISE() {
    return this.prom == Prom.FISEA1 || this.prom == Prom.FISEA2 || this.prom == Prom.FISEA3;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }
}
