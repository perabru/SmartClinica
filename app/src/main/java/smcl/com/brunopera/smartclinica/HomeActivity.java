package smcl.com.brunopera.smartclinica;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

         final ImageButton btnCadastrar = (ImageButton) findViewById(R.id.btnCadastrar);
        final ImageButton btnProntuario = (ImageButton) findViewById(R.id.btnProntuario);
        final ImageButton btnGPS = (ImageButton) findViewById(R.id.btnGPS);
        final ImageButton btnAjuda = (ImageButton) findViewById(R.id.btnAjuda);

        btnCadastrar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("Pressed", "Button pressed");
                    btnCadastrar.setImageResource(R.drawable.microphone64pressed);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {

                    Log.d("Released", "Button released");
                    btnCadastrar.setImageResource(R.drawable.microphone64);


                }
                return false;
             }
        });

        btnProntuario.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("Pressed", "Button pressed");
                    btnProntuario.setImageResource(R.drawable.contract64pressed);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {

                    Log.d("Released", "Button released");
                    btnProntuario.setImageResource(R.drawable.contract64);


                }
                return false;
             }
        });

//----------------------------------------------------------------------------------------
        btnGPS.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("Pressed", "Button pressed");
                    btnGPS.setImageResource(R.drawable.navigation64presse);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {

                    Log.d("Released", "Button released");
                    btnGPS.setImageResource(R.drawable.navigation64);


                }
                return false;
             }
        });

        //-------------------------------------------------------------------

        btnAjuda.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("Pressed", "Button pressed");
                    btnAjuda.setImageResource(R.drawable.info64pressed);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {

                    Log.d("Released", "Button released");
                    btnAjuda.setImageResource(R.drawable.info64);


                }
                return false;
             }
        });


    }
}
