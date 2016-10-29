package study.popup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //Button
    private Button pesquisar;
    private PopupWindow popUpWindowPesquisa;
    private LayoutInflater layoutInflaterPesquisa;
    private RelativeLayout relativeLayoutPesquisa;

    private static final String TAG = "QuickNotesMainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button pesquisar and popup
        pesquisar = (Button) findViewById(R.id.pesquisar);
        relativeLayoutPesquisa = (RelativeLayout) findViewById(R.id.activity_pop_up);
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Begin");
                layoutInflaterPesquisa = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                //ViewGroup containerPesquisa = (ViewGroup) layoutInflaterPesquisa.inflate(R.layout.activity_pop_up, null);

                PopupWindow pw = new PopupWindow(layoutInflaterPesquisa.inflate(R.layout.activity_pop_up, null, false),100,100, true);

               // popUpWindowPesquisa = new PopupWindow(containerPesquisa, 600, 800, true);
                popUpWindowPesquisa.showAtLocation(relativeLayoutPesquisa, Gravity.NO_GRAVITY, 500, 500);
                relativeLayoutPesquisa.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Log.e(TAG, "End");
                        popUpWindowPesquisa.dismiss();
                        return true;

                    }
                });
            }
        });

    }
}
