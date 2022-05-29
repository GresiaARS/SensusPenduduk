package pnj.uts.gresia_andayanirs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btn_signin;
    EditText edt_email,edt_password;
    SharedPreferences savelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_signin = findViewById(R.id.btn_signin);
        savelogin = getSharedPreferences("SensusPenduduk",MODE_PRIVATE);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);


        btn_signin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(edt_email.getText().toString().length()>0 && edt_password.getText().toString().length()>0){
            if(edt_email.getText().toString().equals("gresia@gmail.com")&& edt_password.getText().toString().equals("1234")){
                Intent intent = new Intent(Login.this, activityhome.class);
                intent.putExtra("name",edt_email.getText().toString());
                startActivity(intent);
                SharedPreferences.Editor ngedit = savelogin.edit();
                ngedit.putBoolean("login",true);
                ngedit.commit();
                finish();


            }else{
                Toast.makeText(Login.this,"Mohon Maaf Email atau Password Salah",Toast.LENGTH_SHORT).show();
            }
        }


    }
}
