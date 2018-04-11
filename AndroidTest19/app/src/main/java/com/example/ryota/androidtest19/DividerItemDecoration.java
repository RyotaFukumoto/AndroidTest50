package com.example.ryota.androidtest19;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
private int space;

DividerItemDecoration(int space) {
            this.space = space;
            }

@Override
public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = this.space;
        outRect.right = this.space;


        //for vertical scrolling
        outRect.bottom = this.space;
        outRect.top = this.space;
        }
        }
