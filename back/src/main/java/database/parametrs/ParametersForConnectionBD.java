package database.parametrs;

import org.springframework.beans.factory.annotation.Autowired;

public class ParametersForConnectionBD {
    private String user;
    private String password;
    private String url;
    private String port;

    public ParametersForConnectionBD() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "ParametersForConnectionBD{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
