package com.google.samples.quickstart.signin;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.samples.quickstart.signin.backend.ConnectionManager;
import com.google.samples.quickstart.signin.backend.Data;
import com.google.samples.quickstart.signin.backend.DatabaseHandler;
import com.google.samples.quickstart.signin.backend.ListAdapter;

import org.json.JSONException;

import java.util.List;

/**
 * Created by NILESH on 02-12-2015.
 */
public class TabFragment3 extends Fragment {
    DatabaseHandler dbHandler;
    ListView list;
    SwipeRefreshLayout swipeRefreshLayout;
    ConnectionManager con;
    Context context;
    ListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.listview, container, false);
        list = (ListView) rootview.findViewById(R.id.listView);
        dbHandler = new DatabaseHandler(getActivity());
        swipeRefreshLayout = (SwipeRefreshLayout) rootview.findViewById(R.id.swipe_refresh_layout);
        con = new ConnectionManager(getActivity(), swipeRefreshLayout, list, "2", null);
        context = getActivity();
        final List<Data> workshopList = dbHandler.getDatabyType("2");
        Log.d("TAG", "workshop");
        if (workshopList != null) {
            Log.d("TAG", "workshop-2");
            adapter = new ListAdapter(getActivity(), -1, workshopList);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.d("TAG", "Clicked-" + i);
                    //ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), view.findViewById(R.id.image), "Test_Image");
                    //Intent intent = new Intent(getActivity(), WorkshopDetails.class);
                    //intent.putExtra("Test_Image",(String)view.getTag());
                    //intent.putExtra("position",i);
                    //Bundle bundle = workshopList.get(i).getAsBundle();
                    // intent.putExtras(bundle);
                    //ActivityCompat.startActivity(getActivity(),intent,options.toBundle());
                    //startActivity(intent);
                }
            });

            swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) getActivity());
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    onRun();
                }
            });
        }
        return rootview;
    }
    public void onRefresh() {
        onRun();
    }
    public void onRun(){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(isConnected)
        {
            try {
                con.getDatabaseUpdate(dbHandler.getVersion());

            } catch (JSONException e) {
                e.printStackTrace();
            }}
        else
        {
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(context, "Please Connect To The Internet", Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }
}
