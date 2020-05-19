package nebiyou.passwordgeneretor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    Button btnGenerate ;
    EditText txtUserID,txtPassword,txtUserPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerate=(Button)findViewById(R.id.btnGenerate);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        txtUserPassword=(EditText)findViewById(R.id.txtUserPassword);
        txtUserID=(EditText)findViewById(R.id.txtUserID);
    }
    public void btnGenerate(android.view.View Button){
        String combinedPassword = txtUserID.getText().toString() + txtPassword.getText().toString();
        String hashedPassword = GenerateMD5(combinedPassword);

        txtUserPassword.setText(hashedPassword);
    }

    public String GenerateMD5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}


