package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import java.util.Date;
import javax.ejb.Local;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.models.DailyClosing;


@SuppressWarnings(value = {"all"})
@Local
public interface ClosingEJBLocal extends DistributionGenericEJB {
    
    public DailyClosing closingDailyTransactionWallet(Date closingDate) throws GeneralException, NullParameterException;       
    
}
