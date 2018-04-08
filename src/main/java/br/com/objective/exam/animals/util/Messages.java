package br.com.objective.exam.animals.util;

import static java.text.MessageFormat.format;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Messages {

    private static final Messages INSTANCE = new Messages();

    private ResourceBundle resourceBundle;

    private Messages() {
        resourceBundle = ResourceBundle.getBundle("languages/lang");
    }

    public static Messages getInstance() {
        return INSTANCE;
    }

    public String getMessage(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
    
    public String getMessage(String key, Object... values) {
        try {
            return format(resourceBundle.getString(key), values);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

}