package com.slobevg.hornsandhooves.repository;

import com.slobevg.hornsandhooves.model.Order;
import com.slobevg.hornsandhooves.service.OrderFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import javax.persistence.criteria.Path;
import java.util.List;
import java.util.Objects;

public final class OrderSpecifications {

    public static Specification<Order> from(OrderFilter filter) {

        return Specifications
                .where(hasClosedDate(filter.getClosed()))
                .and(byDepartment(filter.getDepartmentIds()))
                .and(byWorker(filter.getWorkerIds()));
    }

    private static Specification<Order> hasClosedDate(Boolean closed) {
        if (Objects.isNull(closed)) {
            return null;
        }

        return (root, query, cb) -> {
            Path<Object> closedDate = root.get("closedDate");
            return closed ? closedDate.isNotNull() : closedDate.isNull();
        };
    }

    private static Specification<Order> byDepartment(List<Long> ids) {
        if (Objects.isNull(ids) || ids.isEmpty()) {
            return null;
        }

        return (root, query, cb) -> root.get("department").get("id").in(ids);
    }

    private static Specification<Order> byWorker(List<Long> ids) {
        if (Objects.isNull(ids) || ids.isEmpty()) {
            return null;
        }

        return (root, query, cb) -> root.get("worker").get("id").in(ids);
    }
 }
