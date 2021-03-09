package crawler.dgts.utils;

public enum  DCMErrorCode {
    UNKNOWN(0, "Unknown"),
    NOT_SUPPORTED(1,"Not supported yet"),
    INVALID_PARAM(2, "Lỗi param không hợp lệ"),
    INVALID_TOKEN(AppConstant.ERROR_CODE.INVALID_TOKEN, "Invalid token"),
    INVALID_BOND_ID(AppConstant.ERROR_CODE.INVALID_BONDID, "Invalid Bond Id"),
    INVALID_TEMP_BOND_ID(AppConstant.ERROR_CODE.INVALID_BOND_TEMP_ID, "Invalid Bond Temp Id"),
    INVALID_USERNAME(AppConstant.ERROR_CODE.INVALID_USERNAME, "Invalid Username"),
    INVALID_BOND_ISSUANCE_PARTICIPANT_COMPANY_GROUP_TYPE(AppConstant.ERROR_CODE.INVALID_BOND_ISSUANCE_PARTICIPANT_COMPANY_GROUP_TYPE, "Invalid Bond Issuance Participant Company Group Type"),
    INVALID_BOND_ISSUANCE_PARTICIPANT_COMPANY(AppConstant.ERROR_CODE.INVALID_BOND_ISSUANCE_PARTICIPANT_COMPANY, "Invalid Bond Issuance Participant Company"),
    INVALID_BOND_ISSUANCE_PARTICIPANT_PARTICIPANT_TYPE(AppConstant.ERROR_CODE.INVALID_BOND_ISSUANCE_PARTICIPANT_PARTICIPANT_TYPE, "Invalid Bond Issuance Participant Type"),
    INVALID_BOND_PARTICIPANT_CONTACT_ID(AppConstant.ERROR_CODE.INVALID_BOND_PARTICIPANT_CONTACT_ID,"Invalid Bond Participant Contact Id"),
    INVALID_BOND_PARTICIPANT_CONTACT_DESCRIPTION(AppConstant.ERROR_CODE.INVALID_BOND_PARTICIPANT_CONTACT_DESCRIPTION,"Invalid Bond Participant Contact Description"),
    NOT_EXISTS_CASEID(AppConstant.ERROR_CODE.NOT_EXISTS_CASEID, "Invalid Case Id"),
    INVALID_BOND_FEE_ID(AppConstant.ERROR_CODE.INVALID_BOND_FEE_ID, "Invalid Bond Fee Id"),
    INVALID_BOND_FEE_FREQUENCY_CODE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_FREQUENCY_CODE, "Invalid Bond Frequency Code"),
    INVALID_BOND_FEE_DESCRIPTION(AppConstant.ERROR_CODE.INVALID_BOND_FEE_DESCRIPTION, "Invalid Bond Fee Description"),
    INVALID_BOND_FEE_TCB_FEE_SHARING(AppConstant.ERROR_CODE.INVALID_BOND_FEE_TCB_FEE_SHARING, "Invalid Bond Fee TCB Fee Sharing"),
    INVALID_BOND_FEE_TYPE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_TYPE, "Invalid Bond Fee Type"),
    INVALID_BOND_FEE_PAYMENT_TYPE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_TYPE, "Invalid Bond Fee Payment Type"),

    INVALID_BOND_FEE_PAYMENT_DETAIL_ID(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_DETAIL_ID, "Invalid Bond Fee Paymentd Detail Id"),
    INVALID_BOND_FEE_PAYMENT_DETAIL_RATE_CODE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_DETAIL_RATE_CODE, "Invalid Bond Fee Payment Detail Rate Code"),
    INVALID_BOND_FEE_PAYMENT_DETAIL_AMOUNT_CODE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_DETAIL_AMOUNT_CODE, "Invalid Bond Fee Payment Detail Amount Code"),
    INVALID_BOND_FEE_PAYMENT_DETAIL_PERIOD_STARTDATE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_DETAIL_PERIOD_STARTDATE, "Invalid Bond Fee Payment Detail Period Start Date"),
    INVALID_BOND_FEE_PAYMENT_DETAIL_PERIOD_ENDDATE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_DETAIL_PERIOD_ENDDATE, "Invalid Bond Fee Payment Detail Period End Date"),
    INVALID_BOND_FEE_PAYMENT_DETAIL_INVOICE_DATE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_DETAIL_INVOICE_DATE, "Invalid Bond Fee Payment Detail Invoice Date"),
    INVALID_BOND_FEE_PAYMENT_DETAIL_PAYMENT_DATE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_DETAIL_PAYMENT_DATE, "Invalid Bond Fee Payment Payment Date"),
    INVALID_BOND_FEE_PAYMENT_DETAIL_REVENUE_RECOGNITION_DATE(AppConstant.ERROR_CODE.INVALID_BOND_FEE_PAYMENT_DETAIL_REVENUE_RECOGNITION_DATE, "Invalid Bond Fee Payment Detail Revenue Recognition Date"),
    INVALID_BOND_TEMP_BASE_INFO_TENOR_DAY(AppConstant.ERROR_CODE.INVALID_BOND_BASE_INFO_TENOR_DAY, "Ngày kỳ hạn không được vượt quá 31 ngày"),
    BOND_TEMP_BASE_INFO_TENOR_MUST_BE_NOT_EMPTY(AppConstant.ERROR_CODE.INVALID_BOND_BASE_INFO_TENOR_DAY, "Kỳ hạn bond temp không được trống"),
    INVALID_BOND_TEMP_AMOUNT(AppConstant.ERROR_CODE.INVALID_BOND_TEMP_AMOUNT, "Tổng mệnh giá phát hành của các Bond Template đã vượt quá tổng mệnh giá phát hành của Case"),
    INVALID_CASE_AMOUNT(AppConstant.ERROR_CODE.INVALID_CASE_AMOUNT, "Tổng mệnh giá phát hành của các Bond Template đã vượt quá mệnh giá phát hành của Case. Vui lòng kiểm tra dữ liệu"),
    BOND_TEMP_NOT_EXISTED(AppConstant.ERROR_CODE.BOND_TEMP_NOT_EXISTED, "Bond Temp không tồn tại"),
    CASE_ID_NOT_EXISTED(AppConstant.ERROR_CODE.INVALID_CASEID, "Case Id không tồn tại"),
    CANNOT_DEACTIVATE_CLOSED_CASE(AppConstant.ERROR_CODE.CANNOT_DEACTIVATE_CLOSED_CASE, "Bạn không được thực hiện deactivate case có trạng thái Close"),
    CANNOT_DELETE_ACTIVE_CASE(AppConstant.ERROR_CODE.CANNOT_DELETE_ACTIVE_CASE, "Bạn không được thực hiện delete case có trạng thái Active"),
    CANNOT_DEACTIVATE_CASE_IF_BOND_ISSUED(AppConstant.ERROR_CODE.CANNOT_DEACTIVATE_CASE_IF_BOND_ISSUED, "Bạn không được thực hiện deactivate case có chứa trái phiếu đã phát hành"),
    CANNOT_DEACTIVATE_BOND_TEMPLATE_IF_BOND_ISSUED(AppConstant.ERROR_CODE.CANNOT_DEACTIVATE_BOND_TEMPLATE_IF_BOND_ISSUED, "Bạn không được thực hiện deactivate Bond Template có chứa trái phiếu đã phát hành"),
    INVALID_BOND_DISBURSEMENT_DATA(AppConstant.ERROR_CODE.INVALID_BOND_DISBURSEMENT_PROGRESS, "Không thể insert dữ liệu nếu thiếu case_id, bond_temp_id hay bond_id"),
    CANNOT_DELETE_ACTIVE_BOND_TEMPLATE(AppConstant.ERROR_CODE.CANNOT_DELETE_ACTIVE_BOND_TEMPLATE, "Bạn không được thực hiện delete bond template có trạng thái Active"),
    INVALID_BOND_TEMP_SECURED_ASET_ID(AppConstant.ERROR_CODE.INVALID_BOND_SECURED_ASSET_BOND_ID, "Secure Asset ID không hợp lệ hoặc không tồn tại.")
    ;

    private final int code;
    private final String message;

    DCMErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
