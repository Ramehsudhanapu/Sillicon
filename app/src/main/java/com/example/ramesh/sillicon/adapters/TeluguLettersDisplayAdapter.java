package com.example.ramesh.sillicon.adapters;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.ramesh.sillicon.R;
import com.example.ramesh.sillicon.activities.DisplayLessionWiseActivity;
import com.example.ramesh.sillicon.fragments.HomeFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
public class TeluguLettersDisplayAdapter extends RecyclerView.Adapter<TeluguLettersDisplayAdapter.ViewHolder> {
    Context context;
    private String[] telugu_alphabets_stores;
    private Typeface telugu_tf;
    private HomeFragment homefragment;
    public TeluguLettersDisplayAdapter(HomeFragment homeFragment, String[] telugu_alphabets_stores, Typeface telugu_tf) {
        this.homefragment = homeFragment;
        this.telugu_alphabets_stores = telugu_alphabets_stores;
        this.telugu_tf = telugu_tf;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_alphabets, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.teluguletters_txt.setText(telugu_alphabets_stores[position]);
            holder.teluguletters_txt.setTypeface(telugu_tf);
        } catch (Exception ex) {
        }
    }
    @Override
    public int getItemCount() {

        return telugu_alphabets_stores.length;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.teluguletters_txt)
        TextView teluguletters_txt;
        @BindView(R.id.showAnimation)
        RelativeLayout showAnimation;
        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            showAnimation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.getContext().startActivity( new Intent(view.getContext(), DisplayLessionWiseActivity.class));
                  //  buildDialog(R.style.DialogAnimation_2, " కుడి యానిమేషన్    ", view.getContext());
                }
            });
        }
        private void buildDialog(int animationSource, String type, Context context) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("మనబడి");
            // builder.setMessage(type);
            builder.setNegativeButton("అవును ", null);
//            builder.setPositiveButton("",B)
            AlertDialog dialog = builder.create();
            dialog.getWindow().getAttributes().windowAnimations = animationSource;
            dialog.show();
        }
    }
}
