package com.example.user.listview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListActivity extends AppCompatActivity  {

    private static final String TAG = "ListActivity";
    private final static int REQUEST_CODE_1 = 1;
    public static PlacesData usersData = new PlacesData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView userRecyclerView = findViewById(R.id.recyclerview_user_list);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter adapter = new ListAdapter();
        DragHelper swipeAndDragHelper = new DragHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(swipeAndDragHelper);
        adapter.setTouchHelper(touchHelper);
        userRecyclerView.setAdapter(adapter);
        touchHelper.attachToRecyclerView(userRecyclerView);

        adapter.setUserList(getData());
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homeoption, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                finish();
                break;
            case R.id.item1:

                Intent localIntent = new Intent(this,FilterItems.class);
                startActivityForResult(localIntent, REQUEST_CODE_1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case REQUEST_CODE_1:
                if(resultCode == RESULT_OK)
                {
                    if(data.getBooleanExtra("usa",false)) {
                        Toast.makeText(getApplicationContext(), "usa checked", Toast.LENGTH_LONG).show();
                    }
                    try {
                        List<Places> usersList = usersData.getUsersList();
                        if (data.getBooleanExtra("usa", false)) {
                            for(int i=usersList.size()-1;i>=0;i--){
                                if (usersList.get(i).getType().equals("United States"))
                                    usersData.deleteUsers(usersList.get(i));
                            }
                        }
                        if (data.getBooleanExtra("india", false)) {
                                for(int i=usersList.size()-1;i>=0;i--){
                                    if (usersList.get(i).getType().equals("India"))
                                        usersData.deleteUsers(usersList.get(i));
                                }
                                                  }
                        if (data.getBooleanExtra("france", false)) {
                            for(int i=usersList.size()-1;i>=0;i--){
                                if (usersList.get(i).getType().equals("France"))
                                    usersData.deleteUsers(usersList.get(i));
                            }
                                                    }
                    }
                    catch (Exception e){

                    }
                    finish();
                    startActivity(getIntent());

                }
        }
    }
    protected List<Places> getData(){

        List<Places> usersList = usersData.getUsersList();
        return usersList;

    }



}
