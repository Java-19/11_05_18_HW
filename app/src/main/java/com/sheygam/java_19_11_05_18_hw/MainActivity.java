package com.sheygam.java_19_11_05_18_hw;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginFragmentListener, EmailFragment.EmailFragmentListener, PasswordFragment.PasswordFragmentListener {
    private String email = "";
    private String password = "";
    private LoginFragment loginFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginFragment = new LoginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.root,loginFragment)
                .commit();
    }

    @Override
    public void onLoginClicked() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root, new EmailFragment())
                .addToBackStack("EMAIL")
                .commit();
    }

    @Override
    public void onEmailBackClick() {
        email = "";
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onEmailNext(String email) {
        this.email = email;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root,new PasswordFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onOkPasswordClick(String password) {
        this.password = password;
        loginFragment.changeData(this.email,this.password);
        getSupportFragmentManager().popBackStack("EMAIL", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onBackPasswordClick() {
        password = "";
        getSupportFragmentManager().popBackStack();
    }
}
