package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String key = line.split(" ")[0];
                String value = line.split(" ")[1];
                switch (key) {
                    case "Name:":
                        profile.setName(value);
                        break;
                    case "Age:":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email:":
                        profile.setEmail(value);
                        break;
                    case "Phone:":
                        profile.setPhone(Long.parseLong(value));
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }
}
