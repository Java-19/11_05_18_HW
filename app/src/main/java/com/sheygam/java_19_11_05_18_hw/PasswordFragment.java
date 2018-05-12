package com.sheygam.java_19_11_05_18_hw;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class PasswordFragment extends Fragment implements View.OnClickListener {
    private EditText inputPassword;
    private Button okBtn, backBtn;

    private PasswordFragmentListener listener;


    public PasswordFragment() {
        // Required empty public constructor
    }




    public void setPasswordFragmentListener(PasswordFragmentListener listener){
        this.listener = listener;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof PasswordFragmentListener){
            listener = (PasswordFragmentListener) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputPassword = view.findViewById(R.id.inputPassword);
        okBtn = view.findViewById(R.id.okBtn);
        backBtn = view.findViewById(R.id.backBtn);

        okBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backBtn && listener!= null){
            listener.onBackPasswordClick();
        }else if(v.getId() == R.id.okBtn && listener!= null){
            listener.onOkPasswordClick(inputPassword.getText().toString());
        }
    }

    interface PasswordFragmentListener{
        void onOkPasswordClick(String password);
        void onBackPasswordClick();
    }

}
