package com.Database;

public abstract class DBQuery {

	public static final String ADD_PROJECT_QUERY = "insert into I351DeliMaster (L1ID,L1Name,StartDate,Enddate,Status) values (";
	
	public static final String GET_DISTINCT_RECORD_QUERY = "select top 1 ";
	
	public static final String GET_RECORDNUMBER_QUERY = "select isnull(max( " ;

	public static final String SET_DELETEPROJECTI351_QUERY = "Update I351DeliMaster set Status = 0 , EndDate ='";

	public static final String SET_DELETEPROJECTI352_QUERY = "Update I352AuthRole set Active = 0 , EndDate ='";

	public static final String GET_PROJECTMANAGERDETAILS_QUERY = "select L1ID as ProjectId,L1Name as 'ProjectName',L2ID as ModuleID,L2Name as 'ModuleName',L3ID as ComponentID,L3Name as 'ComponentName',StartDate,EndDate,Status from I351DeliMaster where Status = ";

	public static final String GET_PROJECTDETAILS_QUERY = "select distinct L1ID as ProjectId,L1Name as 'ProjectName' ";

	public static final String ADD_MODULE_PROJECT_QUERY = "insert into I351DeliMaster (L1ID,L1Name,L2ID,L2Name,StartDate,Enddate,Status) values (";
	
	public static final String ADD_COMPONENT_PROJECT_QUERY = "insert into I351DeliMaster (L1ID,L1Name,L2ID,L2Name,L3ID,L3Name,StartDate,Enddate,Status) values (";

	public static final String GET_LAST_RECORD_COUNT = "select COUNT(*) from I351DeliMaster where L1Name = '";
	
	public static final String GET_LAST_COUNT_DATA_I352AUTHROLE_QUERY = "select COUNT(*) from I352AuthRole where Active = 1 and MgrID = ";

	public static final String SET_FINALPROJECT_DETAILS_QUERY = "Update I351DeliMaster set L1ID = ";

	public static final String EDIT_MODULE_DETAILS = "Update I351DeliMaster set Status = 0 where L2Name = '";

	public static final String SET_ASSIGNMANAGERDETAILS_QUERY = "insert into I352AuthRole (AuthEntryType,MgrID,DelLinkageID,L1ID,L2ID,L3ID,ActIDL1,PStartDate,PendDate,Peffort,Active) values (";

	public static final String EDIT_ASS_MANAGER_DATA_QUERY = "Update I352AuthRole set PEndDate = '";

	public static final String GET_ASSIGNMANAGERACTIVE_DETAILS_QUERY = "select distinct AuthEntryType,L1Name as ProjectName,MgrID,PStartDate as StartDate,PendDate as EndDate,C.DefnLegendL1 as Activity,Peffort as Efforts from I352AuthRole A,I351DeliMaster B,I350DefMaster C where ";

	public static final String SET_INACTIVEMANAGER_DETAILS = "Update I352AuthRole set Active = 0 , PEndDate ='";

	public static final String GET_ACTIVITYID_DETAILS_QUERY = "select distinct DefnIDL1,DefnLegendL1 as ActivityL1 FROM I350DefMaster where DefnType = 5 and Active = 1";

	public static final String GET_SUBACTIVITYID_DETAILS_QUERY = "select distinct DefnIDL1,DefnLegendL1 as ActivityL1,DefnIDL2,DefnLegendL2 as SubActivityIDL2 FROM I350DefMaster where DefnType = 5 and Active = 1 and DefnLegendL2 != 'null'";

	public static final String GET_MODULE_GRID_QUERY = "select distinct L1ID,L1Name as ProjectName,L2Name as ModuleName,L2ID,L3ID,L3Name as ComponentName from I351DeliMaster  where Status = 1 and L1ID =";

	

	
	
}
