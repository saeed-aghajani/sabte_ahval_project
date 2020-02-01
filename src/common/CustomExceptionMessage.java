/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author saeed
 */
public enum CustomExceptionMessage {
    PERSISTENCE_NON_UNIQUE_RESULT ("خطای پایگاه داده", "رکورد دریافتی از پایگاه داده یکتا نیست"),
    ROLLBACK("",""),
    NO_RESULT_EXCEPTION("خطای پایگاه داده", "هیچ رکوردی از پایگاه داده یافت نشد"),
    EMPTY_PARAMETERS("خطا در پارامترهای ورودی", "تمام فیلدها باید پر شوند"),
    NOT_NUMBER("خطا در پارامترهای ورودی", "فیلد عددی نباید شامل حرف باشد"),
    CONTAIN_NUMBER("خطا در پارامترهای ورودی", "فیلد غیرعددی نباید شامل عدد باشد"),
    INVALID_LENGTH("خطا در پارامترهای ورودی", "طول فیلدها باید صحیح باشد"),
    DB_UNKNOWN_EXCEPTION("خطای پایگاه داده", "خطای ناشناخته در پایگاه داده"),
    NON_REPLICA_REQUEST("درخواست نامعتبر","درخواست صدور برای بار دوم به بعد باید از منوی المثنی اقدام شود"),
    
    ;
    ;
    
    private String title;
    private String persianMsg;

    private CustomExceptionMessage(String title, String persianMsg) {
        this.title = title;
        this.persianMsg = persianMsg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPersianMsg() {
        return persianMsg;
    }

    public void setPersianMsg(String persianMsg) {
        this.persianMsg = persianMsg;
    }

    
    
    
    
    
}
