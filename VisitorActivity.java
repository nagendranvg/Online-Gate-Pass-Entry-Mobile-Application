package info.androidhive.barcodereader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VisitorActivity extends AppCompatActivity {
Button maa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);
        maa=(Button)findViewById(R.id.sub_button);
        maa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maai=new Intent(VisitorActivity.this,LogoutActivity.class);
                startActivity(maai);
            }
        });
    }
}
