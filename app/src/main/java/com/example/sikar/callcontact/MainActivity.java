package com.example.sikar.callcontact;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //1.Save existing state
        super.onCreate(savedInstanceState);
        //2. Set Content View
        setContentView(R.layout.activity_main);
        //3. Set
        final EditText phoneNumber = (EditText)findViewById(R.id.contact);

        Button callButton = (Button)findViewById(R.id.call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNoString = phoneNumber.getText().toString();
                Intent dialContact = new Intent(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:"+phoneNoString);
                dialContact.setData(uri);
                startActivity(dialContact);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
