package com.slobevg.hornsandhooves.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Table(name = "`order`")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    private Department department;

    @ManyToOne
    private Worker worker;

    @CreatedDate
    private Instant createdDate;

    private Instant closedDate;

    private Instant deadline;

    @Enumerated(EnumType.STRING)
    private FurnitureType furnitureType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public FurnitureType getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(FurnitureType furnitureType) {
        this.furnitureType = furnitureType;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public void setDeadline(Instant deadline) {
        this.deadline = deadline;
    }

    public Instant getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Instant closedDate) {
        this.closedDate = closedDate;
    }

    @Transient
    public long daysLeft() {
        return ChronoUnit.DAYS.between(Instant.now(), this.getDeadline());
    }

    @Transient
    public long hoursLeft() {
        long hoursInDay = ChronoUnit.DAYS.getDuration().get(ChronoUnit.HOURS);
        return ChronoUnit.HOURS.between(Instant.now(), this.getDeadline()) % hoursInDay;
    }
}
