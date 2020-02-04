package com.example.study.Presentation.Recycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.study.Common.Kbn;
import com.example.study.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private List<RecycleItemDto> mItemDtoList;

    public RecycleAdapter() {
        mItemDtoList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new ViewHolder(view);
    }

    public void addUserInfo(List<RecycleItemDto> itemDtoList) {
        for (RecycleItemDto itemDto : itemDtoList) {
            mItemDtoList.add(itemDto);
        }

        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView familyName;
        public TextView firstName;
        public TextView sex;
        public TextView zipInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            familyName = itemView.findViewById(R.id.family_name);
            firstName = itemView.findViewById(R.id.first_name);
            sex = itemView.findViewById(R.id.sex);
            zipInfo = itemView.findViewById(R.id.zip_info);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecycleItemDto itemDto = mItemDtoList.get(position);
        holder.familyName.setText(itemDto.getFamilyName());
        holder.firstName.setText(itemDto.getFirstName());
        if (itemDto.getSex() == Kbn.SEX.SEX_MAN) {
            holder.sex.setText(R.string.text_man);
        } else if (itemDto.getSex() == Kbn.SEX.SEX_WOMAN) {
            holder.sex.setText(R.string.text_woman);
        }
    }

    @Override
    public int getItemCount() {
        if (mItemDtoList == null) {
            return 0;
        }
        return mItemDtoList.size();
    }
}
