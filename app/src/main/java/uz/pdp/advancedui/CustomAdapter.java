package uz.pdp.advancedui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.pdp.advancedui.model.Member;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    ArrayList<Member> members;
    Context context;

    public CustomAdapter(ArrayList<Member> members, Context context){
        this.members = members;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (members.get(position).getMemberSubs() != null) return TYPE_ITEM_LIST;
        return TYPE_ITEM_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_LIST){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_list, parent, false);
            return new CustomVIewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view   , parent, false);
        return new CustomVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof  CustomVIewHolder){

        }

        if (holder instanceof CustomVIewHolder){
            ((CustomVIewHolder) holder).img_rv.setImageResource(member.img_rv);
            ((CustomVIewHolder) holder).title.setText(member.title);
            ((CustomVIewHolder) holder).description.setText(member.description);
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class CustomVIewHolder extends RecyclerView.ViewHolder{
        ImageView img_rv;
        TextView title, description;

        public CustomVIewHolder(@NonNull View itemView) {
            super(itemView);
            img_rv = itemView.findViewById(R.id.rv_img);
            title = itemView.findViewById(R.id.rv_title);
            description = itemView.findViewById(R.id.rv_info);
        }
    }
}
