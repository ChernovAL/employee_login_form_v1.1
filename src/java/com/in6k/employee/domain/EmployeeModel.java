package com.in6k.employee.domain;

import com.in6k.employee.form.EmployeeForm;
import com.in6k.employee.persistense.Identifier;
import com.in6k.employee.persistense.ProviderFactory;

import java.io.IOException;

public class EmployeeModel implements Identifier {
    private String name;
    private String surname;
    private String birthday;
    private String email;
    private String password;

    private ProviderFactory.ProviderType providerType;

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

    public ProviderFactory.ProviderType getProviderType() {
        return providerType;
    }

    public void setProviderType(ProviderFactory.ProviderType providerType) {
        this.providerType = providerType;
    }

    public EmployeeModel(EmployeeForm employeeForm, ProviderFactory.ProviderType providerType) {
        this.name = employeeForm.getName();
        this.surname = employeeForm.getSurname();
        this.birthday = employeeForm.getBirthday();
        this.email = employeeForm.getEmail();
        this.password = employeeForm.getPassword();

        this.providerType = providerType;
    }

    public EmployeeModel() {
    }

    public void save() throws IOException {
        ProviderFactory.create(providerType).save(this);
    }

    @Override
    public String getIdentifier() {
        return this.name;
    }
}
