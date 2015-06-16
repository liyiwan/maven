package com.woyo.common.page;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class PageInfoImpl implements PageInfo {
    private List pageData;
    private int pageCount;
    private int pageSize;
    private long totalRecords;
    private int start;
    private int currentNo;

    public PageInfoImpl(List pageData, long totalRecords, int pageSize, int pageNo) {
        this.pageData = pageData;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
        this.currentNo = pageNo;

        //ֵ
        pageCount = (int) ((totalRecords + pageSize - 1) / pageSize);
        if (totalRecords <= 0) {
            pageCount = 0;
        }

        if (currentNo == pageCount) {
            this.pageSize = (int) (totalRecords - ((pageCount - 1) * pageSize));
        }

        start = (pageNo - 1) * pageSize;
    }

    public int getCurrentPageNo() {
        return currentNo;
    }

    public long getEndIndex() {
        return start + pageSize - 1;
    }

    public int getPageCount() {
        return pageCount;
    }

    public List getPageData() {
        return pageData;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public long getStartIndex() {
        return start;
    }

    public int getStartOfNextPage() {
        int pageNo = currentNo + 1;
        if (pageNo > pageCount) {
            pageNo = pageCount;
        }
        return this.getStartOfPage(pageNo);
    }

    public int getStartOfPage(int pageNo) {
        int startIndex = (pageNo - 1) * pageSize + 1;
        if (startIndex < 1) {
            startIndex = 1;
        }
        return startIndex;
    }

    public int getStartOfPreviousPage() {
        int pageNo = currentNo - 1;
        if (pageNo < 1) {
            pageNo = 1;
        }
        return this.getStartOfPage(pageNo);
    }

    public boolean isNextPageEnable() {
        return currentNo < pageCount;
    }

    public boolean isPreviousPageEnable() {
        return currentNo > 1;
    }

}
