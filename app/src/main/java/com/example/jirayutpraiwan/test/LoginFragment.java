package com.example.jirayutpraiwan.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container,false);
    }
    public void onActivityCreated(
            @Nullable Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);

        initLoginBtn();
        initRegisterBtn();

    }

    void initLoginBtn() {
         Button _loginBtn =(Button) getView().findViewById(R.id.login_loin_btn);
         _loginBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 EditText _user = (EditText) getView().findViewById(R.id.login_user);
                 EditText _password = (EditText) getView().findViewById(R.id.login_password);

                 String _userStr = _user.getText().toString();
                 String _passwordStr = _password.getText().toString();
                 if(_userStr.isEmpty() || _passwordStr.isEmpty()){
                     Toast.makeText(
                             getActivity(),
                             "Please fill User ans Password",
                             Toast.LENGTH_SHORT
                     ).show();
                     Log.d("USER", "USER OR PASSWORD IS EMPTY");
                 }
                 else if (_userStr.equals("admin") && _passwordStr.equals("admin")){
                     Log.d("USER","GO TO BMI");
                     getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new BMIFragment()).commit();
                 }
                 else {
                     Toast.makeText(
                             getActivity(),
                             "Incorrect User or Password",
                             Toast.LENGTH_SHORT
                     ).show();
                     Log.d("USER", "INCORRECT UESR OR PASSWORD");
                 }
             }
         });
    }
    void initRegisterBtn() {
        TextView _registerBtn = (TextView) getView().findViewById(R.id.login_regiester_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new RegisterFragment())
                        .commit();
            }
        });
    }
}
