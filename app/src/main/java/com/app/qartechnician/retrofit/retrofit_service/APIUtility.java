package com.app.qartechnician.retrofit.retrofit_service;

import android.content.Context;
import android.util.Log;

import com.app.qartechnician.R;
import com.app.qartechnician.models.calendar_management.calendar_management_request.CalendarManageRequest;
import com.app.qartechnician.models.calendar_management.calendar_management_response.CalendarManageResponse;
import com.app.qartechnician.models.calendar_view.calendar_request.CalendarViewRequest;
import com.app.qartechnician.models.calendar_view.calendar_response.CalendarViewResponse;
import com.app.qartechnician.models.change_password.change_password_request.ChangePasswordRequest;
import com.app.qartechnician.models.change_password.change_password_response.ChangePasswordResponse;
import com.app.qartechnician.models.dashboard_data.dashboard_data_request.DashboardDataRequest;
import com.app.qartechnician.models.dashboard_data.dashboard_data_response.DashboardDataResponse;
import com.app.qartechnician.models.garage_money.garage_money_response.GarageMoneyResponse;
import com.app.qartechnician.models.garage_money_admin.garage_money_admin_request.GarageMoneyAdminRequest;
import com.app.qartechnician.models.garage_money_admin.garage_money_admin_response.GarageMoneyAdminResponse;
import com.app.qartechnician.models.log_in_model.log_in_request.LogInEmailRequest;
import com.app.qartechnician.models.log_in_model.log_in_response.LogInEmailResponse;
import com.app.qartechnician.models.manage_technician.manage_technician_request.ManageTechnicianRequest;
import com.app.qartechnician.models.manage_technician.manage_technician_response.ManageTechnicianResponse;
import com.app.qartechnician.models.my_appointment.my_appointment_request.MyAppointmentRequest;
import com.app.qartechnician.models.my_appointment.my_appointment_response.MyAppointmentResponse;
import com.app.qartechnician.models.notifications.notification_response.NotificationResponse;
import com.app.qartechnician.models.ongoing_order.ongoing_order_request.OnGoingOrderRequest;
import com.app.qartechnician.models.ongoing_order.ongoing_order_response.OnGoingOrderResponse;
import com.app.qartechnician.models.profile_details.profile_details_response.ProfileDetailsResponse;
import com.app.qartechnician.models.profile_update.profile_update_response.ProfileUpdateResponse;
import com.app.qartechnician.models.raise_quotation.raise_quotation_request.RaiseQuotationRequest;
import com.app.qartechnician.models.raise_quotation.raise_quotation_response.RaiseQuotationResponse;
import com.app.qartechnician.models.status_pending.status_pending_request.StatusPendingRequest;
import com.app.qartechnician.models.status_pending.status_pending_response.StatusPendingResponse;
import com.app.qartechnician.models.technician_list.technician_list_request.TechnicianListRequest;
import com.app.qartechnician.models.technician_list.technician_list_response.TechnicianListResponse;
import com.app.qartechnician.models.terms_privacy_about_us.terms_privacy_about_response.TermsPrivacyAboutUsResponse;
import com.app.qartechnician.models.todays_job.todays_job_request.TodayJobRequest;
import com.app.qartechnician.models.todays_job.todays_job_response.TodayJobResponse;
import com.app.qartechnician.models.upcoming_order.upcoimg_order_response.UpcomingOrderResponse;
import com.app.qartechnician.models.upcoming_order.upcoming_order_request.UpcomingOrderRequest;
import com.app.qartechnician.retrofit.retrofit_helper.APIServiceGenerator;
import com.app.qartechnician.retrofit.retrofit_helper.ProcessDialog;
import com.app.qartechnician.utils.CommonUtils;
import com.google.gson.Gson;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * 1.Define - Base_URL of API
 * 2.All Api (request & response) Methods
 *       -> arguments (context,isDialog,requestModel,APIResponseListener)
 * Note:Define - API Methods in APIService Interface
 */

public class APIUtility {

    private static final String TAG = "APIUtility";
    private APIService mApiService;
    private static final String BASE_URL = "http://3.12.253.202:4242/";

    public interface APIResponseListener<T> {
        void onReceiveResponse(T response);

        void onStatusFailed(T response);

        void onFailure();
    }

    public APIUtility() {
        APIServiceGenerator.setBaseUrl(BASE_URL);
        APIServiceGenerator.addHeader("Content-Type", "application/json");
        mApiService = APIServiceGenerator.createService(APIService.class);
    }

    public void showDialog(Context context, boolean isDialog) {
        if (isDialog) {
            ProcessDialog.start(context);
        }
    }

    public void dismissDialog(boolean isDialog) {
        if (isDialog) {
            ProcessDialog.dismiss();
        }
    }

    //Login By Email and Password
    public void login(Context context, final boolean isDialog, final LogInEmailRequest requestModel, final APIResponseListener<LogInEmailResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.loginEmail(requestModel).enqueue(new Callback<LogInEmailResponse>() {
                @Override
                public void onResponse(Call<LogInEmailResponse> call, Response<LogInEmailResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<LogInEmailResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Upcoming Order
    public void upcomingOrder(Context context, final boolean isDialog, String token,final UpcomingOrderRequest requestModel, final APIResponseListener<UpcomingOrderResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.upcomingOrder(token,requestModel).enqueue(new Callback<UpcomingOrderResponse>() {
                @Override
                public void onResponse(Call<UpcomingOrderResponse> call, Response<UpcomingOrderResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<UpcomingOrderResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //OnGoing Order
    public void ongoingOrder(Context context, final boolean isDialog, String token, final OnGoingOrderRequest requestModel, final APIResponseListener<OnGoingOrderResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.ongoingOrder(token, requestModel).enqueue(new Callback<OnGoingOrderResponse>() {
                @Override
                public void onResponse(Call<OnGoingOrderResponse> call, Response<OnGoingOrderResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<OnGoingOrderResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //OnGoing Order
    public void todayJob(Context context, final boolean isDialog, String token, final TodayJobRequest requestModel, final APIResponseListener<TodayJobResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.todayJob(token, requestModel).enqueue(new Callback<TodayJobResponse>() {
                @Override
                public void onResponse(Call<TodayJobResponse> call, Response<TodayJobResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<TodayJobResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Change Password
    public void changePassword(Context context, final boolean isDialog, String token, final ChangePasswordRequest requestModel, final APIResponseListener<ChangePasswordResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.changePassword(token, requestModel).enqueue(new Callback<ChangePasswordResponse>() {
                @Override
                public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<ChangePasswordResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Profile Details
    public void profileDetails(Context context, final boolean isDialog, String token,String loginAs, final APIResponseListener<ProfileDetailsResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + loginAs);

            showDialog(context, isDialog);
            mApiService.profileDetails(token,loginAs).enqueue(new Callback<ProfileDetailsResponse>() {
                @Override
                public void onResponse(Call<ProfileDetailsResponse> call, Response<ProfileDetailsResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<ProfileDetailsResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Technician List
    public void technicianList(Context context, final boolean isDialog, String token, final TechnicianListRequest requestModel, final APIResponseListener<TechnicianListResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.technicianList(token,requestModel).enqueue(new Callback<TechnicianListResponse>() {
                @Override
                public void onResponse(Call<TechnicianListResponse> call, Response<TechnicianListResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<TechnicianListResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Manage Technician List
    public void manageTechnician(Context context, final boolean isDialog, String token, final ManageTechnicianRequest requestModel, final APIResponseListener<ManageTechnicianResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.manageTechnician(token,requestModel).enqueue(new Callback<ManageTechnicianResponse>() {
                @Override
                public void onResponse(Call<ManageTechnicianResponse> call, Response<ManageTechnicianResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<ManageTechnicianResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Dashboard Data Counting
    public void dashboardData(Context context, final boolean isDialog, String token, final DashboardDataRequest requestModel, final APIResponseListener<DashboardDataResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.dashboardData(token,requestModel).enqueue(new Callback<DashboardDataResponse>() {
                @Override
                public void onResponse(Call<DashboardDataResponse> call, Response<DashboardDataResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<DashboardDataResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Status Pending
    public void statusPending(Context context, final boolean isDialog, String token, final StatusPendingRequest requestModel, final APIResponseListener<StatusPendingResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.statusPending(token,requestModel).enqueue(new Callback<StatusPendingResponse>() {
                @Override
                public void onResponse(Call<StatusPendingResponse> call, Response<StatusPendingResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<StatusPendingResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //My Appointment
    public void myAppointment(Context context, final boolean isDialog, String token, final MyAppointmentRequest requestModel, final APIResponseListener<MyAppointmentResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.myAppointment(token,requestModel).enqueue(new Callback<MyAppointmentResponse>() {
                @Override
                public void onResponse(Call<MyAppointmentResponse> call, Response<MyAppointmentResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<MyAppointmentResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Raise Quotation
    public void raiseQuotation(Context context, final boolean isDialog, String token, final RaiseQuotationRequest requestModel, final APIResponseListener<RaiseQuotationResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            Log.d(TAG, "REQUEST@@" + new Gson().toJson(requestModel));

            showDialog(context, isDialog);
            mApiService.raiseQuotation(token,requestModel).enqueue(new Callback<RaiseQuotationResponse>() {
                @Override
                public void onResponse(Call<RaiseQuotationResponse> call, Response<RaiseQuotationResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<RaiseQuotationResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Garage Money Withdrawal
    public void garageMoney(Context context, final boolean isDialog, String token, final APIResponseListener<GarageMoneyResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {

            showDialog(context, isDialog);
            mApiService.garageMoney(token).enqueue(new Callback<GarageMoneyResponse>() {
                @Override
                public void onResponse(Call<GarageMoneyResponse> call, Response<GarageMoneyResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<GarageMoneyResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Garage Money Withdrawal Admin
    public void garageMoneyAdmin(Context context, final boolean isDialog, String token, GarageMoneyAdminRequest requestModel, final APIResponseListener<GarageMoneyAdminResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {

            showDialog(context, isDialog);
            mApiService.garageMoneyAdmin(token,requestModel).enqueue(new Callback<GarageMoneyAdminResponse>() {
                @Override
                public void onResponse(Call<GarageMoneyAdminResponse> call, Response<GarageMoneyAdminResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<GarageMoneyAdminResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Terms-Conditions ,About Us , Privacy Policy
    public void termsPrivacyAboutUs(Context context, final boolean isDialog, String token, String Type, String loginAs, final APIResponseListener<TermsPrivacyAboutUsResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {

            showDialog(context, isDialog);
            mApiService.termsPrivacyAboutUs(token, Type, loginAs).enqueue(new Callback<TermsPrivacyAboutUsResponse>() {
                @Override
                public void onResponse(Call<TermsPrivacyAboutUsResponse> call, Response<TermsPrivacyAboutUsResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<TermsPrivacyAboutUsResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Notifications
    public void notifications(Context context, final boolean isDialog, String token, final APIResponseListener<NotificationResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {

            showDialog(context, isDialog);
            mApiService.notifications(token).enqueue(new Callback<NotificationResponse>() {
                @Override
                public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<NotificationResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Multi-Part - Edit Profile
    public void profileUpdate(Context context, final boolean isDialog, String token, MultipartBody multipartBody, final APIResponseListener<ProfileUpdateResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {
            showDialog(context, isDialog);

            mApiService.profileUpdate(token, multipartBody).enqueue(new Callback<ProfileUpdateResponse>() {
                @Override
                public void onResponse(Call<ProfileUpdateResponse> call, Response<ProfileUpdateResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {

                            apiResponseListener.onReceiveResponse(response.body());


                        } else {
                            apiResponseListener.onStatusFailed(response.body());

                        }
                    }
                    dismissDialog(isDialog);

                }

                @Override
                public void onFailure(Call<ProfileUpdateResponse> call, Throwable t) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);

                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Calender View
    public void calendarView(Context context, final boolean isDialog, CalendarViewRequest requestModel, final APIResponseListener<CalendarViewResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {

            showDialog(context, isDialog);
            mApiService.calendarView(requestModel).enqueue(new Callback<CalendarViewResponse>() {
                @Override
                public void onResponse(Call<CalendarViewResponse> call, Response<CalendarViewResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<CalendarViewResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }

    //Calender Management
    public void calendarManage(Context context, final boolean isDialog, String token, CalendarManageRequest requestModel, final APIResponseListener<CalendarManageResponse> apiResponseListener) {
        if (CommonUtils.isNetworkAvailable(context)) {

            showDialog(context, isDialog);
            mApiService.calendarManage(token, requestModel).enqueue(new Callback<CalendarManageResponse>() {
                @Override
                public void onResponse(Call<CalendarManageResponse> call, Response<CalendarManageResponse> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 1) {
                            apiResponseListener.onReceiveResponse(response.body());
                        } else {
                            apiResponseListener.onStatusFailed(response.body());
                        }
                    }
                    dismissDialog(isDialog);
                }

                @Override
                public void onFailure(Call<CalendarManageResponse> call, Throwable throwable) {
                    apiResponseListener.onFailure();
                    dismissDialog(isDialog);
                }
            });
        } else {
            dismissDialog(isDialog);
            CommonUtils.alert(context, context.getResources().getString(R.string.no_internet_text));
        }
    }


}