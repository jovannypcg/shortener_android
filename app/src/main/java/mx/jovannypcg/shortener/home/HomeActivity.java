package mx.jovannypcg.shortener.home;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mx.jovannypcg.shortener.R;
import mx.jovannypcg.shortener.links.LinksActivity;

public class HomeActivity extends AppCompatActivity implements HomeView {
    @BindView(R.id.layout_short_link) LinearLayout shortLinkLayout;
    @BindView(R.id.et_destination) EditText etDestination;
    @BindView(R.id.tv_short_link) TextView tvShortLink;

    private ProgressDialog progressDialog;
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);
        homePresenter = new HomePresenterImpl(this);
    }

    @OnClick(R.id.btn_shorten)
    public void submitShorten() {
        homePresenter.submitShorten();
    }

    @Override
    public String getDestination() {
        return etDestination.getText().toString();
    }

    @Override
    public String getShortLink() {
        return tvShortLink.getText().toString();
    }

    @Override
    public void showDestinationError(String message) {
        etDestination.setError(message);
    }

    @Override
    public void setShorterLink(String shorterLink) {
        tvShortLink.setText(shorterLink);
    }

    @Override
    public void setShorterLinkLayoutVisibility(int visibility) {
        shortLinkLayout.setVisibility(visibility);
    }

    @Override
    public void showProgress() {
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getResources().getString(R.string.shortening));
        progressDialog.show();
    }

    @Override
    public void dismissProgress() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
                Intent linksIntent = new Intent(this, LinksActivity.class);
                startActivity(linksIntent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.tv_short_link)
    public void shortLinkClicked() {
        homePresenter.copyShortLinkToClipboard();
    }
}
