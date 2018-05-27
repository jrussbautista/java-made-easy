package com.example.jamesrussel.javamadeeasy;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.AttrRes;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class Lesson7cFragment extends Fragment {

    private static final String FORMAT_HTML_COLOR = "%1X";

    public Lesson7cFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson7c, container, false);
        setHasOptionsMenu(true);
        setHtml((WebView) view.findViewById(R.id.web_view),
                getString(R.string.lesson7c),
                android.R.attr.colorBackground,
                android.R.attr.textColorTertiary,
                android.R.attr.textColorLink,
                getResources().getDimension(R.dimen.text_size),
                getResources().getDimension(R.dimen.activity_horizontal_margin));

        return view;
    }

    private void setHtml(WebView webView,
                         String html,
                         @AttrRes int backgroundColor,
                         @AttrRes int textColor,
                         @AttrRes int linkColor,
                         float textSize,
                         float margin) {
        if (TextUtils.isEmpty(html)) {
            return;
        }
        webView.setBackgroundColor(0xFFFFFF);
        webView.getSettings().setBuiltInZoomControls(true); // optional
        webView.loadDataWithBaseURL(null,
                wrapHtml(webView.getContext(), html, textColor, linkColor, textSize, margin),
                "text/html", "UTF-8", null);
    }

    private String wrapHtml(Context context, String html,
                            @AttrRes int textColor,
                            @AttrRes int linkColor,
                            float textSize,
                            float margin) {
        return context.getString(R.string.html,
                html,
                toHtmlColor(context, textColor),
                toHtmlColor(context, linkColor),
                toHtmlPx(context, textSize),
                toHtmlPx(context, margin));
    }

    private String toHtmlColor(Context context, @AttrRes int colorAttr) {
        return String.format(FORMAT_HTML_COLOR, 0xFFFFFF &
                ContextCompat.getColor(context, getIdRes(context, colorAttr)));
    }

    private float toHtmlPx(Context context, float dimen) {
        return dimen / context.getResources().getDisplayMetrics().density;
    }

    @IdRes
    private int getIdRes(Context context, @AttrRes int attrRes) {
        TypedArray ta = context.getTheme().obtainStyledAttributes(new int[]{attrRes});
        int resId = ta.getResourceId(0, 0);
        ta.recycle();
        return resId;
    }
}
