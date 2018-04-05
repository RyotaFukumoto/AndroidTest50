package com.example.ryota.androidtest04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;



public class Test04 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Profile profile1 = new Profile("太郎",25,"男性","Swift");
        Profile profile2 = new Profile("花子",24,"女性","java");
        profileOutput(profile1);
        profileOutput(profile2);




    }

    private void profileOutput(Profile profile){
        switch (profile.getSex()){
            case "男性":
                Log.i("Profile1",profile.getName() +" 君は、" +
                        profile.getLanguage() + " が得意な " + profile.getAge() + " 歳です。");
                break;

            case "女性":
                Log.i("Profile2",profile.getName() +" さんは、" +
                        profile.getLanguage() + " が得意な " + profile.getAge() + " 歳です。");
                break;
            default:
                Log.i ("Profile3","全て入力してくだい。");
        }
    }
}
