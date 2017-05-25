package mx.jovannypcg.shortener.browser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.jovannypcg.shortener.R;

public class BrowserActivity extends AppCompatActivity {
    @BindView(R.id.web_browser) WebView webBrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        ButterKnife.bind(this);

        String url = (String) getIntent().getExtras().get("url");
        webBrowser.loadUrl(url);
    }
}
