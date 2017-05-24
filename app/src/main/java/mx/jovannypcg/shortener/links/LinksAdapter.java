package mx.jovannypcg.shortener.links;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.jovannypcg.shortener.R;
import mx.jovannypcg.shortener.rest.model.ApiShortLink;

public class LinksAdapter extends BaseAdapter {
    private List<ApiShortLink> links;
    private Context context;

    public LinksAdapter(Context context, List<ApiShortLink> links) {
        this.context = context;
        this.links = links;
    }

    @Override
    public int getCount() {
        return links.size();
    }

    @Override
    public Object getItem(int position) {
        return links.get(position).getSlug();
    }

    @Override
    public long getItemId(int position) {
        return links.get(position).getId();
    }

    public void clear() {
        this.links.clear();
    }

    public void addAll(List<ApiShortLink> items) {
        this.links.addAll(items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.layout_link, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.tvDestination.setText(links.get(position).getDestination());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_destination) TextView tvDestination;

        ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
