package files;

import interfaces.ValidData;

import java.util.regex.Pattern;

public class ValidDataFromFile implements ValidData {
    public ValidDataFromFile() {
    }

    public int validate(String text) {
        String[] words = text.split(",");
        if (words.length != 4) {
            return -1;
        } else {
            switch (words[0]) {
                case "bus":
                    if (this.isValidString(words[1], "^[A-Z]{0,5}[0-9]{1,3}$")
                            && this.isValidString(words[2], "^[A-Za-z\\d\\s]{1,30}$")
                            && this.isValidString(words[3], "^[0-9]{1,6}$")) {
                        return 1;
                    }

                    return 0;
                case "user":
                    if (this.isValidString(words[1], "^[a-zA-Z0-9_.-]{3,16}$")
                            && this.isValidString(words[2], "^[a-zA-Z0-9_.-]{8,}$")
                            && this.isValidString(words[3], "^[A-Za-z0-9+_.-]+@(.+)$")) {
                        return 1;
                    }

                    return 0;
                case "student":
                    if (this.isValidString(words[1], "^[A-Z0-9]{3,8}$")
                            && this.isValidString(words[2], "^([2-5]?\\.[0-9]{1,2})$")
                            && this.isValidString(words[3], "^[0-9]{1,6}$")) {
                        return 1;
                    }

                    return 0;
                default:
                    return -2;
            }
        }
    }

    private boolean isValidString(String checkString, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(checkString).matches();
    }
}