package com.eugenebrusov.cards;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.eugenebrusov.cards.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>{

    private Context mCtx;
    private List<Event> eventList;

    public EventAdapter(Context mCtx, List<Event> eventList) {
        this.mCtx = mCtx;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("EventViewHolder", "called");
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_media15x_primarytext_subtext_actions,null);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);

        holder.textViewTitle.setText(event.getTitle());
        holder.textViewPlace.setText(event.getPlace());
        holder.textViewTime.setText(event.getTime());
        holder.textViewPrice.setText(String.valueOf(event.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(event.getImage()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something when clicked on
                //Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), InformationActivity.class);
                // FILL DATA!!!!
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventList.size()  ;
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle, textViewPlace;
        Button textViewTime, textViewPrice;

        public EventViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewPlace = itemView.findViewById(R.id.place);
            textViewPrice = itemView.findViewById(R.id.date);
            textViewTime = itemView.findViewById(R.id.price);
            Log.d("contrsuctor", "called");
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //do something when clicked on
                    //Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(view.getContext(), InformationActivity.class);
                    // FILL DATA!!!!
                    //view.getContext().startActivity(intent);
                    Log.d("teset", "ksks");
                }
            });
        }
    }

}
