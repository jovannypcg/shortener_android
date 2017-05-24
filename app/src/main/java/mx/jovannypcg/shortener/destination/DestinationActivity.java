package mx.jovannypcg.shortener.destination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.jovannypcg.shortener.R;

public class DestinationActivity extends AppCompatActivity {
    @BindView(R.id.tv_destination) TextView tvDestination;
    @BindView(R.id.tv_short_link) TextView tvShortLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        ButterKnife.bind(this);
    }
}
