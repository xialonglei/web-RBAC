package com.xll.util;

import java.util.List;

/**
 * Created by lonely.xia on 2017/10/12.
 */
public class BootstrapTablePage<T> {

    int total;

    List<T> rows;

    int limit;

    int offset;

    String order;

    public BootstrapTablePage() {
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
