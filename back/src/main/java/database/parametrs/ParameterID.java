package database.parametrs;

public class ParameterID {
    private String id;

    public ParameterID() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ParameterID{" +
                "id='" + id + '\'' +
                '}';
    }
}
