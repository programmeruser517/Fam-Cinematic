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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.famcinematic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRateModeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText directoryPathEditText;

  @NonNull
  public final TextView directoryTextView;

  @NonNull
  public final TextView outputTextView;

  @NonNull
  public final Button submitButton;

  @NonNull
  public final TextView titleTextView;

  private ActivityRateModeBinding(@NonNull RelativeLayout rootView,
      @NonNull EditText directoryPathEditText, @NonNull TextView directoryTextView,
      @NonNull TextView outputTextView, @NonNull Button submitButton,
      @NonNull TextView titleTextView) {
    this.rootView = rootView;
    this.directoryPathEditText = directoryPathEditText;
    this.directoryTextView = directoryTextView;
    this.outputTextView = outputTextView;
    this.submitButton = submitButton;
    this.titleTextView = titleTextView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRateModeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRateModeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_rate_mode, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRateModeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.directory_path_edit_text;
      EditText directoryPathEditText = ViewBindings.findChildViewById(rootView, id);
      if (directoryPathEditText == null) {
        break missingId;
      }

      id = R.id.directoryTextView;
      TextView directoryTextView = ViewBindings.findChildViewById(rootView, id);
      if (directoryTextView == null) {
        break missingId;
      }

      id = R.id.outputTextView;
      TextView outputTextView = ViewBindings.findChildViewById(rootView, id);
      if (outputTextView == null) {
        break missingId;
      }

      id = R.id.submit_button;
      Button submitButton = ViewBindings.findChildViewById(rootView, id);
      if (submitButton == null) {
        break missingId;
      }

      id = R.id.titleTextView;
      TextView titleTextView = ViewBindings.findChildViewById(rootView, id);
      if (titleTextView == null) {
        break missingId;
      }

      return new ActivityRateModeBinding((RelativeLayout) rootView, directoryPathEditText,
          directoryTextView, outputTextView, submitButton, titleTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
