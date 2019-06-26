package com.charactersheet;

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
}
