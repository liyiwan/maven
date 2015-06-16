package com.woyo.common.page.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.woyo.common.page.PageInfo;
import com.woyo.common.page.PageInfoImpl;

/**
 * @author Administrator
 *
 */
public class BaseHibernateTemplateDAO extends HibernateDaoSupport implements IBaseHibernateTemplateDAO {
    protected int pageNo; //��ǰ�ǵڼ�ҳ������ӵ�һҳ��ʼ
    protected int pageSize; //ÿҳ�����ʾ�ļ�¼����
    protected int startIndex;//ÿһҳ��¼���������0��ʼ

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void saveObject(Object o) {
        getHibernateTemplate().saveOrUpdate(o);
    }

    public Object getObject(Class clazz, Serializable id) {
        Object o = getHibernateTemplate().get(clazz, id);

        if (o == null) {
            throw new ObjectRetrievalFailureException(clazz, id);
        }

        return o;
    }

    public List getObjects(Class clazz) {
        return getHibernateTemplate().loadAll(clazz);
    }

    public void removeObjectById(Class clazz, Serializable id) {
        getHibernateTemplate().delete(getObject(clazz, id));
    }

    public int getCount(Class clazz) {
        return this.getCountByCondition(clazz, "");
    }

    public int getCountByCondition(Class clazz, String condition) {
        String className = clazz.getName() + " ";
        if (condition != null) {
            String tmp = condition.toLowerCase();
            int pos = tmp.indexOf(" order ");
            if (pos > 0) {
                condition = condition.substring(0, pos);
            }
        } else {
            condition = "";
        }

        Integer count = new Integer(0);

        count = (Integer) this.getHibernateTemplate().find("select count(*) from " + className + condition).get(0);

        return count.intValue();
    }

    public int getCountByHql(String hql) {
        Integer count = 0;
        String condition = hql.substring(hql.toLowerCase().indexOf("from") + 4);

        String tmp = condition.toLowerCase();
        int pos = tmp.indexOf(" order ");
        if (pos > 0) {
            condition = condition.substring(0, pos);
        }

        try {
            List<Integer> list = this.getHibernateTemplate().find("select count(*) from " + condition);
            if (list != null && list.size() > 0) {
                count = list.get(0);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return count.intValue();
    }

    /**
     * ���һ��֧�ַ�ҳ��ѯ��HibernateTemplate
     * @param pageNo ��ʾ�ڼ�ҳ���ӵ�һҳ��ʼ
     * @param pageSize ÿҳ��ʾ������¼��
     * @return
     */
    public HibernateTemplate getPagedHibernateTemplate(int pageNo, int pageSize) {
        this.pageSize = pageSize;
        this.pageNo = (pageNo) >= 1 ? pageNo : 1;
        startIndex = (pageNo - 1) * pageSize;

        return this.getHibernateTemplate();
    }

    public PageInfo findPageInfoByHql(int pageNo, int pageSize, final String hql) {
        List list = this.getPagedHibernateTemplate(pageNo, pageSize).executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return session.createQuery(hql).setFirstResult(getStartIndex()).setMaxResults(getPageSize()).list();
            }
        });
        int rowCount = this.getCountByHql(hql);
        return new PageInfoImpl(list, rowCount, this.getPageSize(), this.getPageNo());
    }

    public List findByHql(final String hql) {
        return this.getHibernateTemplate().find(hql);
    }

    public List findByHql(String hql, Object[] params) {
        return this.getHibernateTemplate().find(hql, params);
    }

    public List findByHql(String hql, Object param) {
        return this.findByHql(hql, new Object[] { param });
    }

    public PageInfo findPageInfoByHql(int pageNo, int pageSize, String hql, Object param) {
        return this.findPageInfoByHql(pageNo, pageSize, hql, new Object[] { param });
    }

    public PageInfo findPageInfoByHql(int pageNo, int pageSize, final String hql, final Object[] params) {
        List list = this.getPagedHibernateTemplate(pageNo, pageSize).executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery(hql).setFirstResult(getStartIndex()).setMaxResults(getPageSize());

                if (params != null) {
                    for (int i = 0; i < params.length; i++) {
                        query.setParameter(i, params[i]);
                    }
                }
                return query.list();
            }
        });

        //get toatl count
        List list2 = this.getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String condition = hql.substring(hql.toLowerCase().indexOf("from") + 4);
                String tmp = condition.toLowerCase();
                int pos = tmp.indexOf(" order ");
                if (pos > 0) {
                    condition = condition.substring(0, pos);
                }

                Query query = session.createQuery("select count(*) from " + condition);
                if (params != null) {
                    for (int i = 0; i < params.length; i++) {
                        query.setParameter(i, params[i]);
                    }
                }
                return query.list();
            }
        });

        int rowCount = (Integer) list2.get(0);
        return new PageInfoImpl(list, rowCount, this.getPageSize(), this.getPageNo());
    }

}
