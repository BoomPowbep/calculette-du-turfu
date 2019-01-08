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


    /**
     * Est appelées lorsque l'on clique sur un bouton
     * @param v
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
                String operator = this.operationType(button);
                break;

            case "NB":
                result.append(button.getText());
                break;
            default:
                break;
        }


    }

    /**
     * Gère une opération
     * @param btn
     */
    private void handleOperation(Button btn) {

    }

    /**
     * Permet de récupérer le type de l'opération actuelle
     * @param btn
     * @return String
     */
    private String operationType(Button btn) {
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
