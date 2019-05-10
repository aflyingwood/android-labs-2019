package edu.hzuapps.androidlabs.soft171408902126;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Button2activity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button2);
        Button button=(Button)findViewById(R.id.send);
        editText=(EditText)findViewById(R.id.input_message);
        button.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.send:
                    String inputText=editText.getText().toString();
                    Toast.makeText(Button2activity.this,"已收到，请稍等！",Toast.LENGTH_SHORT).show();
                    break;
                    default:
                        break;
            }

    }
}
