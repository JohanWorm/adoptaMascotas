package com.example.adoptamascotas;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.state_view, container, false);

        Bundle bundle = getArguments();
        PersonRegister personRegisterData = (PersonRegister) bundle.getSerializable("PersonRegister");

        System.out.print(personRegisterData);

        TextView labelName = view.findViewById(R.id.labelName);
        String sourceString = "<b>" + personRegisterData.getFirstName().toString().toUpperCase() + " " + personRegisterData.getFirstSurname().toString().toUpperCase() + "</b>:";
        labelName.setText(Html.fromHtml(sourceString));

        TextView labelInfo = view.findViewById(R.id.label2);
        labelInfo.setText(getString(R.string.text_state, personRegisterData.getEmail().toString()));

        TextView labelIdentificationType = view.findViewById(R.id.identificationType);
        labelIdentificationType.setText(getIdentificationType(personRegisterData.getIdentificationType()));

        TextView labelIdentification = view.findViewById(R.id.identification);
        labelIdentification.setText(personRegisterData.getIdentification().toString());

        TextView labelGender = view.findViewById(R.id.gender);
        if (personRegisterData.getGender() == 1) {
            labelGender.setText("Masculino");
        } else {
            labelGender.setText("Femenino");
        }

        return view;
    }

    public String getIdentificationType(int position) {
        String identificationType = "";
        switch (position) {
            case 1:
                identificationType = "Tarjeta de identidad";
                break;
            case 2:
                identificationType = "Cédula de ciudadanía";
                break;
            case 3:
                identificationType = "Cédula extranjería";
                break;
            case 4:
                identificationType = "Pasaporte";
                break;
        }

        return identificationType;
    }

}
