package com.example.study.Presentation.Recicle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.study.Common.Kbn;
import com.example.study.R;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private List<RecycleItemDto> itemDtoList;

    public RecycleAdapter(List<RecycleItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fmailyName;
        public TextView firstName;
        public TextView sex;
        public TextView zipInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fmailyName = itemView.findViewById(R.id.family_name);
            firstName = itemView.findViewById(R.id.first_name);
            sex = itemView.findViewById(R.id.sex);
            zipInfo = itemView.findViewById(R.id.zip_info);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecycleItemDto itemDto = itemDtoList.get(position);
        holder.fmailyName.setText(itemDto.getFamilyName());
        holder.firstName.setText(itemDto.getFirstName());
        if (itemDto.getSex() == Kbn.SEX.SEX_MAN) {
            holder.sex.setText(R.string.text_man);
        } else if (itemDto.getSex() == Kbn.SEX.SEX_WOMAN) {
            holder.sex.setText(R.string.text_woman);
        }
    }

    @Override
    public int getItemCount() {
        if (itemDtoList == null) {
            return 0;
        }
        return itemDtoList.size();
    }

    public void addItem(RecycleItemDto itemDto) {
        itemDtoList.add(itemDto);
    }
}
