package com.erickogi14gmail.class2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kimani kogi on 4/9/2017.
 */

public class PrefrenceManager {
    int PRIVATE_MODE = 0;

    private  static final  String myprefrence="MYPREFRENCE";

    public boolean writePref(Context context, String name,String admno, String school, String department, String year, String semister, String email, String password, boolean registeredStatus){
        boolean success=false;
        try {
            SharedPreferences settings = context.getSharedPreferences(myprefrence, PRIVATE_MODE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("keyname", name);
            editor.putString("keyadmno", admno);
            editor.putString("keyschool", school);
            editor.putString("keydepartment", department);
            editor.putString("keyyear", year);
            editor.putString("keysemister", semister);
            editor.putString("keyemail", email);
            editor.putString("keypassword", password);
            editor.putBoolean("keystatus", registeredStatus);


            editor.commit();
            success=true;
        }
        catch (Exception n){

        }
        return success;

    }

        public String[] getDetails(Context context){
            String details[]=new String[8];

            SharedPreferences settings  = context.getSharedPreferences(myprefrence, PRIVATE_MODE);


            details[0]=  settings.getString("keyname","null");
            details[1]=  settings.getString("keyadmno","null");
            details[2]=  settings.getString("keyschool","null");
            details[3]=  settings.getString("keydepartment","null");
            details[4]=  settings.getString("keyyear","null");
            details[5]=  settings.getString("keysemister","null");
            details[6]=  settings.getString("keyemail","null");
            details[7]=  settings.getString("keypassword","null");




            return  details;


        }

        public  boolean getRedistrationStatus(Context context){

                SharedPreferences settings=  context.getSharedPreferences(myprefrence, PRIVATE_MODE);

                boolean status=settings.getBoolean("keystatus",false);
                return  status;


        }


}
