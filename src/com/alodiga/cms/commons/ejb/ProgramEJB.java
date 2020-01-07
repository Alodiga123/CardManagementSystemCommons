package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledAccountException;
import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.LegalPerson;
import com.cms.commons.models.NaturalPerson;
import com.cms.commons.models.Program;
import com.cms.commons.models.ProgramHasNetwork;
import java.util.List;


@Remote
public interface ProgramEJB extends DistributionGenericEJB {
 
    //Program
    public List<Program> getProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Program loadProgram(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Program saveProgram(Program Program)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Program> getProgramByProgramType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //NaturalPerson
    public List<NaturalPerson> getProgramOwner(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //LegalPerson
    public List<LegalPerson> getCardManagementProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    
    //ProgramHasNetwork
    public List<ProgramHasNetwork> getProgramHasNetwork(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramHasNetwork loadProgramHasNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramHasNetwork saveProgramHasNetwork(ProgramHasNetwork programHasNetwork)  throws RegisterNotFoundException, NullParameterException, GeneralException;
}
