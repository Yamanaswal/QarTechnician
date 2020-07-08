package com.app.qartechnician.models.raise_quotation.raise_quotation_response;

public class RaiseQuotationResponseAcceptStatus {

  private String acceptedBy;
  private String request;
  private String quotationRequest;
  private String _id;

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getQuotationRequest() {
        return quotationRequest;
    }

    public void setQuotationRequest(String quotationRequest) {
        this.quotationRequest = quotationRequest;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
