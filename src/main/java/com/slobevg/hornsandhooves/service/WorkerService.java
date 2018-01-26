package com.slobevg.hornsandhooves.service;

import com.slobevg.hornsandhooves.model.Worker;
import com.slobevg.hornsandhooves.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
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
        workerRepository.delete(worker);
    }
}
