package com.in6k.employee.persistense;

public class ProviderFactory {
    public enum ProviderType { XML, DB }

    public static DataProvider create(ProviderType type) {
        if (type == ProviderType.XML) return new XmlProvider();
        if (type == ProviderType.DB) return new DbProvider();

        return null;
    }
}
