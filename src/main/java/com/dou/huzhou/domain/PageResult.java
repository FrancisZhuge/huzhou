package com.dou.huzhou.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description: 分页类，分页后台分页，前台传入数据即可。本分页类，页数从0开始。
 * @Date: Created in 2017/10/15, 15:38
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class PageResult<T> {
    //总记录数
    private long totalCount;
    //当前页号
    private int pageNo;
    //总页数
    private int totalPageCount;
    //页大小
    private int pageSize;
    //列表记录
    private List<T> items;

    public PageResult(long totalCount, int pageNo, int pageSize, List<T> items) {
        this.items = items==null?new ArrayList<>():items;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        if(totalCount != 0){
            //计算总页数
            int tem = (int)totalCount/pageSize;
            this.totalPageCount = (totalCount%pageSize==0)?tem:(tem+1);
            this.pageNo = pageNo;
        } else {
            this.pageNo = 0;
        }
    }
    public long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getTotalPageCount() {
        return totalPageCount;
    }
    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public List getItems() {
        return items;
    }
    public void setItems(List items) {
        this.items = items;
    }
}
