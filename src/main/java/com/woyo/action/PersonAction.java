package com.woyo.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.woyo.common.page.PageInfo;
import com.woyo.model.Admin;
import com.woyo.model.Group;
import com.woyo.model.Person;
import com.woyo.service.AdminService;
import com.woyo.service.GroupService;
import com.woyo.service.PersonService;

public class PersonAction extends BaseAction implements ModelDriven, Preparable {
	private PersonService personService;
	private AdminService adminService;
	private PageInfo pageInfo;
	private String pageUrl;
	private String pageParams;
	private GroupService groupService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
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

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo allPersons) {
		this.pageInfo = allPersons;
	}

	private int type;
	private String name;
	private String password;
	private Person model;

	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String login() {
		if (type == 1) {
			Person p = personService.findByName(name);
			if (p != null) {
				if (this.password.equals(p.getPassword())) {
					ActionContext.getContext().getSession().put("loginPerson", p);
					return "personLoginSuccess";
				}
			} else {
				this.setMessage("�û�������벻��ȷ��");
			}
		} else {
			Admin admin = adminService.findByName(name);
			if (admin != null) {
				if (this.password.equals(admin.getPassword())) {
					ActionContext.getContext().getSession().put("loginAdmin", admin);
					return "adminLoginSuccess";
				}
			} else {
				this.setMessage("����Ա�û���������벻��ȷ��");
			}
		}
		return "login";
	}

	/**
	 * ��ѯ���е���ͨ�û�
	 * bill ��2010��3��17
	 * @return
	 */
	public String findAll() {
		this.pageUrl = "person/person_findAll.action";
		pageInfo = personService.findAll(this.getPageNo());
		return "goAll";
	}

	public String findAllPersons() {
		this.pageUrl = "person/person_findAllPersons.action";
		pageInfo = personService.findAll(this.getPageNo());
		return "goAllPersons";
	}

	/**
	 * ɾ���û���Ϣ
	 * bill ��2010��3��17
	 * @return
	 */
	public String delete() {
		personService.delete(id);
		return this.findAll();
	}

	/**
	 * �����û���Ϣ
	 * bill ��2010��3��17
	 * @return
	 */
	public String update() {

		if (type == 1) {//type=1���޸�ҳ��
			PageInfo p = groupService.findAll(1);
			ActionContext.getContext().put("groups", p);
			return "goUpdate";
		} else { // type=�����޸�
			Group group = groupService.findById(model.getGroup().getId());
			model.setGroup(group);
			personService.update(model);
			return this.findAll();
		}
	}

	public String detailPerson() {
		return "goDetail";
	}

	public Person getModel() {
		return model;
	}

	public void prepare() throws Exception {
		if (id != 0) {
			model = personService.findById(id);
		} else {
			model = new Person();
		}
	}
}
