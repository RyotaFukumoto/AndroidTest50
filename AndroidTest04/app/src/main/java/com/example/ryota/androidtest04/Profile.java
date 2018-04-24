package com.example.ryota.androidtest04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Account account1 = new Account("太郎",25,"男性","Swift");
        Account account2 = new Account("花子",24,"女性","java");

        ProfileOutPut(account1);
        ProfileOutPut(account2);

    }


    
    public void ProfileOutPut(Account account) {
            switch (account.getSex()){
                case "男性":
                    Log.i("Profile1", account.getName() +" 君は、" +
                            account.getLanguage() + " が得意な " + account.getAge() + " 歳です。");
                    break;

                case "女性":
                    Log.i("Profile2", account.getName() +" さんは、" +
                            account.getLanguage() + " が得意な " + account.getAge() + " 歳です。");
                    break;
                default:
                    Log.i ("Profile3","全て入力してくだい。");
            }

    }
}