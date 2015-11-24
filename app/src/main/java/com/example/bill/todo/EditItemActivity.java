package com.example.bill.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {
    int mPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        String item = getIntent().getStringExtra("item");
        this.mPos = getIntent().getIntExtra("pos", 0);
        EditText etItem = (EditText) findViewById(R.id.etItem);
        etItem.setText(item, TextView.BufferType.EDITABLE);
    }

    public void onSubmit(View v) {
        // closes the activity and returns to main screen
        // Prepare data intent
        EditText etItem = (EditText) findViewById(R.id.etItem);
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("pos", this.mPos);
        data.putExtra("item", etItem.getText().toString());
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        this.finish();
    }
}
