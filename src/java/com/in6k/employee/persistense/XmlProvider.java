package com.in6k.employee.persistense;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlProvider implements DataProvider{

    protected String path = "/home/alexandr/test";

    public XmlProvider(String path) {
        this.path = path;
    }

    public XmlProvider() {
    }

    @Override
    public void save(Identifier identifier) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + identifier.getIdentifier() + ".xml");
            try {
                XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
                try {
                    xmlEncoder.writeObject(identifier);
                    xmlEncoder.flush();
                } finally {
                    xmlEncoder.close();
                }
            } finally {
                fileOutputStream.close();
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
}
