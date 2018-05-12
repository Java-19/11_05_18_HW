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
public class EmailFragment extends Fragment implements View.OnClickListener {

    private EditText inputEmail;
    private Button backBtn, nextBtn;

    private EmailFragmentListener listener;

    public EmailFragment() {
        // Required empty public constructor
    }

    public void setEmailFragmentListener(EmailFragmentListener listener){
        this.listener = listener;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof EmailFragmentListener){
            listener = (EmailFragmentListener) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputEmail = view.findViewById(R.id.inputEmail);
        backBtn = view.findViewById(R.id.backBtn);
        nextBtn = view.findViewById(R.id.nextBtn);

        backBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backBtn && listener!= null){
            listener.onEmailBackClick();
        }else if(v.getId() == R.id.nextBtn && listener!= null){
            listener.onEmailNext(inputEmail.getText().toString());
        }
    }

    interface EmailFragmentListener{
        void onEmailBackClick();
        void onEmailNext(String email);
    }

}
