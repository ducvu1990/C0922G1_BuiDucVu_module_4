package com.example.program_to_store_email_configuration.repository;

import com.example.program_to_store_email_configuration.model.Settings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class SettingsRepository {
    static Map<String,Settings> settings = new HashMap<>();
    static {
        Settings settings1 = new Settings("English",10,true,"hello");
        Settings settings2 = new Settings("Vietnamese",5,false,"xin chao");
        Settings settings3 = new Settings("Japanese",25,true,"conichiwa");
        Settings settings4 = new Settings("Chinese",100,false,"xin chao");
        settings.put("a@codegym.vn",settings1);
        settings.put("c@codegym.vn",settings2);
        settings.put("d@codegym.vn",settings3);
        settings.put("b@codegym.vn",settings4);
    }
    public List<String> finAllEmail(){
        return new ArrayList<>(settings.keySet());
    }
    public Settings finSetting(String key){
        Settings settings1 = null;
        for (Map.Entry<String, Settings> entry : settings.entrySet()) {
            if (entry.getKey().equals(key)){
                settings1 = entry.getValue();
                return settings1;
            }
        }
        return null;
    }
    public void update(Settings setting, String email){
        for (Map.Entry<String, Settings> entry :settings.entrySet()) {
            if (entry.getKey().equals(email)){
                entry.setValue(setting);
            }
        }
    }

}
