package cn.maxlu.task.spring.schedule;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.util.Date;

public class CustomTrigger implements Trigger {
    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        return new Date();
    }
}
