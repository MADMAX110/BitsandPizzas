package com.hfad.bitsandpizzas;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    interface Listener{
        void onCLick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //每个ViewHolder包含一个CardView
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    //使用适配器的构造方法向它传递数据
    public CaptionedImagesAdapter(String[] captions, int[] imageIds){
        this.captions = captions;
        this.imageIds = imageIds;
    }

    //告诉适配器有多少个数据项
    public int getItemCount() {
        return captions.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    //为CardViews使用前面创建的布局
    //回收视图需要新的视图持有者时就会调用该方法
    //首次构造回收视图时，回收视图会反复调用这个方法来构造将在屏幕上显示的一组持有者
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    //用数据填充CardView的ImageView和TextView
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView")final int position){
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView = (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCLick(position);
                }
            }
        });
    }
}
