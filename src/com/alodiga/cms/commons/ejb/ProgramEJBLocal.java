package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledAccountException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.Account;
import javax.ejb.Local;


@Local
public interface ProgramEJBLocal extends DistributionGenericEJB {

   public Account saveProgram(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException, DisabledAccountException;

}
