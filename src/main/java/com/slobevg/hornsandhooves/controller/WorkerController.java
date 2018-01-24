package com.slobevg.hornsandhooves.controller;

import com.slobevg.hornsandhooves.model.Worker;
import com.slobevg.hornsandhooves.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    public void create(@RequestBody Worker worker) {
    }

    public List<Worker> list() {
        return null;
    }

    public void update(@RequestBody Worker worker) {

    }

    public void delete(@RequestParam Long id) {

    }
}
