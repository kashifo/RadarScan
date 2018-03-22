package in.casperon.shareitscan;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView radarView1, radarView2, radarView3, radarView4, radarView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRadarViews();
        radarHandler = new Handler();
        radarHandler.postDelayed(radarViewRunnable, 1000);
    }

    //FOR DEMO
    Handler radarHandler;
    boolean show = true;
    int pos = 1;

    private Runnable radarViewRunnable = new Runnable() {
        @Override
        public void run() {

            if (pos == 10) {
                pos = 1;
                if (show)
                    show = false;
                else
                    show = true;
            }

            showUserOnRadar(show, pos);
            pos++;

            radarHandler.postDelayed(radarViewRunnable, 2000);
        }
    };
    //FOR DEMO


    void initRadarViews() {

        radarView1 = (TextView) findViewById(R.id.radarView1);
        radarView2 = (TextView) findViewById(R.id.radarView2);
        radarView3 = (TextView) findViewById(R.id.radarView3);
        radarView4 = (TextView) findViewById(R.id.radarView4);
        radarView5 = (TextView) findViewById(R.id.radarView5);

        radarView1.setOnClickListener(radarViewClick);
        radarView2.setOnClickListener(radarViewClick);
        radarView3.setOnClickListener(radarViewClick);
        radarView4.setOnClickListener(radarViewClick);
        radarView5.setOnClickListener(radarViewClick);

        radarView2.setX( 100 );
        radarView2.setY( 100 );
    }

    void showUserOnRadar(boolean show, int position) {

        int visible = View.VISIBLE;

        if (!show)
            visible = View.INVISIBLE;


        switch (position) {

            case 1:
                radarView1.setVisibility(visible);
                break;
            case 2:
                radarView2.setVisibility(visible);
                break;
            case 3:
                radarView3.setVisibility(visible);
                break;
            case 4:
                radarView4.setVisibility(visible);
                break;
            case 5:
                radarView5.setVisibility(visible);
                break;

        }

    }


    View.OnClickListener radarViewClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showToast(((TextView) v).getText().toString());
        }
    };

    void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
