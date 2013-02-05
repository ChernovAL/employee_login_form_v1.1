package com.in6k.employee.form;

import java.util.ArrayList;
import java.util.List;

public class EmployeeForm {
    private String name;
    private String surname;
    private String birthday;
    private String email;
    private String password;
    private String password_confirm;

    private static final String VALID_NAME = "[a-zA-Z]{2,}";
    private static final String VALID_SURNAME = "[a-zA-Z]{2,}";
    private static final String VALID_EMAIL = "^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$";
    private static final String VALID_PASSWORD = "[a-zA-Zа-яА-Я0-9]{1,}";
    private static final String VALID_BIRTHDAY = "^[0-9]+-[0-9]+-[0-9]+$";

    private List validateErrors = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }

    public EmployeeForm() {
    }

    public EmployeeForm(String name, String surname, String birthday, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }

    public List validate() {
        String error;

        if(!isNameValidate()) {
            error = "Name is not valid.";
            validateErrors.add(error);
        }

        if(!isSurnameValidate()) {
            error = "Surname is not valid.";
            validateErrors.add(error);
        }

        if(!isBirthdayValidate()) {
            error = "Birthday is not valid.";
            validateErrors.add(error);
        }

        if(!isEmailValidate()) {
            error = "Email is not valid.";
            validateErrors.add(error);
        }

        if(!isPasswordValidate()) {
            error = "Password is not valid.";
            validateErrors.add(error);
        }

        if(!isPasswordAndConfirmEquals()) {
            error = "Password and password confirm not equals.";
            validateErrors.add(error);
        }

        return this.validateErrors;
    }

    private boolean isNameValidate() {
        return this.name.matches(VALID_NAME);
    }

    private boolean isSurnameValidate() {
        return this.surname.matches(VALID_SURNAME);
    }

    private boolean isBirthdayValidate() {
        return this.birthday.matches(VALID_BIRTHDAY);
    }

    private boolean isEmailValidate() {
        return this.email.matches(VALID_EMAIL);
    }

    private boolean isPasswordValidate() {
        return this.password.matches(VALID_PASSWORD);
    }

    private boolean isConfirmValidate() {
        return this.password_confirm.matches(VALID_PASSWORD);
    }

    private boolean isPasswordAndConfirmEquals() {
        boolean result = false;
        boolean passwordAndConfirmIsValid = isPasswordValidate() && isConfirmValidate();

        if(passwordAndConfirmIsValid) {
            result = this.password.equals(this.password_confirm) ? true: false;
        }

        return result;
    }
}