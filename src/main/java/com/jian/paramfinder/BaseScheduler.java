package com.jian.paramfinder;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.scheduling.*;
import org.springframework.scheduling.concurrent.*;
import org.springframework.scheduling.support.*;

/**
 * @author chenjian
 */
public abstract class BaseScheduler implements CommandLineRunner {

    @Value("${version.control.configPath}")
    private String configPath;
    @Value("${version.control.saveDir}")
    private String saveDir;
    @Value("${cluster.ip-port}")
    private String ipAddress;
    @Value("${schedule.cron}")
    private String cron;

    private TaskScheduler taskScheduler;

    public BaseScheduler() {
        taskScheduler = new DefaultManagedTaskScheduler();
    }


    /**
     *  1.wait for last task finishing
     *  2.calculate result, do something
     *  3.change config, restart cluster
     */
    protected void schedule() {
        beforeProcess();

        process();

        afterProcess();
    }


    protected abstract void process();

    protected abstract void beforeProcess();

    protected abstract void afterProcess();

    @Override
    public void run(String... args) {
        taskScheduler.schedule(this::schedule, new CronTrigger(cron));
    }

}
