package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.EmptyListException;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.DaysWeek;
import com.cms.commons.models.DaysWeekHasProgramLoyalty;
import com.cms.commons.models.LegalPerson;
import com.cms.commons.models.LoyaltyTransactionHasCommerceCategory;
import com.cms.commons.models.NaturalPerson;
import com.cms.commons.models.Program;
import com.cms.commons.models.ProgramHasNetwork;
import com.cms.commons.models.ProgramLoyalty;
import com.cms.commons.models.ProgramLoyaltyTransaction;
import com.cms.commons.models.ProgramLoyaltyType;
import com.cms.commons.models.ProjectAnnualVolume;
import com.cms.commons.models.StatusProgramLoyalty;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProgramEJBLocal extends DistributionGenericEJB {
    
    //Program
    public List<Program> getProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Program loadProgram(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Program saveProgram(Program Program) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Program searchProgram(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Program> getProgramByProgramType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Program> getProgramByProductType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //NaturalPerson
    public List<NaturalPerson> getProgramOwner(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    //LegalPerson
    public List<LegalPerson> getCardManagementProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<LegalPerson> getLegalPersonByDelivery(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    //ProgramHasNetwork
    public List<ProgramHasNetwork> getProgramHasNetwork(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ProgramHasNetwork> getProgramHasNetworkBD(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramHasNetwork loadProgramHasNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramHasNetwork saveProgramHasNetwork(ProgramHasNetwork programHasNetwork)  throws RegisterNotFoundException, NullParameterException, GeneralException;

    //ProgramLoyalty
    public List<ProgramLoyalty> getProgramLoyalty(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramLoyalty loadProgramLoyalty(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramLoyalty saveProgramLoyalty(ProgramLoyalty programLoyalty)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ProgramLoyaltyType
    public List<ProgramLoyaltyType> getProgramLoyaltyType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramLoyaltyType loadProgramLoyaltyType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramLoyaltyType saveProgramLoyaltyType(ProgramLoyaltyType programLoyaltyType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //StatusProgramLoyalty
    public List<StatusProgramLoyalty> getStatusProgramLoyalty(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusProgramLoyalty loadStatusProgramLoyalty(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusProgramLoyalty saveStatusProgramLoyalty(StatusProgramLoyalty statusProgramLoyalty)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //DaysWeekHasProgramLoyalty
    public List<DaysWeekHasProgramLoyalty> getDaysWeekHasProgramLoyalty(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<DaysWeekHasProgramLoyalty> getDaysWeekHasProgramLoyaltyByLoyalty(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public DaysWeekHasProgramLoyalty loadDaysWeekHasProgramLoyalty(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DaysWeekHasProgramLoyalty saveDaysWeekHasProgramLoyalty(DaysWeekHasProgramLoyalty daysWeekHasProgramLoyalty)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //DaysWeekHasProgramLoyalty
    public List<DaysWeek> getDaysWeek(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public DaysWeek loadDaysWeek(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DaysWeek saveDaysWeek(DaysWeek daysWeek)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ProgramLoyaltyTransaction
    public List<ProgramLoyaltyTransaction> getProgramLoyaltyTransaction(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ProgramLoyaltyTransaction> getProgramLoyaltyTransactionByLoyalty(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ProgramLoyaltyTransaction> getProgramLoyaltyTransactionUnique(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramLoyaltyTransaction loadProgramLoyaltyTransaction(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramLoyaltyTransaction saveProgramLoyaltyTransaction(ProgramLoyaltyTransaction programLoyaltyTransaction)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //LoyaltyTransactionHasCommerceCategory
    public List<LoyaltyTransactionHasCommerceCategory> getLoyaltyTransactionHasCommerceCategory(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<LoyaltyTransactionHasCommerceCategory> getLoyaltyTransactionHasCommerceCategoryByTransaction(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<LoyaltyTransactionHasCommerceCategory> getLoyaltyTransactionHasCommerceCategoryUnique(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public LoyaltyTransactionHasCommerceCategory loadLoyaltyTransactionHasCommerceCategory(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LoyaltyTransactionHasCommerceCategory saveLoyaltyTransactionHasCommerceCategory(LoyaltyTransactionHasCommerceCategory loyaltyTransactionHasCommerceCategory)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ProjectAnnualVolume
    public List<ProjectAnnualVolume> getProjectAnnualVolume(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ProjectAnnualVolume> getProjectAnnualVolumeByProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProjectAnnualVolume loadProjectAnnualVolume(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProjectAnnualVolume saveProjectAnnualVolume(ProjectAnnualVolume projectAnnualVolume)  throws RegisterNotFoundException, NullParameterException, GeneralException;
}
