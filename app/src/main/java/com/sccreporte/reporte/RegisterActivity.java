package com.sccreporte.reporte;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText nombreET;
    private EditText gradoET;
    private EditText ministerioET;
    private EditText responsabilidadET;
    private EditText pastorET;
    private EditText lugarET;
    private Button registerB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombreET = (EditText) findViewById(R.id.nombreEditText);
        gradoET = (EditText) findViewById(R.id.gradoEditText);
        ministerioET = (EditText) findViewById(R.id.ministerioEditText);
        responsabilidadET = (EditText) findViewById(R.id.responsabilidadEditText);
        pastorET = (EditText) findViewById(R.id.pastorEditText);
        lugarET = (EditText) findViewById(R.id.lugardEditText);
        registerB = (Button) findViewById(R.id.registerButton);

        registerB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = RegisterActivity.this;
                Class destinationActivity = CreatePasswordActivity.class;
                Intent startChildActivityIntent = new Intent(context, destinationActivity);

                JSONObject dataUserJSON = createPersonalData();
                startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, dataUserJSON.toString());

                startActivity(startChildActivityIntent);
                finish();
            }
        });
    }

    /**
     * Crea el objeto JSON que contiene los datos del registro del usuario
     * @return
     */
    private JSONObject createPersonalData(){
        JSONObject obj = new JSONObject();
        try{
            obj.put("nombre",nombreET.getText());
            obj.put("grado",gradoET.getText());
            obj.put("ministerio",ministerioET.getText());
            obj.put("responsabilidad",responsabilidadET.getText());
            obj.put("pastor",pastorET.getText());
            obj.put("lugar",lugarET.getText());
        }catch (JSONException e){
            e.printStackTrace();
        }
        return obj;
    }
}
