package com.example.adoptamascotas;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterFragment extends Fragment {

    Fragment fragment = new StateFragment();

    EditText firstName;
    EditText secondName;
    EditText firstSurname;
    EditText secondSurname;
    Spinner identificationType;
    EditText identification;
    EditText email;
    RadioGroup gender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.register_view, container, false);

        Button buttonRegister = (Button) view.findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            firstName = (EditText) view.findViewById(R.id.firstName);
            secondName = (EditText) view.findViewById(R.id.secondName);
            firstSurname = (EditText) view.findViewById(R.id.firstSurname);
            secondSurname = (EditText) view.findViewById(R.id.secondSurname);
            identificationType = (Spinner) view.findViewById(R.id.identificationType);
            identification = (EditText) view.findViewById(R.id.identification);
            email = (EditText) view.findViewById(R.id.email);
            gender = (RadioGroup) view.findViewById(R.id.gender);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Bundle bundle = new Bundle();
            PersonRegister personRegisterData = new PersonRegister(firstName.getText().toString(), secondName.getText().toString(), firstSurname.getText().toString(), secondSurname.getText().toString(), identificationType.getSelectedItemPosition(), identification.getText().toString(), email.getText().toString(), gender.getCheckedRadioButtonId());
            if (validatePersonRegisterData(personRegisterData)) {
                bundle.putSerializable("PersonRegister", personRegisterData);
                fragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.content_frame, fragment);
                fragmentTransaction.commit();
            } else {
                Toast toastInvalidPersonRegisterData = Toast.makeText(getActivity().getApplicationContext(), R.string.invalidPersonRegisterData, Toast.LENGTH_SHORT);
                toastInvalidPersonRegisterData.show();
            }
            }
        });

        Button buttonCancel = (Button) view.findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.content_frame, new HomeFrament());
                fragmentTransaction.commit();
            }
        });


        Spinner spinnerIdentificationType = (Spinner) view.findViewById(R.id.identificationType);
        ArrayAdapter<CharSequence> adapterIdentificationType = ArrayAdapter.createFromResource(getActivity(),
                R.array.identification_type_array, android.R.layout.simple_spinner_item);
        adapterIdentificationType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdentificationType.setAdapter(adapterIdentificationType);

        return view;
    }

    public boolean validatePersonRegisterData(PersonRegister personRegisterData) {
        boolean statusRegister = true;

        if (TextUtils.isEmpty(personRegisterData.getFirstName().toString())) {
            statusRegister = false;
        } else if (TextUtils.isEmpty(personRegisterData.getFirstSurname().toString())) {
            statusRegister = false;
        } else if(TextUtils.isEmpty(personRegisterData.getIdentification().toString())) {
            statusRegister = false;
        } else if (personRegisterData.getIdentificationType() < 1) {
            statusRegister = false;
        } else if (TextUtils.isEmpty(personRegisterData.getEmail().toString())) {
            statusRegister = false;
        } else if (personRegisterData.getGender() < 1) {
            statusRegister = false;
        }

        return statusRegister;
    }

}
