package duydh.viewpager2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> listData;

    public LandScapeAdapter(Context _context, ArrayList<LandScape> _listData) {
        this.context = _context;
        this.listData = _listData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land,parent, false);
        ItemLandHolder viewHolderCreated = new ItemLandHolder(vItem);
        return viewHolderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // Lấy đối tượng
        LandScape landScapeHienThi = listData.get(position);
        //Trích thông tin
        String caption = landScapeHienThi.getLandCaption();
        String imageFileName = landScapeHienThi.getLandImageFileName();
        //Đặt vào các trường thông tin của holder
        holder.tvCaption.setText(caption);
        // Đặt ảnh
        String packageName = holder.itemView.getContext().getPackageName();
        int imageId = holder.itemView.getResources().getIdentifier(imageFileName, "drawable", packageName);
        holder.ivLandscapeImage.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCaption;
        ImageView ivLandscapeImage;
        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCaption);
            ivLandscapeImage = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTriDuocClick = getAdapterPosition();
            LandScape phanTuDuocClick = listData.get(viTriDuocClick);
            //bóc thông tin
            String ten = phanTuDuocClick.getLandCaption();
            String tenFile = phanTuDuocClick.getLandImageFileName();
            // Toast
            String chuoiThongBao = "Bạn vừa chọn " + ten;
            Toast.makeText(context, chuoiThongBao, Toast.LENGTH_SHORT).show();
        }
    }


}
