package com.woyo.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public abstract class BaseAction extends ActionSupport {

    /**
     * 
     */
    private int pageNo = 1;
    /**
     * 
     */
    private String message;

    /**
     * @return pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 
     * @return message
     */

    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
