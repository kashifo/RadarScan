package cf.kashif.radarscan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DynamicPositionTest extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rlCenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_position_test);


        int id = (int) (Math.random() * 100); // Some arbitrary ID value.

        setView( id, "User"+id, 0, 0 );
        id = (int) (Math.random() * 100); // Some arbitrary ID value.
        setView( id, "User"+id, 400, 0 );
        id = (int) (Math.random() * 100); // Some arbitrary ID value.
        setView( id, "User"+id, 0, 400 );
        id = (int) (Math.random() * 100); // Some arbitrary ID value.
        setView( id, "User"+id, 400, 400 );

        id = (int) (Math.random() * 100); // Some arbitrary ID value.
        setView( id, "User"+id, 100, 100 );
        id = (int) (Math.random() * 100); // Some arbitrary ID value.
        setView( id, "User"+id, 200, 200 );
        id = (int) (Math.random() * 100); // Some arbitrary ID value.
        setView( id, "User"+id, 300, 300 );

        id = (int) (Math.random() * 100); // Some arbitrary ID value.
        setView( id, "User"+id, 300, 100 );
        id = (int) (Math.random() * 100); // Some arbitrary ID value.
        setView( id, "User"+id, 100, 300 );

    }

    void setView( int id, String text, int x, int y ){

        rlCenter = (RelativeLayout) findViewById(R.id.rlCenter);
        RelativeLayout.LayoutParams params;

        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText( text );
        tv.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.ic_action_user, 0, 0 );
        tv.setOnClickListener(this);

        params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = x;
        params.topMargin = y;
        rlCenter.addView(tv, params);

    }

    @Override
    public void onClick(View v) {

        showToast(((TextView) v).getText().toString());

    }

    void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
