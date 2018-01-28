package com.slobevg.hornsandhooves.service;

import com.slobevg.hornsandhooves.model.Order;
import com.slobevg.hornsandhooves.model.Worker;
import com.slobevg.hornsandhooves.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final OrderService orderService;

    @Autowired
    public WorkerService(WorkerRepository workerRepository, OrderService orderService) {
        this.workerRepository = workerRepository;
        this.orderService = orderService;
    }

    @Transactional
    public void save(Worker worker) {
        workerRepository.save(worker);
    }

    @Transactional(readOnly = true)
    public List<Worker> list() {
        return workerRepository.findAll();
    }

    @Transactional
    public void delete(Worker worker) {
        orderService.list(OrderFilter.byWorker(worker))
                .forEach(order -> order.setWorker(null));
        workerRepository.delete(worker);
    }
}
