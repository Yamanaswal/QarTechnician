package com.app.qartechnician.fragments.home_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.app.qartechnician.R;
import com.app.qartechnician.models.profile_details.profile_details_response.ProfileDetailsResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.screens.AboutUsActivity;
import com.app.qartechnician.screens.ChangePasswordActivity;
import com.app.qartechnician.screens.EditProfileActivity;
import com.app.qartechnician.screens.LoginActivity;
import com.app.qartechnician.screens.ManageDatesActivity;
import com.app.qartechnician.screens.PrivacyPolicyActivity;
import com.app.qartechnician.screens.TechnicianManagementActivity;
import com.app.qartechnician.screens.TermsConditionActivity;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;
import com.bumptech.glide.Glide;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private View view;
    private RelativeLayout main_layout, manage_date, tech_management, change_password, about_us, privacy_policy, terms_condition, change_language, notification, log_out_button;
    private RelativeLayout edit_icon;
    private CircleImageView profile_image;
    TextView profile_name, email_id, phone_number, wallet_amount;
    SwitchCompat notification_switch;
    private String email, address, mobile, profile_pic, name, country, city, state;
    private double longitude, latitude;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        setIds();
        main_layout.setVisibility(View.INVISIBLE);
        hitApiProfileDetails();
        return view;
    }

    private void setIds() {
        main_layout = view.findViewById(R.id.main_layout);
        manage_date = view.findViewById(R.id.manage_date);
        tech_management = view.findViewById(R.id.tech_management);
        change_password = view.findViewById(R.id.change_password);
        about_us = view.findViewById(R.id.about_us);
        privacy_policy = view.findViewById(R.id.privacy_policy);
        terms_condition = view.findViewById(R.id.terms_condition);
        change_language = view.findViewById(R.id.change_language);
        notification = view.findViewById(R.id.notification);
        edit_icon = view.findViewById(R.id.edit_icon);
        profile_image = view.findViewById(R.id.profile_image);
        log_out_button = view.findViewById(R.id.log_out_button);
        profile_name = view.findViewById(R.id.profile_name);
        email_id = view.findViewById(R.id.email_id);
        phone_number = view.findViewById(R.id.phone_number);
        wallet_amount = view.findViewById(R.id.wallet_amount);
        notification_switch = view.findViewById(R.id.notification_switch);

        //Set Listeners
        manage_date.setOnClickListener(this);
        tech_management.setOnClickListener(this);
        change_password.setOnClickListener(this);
        about_us.setOnClickListener(this);
        privacy_policy.setOnClickListener(this);
        terms_condition.setOnClickListener(this);
        change_language.setOnClickListener(this);
        notification.setOnClickListener(this);
        edit_icon.setOnClickListener(this);
        log_out_button.setOnClickListener(this);
    }

    private void hitApiProfileDetails() {

        new APIUtility().profileDetails(getContext(), true,Preferences.getPreference(getContext(),PrefEntities.ACCESS_TOKEN),Preferences.getPreference(getContext(),PrefEntities.LOGIN_AS), new APIUtility.APIResponseListener<ProfileDetailsResponse>() {
            @Override
            public void onReceiveResponse(ProfileDetailsResponse response) {
                if (response != null && response.getCode() == 1) {
                    setData(response);
                } else {
                    Toast.makeText(getContext(), "" + R.string.somethingwentwrong, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStatusFailed(ProfileDetailsResponse response) {
                Toast.makeText(getContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                CommonUtils.alert(getContext(), getString(R.string.somethingwentwrong));
            }
        });
    }

    private void setData(ProfileDetailsResponse response) {
        if (isAdded() && response.getData().getUser().getAvatar() != null && !response.getData().getUser().getAvatar().isEmpty()) {
            Glide.with(Objects.requireNonNull(getContext())).load(response.getData().getUser().getAvatar()).placeholder(R.drawable.profile_image).into(profile_image);
            profile_pic = response.getData().getUser().getAvatar();
        }

        profile_name.setText(response.getData().getUser().getName());
        email_id.setText(response.getData().getUser().getEmail());
        phone_number.setText(response.getData().getUser().getMobileNo());
        wallet_amount.setText((int) response.getData().getWallet() + " Qar");
        email = response.getData().getUser().getEmail();
        name = response.getData().getUser().getName();
        mobile = response.getData().getUser().getMobileNo();
        address = response.getData().getUser().getAddress().getPostalAddress();
        if (response.getData().getUser().getAddress() != null) {
            country = response.getData().getUser().getAddress().getCountry();
            city = response.getData().getUser().getAddress().getCity();
            state = response.getData().getUser().getAddress().getState();
            longitude = response.getData().getUser().getAddress().getCoordinates().get(0);
            longitude = response.getData().getUser().getAddress().getCoordinates().get(1);
        }


        notification_switch.setChecked(response.getData().getUser().isNotification());

        //after data set show Main View
        main_layout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.manage_date:
                startActivity(new Intent(getContext(), ManageDatesActivity.class));
                getActivity().finish();
                break;

            case R.id.tech_management:
                startActivity(new Intent(getContext(), TechnicianManagementActivity.class));
                getActivity().finish();
                break;

            case R.id.change_password:
                startActivity(new Intent(getContext(), ChangePasswordActivity.class));
                getActivity().finish();
                break;

            case R.id.about_us:
                startActivity(new Intent(getContext(), AboutUsActivity.class));
                getActivity().finish();
                break;

            case R.id.privacy_policy:
                startActivity(new Intent(getContext(), PrivacyPolicyActivity.class));
                getActivity().finish();
                break;

            case R.id.terms_condition:
                startActivity(new Intent(getContext(), TermsConditionActivity.class));
                getActivity().finish();
                break;

            case R.id.change_language:
                break;

            case R.id.edit_icon:
                Intent intent = new Intent(getContext(), EditProfileActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("name", name);
                intent.putExtra("mobile", mobile);
                intent.putExtra("address", address);
                intent.putExtra("profile_pic", profile_pic);
                intent.putExtra("country", country);
                intent.putExtra("city", city);
                intent.putExtra("state", state);
                intent.putExtra("longitude", longitude);
                intent.putExtra("latitude", latitude);
                startActivity(intent);
                getActivity().finish();
                break;

            case R.id.log_out_button:
                Preferences.removePreference(getContext(), PrefEntities.ACCESS_TOKEN);
                Preferences.removePreference(getContext(), PrefEntities.USER);
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
                break;
        }
    }
}
