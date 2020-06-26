package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledUserException;
import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.ComercialAgency;
import com.cms.commons.models.Employee;
import com.cms.commons.models.PasswordChangeRequest;
import com.cms.commons.models.Permission;
import com.cms.commons.models.PermissionData;
import com.cms.commons.models.PermissionGroup;
import com.cms.commons.models.PermissionGroupData;
import com.cms.commons.models.Profile;
import com.cms.commons.models.ProfileData;
import com.cms.commons.models.User;
import com.cms.commons.models.UserHasProfile;
import java.util.Date;
import java.util.List;

/**
 * @author jgomez
 * Fecha creación: 18/06/2020
 */
@Remote
public interface UserEJB extends DistributionGenericEJB {    
     
    //User
    public List<User> getUser(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public User loadUser(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public User saveUser(User user)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<User> validatePassword(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public User loadUserByLogin(String login) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Employee
    public List<Employee> getEmployee(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Employee loadEmployee(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Employee saveEmployee(Employee employee)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ComercialAgency
    public List<ComercialAgency> getComercialAgency(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ComercialAgency loadComercialAgency(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ComercialAgency saveComercialAgency(ComercialAgency comercialAgency)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PasswordChangeRequest
    public List<PasswordChangeRequest> getPasswordChangeRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PasswordChangeRequest loadPasswordChangeRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PasswordChangeRequest savePasswordChangeRequest(PasswordChangeRequest passwordChangeRequest)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PermissionGroup
    public List<PermissionGroup> getPermissionGroup(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PermissionGroup loadPermissionGroup(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PermissionGroup savePermissionGroup (PermissionGroup permissionGroup) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<PermissionGroup> getPermissionGroups() throws EmptyListException, NullParameterException, GeneralException;
    
    //PermissionGroupData
    public List<PermissionGroupData> getPermissionGroupData(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PermissionGroupData loadPermissionGroupData(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PermissionGroupData savePermissionGroupData (PermissionGroupData permissionGroupData) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Permission
    public List<Permission> getPermission(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Permission loadPermission(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Permission savePermission (Permission permission) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Permission> getPermissions() throws EmptyListException, NullParameterException, GeneralException;
    public List<Permission> getPermissionByGroupId(Long groupId) throws EmptyListException, NullParameterException, GeneralException;
    public List<Permission> getPermissionByProfileId(Long profileId) throws EmptyListException, NullParameterException, GeneralException;
    public Permission loadPermissionById(Long permissionId) throws GeneralException, NullParameterException, RegisterNotFoundException;
    
    //PermissionData
    public List<PermissionData> getPermissionData(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PermissionData loadPermissionData(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PermissionData savePermissionData (PermissionData permissionData) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Tabla  Profile
    public List<Profile> getProfile(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Profile loadProfile(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Profile saveProfile (Profile profile) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Profile> getProfiles() throws EmptyListException, GeneralException;
    
    //Tabla  ProfileData
    public List<ProfileData> getProfileData(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProfileData loadProfileData(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProfileData saveProfileData (ProfileData profileData) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Tabla  UserHasProfile
    public List<UserHasProfile> getUserHasProfile(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public UserHasProfile loadUserHasProfile(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public UserHasProfile saveUserHasProfile(UserHasProfile userHasProfile) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<UserHasProfile> getUserHasProfileByUser(UserHasProfile userHasProfile) throws EmptyListException, GeneralException, NullParameterException;
    
}
