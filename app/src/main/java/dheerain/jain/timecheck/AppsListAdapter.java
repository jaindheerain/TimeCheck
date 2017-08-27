package dheerain.jain.timecheck;

import android.app.usage.UsageStats;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dheerain on 27-08-2017.
 */

public class AppsListAdapter extends RecyclerView.Adapter<AppsListAdapter.ViewHolder> {

    Context context;
    List<UsageStats> usageStatses;
    public AppsListAdapter(Context c, List<UsageStats> usageStatses) {

        context=c;
        this.usageStatses=usageStatses;

    }

    @Override
    public AppsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_apps,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(AppsListAdapter.ViewHolder holder, int position) {

        holder.name.setText(usageStatses.get(position).getPackageName());
        try {
            holder.icon.setImageDrawable(context.getPackageManager()
                    .getApplicationIcon(usageStatses.get(position).getPackageName()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return usageStatses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;
        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            icon= (ImageView) itemView.findViewById(R.id.appIcon);
        }
    }
}
