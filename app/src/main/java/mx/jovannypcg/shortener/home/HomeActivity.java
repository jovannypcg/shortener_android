package mx.jovannypcg.shortener.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mx.jovannypcg.shortener.R;

public class HomeActivity extends AppCompatActivity implements HomeView {
    @BindView(R.id.layout_short_link) LinearLayout shortLinkLayout;
    @BindView(R.id.et_destination) EditText etDestination;
    @BindView(R.id.tv_short_link) TextView tvShortLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_shorten)
    public void submitShorten() {
        this.showMessage("shorten");
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_show_links:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
