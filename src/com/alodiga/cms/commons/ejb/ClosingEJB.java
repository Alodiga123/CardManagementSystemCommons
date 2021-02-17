package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.models.DailyClosing;
import java.util.Date;
import javax.ejb.Remote;



@SuppressWarnings(value = {"all"})
@Remote
public interface ClosingEJB extends DistributionGenericEJB {
    
    public DailyClosing closingDailyTransactionWallet(Date closingDate) throws GeneralException, NullParameterException;    
    
}
