package com.example.study.Presentation.Recycler;

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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEWTYPE_USER_INFO = 0;
    private final int VIEWTYPE_LOADING = 1;

    private List<RecylerItemData> mRecylerItemDataList;

    public RecyclerAdapter() {
        mRecylerItemDataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEWTYPE_USER_INFO) {
            View view = inflater.inflate(R.layout.recycler_item, parent, false);
            return new UserDataViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.recycler_item, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    public void addUserInfo(List<UserItemDto> userItemDtoList) {
        for (UserItemDto useritemDto : userItemDtoList) {
            UserData userData = new UserData(VIEWTYPE_USER_INFO, useritemDto);
            mRecylerItemDataList.add(userData);
        }

        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        RecylerItemData itemData = mRecylerItemDataList.get(position);
        switch (itemData.viewType) {
            case VIEWTYPE_USER_INFO:
                UserData userData = (UserData) itemData;
                UserDataViewHolder userDataViewHolder = (UserDataViewHolder) viewHolder;
                userDataViewHolder.familyName.setText(userData.getFamilyName());
                userDataViewHolder.firstName.setText(userData.getFirstName());
                if (userData.getSex() == Kbn.SEX.SEX_MAN) {
                    userDataViewHolder.sex.setText(R.string.text_man);
                } else if (userData.getSex() == Kbn.SEX.SEX_WOMAN) {
                    userDataViewHolder.sex.setText(R.string.text_woman);
                }
                break;
            case VIEWTYPE_LOADING:
                break;

        }
    }

    @Override
    public int getItemCount() {
        if (mRecylerItemDataList == null) {
            return 0;
        }
        return mRecylerItemDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mRecylerItemDataList.get(position).viewType;
    }

    public class UserDataViewHolder extends RecyclerView.ViewHolder {
        private TextView familyName;
        private TextView firstName;
        private TextView sex;
        private TextView zipInfo;

        public UserDataViewHolder(@NonNull View itemView) {
            super(itemView);

            familyName = itemView.findViewById(R.id.family_name);
            firstName = itemView.findViewById(R.id.first_name);
            sex = itemView.findViewById(R.id.sex);
            zipInfo = itemView.findViewById(R.id.zip_info);
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class RecylerItemData {
        public int viewType = 0;

        RecylerItemData(int viewType) {
            this.viewType = viewType;
        }
    }

    public class UserData extends RecylerItemData {

        UserData(int viewType) {
            super(viewType);
        }

        UserData(int viewType, UserItemDto data) {
            super(viewType);
            familyName = data.getFamilyName();
            firstName = data.getFirstName();
            sex = data.getSex();
            zipCode = data.getZipCode();
        }

        private String familyName;

        private String firstName;

        private Kbn.SEX sex;

        private String zipCode;

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Kbn.SEX getSex() {
            return sex;
        }

        public void setSex(Kbn.SEX sex) {
            this.sex = sex;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }

    // sample http://www.fineblue206.net/20190604192949
}
