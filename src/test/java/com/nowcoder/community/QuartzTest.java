package com.nowcoder.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Dai
 * @Date: 2024/05/21 12:00
 * @Description: QuartzTest
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class QuartzTest {

    @Autowired
    private Scheduler scheduler;

    @Test
    public void testDeleteJob() {
        try {
            boolean result = scheduler.deleteJob(new JobKey("alphaJob", "alphaJobGroup"));
            System.out.println(result);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }
}
