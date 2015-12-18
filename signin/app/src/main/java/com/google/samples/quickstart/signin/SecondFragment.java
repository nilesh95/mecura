package com.google.samples.quickstart.signin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * Created by NILESH on 01-12-2015.
 */
public class SecondFragment extends Fragment {
    SearchView search,search1,search2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search, container, false);
        search=(SearchView) view.findViewById(R.id.searchView1);
        search.setQueryHint("Area");
        search1=(SearchView) view.findViewById(R.id.searchView2);
        search1.setQueryHint("Specilization");
        search2=(SearchView) view.findViewById(R.id.searchView3);
        search2.setQueryHint("State");
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

                 //Toast.makeText( ((AppCompatActivity)getActivity()).getBaseContext(), String.valueOf(hasFocus),
                // Toast.LENGTH_SHORT).show();
            }
        });

        //*** setOnQueryTextListener ***
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                Toast.makeText(((AppCompatActivity) getActivity()).getBaseContext(), query,
                        Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub

                //	Toast.makeText(getBaseContext(), newText,
                //Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        search1.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

                //Toast.makeText( ((AppCompatActivity)getActivity()).getBaseContext(), String.valueOf(hasFocus),
                       // Toast.LENGTH_SHORT).show();
            }
        });

        //*** setOnQueryTextListener ***
        search1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                Toast.makeText(((AppCompatActivity)getActivity()).getBaseContext(), query,
                        Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub

                //	Toast.makeText(getBaseContext(), newText,
                //Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        search2.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

                //Toast.makeText( ((AppCompatActivity)getActivity()).getBaseContext(), String.valueOf(hasFocus),
                       // Toast.LENGTH_SHORT).show();
            }
        });

        //*** setOnQueryTextListener ***
        search2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                Toast.makeText(((AppCompatActivity)getActivity()).getBaseContext(), query,
                        Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub

                //	Toast.makeText(getBaseContext(), newText,
                //Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return view;
    }
}
