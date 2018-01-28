package com.slobevg.hornsandhooves.service;

import com.slobevg.hornsandhooves.model.Worker;

import java.util.Collections;
import java.util.List;

public class OrderFilter {
    private Boolean closed;
    private List<Long> workerIds;
    private List<Long> departmentIds;

    public List<Long> getWorkerIds() {
        return workerIds;
    }

    public void setWorkerIds(List<Long> workerIds) {
        this.workerIds = workerIds;
    }

    public List<Long> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Long> departmentIds) {
        this.departmentIds = departmentIds;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public static OrderFilter byWorker(Worker worker) {
        OrderFilter filter = new OrderFilter();
        filter.setWorkerIds(Collections.singletonList(worker.getId()));
        return filter;
    }
}
