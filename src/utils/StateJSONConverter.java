package utils;

import model.State;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;

public class StateJSONConverter {
  private State state;
  private String jsonState;

  public StateJSONConverter(State state) throws IOException {
    this.state = state;

    JSONObject obj = new JSONObject();

    obj.put("id", state.getId());
    obj.put("present", state.isPresent());
    obj.put("onCampus", state.isOnCampus());
    obj.put("state", state.getState());

    StringWriter out = new StringWriter();
    obj.writeJSONString(out);

    this.jsonState = out.toString();
  }

  public StateJSONConverter(String jsonState) throws ParseException {
    this.jsonState = jsonState;

    JSONParser parser = new JSONParser();
    this.state = (State) parser.parse(jsonState);
  }

  public State getState() {
    return state;
  }

  public String getJsonState() {
    return jsonState;
  }
}
