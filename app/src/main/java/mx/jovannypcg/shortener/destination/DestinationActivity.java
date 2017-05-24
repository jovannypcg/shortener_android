package mx.jovannypcg.shortener.destination;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mx.jovannypcg.shortener.R;

public class DestinationActivity extends AppCompatActivity implements DestinationView {
    @BindView(R.id.tv_destination) TextView tvDestination;
    @BindView(R.id.tv_short_link) TextView tvShortLink;

    private ProgressDialog progressDialog;
    private DestinationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);

        presenter = new DestinationPresenterImpl(this);
        presenter.requestDetails();
    }

    @Override
    public Object getExtra(String key) {
        return getIntent().getExtras().get(key);
    }

    @Override
    public void setDestination(String link) {
        this.tvDestination.setText(link);
    }

    @Override
    public void setShortLink(String link) {
        this.tvShortLink.setText(link);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void dismissProgress() {
        progressDialog.dismiss();
    }

    @OnClick(R.id.btn_go)
    public void goToShortLink() {

    }
}
