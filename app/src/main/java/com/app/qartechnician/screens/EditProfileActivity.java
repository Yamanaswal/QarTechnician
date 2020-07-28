package com.app.qartechnician.screens;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.EditProfileAdapter;
import com.app.qartechnician.models.profile_update.profile_update_response.ProfileUpdateResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.Constants;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "EditProfileActivity";
    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;
    CircleImageView profile_image;
    EditText full_name, phone_number;
    TextView email, address;
    CardView take_photo;
    private String user_email, user_mobile, user_name, user_address, user_pic, country, city, state;
    private double longitude, latitude;
    String path;
    Button save_button;
    RecyclerView recycler_view;
    List<Bitmap> bitmapList;
    File fileCoverImage;
    SwipeRefreshLayout pullToRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        setIds();
        setData();
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        back_button = toolbar.findViewById(R.id.back_button);
        full_name = findViewById(R.id.full_name);
        phone_number = findViewById(R.id.phone_number);
        address = findViewById(R.id.address);
        full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        take_photo = findViewById(R.id.take_photo);
        profile_image = findViewById(R.id.profile_image);
        save_button = findViewById(R.id.save_button);
        recycler_view = findViewById(R.id.recycler_view);
        pullToRefresh = findViewById(R.id.pullToRefresh);


        //Listeners
        back_button.setOnClickListener(this);
        save_button.setOnClickListener(this);
        take_photo.setOnClickListener(this);
        address.setOnClickListener(this);
        profile_image.setOnClickListener(this);
        pullToRefresh.setOnRefreshListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.edit_profile);
        setSupportActionBar(toolbar);
        setUserProfile();

        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        CommonUtils.requestMultiplePermissions(this, permissions);

        bitmapList = new ArrayList<>();
        //Getting User Profile Details

    }

    private void setRecyclerView(List<Bitmap> bitmapList) {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        EditProfileAdapter adapter = new EditProfileAdapter(this, bitmapList);
        recycler_view.setAdapter(adapter);
    }

    private void setUserProfile() {
        //Getting data from Profile Page
        user_email = getIntent().getStringExtra("email");
        user_name = getIntent().getStringExtra("name");
        user_mobile = getIntent().getStringExtra("mobile");
        user_pic = getIntent().getStringExtra("profile_pic");
        user_address = getIntent().getStringExtra("address");
        country = getIntent().getStringExtra("country");
        city = getIntent().getStringExtra("city");
        state = getIntent().getStringExtra("state");
        longitude = getIntent().getDoubleExtra("longitude", 0);
        latitude = getIntent().getDoubleExtra("latitude", 0);

        //Setting in Edit Profile
        email.setText(user_email);
        address.setText(user_address);
        full_name.setText(user_name);
        phone_number.setText(user_mobile);
        if (!user_pic.isEmpty()) {
            Glide.with(this).load(user_pic).placeholder(R.drawable.profile_image).into(profile_image);
        }

        pullToRefresh.setRefreshing(false);
    }

    private void hitApiMultiPart() {

        //Create Multipart Builder
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        System.out.println(user_pic);
        //Set Data in Multipart Builder
        builder.addFormDataPart("name", full_name.getText().toString().trim());
        builder.addFormDataPart("mobileNo", phone_number.getText().toString().trim());
        builder.addFormDataPart("loginAs", Preferences.getPreference(EditProfileActivity.this, PrefEntities.LOGIN_AS));
        builder.addFormDataPart("lat", String.valueOf(latitude));
        builder.addFormDataPart("long", String.valueOf(longitude));
        builder.addFormDataPart("postalAddress", user_address);
        builder.addFormDataPart("country", country);
        builder.addFormDataPart("city", city);
        builder.addFormDataPart("state", state);

        if (path != null && !path.isEmpty()) {
            fileCoverImage = new File(path);
            builder.addFormDataPart("profileImage",
                    fileCoverImage.getName() + System.currentTimeMillis(),
                    RequestBody.create(fileCoverImage, MediaType.parse("multipart/form-data")));

        }

        //Create Multipart Request
        final MultipartBody requestBody = builder.build();

        new APIUtility().profileUpdate(EditProfileActivity.this, true, Preferences.getPreference(EditProfileActivity.this, PrefEntities.ACCESS_TOKEN), requestBody,
                new APIUtility.APIResponseListener<ProfileUpdateResponse>() {
                    @Override
                    public void onReceiveResponse(ProfileUpdateResponse response) {
                        if( response != null && response.getCode() == 1){
                            Log.d(TAG, "onReceiveResponse: " + response.getMessage());
                            Intent intent = new Intent(EditProfileActivity.this, HomeActivity.class);
                            intent.putExtra(Constants.BACK_KEY, "back_key");
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onStatusFailed(ProfileUpdateResponse response) {
                        Toast.makeText(EditProfileActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure() {
                        CommonUtils.alert(EditProfileActivity.this, getString(R.string.somethingwentwrong));
                    }
                });


    }

    private void selectImage(Context context) {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                //Take Photo - 0
                case 0:
                    if (resultCode == RESULT_OK && data != null) {

                        Bitmap photo = (Bitmap) data.getExtras().get("data");
                        profile_image.setImageBitmap(photo);

                        // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
                        Uri tempUri = CommonUtils.getImageUri(getApplicationContext(), photo);

                        // CALL THIS METHOD TO GET THE ACTUAL PATH
                        path = CommonUtils.getRealPathFromURI(tempUri, this);

                        System.out.println(path);
                    }
                    break;

                //Choose from Gallery - 1
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri uri = data.getData();

                        try {
                            Bitmap bitmap = (MediaStore.Images.Media.getBitmap(getContentResolver(), uri));
                            profile_image.setImageBitmap(bitmap);
                            path = CommonUtils.getRealPathFromURI(uri, this);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra(Constants.BACK_KEY, "back_key");
                startActivity(intent);
                finish();
                break;

            case R.id.profile_image:
                selectImage(this);
                break;

            case R.id.save_button:
                hitApiMultiPart();
                break;

            case R.id.take_photo:
                selectImage(this);
                setRecyclerView(bitmapList);
                break;

            case R.id.address:
                startActivity(new Intent(this, SelectLocationActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onRefresh() {
        setData();
    }


}
