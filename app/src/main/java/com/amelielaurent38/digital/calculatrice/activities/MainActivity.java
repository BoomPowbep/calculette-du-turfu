package com.amelielaurent38.digital.calculatrice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amelielaurent38.digital.calculatrice.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Est appelées lorsque l'on clique sur un bouton
     * @param v La vue à l'origine de l'événement
     */
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
                this.handleOperation(button);
                break;

            case "NB":
                result.append(button.getText());
                break;
            default:
                break;
        }


    }


    /**
     * Permet de récupérer le type de l'opération actuelle et effectue l'opération
     * @param btn Le bouton qui a été cliqué
     *            
     * @return String
     */
    private String handleOperation(Button btn) {
        int bt_id = btn.getId();
        switch (bt_id) {
            case R.id.bt_plus:
                return "plus";

            case R.id.bt_minus:
                return "minus";

            case R.id.bt_divide:
                return "divide";

            case R.id.bt_multiply:
                return "multiply";

            case R.id.bt_equals:
                return "equals";
        }
        return "";
    }

}


