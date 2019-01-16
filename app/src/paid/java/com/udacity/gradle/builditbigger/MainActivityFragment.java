package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button btnTellJoke = root.findViewById(R.id.btnTellJoke);

        btnTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EndpointsAsyncTask task = new EndpointsAsyncTask();
                task.setContract(new CallbackAsyncTask() {
                    @Override
                    public void getResult(String result) {
                        AndroidLibActivity.startActivity(getActivity(), result);
                    }
                });
                task.execute();
            }
        });
        return root;
    }
}
