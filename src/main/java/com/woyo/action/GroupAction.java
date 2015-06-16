package com.woyo.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.woyo.common.page.PageInfo;
import com.woyo.model.Group;
import com.woyo.service.AdminService;
import com.woyo.service.GroupService;

/**
 * @author Administrator
 *
 */
public class GroupAction extends BaseAction implements ModelDriven, Preparable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private AdminService adminService;
    private PageInfo pageInfo;
    private String pageUrl;
    private String pageParams;
    private GroupService groupService;
    private int id;
    private Group model;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Group getModel() {
        return model;
    }

    /**
     * prepare׼�����
     */
    public void prepare() throws Exception {
        if (id != 0) {
            model = groupService.findById(id);
        } else {
            model = new Group();
        }
    }

    /**
     * ��ѯ���е�����Ϣ
     *  bill 2010,3,17
     * @return
     */
    public String findAll() {
        this.pageUrl = "group/group_findAll.action";
        pageInfo = groupService.findAll(this.getPageNo());
        return "goAll";
    }

    /**
     * ���ӻ����޸�����Ϣ
     * bill 2010,3,17
     * @return
     */
    public String addAndUpdate() {
        //        System.out.println("id=" + id);
        if (id != 0) {
            groupService.update(model);
        } else {
            groupService.save(model);
        }
        return this.findAll();

    }

    /**
     * 
     * @return
     */
    public String delete() {
        groupService.delete(id);
        this.pageUrl = "group/group_delete";
        return this.findAll();
    }

    public String goUpdate() {
        return "goUpdateJsp";
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageParams() {
        return pageParams;
    }

    public void setPageParams(String pageParams) {
        this.pageParams = pageParams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
