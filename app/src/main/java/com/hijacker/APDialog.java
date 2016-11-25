package com.hijacker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class APDialog extends DialogFragment {
    AP info_ap;
    TextView ap[] = {null, null, null, null, null, null, null, null, null, null, null, null};
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.ap_info, null);

        if(ap[0]==null) {
            ap[0] = (TextView) view.findViewById(R.id.essid);
            ap[1] = (TextView) view.findViewById(R.id.mac);
            ap[2] = (TextView) view.findViewById(R.id.channel);
            ap[3] = (TextView) view.findViewById(R.id.pwr);
            ap[4] = (TextView) view.findViewById(R.id.enc);
            ap[5] = (TextView) view.findViewById(R.id.auth);
            ap[6] = (TextView) view.findViewById(R.id.cipher);
            ap[7] = (TextView) view.findViewById(R.id.beacons);
            ap[8] = (TextView) view.findViewById(R.id.data);
            ap[9] = (TextView) view.findViewById(R.id.ivs);
            ap[10] = (TextView) view.findViewById(R.id.clients);
            ap[11] = (TextView) view.findViewById(R.id.manuf);
        }

        ap[0].setText(info_ap.essid);
        ap[1].setText(info_ap.mac);
        ap[2].setText(Integer.toString(info_ap.ch));
        ap[3].setText(Integer.toString(info_ap.pwr));
        ap[4].setText(info_ap.enc);
        ap[5].setText(info_ap.auth);
        ap[6].setText(info_ap.cipher);
        ap[7].setText(Integer.toString(info_ap.beacons));
        ap[8].setText(Integer.toString(info_ap.data));
        ap[9].setText(Integer.toString(info_ap.ivs));
        ap[10].setText(Integer.toString(info_ap.clients.size()));
        ap[11].setText(info_ap.manuf);

        builder.setView(view);
        builder.setTitle(info_ap.essid);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //close
            }
        });
        builder.setNeutralButton("Refresh", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {}
        });
        return builder.create();
    }
    @Override
    public void onStart() {
        super.onStart();
        AlertDialog d = (AlertDialog)getDialog();
        if(d != null) {
            Button neutralButton = d.getButton(Dialog.BUTTON_NEUTRAL);
            neutralButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ap[0].setText(info_ap.essid);
                    ap[1].setText(info_ap.mac);
                    ap[2].setText(Integer.toString(info_ap.ch));
                    ap[3].setText(Integer.toString(info_ap.pwr));
                    ap[4].setText(info_ap.enc);
                    ap[5].setText(info_ap.auth);
                    ap[6].setText(info_ap.cipher);
                    ap[7].setText(Integer.toString(info_ap.beacons));
                    ap[8].setText(Integer.toString(info_ap.data));
                    ap[9].setText(Integer.toString(info_ap.ivs));
                    ap[10].setText(Integer.toString(info_ap.clients.size()));
                    ap[11].setText(info_ap.manuf);
                }
            });
        }
    }
}
