package com.projet_integrateur.app.model;

import android.util.Log;

import com.projet_integrateur.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
public class Members_by_Manif
{
    //!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    private static final String  TAG = "[" + Members_by_Manif.class.getSimpleName().toUpperCase() + "]";

    private Integer id;
    private UUID manif;
    private UUID  member;
    private Boolean is_present;
    private Integer rating;
    private String  date_created, last_update = Utils.updateTime_Now();

    public static Members_by_Manif Create(String thisManif, String thisMember, String thisIsPresent, String thisRating, String thisDate_created, String thisLast_update)
    {
        return  Members_by_Manif.Create( String.valueOf(Models.getMembers_by_Manifs().size()), thisManif,  thisMember, thisIsPresent,thisRating,thisDate_created, thisLast_update);
    }
    public static Members_by_Manif Create( String thisId, String thisManif, String thisMember, String thisIsPresent, String thisRating, String thisDate_created, String thisLast_update)
    {
        Members_by_Manif newMembers_by_Manif = null;

        List<Member> MemberList = Models.getMembers_From_Manif(UUID.fromString( thisManif));

        if(MemberList == null) MemberList = new ArrayList<>();
        Boolean isExistFlag = false;
        for (int i =0 ; i < MemberList.size(); i++)
        {
            if (MemberList.get(i).getId().toString().equals(thisMember) ) isExistFlag= true;
        }
        if (!isExistFlag )
        {
            newMembers_by_Manif = new Members_by_Manif(  Integer.valueOf(thisId), UUID.fromString(thisManif), UUID.fromString(thisMember), Boolean.valueOf(thisIsPresent), Integer.valueOf(thisRating), thisDate_created, thisLast_update );
            if (newMembers_by_Manif == null) { Log.e(TAG, "Une erreur est survenue lors la creation !!");    }
            else
            {
                Models.members_by_Manifs.add(newMembers_by_Manif);
                newMembers_by_Manif.setId(Models.members_by_Manifs.indexOf(newMembers_by_Manif));
            }
        }else Log.e(TAG, Models.getMember(UUID.fromString(thisMember)).getUsername() + " EXISTE DEJA");

        return newMembers_by_Manif;
    }

    private Members_by_Manif(Integer thisId, UUID thisManif, UUID thisMember, Boolean thisIsPresent, Integer thisRating, String thisDate_created, String thisLast_update)
    {
        id =thisId;
        manif = thisManif;
        member = thisMember;
        is_present = thisIsPresent;
        rating = thisRating;
        date_created = thisDate_created;
        last_update = thisLast_update;

        updateLast_update();
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    private void        updateLast_update()		 {  this.last_update = Utils.updateTime_Now(); }
    public String         getLast_update()		 { return last_update; }
    //?-------------------------------------------------------------------------------------------------------------------------------------------

    //?-------------------------------------------------------------------------------------------------------------------------------------------
    // GETTERS
    public Integer getId()  	{ return id; }
    public UUID getManif()  	{ return manif; }
    public UUID getMember()  	{ return member; }
    public Boolean isPresent()  	{ return is_present; }
    public Integer geRating()  	{ return rating; }
    public String getDate_created()	{ return date_created; }

    //?-------------------------------------------------------------------------------------------
    //SETTERS
    public void setId(Integer thisId) 	                { id = thisId; updateLast_update(); }
    public void setManif(UUID thisManif) 	            { manif = thisManif; updateLast_update(); }
    public void setMember(UUID thisMember) 	        { member = thisMember; updateLast_update(); }

    public void setPresent(Boolean thisIsPresent) 	    { is_present = thisIsPresent; updateLast_update(); }
    public void setRating(Integer thisRating) 			{ rating = thisRating; updateLast_update(); }

    public void setDate_created(String thisDate_created) { date_created = thisDate_created; }
    public void setLast_update(String thisLast_updated) { last_update = thisLast_updated; }
    //?-------------------------------------------------------------------------------------------
   
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public 	String toJSON()
    {
        String  thisString = "\t{\n";

        thisString += "\t\t\"manif\": \""   		+ manif             + "\",\n";
        thisString += "\t\t\"member\": \""   		+ member            + "\",\n";
        thisString += "\t\t\"is_present\": \""   	+ is_present            + "\",\n";
        thisString += "\t\t\"rating\": \""   		+ rating            + "\",\n";
        thisString += "\t\t\"date_created\": \""    + date_created          + "\",\n";
        thisString += "\t\t\"last_update\": \""    + last_update          + "\"\n";

        thisString += "\t}";
        return thisString;
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public void logInfo()    { Log.i(TAG,  this.toJSON());   }
    //?-------------------------------------------------------------------------------------------------------------------------------------------


}

