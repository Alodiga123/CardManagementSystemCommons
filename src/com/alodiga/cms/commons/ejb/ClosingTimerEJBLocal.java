package com.alodiga.cms.commons.ejb;

import java.util.Date;
import javax.ejb.Local;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import javax.ejb.Timer;


@SuppressWarnings(value = {"all"})
@Local
public interface ClosingTimerEJBLocal extends DistributionGenericEJB {
    
    public void execute(Timer timer);

    public void forceExecution() throws Exception;

    public void forceTimeout() throws Exception;

    public Date getNextExecutionDate();

    public void restart() throws Exception;

    public void start() throws Exception;

    public void stop() throws Exception;

    public Long getTimeoutInterval();
    
}
