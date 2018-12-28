package com.example.user.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import static com.example.user.listview.ListActivity.usersData;

public class FilterItems extends AppCompatActivity {

    private CheckBox usa, india, france;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_items);

    }



    @Override
    public void onBackPressed() {
        usa = (CheckBox) findViewById(R.id.usa);
        india = (CheckBox) findViewById(R.id.india);
        france = (CheckBox) findViewById(R.id.france);

        Intent intent = new Intent();
        intent.putExtra("usa", usa.isChecked());
        intent.putExtra("india", india.isChecked());
        intent.putExtra("france", france.isChecked());
        setResult(RESULT_OK, intent);
        finish();

    }


}
