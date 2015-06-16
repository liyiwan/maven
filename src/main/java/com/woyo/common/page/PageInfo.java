package com.woyo.common.page;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface PageInfo {
    /**
     * ���ط�ҳ��ļ�¼�б�
     * @return
     */
    List getPageData();

    /**
     * ����ҳ��������
     * @return
     */
    int getPageCount();

    /**
     * ���ؼ�¼��������
     * @return
     */
    long getTotalRecords();

    /**
     * ���ص�ǰҳ��
     * @return
     */
    int getCurrentPageNo();

    /**
     * ÿҳ�ļ�¼����
     * @return
     */
    int getPageSize();

    /**
     * �ж��Ƿ�����һҳ
     * @return
     */
    boolean isNextPageEnable();

    /**
     * �ж��Ƿ�����һҳ
     * @return
     */
    boolean isPreviousPageEnable();

    /**
     * ������һҳ����ʼ����
     * @return
     */
    int getStartOfNextPage();

    /**
     * ������һҳ����ʼ����
     * @return
     */
    int getStartOfPreviousPage();

    /**
     * ������һҳ����ʼ����
     * @param pageNo ָ����ҳ��
     * @return
     */
    int getStartOfPage(int pageNo);

    /**
     * ���ص�ǰҳ����ʼ����
     * @return
     */
    long getStartIndex();

    /**
     * ���ص�ǰҳ�Ľ�������
     * @return
     */
    long getEndIndex();
}
