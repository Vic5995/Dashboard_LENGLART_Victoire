package utils;

import model.Student;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;

public class StudentJSONConverter {
  Student student;
  String jsonStudent;

  public StudentJSONConverter(Student student) throws IOException {
    this.student = student;

    JSONObject obj = new JSONObject();

    obj.put("id", student.getId());
    obj.put("login", student.getLogin());
    obj.put("lastName", student.getLastName());
    obj.put("firstName", student.getFirstName());
    obj.put("password", student.getPassword());
    obj.put("promotion", student.getPromotion());
    obj.put("state", (new StateJSONConverter(student.getState())).getJsonState());
    obj.put("comment", student.getComment());

    StringWriter out = new StringWriter();
    obj.writeJSONString(out);

    this.jsonStudent = out.toString();
  }

  public StudentJSONConverter(String jsonStudent) throws ParseException {
    this.jsonStudent = jsonStudent;

    JSONParser parser = new JSONParser();
    this.student = (Student)parser.parse(jsonStudent);
  }

  public Student getStudent() {
    return student;
  }

  public String getJsonStudent() {
    return jsonStudent;
  }
}
