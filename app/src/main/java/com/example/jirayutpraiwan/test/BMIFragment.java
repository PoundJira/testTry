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
import android.widget.TextView;
import android.widget.Toast;

public class BMIFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bmi, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initCalculateBtn();
    }

    void initCalculateBtn() {
        Button _calculateBtn = (Button) getView().findViewById(R.id.bmi_calculate_btn);
        _calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _height = (EditText) getView().findViewById(R.id.bmi_height);
                EditText _weight = (EditText) getView().findViewById(R.id.bmi_weight);

                String _heightStr = _height.getText().toString();
                String _weightStr = _weight.getText().toString();

                Float _heightFloat = Float.parseFloat(_heightStr);
                Float _weightFloat = Float.parseFloat(_weightStr);

                if(_heightStr.isEmpty() || _weightStr.isEmpty()){
                    Toast.makeText(
                            getActivity(),
                            "PLEASE FILL ALL INFORMATOIN",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("BMI", "SHOULD FILL ANY INFORMATION");
                }
                else {
                    Float bmi_value = _weightFloat/((_heightFloat/100)*(_heightFloat/100));
                    TextView bmi_label = (TextView) getView().findViewById(R.id.bmi_value);
                    bmi_label.setText(bmi_value.toString());
                    Log.d("BMI", "BMI VALUE IS SUCCESSFUL");
                }
            }
        });
    }
}
