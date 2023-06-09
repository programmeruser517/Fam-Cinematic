// Generated by view binder compiler. Do not edit!
package com.example.famcinematic.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.famcinematic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RateActivityMovieBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView movieNameTextView;

  private RateActivityMovieBinding(@NonNull LinearLayout rootView,
      @NonNull TextView movieNameTextView) {
    this.rootView = rootView;
    this.movieNameTextView = movieNameTextView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RateActivityMovieBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RateActivityMovieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.rate_activity_movie, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RateActivityMovieBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.movie_name_text_view;
      TextView movieNameTextView = ViewBindings.findChildViewById(rootView, id);
      if (movieNameTextView == null) {
        break missingId;
      }

      return new RateActivityMovieBinding((LinearLayout) rootView, movieNameTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
