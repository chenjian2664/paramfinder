package com.jian.paramfinder;

import org.springframework.stereotype.*;

/**
 * @author chenjian
 */
@Component
public class PrestoScheduler extends BaseScheduler{
    @Override
    protected void process() {
        System.out.println("hello world");
    }

    @Override
    protected void beforeProcess() {
        System.out.println("before process");
    }

    @Override
    protected void afterProcess() {
        System.out.println("after process");
    }
}
