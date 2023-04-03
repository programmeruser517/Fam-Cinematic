// Generated by view binder compiler. Do not edit!
package com.example.famcinematic.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.famcinematic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button pickButton;

  @NonNull
  public final Button rateButton;

  @NonNull
  public final TextView titleTextview;

  private ActivityMainBinding(@NonNull RelativeLayout rootView, @NonNull Button pickButton,
      @NonNull Button rateButton, @NonNull TextView titleTextview) {
    this.rootView = rootView;
    this.pickButton = pickButton;
    this.rateButton = rateButton;
    this.titleTextview = titleTextview;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.pick_button;
      Button pickButton = ViewBindings.findChildViewById(rootView, id);
      if (pickButton == null) {
        break missingId;
      }

      id = R.id.rate_button;
      Button rateButton = ViewBindings.findChildViewById(rootView, id);
      if (rateButton == null) {
        break missingId;
      }

      id = R.id.title_textview;
      TextView titleTextview = ViewBindings.findChildViewById(rootView, id);
      if (titleTextview == null) {
        break missingId;
      }

      return new ActivityMainBinding((RelativeLayout) rootView, pickButton, rateButton,
          titleTextview);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
