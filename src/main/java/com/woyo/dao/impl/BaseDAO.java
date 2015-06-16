package com.woyo.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.woyo.common.page.hibernate.BaseHibernateTemplateDAO;
import com.woyo.util.Constants;

/**
 * ʵ��DAO��Ļ��࣬����Spring�ṩ��HibernateTemplate��ʵ��
 * @author: liuyu
 * Created time: May 5, 2008
 * CopyRights: www.bill.com
 */

public class BaseDAO extends BaseHibernateTemplateDAO {

    /**
     * ���һ��֧�ַ�ҳ��ѯ��HibernateTemplate, ҳ���Сʹ���ⲿ�����ļ������õ�Ĭ��ֵ
     * @param pageNo
     * @return
     */
    public HibernateTemplate getPagedHibernateTemplate(int pageNo) {
        return super.getPagedHibernateTemplate(pageNo, Constants.MAX_PAGE_SIZE);
    }

}
