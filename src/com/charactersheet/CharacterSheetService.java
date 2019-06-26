package com.charactersheet;

import java.io.*;
import java.nio.file.Files;

public class CharacterSheetService {
    private CharacterModel characterModel;
    private com.google.gson.Gson gson;

    public CharacterSheetService(CharacterModel characterModel) {
        this.characterModel = characterModel;
    }

    public String createJSON() {
        return gson.toJson(characterModel);
    }

    public CharacterModel loadFromJSON(String strJson) {
        CharacterModel outputCharacterModel = gson.fromJson(strJson, CharacterModel.class);
        return outputCharacterModel;
    }

    public void saveToFile(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("writing to file");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(File file) {
        String test = new String();
        try {
            test = Files.readString( file.toPath() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(test);
    }
}
