package com.example.jirayutpraiwan.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRegisterBtn();
    }

    void initRegisterBtn() {
        Button _registerBtn = (Button) getView().findViewById(R.id.register_register_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _user = (EditText) getView().findViewById(R.id.register_user);
                EditText _name = (EditText)getView().findViewById(R.id.register_name);
                EditText _age = (EditText)getView().findViewById(R.id.register_age);
                EditText _password = (EditText)getView().findViewById(R.id.register_password);

                String _userStr = _user.getText().toString();
                String _nameStr = _name.getText().toString();
                String _ageStr = _age.getText().toString();
                String _passwordStr = _password.getText().toString();
                if(_userStr.isEmpty() || _nameStr.isEmpty() || _ageStr.isEmpty() || _passwordStr.isEmpty()){
                    Toast.makeText(
                            getActivity(),
                            "Please fill all the Blank",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER","PLEASE FILL ALL INFORMATION");
                }
                else if (_userStr.equals("admin")){
                    Toast.makeText(
                            getActivity(),
                            "This user is already",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER","USER IS ALREADY");
                }
                else{
                    Log.d("REGISTER","GO TO BMI");
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new BMIFragment()).commit();
                }
            }
        });
    }
}
