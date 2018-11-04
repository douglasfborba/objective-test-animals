package br.com.objective.exam.animals.util;

import static br.com.objective.exam.animals.util.GlobalConstants.DEFAULT_LANGUAGE;
import static java.text.MessageFormat.format;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * @author Douglas Borba
 * @version 1.0
 *
 */

public final class Messages {

    private static final Messages INSTANCE = new Messages();

    private final ResourceBundle resourceBundle;

    private Messages() {
        resourceBundle = ResourceBundle.getBundle(DEFAULT_LANGUAGE);
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