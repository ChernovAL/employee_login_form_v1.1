package com.in6k.employee;

public class Employee {
    public String name;
    public String surname;
    public String birthday;
    public String email;
    public String password;

    public Employee() {
    }

    public Employee(String name, String surname, String birthday, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }

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
}
