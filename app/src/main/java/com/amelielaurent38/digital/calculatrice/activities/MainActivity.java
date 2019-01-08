package com.amelielaurent38.digital.calculatrice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amelielaurent38.digital.calculatrice.R;
import com.amelielaurent38.digital.calculatrice.models.Operation;
import com.amelielaurent38.digital.calculatrice.models.OperationType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    String calcul = "";
    OperationType operationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Est appelées lorsque l'on clique sur un bouton
     *
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
            case "AC":

                result.setText("");
                this.handleOperation(button);
                break;

            case "OP":
                operationType = this.handleOperation(button);
                result.append(operationType.toString());
                break;

            case "EQ":

                String[] parts = result.getText().toString().split(getSplitter());

                double Number1 = Double.parseDouble(parts[0]);
                double Number2 = Double.parseDouble(parts[1]);

                Operation theOperation = new Operation(Number1, Number2, operationType);
                result.setText(String.format(theOperation.getResult().toString()));

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
     *
     * @param btn Le bouton qui a été cliqué
     * @return String
     */
    private OperationType handleOperation(Button btn) {
        int bt_id = btn.getId();
        switch (bt_id) {
            case R.id.bt_plus:
                return OperationType.ADDTION;

            case R.id.bt_minus:
                return OperationType.SOUSTRACTION;

            case R.id.bt_divide:
                return OperationType.DIVISION;

            case R.id.bt_multiply:
                return OperationType.MUTIPLICATION;

        }
        return OperationType.UNKOWN;
    }

    /**
     * 
     * @return
     */
    private String getSplitter() {
        switch (operationType) {
            case ADDTION:
                return "\\+";
            case DIVISION:
                return "\\/";
            case MUTIPLICATION:
                return "\\*";
            default:
                return operationType.toString();
        }
    }

}


