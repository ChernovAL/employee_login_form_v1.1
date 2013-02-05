package com.in6k.employee.persistense;

import com.in6k.employee.persistense.Identifier;

import java.io.IOException;

public interface DataProvider {
    void save(Identifier model) throws IOException;
}
