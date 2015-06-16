package com.woyo.common.page.hibernate;

import java.io.Serializable;
import java.util.List;

import com.woyo.common.page.PageInfo;

/**
 * ����DAO�ӿڵĸ��ӿڣ������ṩһЩͨ�õķ���
 * @author: liuyu
 * Created time: Jan 23, 2008
 * CopyRights: www.bill.com
 */
public interface IBaseHibernateTemplateDAO {
    /**
     * �������еĶ���
     * @param clazz
     * @return ���ض���List
     */
    List getObjects(Class clazz);

    /**
     * ���OID�����Ҷ���
     * @param clazz
     * @param id
     * @return
     */
    Object getObject(Class clazz, Serializable id);

    /**
     * ��ݶ����״̬�������
     * @param o
     */
    void saveObject(Object o);

    /**
     * ��ݶ���ID��ɾ�����
     * @param clazz
     * @param id
     */
    void removeObjectById(Class clazz, Serializable id);

    /**
     * ȡ���е�ʵ�����
     * @param ʵ������
     * @return ���е�ʵ�����Ҳ���Ƕ�Ӧ�����еļ�¼��
     */
    int getCount(Class clazz);

    /**
     * ��ݲ�ѯ�������ض�Ӧ��ʵ����ĸ���
     * @param clazz ��ѯ��ʵ������
     * @param condition ��ѯ����������HQL�﷨
     * @return ����ʵ����ĸ���Ҳ���Ƕ�Ӧ�ļ�¼��
     */
    int getCountByCondition(Class clazz, String condition);

    /**
     * ��ݲ�ѯ�������ض�Ӧ��ʵ����ĸ���
     * @param hql ��ѯ��HQL���
     * @return ����ʵ����ĸ���Ҳ���Ƕ�Ӧ�ļ�¼��
     */
    int getCountByHql(String hql);

    /**
     * ���HQL��䷵�ذ�ʵ����Զ����ҳ��ݽṹPageInfo
     * @param pageNo ��ѯ�ĵ�ǰҳ��
     * @param pageSize ÿҳ����ʾ������¼��
     * @param hql ��ѯ��HQL���
     * @return ���ص�ǰ��ҳ��Ϣ��PageInfo����
     */
    PageInfo findPageInfoByHql(int pageNo, int pageSize, final String hql);

    /**
     * ���HQL��䷵�ذ�ʵ����Զ����ҳ��ݽṹPageInfo
     * @param pageNo ��ѯ�ĵ�ǰҳ��
     * @param pageSize ÿҳ����ʾ������¼��
     * @param hql ��ѯ��HQL��䣬����ѯ����
     * @param params hql����ж�Ӧ��һ������
     * @return ���ص�ǰ��ҳ��Ϣ��PageInfo����
     */
    PageInfo findPageInfoByHql(int pageNo, int pageSize, final String hql, Object param);

    /**
     * ���HQL��䷵�ذ�ʵ����Զ����ҳ��ݽṹPageInfo
     * @param pageNo ��ѯ�ĵ�ǰҳ��
     * @param pageSize ÿҳ����ʾ������¼��
     * @param hql ��ѯ��HQL��䣬����ѯ����
     * @param params hql����ж�Ӧ�Ĳ�������
     * @return ���ص�ǰ��ҳ��Ϣ��PageInfo����
     */
    PageInfo findPageInfoByHql(int pageNo, int pageSize, final String hql, Object[] params);

    /**
     * ���HQL��䷵�ذ�ʵ���List
     * @param hql ��ѯ��HQL���
     * @return ���ذ��ѯ���ʵ���List
     */
    List findByHql(String hql);

    /**
     * ���HQL��䷵�ذ�ʵ���List
     * @param hql ��ѯ��HQL��䣬����ѯ����
     * @param params hql����ж�Ӧ��һ������
     * @return ���ذ��ѯ���ʵ���List
     */
    List findByHql(String hql, Object param);

    /**
     * ���HQL��䷵�ذ�ʵ���List
     * @param hql ��ѯ��HQL��䣬����ѯ����
     * @param params hql����ж�Ӧ�Ĳ�������
     * @return ���ذ��ѯ���ʵ���List
     */
    List findByHql(String hql, Object[] params);

}
