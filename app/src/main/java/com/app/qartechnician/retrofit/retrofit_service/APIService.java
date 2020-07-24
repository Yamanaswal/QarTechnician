package com.app.qartechnician.retrofit.retrofit_service;

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

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @POST("api/technician/login")
    Call<LogInEmailResponse> loginEmail(@Body LogInEmailRequest request);

    @POST("api/booking/technician/upcomming")
    Call<UpcomingOrderResponse> upcomingOrder(@Header("Authorization") String token, @Body UpcomingOrderRequest upcomingOrderRequest);

    @POST("api/booking/technician/ongoing")
    Call<OnGoingOrderResponse> ongoingOrder(@Header("Authorization") String token, @Body OnGoingOrderRequest onGoingOrderRequest);

    @POST("api/booking/technician/todaybooking")
    Call<TodayJobResponse> todayJob(@Header("Authorization") String token, @Body TodayJobRequest todayJobRequest);

    @POST("api/technician/password/update/both")
    Call<ChangePasswordResponse> changePassword(@Header("Authorization") String token, @Body ChangePasswordRequest changePasswordRequest);

    @GET("api/technician/profile/detail/both")
    Call<ProfileDetailsResponse> profileDetails(@Header("Authorization") String token, @Query("loginAs") String loginAs);

    @POST("api/garage/technician/list")
    Call<TechnicianListResponse> technicianList(@Header("Authorization") String token, @Body TechnicianListRequest technicianListRequest);

    @POST("api/technician/garage/technician/permission")
    Call<ManageTechnicianResponse> manageTechnician(@Header("Authorization") String token, @Body ManageTechnicianRequest manageTechnicianRequest);

    @POST("api/booking/dashboard/tech/garage")
    Call<DashboardDataResponse> dashboardData(@Header("Authorization") String token, @Body DashboardDataRequest dashboardDataRequest);

    @POST("api/booking/technician/statuspending")
    Call<StatusPendingResponse> statusPending(@Header("Authorization") String token, @Body StatusPendingRequest statusPendingRequest);

    @POST("api/booking/myappointment/technician/garage")
    Call<MyAppointmentResponse> myAppointment(@Header("Authorization") String token, @Body MyAppointmentRequest myAppointmentRequest);

    @POST("api/booking/quotation")
    Call<RaiseQuotationResponse> raiseQuotation(@Header("Authorization") String token, @Body RaiseQuotationRequest raiseQuotationRequest);

    @POST("api/garage/wallet")
    Call<GarageMoneyResponse> garageMoney(@Header("Authorization") String token);

    @POST("api/garage/wallet/withdrawal/request")
    Call<GarageMoneyAdminResponse> garageMoneyAdmin(@Header("Authorization") String token, @Body GarageMoneyAdminRequest garageMoneyAdminRequest);

    @GET("api/cms/get")
    Call<TermsPrivacyAboutUsResponse> termsPrivacyAboutUs(@Header("Authorization") String token, @Query("type") String Type, @Query("loginAs") String loginAs);

    @POST("api/notification/technician/list")
    Call<NotificationResponse> notifications(@Header("Authorization") String token);

    //Important - edit profile
    @POST("api/technician/profile/update/both")
    Call<ProfileUpdateResponse> profileUpdate(@Header("Authorization") String token, @Body RequestBody requestBody);


}
