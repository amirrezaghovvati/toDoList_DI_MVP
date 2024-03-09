package com.example.ce_todolistmvp.Model.shared;

import android.content.Context;
import android.content.SharedPreferences;

public class SignUpAuth {
    private SharedPreferences sharedPreferences;
    public SignUpAuth(Context context){
        sharedPreferences=context.getSharedPreferences("sharedMain",Context.MODE_PRIVATE);
    }
    public void saveName(String name){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",name);
        editor.apply();
    }
    public String getUserName(){
        return sharedPreferences.getString("name","");
    }
    public void saveProfileRes(int res){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("res",res);
        editor.apply();
    }
    public int getProfileRes(){
        return sharedPreferences.getInt("res",0);
    }
    public void clearAuthentication(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    public void updateUserProfile(String name,int res){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",name);
        editor.putInt("res",res);
        editor.apply();
    }
}
