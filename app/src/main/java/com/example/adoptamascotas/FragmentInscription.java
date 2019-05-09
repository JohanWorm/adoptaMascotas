package com.example.adoptamascotas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FragmentInscription extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.inscription_view, container, false);

        // spinner identification type
        Spinner spinnerIdentificationType = (Spinner) rootView.findViewById(R.id.identificationType);
        ArrayAdapter<CharSequence> adapterIdentificationType = ArrayAdapter.createFromResource(getActivity(),
                R.array.identification_type_array, android.R.layout.simple_spinner_item);
        adapterIdentificationType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdentificationType.setAdapter(adapterIdentificationType);

        return rootView;
    }


}
