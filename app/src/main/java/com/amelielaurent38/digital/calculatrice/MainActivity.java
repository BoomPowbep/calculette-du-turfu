package com.amelielaurent38.digital.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {

        TextView result = findViewById(R.id.tv_result);

        if (!(v instanceof Button)) {
            return;
        }

        if (v.getTag() == null) {
            return;
        }

        String tag = v.getTag().toString();

        Button button = (Button) v;
        switch (tag) {
            case "OP":
                result.setText("");
                break;

            case "NB":
                result.append(button.getText());
                break;
            default:
                break;
        }


    }
}
