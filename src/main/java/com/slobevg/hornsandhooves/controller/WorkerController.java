package com.slobevg.hornsandhooves.controller;

import com.slobevg.hornsandhooves.model.Worker;
import com.slobevg.hornsandhooves.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    public void create(@RequestBody Worker worker) {
        workerService.save(worker);
    }

    @GetMapping
    public List<Worker> list() {
        return workerService.list();
    }

    @GetMapping(path = "/{id}")
    public Worker get(@PathVariable("id") Worker worker) {
        return worker;
    }

    @PatchMapping(value = "/{id}")
    public void update(@ModelAttribute("id") Worker worker) {
        workerService.save(worker);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Worker worker) {
        workerService.delete(worker);
    }
}
