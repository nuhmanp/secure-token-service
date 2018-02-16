package de.adorsys.sts.pluginexample;

public class ExampleLoginAdapter {

    public String getSecret(String username, String password) {
        return "my_secret_example_token: (" + username + ":" + password + ")";
    }
}
