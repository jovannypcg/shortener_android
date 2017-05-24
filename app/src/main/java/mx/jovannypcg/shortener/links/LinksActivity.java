package mx.jovannypcg.shortener.links;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mx.jovannypcg.shortener.R;

public class LinksActivity extends AppCompatActivity implements LinksView {
    @BindView(R.id.lv_links) ListView lvLinks;

    private LinksPresenter presenter;
    private ArrayAdapter<String> linksAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        ButterKnife.bind(this);

        presenter = new LinksPresenterImpl(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getResources().getString(R.string.retrieving));

        linksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lvLinks.setAdapter(linksAdapter);
    }

    @OnClick(R.id.btn_get_links)
    public void getLinks() {
        presenter.submitRequest();
    }

    @Override
    public void refreshList(String[] items) {
        linksAdapter.clear();
        linksAdapter.addAll(items);
        linksAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void dismissProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
