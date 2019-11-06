package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledAccountException;
import com.alodiga.cms.commons.exception.DisabledUserException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.alodiga.cms.commons.exception.InvalidPasswordException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.Account;
import com.cms.commons.models.User;


@Remote
public interface AccessControlEJB extends DistributionGenericEJB {

   
   
   public User loadUserByLogin(String login) throws RegisterNotFoundException, NullParameterException, GeneralException;
   
   public User validateUser(String login, String password) throws RegisterNotFoundException, NullParameterException, GeneralException, DisabledUserException, InvalidPasswordException;
   
   
   
     

   
}
