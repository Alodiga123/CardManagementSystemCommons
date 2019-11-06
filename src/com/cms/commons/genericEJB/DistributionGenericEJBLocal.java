package com.cms.commons.genericEJB;

import javax.ejb.Local;

@Local
public interface DistributionGenericEJBLocal  
{
	void init();
    public boolean echo() throws Exception;
}
