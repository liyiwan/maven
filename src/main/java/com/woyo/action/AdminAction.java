package com.woyo.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.woyo.model.Admin;
import com.woyo.service.AdminService;

/**
 * @author Administrator
 *
 */
public class AdminAction extends BaseAction implements ModelDriven<Object>, Preparable {
    private static final String LOGIN_ADMIN = "loginAdmin";
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private AdminService adminService;
    private int id;
    private Admin model;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Admin getModel() {
        return model;
    }

    /**
     * prepare׼�����
     */
    public void prepare() throws Exception {
        if (id != 0) {
            model = adminService.findById(id);
        } else {
            model = new Admin();
        }
    }

    /**
     * �����޸�
     * bill 2010.3.17
     * @return
     */
    public String updatePassword() {
        Admin admin = (Admin) ActionContext.getContext().getSession().get(LOGIN_ADMIN);
        String p = admin.getPassword();
        if (!p.equals(oldPassword)) {
            this.setMessage("ԭ���벻��ȷ��");
        } else {
            if (!newPassword.equals(confirmPassword) || "".equals(newPassword) || "".equals(confirmPassword)) {
                this.setMessage("");
            } else {
                this.setMessage("�����޸ĳɹ���");
                admin.setPassword(newPassword);
                adminService.update(admin);
            }
        }
        return "updateSuccess";
    }

    /**
     * �˳���¼
     * bill 2010.3.17
     * @return
     */
    public String logout() {
        ActionContext.getContext().getSession().remove(LOGIN_ADMIN);
        return "login1";
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
