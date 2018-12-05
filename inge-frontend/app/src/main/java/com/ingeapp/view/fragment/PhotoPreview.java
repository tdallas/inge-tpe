package com.ingeapp.view.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.ingeapp.R;

public class PhotoPreview extends DialogFragment {

    public final static String PHOTO_PARAM = "photoId";

    private String path;

    public static PhotoPreview newInstance() {
        return new PhotoPreview();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.row_photo_p, container, false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDarker)));

        ImageView photoImage = (ImageView) v.findViewById(R.id.preview);
        //photoimage.setImage,,,,asd

        return v;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
