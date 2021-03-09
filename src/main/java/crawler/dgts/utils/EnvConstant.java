package crawler.dgts.utils;

public class EnvConstant {
	public static final int REF_COUPON_TYPE_FIX = 115;  // cố định
	public static final int REF_COUPON_TYPE_FLOAT = 116; // thả nổi

	public static final int REF_ISSUANCE_FORM_PP = 118;
	public static final int REF_ISSUANCE_FORM_PO = 119;
	public static final int REF_SECTORL2_COMMERCIAL_BANK = 152;

	public static final int REF_GUARANTOR_FORM_PERSONAL = 252;
	public static final int REF_GUARANTOR_FORM_COMPANY = 254;

	public static final int REF_PARTICIPANT_TYPE_ISSUER = 265;
	public static final int REF_PARTICIPANT_TYPE_UNDERWRITING = 266;
	public static final int REF_PARTICIPANT_TYPE_LAW_CONSULTING = 268;
	public static final int REF_PARTICIPANT_TYPE_CUSTODY = 269;
	public static final int REF_PARTICIPANT_TYPE_COMPANY_CUSTODY = 938;
	public static final int REF_PARTICIPANT_TYPE_BOND_OWNER_REP = 270;
	public static final int REF_PARTICIPANT_TYPE_SECURED_AGENT = 271;
	public static final int REF_PARTICIPANT_TYPE_ACCOUNT_MANAGEMENT = 272;
	public static final int REF_PARTICIPANT_TYPE_DLPH = 300;
	public static final int REF_PARTICIPANT_TYPE_TVPH = 583;
	public static final int REF_PARTICIPANT_TYPE_REGISTRATION = 682;
	public static final int REF_COMPANY_GROUP_TYPE_ISSUER = 280;
	public static final int REF_COMPANY_GROUP_TYPE_ADVISORY = 281;
	public static final int REF_COMPANY_GROUP_TYPE_DAI_LY = 282;
	public static final int REF_COMPANY_GROUP_TYPE_ADVISORY_RELEASE = 283;
	public static final int REF_COMPANY_GROUP_TYPE_OTHER = 284;

	public static final int REF_PHASING_ISSUED = 349;

	public static final int REF_COUPON_PERIOD_TYPE_REMAIN = 370;
	public static final int REF_COUPON_PERIOD_TYPE_ALL = 371;

	public static final int REF_PERSONAL_GENDER_MALE = 417;
	public static final int REF_PERSONAL_GENDER_FEMALE = 418;

	public static final int REF_SUBSCRIPTION_TYPE_PRIMARY = 430;
	public static final int REF_SUBSCRIPTION_TYPE_SECONDARY = 431;

	public static final int REF_DICTIONARY_TYPE_EOD = 505;
	public static final int REF_DICTIONARY_TYPE_COVENANT = 506;
	public static final int REF_DICTIONARY_TYPE_DEFINITION = 508;

	public static final int REF_SHAREHOLDER_FORM_PERSONAL = 659;
	public static final int REF_SHAREHOLDER_FORM_ORGANIZATION = 660;

	public static final int REF_OWRNERSHIP_FORM_TNHH = 826;
	public static final int REF_OWRNERSHIP_FORM_TNHH_1_MEM = 925;
	public static final int REF_OWRNERSHIP_FORM_CP = 827;
	public static final int REF_CHAIRMAN_ROLE_CP = 910;
	public static final int REF_CHAIRMAN_ROLE_TNHH = 906;
	public static final int REF_CHAIRMAN_ROLE_TNHH_1TV = 927;
	public static final int REF_CEO_ROLE = 914;
	public static final int REF_BKS_ROLE = 919;
	public static final int REF_BTC_ROLE = 922;
	public static final int REF_PROJECT_AGREEMENT_PARTY_PERSONAL = 878;
	public static final int REF_PROJECT_AGREEMENT_PARTY_COMPANY = 879;
	
	public static final int REF_SECURED_ASSET_SECURITIES = 970;
	public static final int REF_SECURED_ASSET_REAL_ESTATE_MOVEABLE = 974;
	public static final int REF_SECURED_ASSET_REAL_ESTATE_IMMOVEABLE = 975;
	public static final int REF_SECURED_ASSET_FINANCIAL_INSTRUMENT = 972;
	public static final int REF_SECURED_ASSET_OTHER_MOVEABLE = 973;

	public static final int COMPANY_ID_TCBS = 993;
	public static final int COMPANY_ID_TCB = 645;
	public static final String COMPANY_TCB_TICKER = "TCB";
	public static final String COMPANY_TCBS_BANK_ACCOUNT = "138.3333.6666.016";

	public static final String REF_CATEGORY_INVESTER_TYPE = "EXPOSE_INVESTOR_TYPE";
	public static final String REF_CATEGORY_EXPOSE_PRIORITY = "EXPOSE_PRIORITY";

	public static final String BOND_ROLE_DEAL_SUPPERVISOR = "DCM Deal Supervisor";
	public static final String BOND_ROLE_DEAL_OWNER = "DCM Deal Owner";
	public static final String BOND_ROLE_DEAL_SUPPORTER = "DCM Deal Supporter";
	public static final String BOND_ROLE_DEAL_SPECIALIST = "DCM Deal Specialist";
	public static final String BOND_ROLE_DEAL_FOLLOWER = "DCM Deal Follower";

	// pipeline
	public static final String PIPELINE_SUPPERVISOR = "Supervisor";
	public static final String PIPELINE_OWNER = "Owner";
	public static final String PIPELINE_SENIOR_INVESTMENT_BANKER = "Senior Investment Banker";
	public static final String PIPELINE_ANALYST = "Analyst";
	public static final String PIPELINE_REGION = "REGION";
	public static final String PIPELINE_COMPANY_GROUP = "COMPANY_GROUP";
	public static final String PIPELINE_CASE_STATUS = "CASE_STATUS";
	public static final String PIPELINE_PHASING = "PHASING";
	public static final String PIPELINE_WHOLE_SALE = "Bán buôn";
	public static final String PIPELINE_RETAIL = "Bán lẻ";
	public static final String PIPELINE_REMAIN = "Còn lại";
	public static final String PIPELINE_IB_GROUP = "IB Group";
	public static final String PIPELINE_TCB = "Techcombank";
	public static final String PIPELINE_OTHER_FI = "Other FI";
	public static final String PIPELINE_NON_FI = "Non FI";
	public static final String GUARANTOR_TYPE_GUARANTEED = "GUARANTEE";
	public static final String GUARANTOR_TYPE_ASSET = "ASSET";

	public static final String PARRENT_TYPE_SECURED_ASSET = "INITIAL_APPRAISER";
	public static final String PARRENT_TYPE_MECHANISM = "REVALUATION_APPRAISER";

	public static final String TERMSHEET_CHECKLIST_TYPE = "TERMSHEET_CHECKLIST";

	public static final String DEAL_TYPE_CASE = "CASE";
	public static final String DEAL_TYPE_BOND = "BOND";

	public static final String BOND_HODER_REQUEST_MEETING = "MEETING";
	public static final String BOND_HODER_REQUEST_WRITE = "WRITE";
	public static final String BOND_HODER_INFOR_HC = "HC";
	public static final String BOND_HODER_INFOR_MR = "MR";
	public static final String BOND_HODER_INFOR_WR = "WR";

	public static final String BOND_PRIMARY_DISTRIBUTION_INVESTOR_TYPE_ORGANIZATION = "ORGANIZATION";
	public static final String BOND_PRIMARY_DISTRIBUTION_INVESTOR_TYPE_PERSONAL = "PERSONAL";

	public static final String TERMSHEET_STATUS_PROCESSING = "PROCESSING";
	public static final String TERMSHEET_STATUS_DRAFT = "DRAFT";
	public static final String TERMSHEET_STATUS_ACTIVE = "ACTIVE";
	public static final String TERMSHEET_STATUS_FINAl = "FINAl";

	public static final String BOND_UOP_TYPE_LEVEL_1 = "UOP_TYPE";
	public static final String BOND_UOP_TYPE_LEVEL_2 = "UOP_TYPE_2";

	public static final String BOND_TNC_FORM_TYPE = "TNC_FORM_TYPE";

	public static final String BOND_TNC_TYPE = "BOND_TNC_TYPE";
	public static final String BOND_UOP_FORM_TYPE = "UOP_FORM";

	public static final String BOND_EXPOSE_TYPE_INVESTER = "INVESTER";
	public static final String BOND_EXPOSE_TYPE_WAREHOUSE = "WAREHOUSE";

	public static final String CLASS_TYPE_BOND_DISTRIBUTION = "invokeBondDistribution";
	public static final String BOND_DISTRIBUTION_PARAMETER_BOND_ID = "bond_id";	
	public static final String BOND_DISTRIBUTION_PARAMETER_FROM_CASE = "from_case";	
	
	public static final String CLASS_TYPE_SECURE_ASSET_DOC = "SecureAssetDoc";
	public static final String SECURE_ASSET_PARAMETER_BOND_ID = "bond_id";	
	public static final String SECURE_ASSET_PARAMETER_ASSET_ID = "asset_id";	
	
	public static final String CLASS_TYPE_BOND_LISTING = "BondListingDocumentData";
	public static final String BOND_LISTING_PARAMETER_BOND_ID = "bond_id";	
	
	public static final String CLASS_TYPE_BOND_SUBSCRIBER_AGREEMENT = "BondSubscriberAgreement";
	public static final String BOND_SUBSCRIBER_AGREEMENT_PARAMETER_BOND_ID = "bond_primary_distribution_id";	
	
	public static final String CLASS_TYPE_BOND_ISSUANCE = "BondIssuance";
	public static final String BOND_ISSUANCE_PARAMETER_BOND_ID = "bond_id";	
	public static final String BOND_ISSUANCE_PARAMETER_FROM_CASE = "from_case";	
	public static final String BOND_ISSUANCE_PARAMETER_USING_BOND_MASTER = "using_bond_master";
	public static final String OWNERSHIP_FORM_FULL_NAME_CP = "Cổ phần";
	public static final String OWNERSHIP_FORM_FULL_NAME_TNHH = "Công ty trách nhiệm hữu hạn";
	public static final String OWNERSHIP_FORM_FULL_NAME_TNHH_1TV = "TNHH một thành viên";
	public static final String OWNERSHIP_FORM_FULL_NAME_TNHH_2TV = "TNHH hai thành viên trở lên";
	
	public static final String LINKING_WORDS_AND = "và";
	public static final String LINKING_WORDS_AND_OR = " và/hoặc ";
	public static final String ISSUANCE_METHOD_NOTE_VALUE_1 = "theo hình thức cố gắng tối đa";
	public static final String ISSUANCE_METHOD_NOTE_VALUE_2 = "theo hình thức cam kết chắc chắn";
	public static final String ISSUANCE_FORM_LOWER_CASE_1 = "Phát hành riêng lẻ";
	public static final String ISSUANCE_FORM_LOWER_CASE_2 = "Phát hành ra công chúng";
	public static final String ISSUANCE_FORM_LOWER_CASE_3 = "Phát hành riêng lẻ và/hoặc chào bán công chúng";
	public static final String UNDER_WRITING_BASIC_VALUE_1 = "theo hình thức nỗ lực tối đa";
	public static final String UNDER_WRITING_BASIC_VALUE_2 = "theo hình thức cam kết chắc chắn";
	public static final String BOND_SENIORITY_1 = "không phải nợ thứ cấp";
	public static final String BOND_SENIORITY_2 = "nợ thứ cấp";
	public static final String BOND_LISTING_VALUE_1 = "chắc chắn";
	public static final String BOND_LISTING_VALUE_2 = "có thể";
	public static final String BOND_LISTING_VALUE_3 = "hứa";

	public static final String UOP_WORKING_CAPITAL = "tăng quy mô vốn hoạt động";
	public static final String UOP_LOAN_RESTRUCTURE = "cơ cấu các khoản nợ";
	public static final String UOP_PROJECT_FINANCING = "thực hiện chương trình, dự án đầu tư";

	public static final int BOND_ISSUANCE_METHOD_120 = 120; //Bảo lãnh phát hành trên cơ sở cố gắng tối đa
	public static final int BOND_ISSUANCE_METHOD_121 = 121; //Bảo lãnh phát hành trên cơ sở cam kết chắc chắn
	public static final int BOND_ISSUANCE_METHOD_122 = 122; //Đại lý phát hành
	public static final int BOND_ISSUANCE_METHOD_123 = 123; //Đấu thầu
	public static final int BOND_ISSUANCE_METHOD_124 = 124; //Bán trực tiếp cho nhà đầu tư

	public static class BOND_TNC_OTHER_TYPE {
		public static final String COVENANT = "COVENANT";
		public static final String EOD = "EOD";
		public static final String DEFINITION = "DEFINITION";
	}

	public static class FEE_TYPE {
		public static final int BLPH = 438;
		public static final int LKTP = 439;
		public static final int DDNSHTP = 440;
		public static final int TVNY = 441;
		public static final int DVCK = 442;
		public static final int TVCBCK = 443;
		public static final int DLPH = 444;
		public static final int TVL = 931;
		public static final int QLTSDB = 932;
		public static final int QLTK = 933;
		public static final int TVPH = 934;
		public static final int DLDK = 935;
		public static final int DGTS = 936;
		public static final int DVLK = 937;
	}

	public static final int BOND_FEE_TYPE_CASE = 1;
	public static final int BOND_FEE_TYPE_BOND = 0;

	public static final String TAT_CA = "Tất cả";
	public static final String BLANK = "";
	public static final String ON_GOING = "On going";
	public static final String CLOSED = "Closed";
	public static final String CANCELLED = "Cancelled";

	public static final String COMMA = ",";
	public static final String DOT = ".";

	public static final int REF_BOND_LISTING = 351;

	public static final int ACTIVE = 1;
	public static final int INACTIVE = 0;

	public static final String IS_FROM_CASE = "IS_FROM_CASE";
	public static final String IS_FROM_BOND_TEMP = "IS_FROM_BOND_TEMP";
	public static final String IS_FROM_BOND = "IS_FROM_BOND";

	public static final String IS_FALSE_STRING = "false";
	public static final String IS_TRUE_STRING = "true";

	public static final int FIRST_INTEREST_PERIOD = 368;
	public static final int ALL_PERIODS = 371;

	//Convertible bonds
	public static final int BOND_TNC_TYPE_CONVERTIBLE_BONDS = 260; // Trái phiếu có chuyển đổi
	public static final int BOND_TNC_TYPE_BONDS_WARRANTS = 261; // Trái phiếu kèm chứng quyền
	public static final int BOND_TNC_TYPE_COLLATERAL = 263; // Có tài sản đảm bảo
	public static final int BOND_TNC_TYPE_GUARANTEE = 264; // Có bảo lãnh

	public static final int SENIORITY_SECONDARY_DEBT = 128; // Nợ thứ cấp

	public static final int REFERENCE_COUPON_207 = 207; // Lãi suất cơ sở áp dụng cho khách hàng doanh nghiệp lớn đối với các khoản vay ngắn hạn dưới 6 tháng bằng đồng Việt Nam có lãi suất thả nổi
	public static final int REFERENCE_COUPON_208 = 208; // Lãi suất cơ sở áp dụng cho khách hàng doanh nghiệp lớn đối với các khoản vay ngắn hạn 6 tháng bằng đồng Việt Nam có lãi suất thả nổi
	public static final int REFERENCE_COUPON_209 = 209; // Lãi suất cơ sở áp dụng cho khách hàng doanh nghiệp lớn đối với các khoản vay ngắn hạn trên 6 tháng đến nhỏ hơn hoặc bằng 1 năm bằng đồng Việt Nam có lãi suất thả nổi
	public static final int REFERENCE_COUPON_210 = 210; // Lãi suất cơ sở áp dụng cho khách hàng doanh nghiệp lớn đối với các khoản vay trung hạn trên 1 năm đến nhỏ hơn hoặc bằng 5 năm bằng đồng Việt Nam có lãi suất thả nổi
	public static final int REFERENCE_COUPON_211 = 211; // Lãi suất cơ sở áp dụng cho khách hàng doanh nghiệp lớn đối với các khoản vay dài hạn hạn trên 5 năm bằng đồng Việt Nam có lãi suất thả nổi
	public static final int REFERENCE_COUPON_585 = 585; // Lãi suất cơ sở áp dụng cho khách hàng doanh nghiệp lớn đối với các khoản vay lãi suất cố định

	public static final String PRECIOUS = "quý ";
	
	public static final int IS_MIGRATE = 1;

	public static final int IS_EXPOSE = 1;
	public static final int IS_NOT_EXPOSE = 0;

	public static final int PROMISE_LISING = 434;
	public static final int ASSURED_LISING = 351;
	public static final int MAY_LISING = 352;

	public static final int MASAN_GROUP = 354;

	public static final int TTTP = 1; // Thư thỏa thuận phí
	public static final int DNTTP = 2; // Đề nghị thanh toán phí
	
	public static final int REF_CASE_STATUS_ON_GOING = 60;

	public static String[] getFeeTypeName() {
		return FEE_TYPE_NAME;
	}

	protected static final String[] FEE_TYPE_NAME = {
			"Tư vấn chào bán chứng khoán",
			"Bảo lãnh phát hành",
			"Đại lý phát hành",
			"Tư vấn niêm yết"
	};

	public static Integer[] getFeeTypeIds() {
		return FEE_TYPE_IDS;
	}
	protected static final Integer[] FEE_TYPE_IDS = {
			443,
			438,
			444,
			441
	};
	//(BOND_TEMP_COUPON_CALCULATION_SCHEDULE)  Period_Determinant_id
	public static final int  CALCULATION_PERIOD_DETERMINANT_DK=1007;// xác định kỳ tính lãi định kỳ
	public static final int  CALCULATION_PERIOD_DETERMINANT_DKTKDT=1008;//định kỳ trừ kì đầu tiên
	public static final int  CALCULATION_PERIOD_DETERMINANT_DKTKCC=1009;// định kỳ trừ kì trừ kỳ cuối cùng
	public static final int  CALCULATION_PERIOD_DETERMINANT_DKTKDTVCC=1010;// định kỳ trừ kỳ đầu tiên và cuối cùng
	public static final int  CALCULATION_PERIOD_DETERMINANT_KDK=1011;// không định kỳ
	//(BOND_TEMP_COUPON_PAYMENT_SCHEDULE) Payment_Period_Determinant_id
	public static final int PAYMENT_PEIOD_DETERMINANT_MK=1012;// ngày kết thúc mỗi kỳ tính lãi
	public static final int PAYMENT_PEIOD_DETERMINANT_AH=1013;// ân hạn sau đó thanh toán vào ngày kết thúc mỗi kỳ
	public static final int PAYMENT_PEIOD_DETERMINANT_MSN=1014;// ngày kết thúc một số kỳ tính lãi
	
}
