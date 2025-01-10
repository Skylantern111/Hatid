package com.example.hatid;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class act_booking extends AppCompatActivity {

    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking); // Ensure this is the correct layout

        // Get reference to the Cancel button
        Button cancelButton = findViewById(R.id.cancel_button); // Make sure the ID matches your layout

        // Set OnClickListener for Cancel button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the arrival dialog when the Cancel button is clicked
                showArrivalDialog();
            }
        });
    }

    // Custom Dialog for arrival
    private void showArrivalDialog() {
        // Create and show the custom dialog
        loadingDialog = new Dialog(this);
        loadingDialog.setContentView(R.layout.end); // This layout has your dialog's UI
        loadingDialog.setCancelable(false); // Prevent dialog dismissal by tapping outside

        // Show the dialog
        loadingDialog.show();

        // Get references to the views for animations
        LinearLayout dialogLayout = loadingDialog.findViewById(R.id.end);
        TextView arrivalMessage = loadingDialog.findViewById(R.id.arrivalMessage);
        ImageView arrivalIcon = loadingDialog.findViewById(R.id.arrivalIcon);
        TextView thankYouMessage = loadingDialog.findViewById(R.id.thankYouMessage);

        // Set dynamic messages (optional)
        arrivalMessage.setText("You’ve arrived at your destination!");
        arrivalIcon.setImageResource(R.drawable.ic_arrival); // Custom icon for arrival
        thankYouMessage.setText("Thank you for using our service!");

        // Animation for dialog appearance (fade-in)
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(dialogLayout, "alpha", 0f, 1f);
        fadeIn.setDuration(800); // 800ms fade-in animation
        fadeIn.start();

        // Close the dialog and app after 10 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Animation for dialog disappearance (fade-out)
                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(dialogLayout, "alpha", 1f, 0f);
                fadeOut.setDuration(800); // 800ms fade-out animation
                fadeOut.start();

                // After fade-out is complete, dismiss the dialog and close the app
                fadeOut.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        // Dismiss the dialog
                        if (loadingDialog.isShowing()) {
                            loadingDialog.dismiss();
                        }
                        // Close the app after the animation ends
                        finishAffinity(); // finishAffinity() will ensure the app is fully closed
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                });
            }
        }, 10000); // Delay of 10 seconds before fade-out
    }

    // Optional: If you want to manually dismiss the dialog
    private void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
}
