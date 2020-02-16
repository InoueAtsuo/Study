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
import java.util.Iterator;
import java.util.List;

/**
 * RecyclerAdapter
 *
 * RecyclerViewの中心となるクラスです。
 * 必ずRecyclerView.Adapterをextendします。
 *
 * 通常RecyclerViewに表示するのは1種類ですが、
 * 今回はユーザ情報とLoading情報の2種類です。
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEWTYPE_USER_INFO = 0;
    private final int VIEWTYPE_LOADING = 1;

    // リサイクルアイテムデータ一覧
    //   ここに追加されたデータが、リサイクルデータとして表示されます。
    private List<RecylerItemData> mRecylerItemDataList;

    public RecyclerAdapter() {
        mRecylerItemDataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // viewTypeによって、ViewHolderの種類を変えます
        switch (viewType) {
            case VIEWTYPE_USER_INFO:
                View userView = inflater.inflate(R.layout.recycler_item, parent, false);
                return new UserDataViewHolder(userView);
            case VIEWTYPE_LOADING:
                View loadingView = inflater.inflate(R.layout.recycler_loading, parent, false);
                return new LoadingViewHolder(loadingView);
            default:
                return null;
        }
    }

    /**
     * ユーザ情報追加
     *   ユーザ情報をリサイクルアイテムデータ一覧に追加します。
     *
     * @param userItemDtoList ユーザ情報リスト
     */
    public void addUserInfo(List<UserItemDto> userItemDtoList) {
        for (UserItemDto useritemDto : userItemDtoList) {
            UserData userData = new UserData(VIEWTYPE_USER_INFO, useritemDto);
            mRecylerItemDataList.add(userData);
        }

        // notifyDataSetChangedを実行すると、リサイクルアイテムデータ一覧の内容が画面に表示されます。
        // 今回はデータ件数が少ないのでnotifyDataSetChangedで全データ表示を反映させています。
        // ほかにもnotifyItemChanged(int), notifyItemRemoved()など特定の表示箇所のみを反映させる方法もあります。
        notifyDataSetChanged();
    }

    /**
     * Loading情報追加
     */
    public void addLoading() {
        LoadingData loadingData = new LoadingData(VIEWTYPE_LOADING);
        mRecylerItemDataList.add(loadingData);

        notifyDataSetChanged();
    }

    /**
     * Loading情報削除
     */
    public void removeLoading() {
        Iterator<RecylerItemData> i = mRecylerItemDataList.iterator();
        while (i.hasNext()) {
            RecylerItemData itemData = i.next();
            if (itemData.viewType == VIEWTYPE_LOADING){
                i.remove();
            }
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

    /**
     * リサイクルデータ数取得
     *   リサイクル表示するデータ数を戻します。
     *   この関数は必須です。
     *
     * @return リサイクルデータ数
     */
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

    /**
     * ユーザデータのViewHolder
     */
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

    /**
     * LoadingデータのViewHolder
     */
    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    /**
     * リサイクル表示するアイテムデータ
     *
     * viewTypeで種類を判定するようにします。
     */
    public class RecylerItemData {
        public int viewType;

        RecylerItemData(int viewType) {
            this.viewType = viewType;
        }
    }

    /**
     * ユーザデータ
     */
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

    /**
     * Loadingデータ
     */
    public class LoadingData extends RecylerItemData {

        LoadingData(int viewType) {
            super(viewType);
        }
    }
}