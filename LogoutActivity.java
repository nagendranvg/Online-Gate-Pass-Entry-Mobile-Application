package info.androidhive.barcodereader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogoutActivity extends AppCompatActivity {
Button lout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        lout=(Button)findViewById(R.id.logout_button);
        lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loout=new Intent(LogoutActivity.this,MainActivity.class);
                startActivity(loout);
            }
        });
    }
}
