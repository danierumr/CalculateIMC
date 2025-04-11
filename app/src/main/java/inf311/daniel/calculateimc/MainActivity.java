package inf311.daniel.calculateimc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Ciclo_Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_main);

        Button btnResult = (Button) findViewById(R.id.btnRelatorio);

        EditText name = (EditText) findViewById(R.id.nameInput);
        EditText age = (EditText) findViewById(R.id.ageInput);
        EditText weight = (EditText) findViewById(R.id.weightInput);
        EditText height = (EditText) findViewById(R.id.heightInput);

        btnResult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double weightVal = Double.parseDouble(weight.getText().toString());
                double heightVal = Double.parseDouble(height.getText().toString());

                double imcVal = (weightVal) / (heightVal * heightVal);

                Intent it = new Intent(getBaseContext(), ResultActivity.class);
                it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                Bundle params = new Bundle();

                params.putString("name", name.getText().toString());
                params.putString("age", age.getText().toString());

                params.putDouble("height", heightVal);
                params.putDouble("weight", weightVal);
                params.putDouble("imc", imcVal);

                it.putExtras(params);

                startActivity(it);
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