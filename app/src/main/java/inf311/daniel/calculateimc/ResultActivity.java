package inf311.daniel.calculateimc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class ResultActivity extends AppCompatActivity {

    private String TAG = "Ciclo_Result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.result_activity);

        Intent it = getIntent();
        Bundle params = it.getExtras();

        TextView nameRes = (TextView) findViewById(R.id.nameValue);
        TextView ageRes = (TextView) findViewById(R.id.ageValue);
        TextView weightRes = (TextView) findViewById(R.id.weightValue);
        TextView heightRes = (TextView) findViewById(R.id.heightValue);

        TextView imcRes = (TextView) findViewById(R.id.imcValue);
        TextView classRes = (TextView) findViewById(R.id.classificationValue);

        nameRes.setText(params.getString("name"));
        ageRes.setText(params.getString("age"));


        double weight = params.getDouble("weight");
        double height = params.getDouble("height");
        double imcVal = params.getDouble("imc");

        String formattedWeight = String.format("%.1f kg", weight);
        String formattedHeight = String.format("%.2f m", height);
        String formattedImc = String.format("%.1f kg/m²", imcVal);

        weightRes.setText(formattedWeight);
        heightRes.setText(formattedHeight);
        imcRes.setText(formattedImc);


        String classification = "";
        if(imcVal < 18.5) {
            classification = getResources().getString(R.string.abaixo_peso);
        } else if (imcVal >= 18.5 && imcVal <= 24.9) {
            classification = getResources().getString(R.string.saudavel_peso);
        } else if (imcVal >= 25.0 && imcVal <= 29.9) {
            classification = getResources().getString(R.string.sobre_peso);
        } else if (imcVal >= 30.0 && imcVal <= 34.9) {
            classification = getResources().getString(R.string.ob1_peso);
        } else if (imcVal >= 35.0 && imcVal <= 39.9) {
            classification = getResources().getString(R.string.ob2_peso);
        } else {
            classification = getResources().getString(R.string.ob3_peso);
        }

        classRes.setText(classification);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
