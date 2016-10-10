package estudos.optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Inflando o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //Criando os eventos
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.settings_id:
                Toast.makeText(getBaseContext(), "Clicou em settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact_id:
                Toast.makeText(getBaseContext(), "Clicou em contato", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mim:
                Toast.makeText(getBaseContext(), "Clicou em mim", Toast.LENGTH_SHORT).show();
                break;
            case R.id.vc:
                Toast.makeText(getBaseContext(), "Clicou em si mesmo, como se sente agora?", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
