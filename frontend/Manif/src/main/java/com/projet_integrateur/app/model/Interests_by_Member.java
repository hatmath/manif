package com.projet_integrateur.app.model;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.utils.Utils;

import java.util.UUID;

public class Interests_by_Member
{
    private final static String  TAG = "[" + Interests_by_Member.class.getSimpleName().toUpperCase() + "]";

    private Integer id = -1;
    private Integer interest;
    private UUID  member;
    private String  date_created, last_update =  Utils.updateTime_Now();

    public static Interests_by_Member Create(String thisInterest, String thisMember)
    {
        return Interests_by_Member.Create( thisInterest,  thisMember, Utils.updateTime_Now());
    }
    public static Interests_by_Member Create(String thisInterest, String thisMember, String thisDate_created)
    {
        Interests_by_Member newInterests_by_Member = null;

        if (Models.getInterests_by_Member(Integer.valueOf(thisInterest)) == null )
        {
            newInterests_by_Member = new Interests_by_Member(Integer.valueOf(thisInterest), UUID.fromString(thisMember), thisDate_created, Utils.updateTime_Now() );
            if (newInterests_by_Member == null) { Log.e(TAG, "Une erreur est survenue lors la creation !!");    }
            else
            {
                Models.interests_by_Members.add(newInterests_by_Member);
                newInterests_by_Member.setId(Models.interests_by_Members.indexOf(newInterests_by_Member));
            }
        }

        return newInterests_by_Member;
    }

    private Interests_by_Member(Integer thisInterest, UUID thisMember, String thisDate_created, String thisLast_update )
    {
        id = -1;
        interest = thisInterest;
        member = thisMember;
        date_created =  thisDate_created;
        last_update =  thisLast_update;
        updateLast_update();
    }

    //?-------------------------------------------------------------------------------------------------------------------------------------------
    private void        updateLast_update()		 {  this.last_update = Utils.updateTime_Now(); }
    public String         getLast_update()		 { return last_update; }
    //?-------------------------------------------------------------------------------------------------------------------------------------------

    //?-------------------------------------------------------------------------------------------------------------------------------------------
    // GETTERS
    public Integer getId()  	{ return id; }
    public Integer getInterest()  	{ return this.interest; }
    public UUID getMember()  	{ return member; }
    public String getDate_created()	{ return date_created; }
    //?-------------------------------------------------------------------------------------------
    //SETTERS
    private void setId(Integer thisId) 	                { id = thisId; updateLast_update(); }
    private void setInterest(Integer thisInterest) 	        { interest = thisInterest; updateLast_update(); }
    private void setMember(UUID thisMember) 	            { member = thisMember;  updateLast_update();}
   private void setDate_created(String thisDate_created)    { date_created = thisDate_created; }


    //?-------------------------------------------------------------------------------------------------------------------------------------------
    
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public 	String toJSON()
    {
        String  thisString = "\t{\n";

        thisString += "\t\t\"interest\": \""   		+ interest             + "\",\n";
        thisString += "\t\t\"member\": \""   		+ member            + "\",\n";
        thisString += "\t\t\"date_created\": \""    + date_created          + "\"\n";
        thisString += "\t}";
        return thisString;
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------

    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public void logInfo()
    {
        
        Log.i(TAG,  this.toJSON());
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------


}