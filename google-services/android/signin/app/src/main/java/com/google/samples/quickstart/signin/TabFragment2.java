package com.google.samples.quickstart.signin;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by NILESH on 02-12-2015.
 */
public class TabFragment2 extends Fragment {
    String vast;
    EditText tx, kiloE, pituusE, ikaE;
    TextView counter;
    Spinner spin;
    String gender="Male";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter = (TextView) view.findViewById(R.id.textView6);

                //Creating a spinner and adding two items to it.
                spin = (Spinner) view.findViewById(R.id.spinner1);

                ArrayAdapter<CharSequence> adapter;
                adapter = ArrayAdapter.createFromResource(
                        getActivity(), R.array.gender, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(adapter);
                spin.setOnItemSelectedListener(new SpinnerListener());


                int kilo = 0, pituus = 0, ika = 0, vastaus = 0;
                String test1, test2, test3;
                kiloE = (EditText) view.findViewById(R.id.editText1);
                ikaE = (EditText) view.findViewById(R.id.EditText01);
                pituusE = (EditText) view.findViewById(R.id.EditText02);
                test1 =  kiloE.getText().toString();
                test2 =ikaE.getText().toString();
                test3 = pituusE.getText().toString();

                try {
                    if (test1!="" && test2!="" && test3!="") {
                        kiloE = (EditText) view.findViewById(R.id.editText1);
                        kilo = Integer.parseInt(kiloE.getText().toString().trim());
                        ikaE = (EditText) view.findViewById(R.id.EditText01);
                        ika = Integer.parseInt(ikaE.getText().toString().trim());
                        pituusE = (EditText) view.findViewById(R.id.EditText02);
                        pituus = Integer.parseInt(pituusE.getText().toString().trim());

                        if (gender.contains("Male"))
                            vastaus = (int) Math.round(1.2 * (66 + (13.7 * kilo) + (5 * pituus) - (6.8 * ika)));

                        if (gender.contains("Female"))
                            vastaus = (int) Math.round(1.2 * (655 + (9.6 * kilo) + (1.8 * pituus) - (4.7 * ika)));

                       vast = String.valueOf(vastaus + " kcal/day");
                        counter.setText(String.valueOf("-" +  vast));
                    }
                } catch (Exception e) {
                    vast = String.valueOf(vastaus + " kcal/day");
                    counter.setText(String.valueOf("-" +  gender));
                    System.out.println(e);
                }

            }

        });


        return view;
    }
    //spinner listener for values male and female
    public class SpinnerListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            gender = parent.getItemAtPosition(pos).toString();
        }



        public void onItemSelected1(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

        }

        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }


    }

}
