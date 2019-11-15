package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledAccountException;
import com.alodiga.cms.commons.exception.EmptyListException;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.Account;
import com.cms.commons.models.Program;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ProgramEJBLocal extends DistributionGenericEJB {

 public Account saveProgram(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException, DisabledAccountException;
 //Tabla de Program
    public List<Program> getProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Program loadProgram(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Program saveProgram(Program program) throws RegisterNotFoundException, NullParameterException, GeneralException;

 
}
