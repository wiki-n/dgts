package crawler.dgts.utils;

/**
 * @author hungnv26
 * Used to store the document template code
 */
public class DocConstants {
    public static final String BOND_SENIORITY = "nợ thứ cấp";
    public static final String LTV = "LTV";
    public static final String TCBS = "TCBS";
    public static final String PLEDGE_SHARE_TRADING_STATUS_792 = "792";
    public static final String PLEDGE_SHARE_TRADING_STATUS_793 = "793";
    public static final String PLEDGE_SHARE_TRADING_STATUS_794 = "794";
    public static final String PLEDGE_SHARE_TRADING_STATUS_795 = "795";
    public static final String PLEDGE_SHARE_TRADING_VALUE_792 = "(1)";
    public static final String PLEDGE_SHARE_TRADING_VALUE_793 = "(2)";
    public static final String PLEDGE_SHARE_TRADING_VALUE_794 = "(7)";
    public static final String PLEDGE_SHARE_TRADING_VALUE_795 = "(8)";
    public static final String PLEDGE_SHARE_TRANFER_CONDITION = "tự do";
    public static final String TNHH = "TNHH";
    public static final String CP = "CP";

    public interface TncLocation{
        String BHA = "BHA";
    }

    public interface SecuringPartyForm{
        String TO_CHUC = TOCHUC_LOWERCASE;
        String CA_NHAN = "cá nhân";
    }

    public interface GuarantorFormId{
        String TO_CHUC = "254";
        String CA_NHAN = "252";
    }

    public interface SecuringPartyPrefix{
        String ONG = "ông";
        String BA = "bà";
        String ONG_UPPER = "Ông";
        String BA_UPPER = "Bà";
    }
    
    public interface SecuringSpousePrefix{
        String VO = "Vợ";
        String CHONG = "Chồng";
    }

    public interface PersonalTitleId{
        String ONG = "555";
        String BA = "556";
    }
    
    public interface PersonalGenderId{
        String NAM = "417";
        String NU = "418";
    }

    public interface BondTNCType{
        String BOND_CONVERTIBLE = "260";
        String BOND_WARRANT = "261";
        String BOND_SECURED = "263";
        String BOND_GUARANTEE = "264";
    }

    public interface  ShareOrCapital{
        String CO_PHAN = "Cổ Phần";
        String PHAN_VON_GOP = "Phần Vốn Góp";
    }

    public interface  RelatedClause{
        String RC_3_3 = "3.3";
        String RC_3_4 = "3.4";
    }

    public interface AssetTypeLevel2{
        String HNX  = "HNX";
        String HSX = "HSX";
        String UPCOM = "UPCoM";
    }


    public static final String TCBLPH_LOWERCASE = "tổ chức bảo lãnh phát hành";
    public static final String TCBLPH_CAMELCASE = "Tổ Chức Bảo Lãnh Phát Hành";
    public static final String TCBLPH_FIRSTCAPITAL = "Tổ chức bảo lãnh phát hành";
    public static final String BLPH_LOWERCASE = "bảo lãnh phát hành";
    public static final String BLPH_CAMELCASE = "Bảo Lãnh Phát Hành";
    public static final String DLPH_LOWERCASE = "đại lý phát hành";
    public static final String DLPH_CAMELCASE = "Đại Lý Phát Hành";
    public static final String DLPH_FIRSTCAPITAL = "Đại lý phát hành";
    public static final String TCTVPH_LOWERCASE = "tổ chức tư vấn phát hành";
    public static final String TCTVPH_CAMELCASE = "Tổ Chức Tư Vấn Phát Hành";
    public static final String TCTVPH_FIRSTCAPITAL = "Tổ chức tư vấn phát hành";
    public static final String TVCB_CK_LOWERCASE = "tư vấn chào bán chứng khoán";
    public static final String TVCB_CK_CAMELCASE = "Tư Vấn Chào Bán Chứng Khoán";
    public static final String TVPH_LOWERCASE = "tư vấn phát hành";
    public static final String TVPH_CAMELCASE = "Tư Vấn Phát Hành";
    public static final String TVNY_LOWERCASE = "tư vấn niêm yết";
    public static final String TVNY_CAMELCASE = "Tư Vấn Niêm Yết";
    public static final String TSDB_LOWERCASE = "dịch vụ quản lý tài sản bảo đảm";
    public static final String TSDB_CAMELCASE = "Dịch Vụ Quản Lý Tài Sản Bảo Đảm";
    public static final String QL_TSDB_LOWERCASE = "quản lý " + TSDB_LOWERCASE;
    public static final String QL_TSDB_CAMELCASE = "Quản Lý " + TSDB_CAMELCASE;
    public static final String BLPH_DLPH_LOWERCASE = "bảo lãnh phát hành/đại lý phát hành";
    public static final String BLPH_DLPH_CAMELCASE = "Bảo Lãnh Phát Hành/Đại lý Phát Hành";
    public static final String DDCSH_TP_LOWERCASE = "dịch vụ đại diện chủ sở hữu trái phiếu";
    public static final String DDCSH_TP_CAMELCASE = "Dịch Vụ Đại Diện Chủ Sở Hữu Trái Phiếu";
    public static final String DDNSH_TP_LOWERCASE = "dịch vụ đại diện người sở hữu trái phiếu";
    public static final String DDNSH_TP_CAMELCASE = "Dịch Vụ Đại Diện Người Sở Hữu Trái Phiếu";
    public static final String DVCK_LOWERCASE = "dịch vụ chứng khoán";
    public static final String DVCK_CAMELCASE = "Dịch Vụ Chứng Khoán";
    public static final String DVLK_LOWERCASE = "dịch vụ lưu ký";
    public static final String DVLK_CAMELCASE = "Dịch Vụ Lưu Ký";
    public static final String LK_LOWERCASE = "dịch vụ lưu ký";
    public static final String LK_CAMELCASE = "Dịch Vụ Lưu Ký";
    public static final String DLDK_LOWERCASE = "dịch vụ đại lý đăng ký";
    public static final String DLDK_CAMELCASE = "Dịch Vụ Đại Lý Đăng Ký";
    public static final String QLTK_LOWERCASE = "dịch vụ quản lý tài khoản";
    public static final String QLTK_CAMELCASE = "Dịch Vụ Quản Lý Tài Khoản";
    public static final String DDCSH_TP_NOT_MASAN_NORMAL = "Đại diện người sở hữu trái phiếu";
    public static final String DDCSH_TP_MASAN_NORMAL = "Đại diện chủ sở hữu trái phiếu";
    public static final String TTTP_NORMAL = "Thư thỏa thuận phí";
    public static final String DNTTP_NORMAL = "Đề nghị thanh toán phí";

    public static final String DLDK_VA_QLCN_LOWERCASE = "đại lý đăng ký và quản lý chuyển nhượng";


    public static final String CK_LOWERCASE = " dịch vụ chứng khoán";
    public static final String CK_CAMELCASE = "Dịch Vụ Chứng Khoán";
    public static final String TOCHUC_LOWERCASE = "tổ chức";
    public static final String TOCHUC_CAMELCASE = "Tổ Chức";
    public static final String DIEU_5_PHI = "Điều 5. Phí";
    public static final String DIEU_6_PHI = "Điều 6. Phí";
    public static final String DIEU_7_PHI = "Điều 7. Phí Và Chi Phí";
    public static final String DIEU_5_6 = "Điều 5.6 Phí Và Chi Phí (có chia sẻ TSBĐ) hoặc Điều 4.6 Phí Và Chi Phí (nếu không chia sẻ TSBĐ)";
    public static final String DIEU_6_LAI_PHI = "Điều 6. Lãi Suất Và Chi Phí";
    public static final String DIEU_4_PHI = "Điều 4. Phí Và Chi Phí";
    public static final String DIEU_9_PHI = "Điều 9. Phí Và Chi Phí";

    public static final String SPACE = " ";
    public static final String TREN_TONG_MENH_GIA_TP_PH_ID = "953";
    public static final String TREN_DU_NO_TP_THOI_DIEM_MUA_LAI_ID = "939";
    public static final String TREN_TONG_MENH_GIA_TP_PH = "trên tổng mệnh giá trái phiếu phát hành";
    public static final String TREN_DU_NO_TP_THOI_DIEM_MUA_LAI = "trên dư nợ trái phiếu tại thời điểm mua lại";
    public static final String MASAN = "Masan";
    
    public static final String BLANK_BOND = "Blank bond";
}
