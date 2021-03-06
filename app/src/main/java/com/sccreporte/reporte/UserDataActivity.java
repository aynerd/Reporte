package com.sccreporte.reporte;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.sccreporte.reporte.data.User;
import com.sccreporte.reporte.databinding.ActivityUserDataBinding;
import com.sccreporte.reporte.utilities.DataUtils;

public class UserDataActivity extends AppCompatActivity {

    ImageButton backBT;
    Button editBT;
    User mUser;
    ActivityUserDataBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        // Set the content view to the layout
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_data);

        // Back button click
        backBT = findViewById(R.id.backButton);
        editBT = findViewById(R.id.editButton);

        backBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        editBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = UserDataActivity.this;
                Class destinationActivity = EditUserActivity.class;
                Intent startChildActivityIntent = new Intent(context, destinationActivity);
                startActivity(startChildActivityIntent);
                finish();
            }
        });

        mUser = DataUtils.loadUserData(this);
        if(mUser.id == -1)
            finish();

        displayUserData();
    }

    /**
     * Bind each attribute in the views to the corresponding data
     */
    private void displayUserData(){
        mBinding.nameUserTextView.setText(String.valueOf(mUser.nombre));
        mBinding.lugarUserTextView.setText(String.valueOf(mUser.lugar));

        String temp = String.valueOf(mUser.grado);
        if(!temp.isEmpty())
            mBinding.gradoTextView.setText(temp);
        else
            mBinding.gradoTextView.setText("No");

        temp = String.valueOf(mUser.ministerio);
        if(!temp.isEmpty())
            mBinding.ministerioTextView.setText(temp);
        else
            mBinding.ministerioTextView.setText("No");

        temp = String.valueOf(mUser.responsabilidad);
        if(!temp.isEmpty())
            mBinding.responsabilidadTextView.setText(temp);
        else
            mBinding.responsabilidadTextView.setText("No");

        temp = String.valueOf(mUser.pastor);
        if(!temp.isEmpty())
            mBinding.pastorTextView.setText(temp);

        temp = String.valueOf(mUser.numero);
        if(!temp.isEmpty())
            mBinding.numeroTextView.setText(temp);
        else
            mBinding.numeroTextView.setText("No");
    }
}
