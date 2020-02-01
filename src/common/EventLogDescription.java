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
public enum EventLogDescription {
    SUCCESSFUL_LOGIN("ورود موفق"),
    FAILED_LOGIN("ورود ناموفق"),
    REGISTER_BIRTH_CERTIFICATE("ثبت اطلاعات شناسنامه"),
    REGISTER_NATIONAL_CARD("ثبت اطلاعات کارت ملی"),
    EDIT_BIRTH_CERTIFICATE("ویراییش اطلاعات شناسنامه"),
    EDIT_NATIONAL_CARD("ویراییش اطلاعات کارت ملی"),
    REMOVE_BIRTH_CERTIFICATE("حذف اطلاعات شناسنامه"),
    REMOVE_NATIONAL_CARD("حذف اطلاعات کارت ملی"),
    ISSUE_BIRTH_CERTIFICATE("صدور شناسنامه"),
    ISSUE_NATIONAL_CARD("صدور کارت ملی"),
    ISSUE_BIRTH_CERTIFICATE_REPLICA("صدور المثنی شناسنامه"),
    ISSUE_NATIONAL_CARD_REPLICA("صدور المثنی کارت ملی"),
    DELIVER_BIRTH_CERTIFICATE("تحویل شناسنامه"),
    DELIVER_NATIONAL_CARD("تحویل کارت ملی"),
    ADD_USER(" ثبت اطلاعات کاربر"),
    EDIT_USER("ویراییش اطلاعات کاربر"),
    REMOVE_USER("حذف اطلاعات کاربر");

    String persianMsg;
    
    private EventLogDescription(String persianMsg) {
        this.persianMsg = persianMsg;
    }

    public String getPersianMsg() {
        return persianMsg;
    }

    public void setPersianMsg(String persianMsg) {
        this.persianMsg = persianMsg;
    }

    
    
    
}
