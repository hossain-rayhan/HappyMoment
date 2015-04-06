package iit.du.edu.happymoment.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

import iit.du.edu.happymoment.R;
import iit.du.edu.happymoment.model.Url;

/**
 * Created by Rayhan on 4/6/2015.
 */
public class UrlListAdapter extends ArrayAdapter<Url> {
    private Context context;
    private int layoutResourceId;

    public UrlListAdapter(Context context, int layout, List<Url> urls) {
        super(context, layout, urls);
        this.context = context;
        layoutResourceId = layout;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Url url = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.tvUrlText = (TextView) convertView.findViewById(R.id.tv_url_text);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.tvUrlText.setText(url.getText());

        final ViewHolder finalHolder = holder;



        return convertView;
    }

    private class ViewHolder {
        TextView tvUrlText;
        RelativeLayout rlListItem;
    }
}
