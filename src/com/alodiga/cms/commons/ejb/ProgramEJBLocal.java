package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledAccountException;
import com.alodiga.cms.commons.exception.EmptyListException;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.Account;
import com.cms.commons.models.LegalPerson;
import com.cms.commons.models.NaturalPerson;
import com.cms.commons.models.Program;
import com.cms.commons.models.ProgramHasNetwork;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProgramEJBLocal extends DistributionGenericEJB {
    
    //Program
    public List<Program> getProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Program loadProgram(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Program saveProgram(Program Program) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //NaturalPerson
    public List<NaturalPerson> getProgramOwner(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    //LegalPerson
    public List<LegalPerson> getCardManagementProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    //ProgramHasNetwork
    public List<ProgramHasNetwork> getProgramHasNetwork(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramHasNetwork loadProgramHasNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramHasNetwork saveProgramHasNetwork(ProgramHasNetwork programHasNetwork)  throws RegisterNotFoundException, NullParameterException, GeneralException;

}
