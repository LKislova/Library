package library.validator;

import java.util.Date;

/**
 * Created by trainee on 03.12.14.
 */
public class LibraryValidator {
    public boolean validateText(String name, int maxSize) {
        if ((name.isEmpty()) || (name.length() > maxSize)) {
            return true;
        }
        return false;
    }

    public boolean validateDate(Date date, Date maxValue) {
        if ((date.after(maxValue))) {
            return true;
        }
        return false;
    }

    public boolean validateNumber(Integer number, Integer maxValue, Integer minValue) {
        if ((number > maxValue) || (number < minValue) || (number == null)) {
            return true;
        }
        return false;
    }
}


