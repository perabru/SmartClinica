package smcl.com.brunopera.smartclinica;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private SlideAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);





    }



    public void irParaTelaCadastro(View view){
        Intent myIntent = new Intent(this.getApplicationContext(), CadastroActivity.class);
        startActivityForResult(myIntent, 0);

    }

    public void makeLogin(View view){
        Intent myIntent = new Intent(this.getApplicationContext(), LoginActivity.class);
        startActivityForResult(myIntent, 0);

    }
}
