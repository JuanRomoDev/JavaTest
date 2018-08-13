package com.juanromodev.javatest.ui.test;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.juanromodev.javatest.R;

public class ExitTestDialogFragment extends DialogFragment {

    private Callbacks callbacks;

    /**
     * Required interface for hosting activities
     */
    public interface Callbacks {
        void onDialogPositiveClick(DialogFragment dialog);

        void onDialogNegativeClick(DialogFragment dialog);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.exit_exam_dialog_title)
                .setMessage(R.string.exit_exam_dialog_message)
                .setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        callbacks.onDialogPositiveClick(ExitTestDialogFragment.this);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        callbacks.onDialogNegativeClick(ExitTestDialogFragment.this);
                    }
                });

        return builder.create();
    }
}
