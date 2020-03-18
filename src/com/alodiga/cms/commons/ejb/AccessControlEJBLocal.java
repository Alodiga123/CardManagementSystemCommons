package com.alodiga.cms.commons.ejb;
import com.alodiga.cms.commons.exception.DisabledAccountException;
import com.alodiga.cms.commons.exception.DisabledUserException;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.InvalidPasswordException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.User;


import javax.ejb.Local;

@Local
public interface AccessControlEJBLocal extends DistributionGenericEJB {

   
    
   public User loadUserByLogin(String login) throws RegisterNotFoundException, NullParameterException, GeneralException;
   
   public User validateUser(String login, String password) throws RegisterNotFoundException, NullParameterException, GeneralException, DisabledUserException, InvalidPasswordException;
   
   
   
}
