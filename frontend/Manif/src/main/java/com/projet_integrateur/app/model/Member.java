package com.projet_integrateur.app.model;

import static com.projet_integrateur.app.controller.TestController.E_TEST;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.projet_integrateur.app.controller.TestController;
import com.projet_integrateur.utils.Utils;

import android.util.Log;



//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
public class Member
{

    // !^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    // DATAMEMBERS
    private static final String  TAG = "[" + Member.class.getSimpleName().toUpperCase() + "]";

    private UUID 		id = UUID.randomUUID();
    private String 		username = "";
    private String 		password = "";
    private String 		salt = "";
    private String 		description = "";
    private Integer		avatar = 0;
    private String 		mail = "";
    private String 		phone = "";
    private String      date_created, last_update, last_login =  Utils.updateTime_Now();
    private Boolean      isPresent = false;


    List<Interests_by_Member> interests_List = new ArrayList<>();


    //!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    //----------------------------------------------------------------------------------------------
  

    //BUILDER
    public static Member Create(String thisUsername, String thisPassword)
    {
        return  Member.Create( UUID.randomUUID().toString(), thisUsername, 	thisPassword, "", "", "0","","",  Utils.updateTime_Now(), Utils.updateTime_Now(),Utils.updateTime_Now());
    }
    public static Member Create(String thisId, String thisUsername, String thisPassword, String thisSalt,  
                                String thisDescription, String thisAvatar, String thisMail, String thisPhone,
                                String thisLast_login, String thisDate_created, String thisLast_update)
    {
        Member newMember = null;

        if (Models.getMember(thisUsername) == null ) //SI NEXISTE PAS
        {
                newMember = new Member(UUID.fromString(thisId), thisUsername, thisPassword, thisSalt, thisLast_login, thisDate_created, thisLast_update );
                if (newMember == null) {Log.e(TAG, "Une erreur est survenue lors la creation !!");            }
                else
                {
                    newMember.setDescription(thisDescription);
                    newMember.setAvatar(Integer.valueOf(thisAvatar));
                    newMember.setMail(thisMail);
                    newMember.setPhone(thisPhone);
                    Models.members.add(newMember);
                }

        }
        else    Utils.log(TAG, thisUsername + " EXISTE DEJA");


        return newMember;
    }
    // ?-------------------------------------------------------------------------------------------------------------------------------------------

    // ?-------------------------------------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    private Member(UUID thisId, String thisUsername, String thisPassword, String thisSalt,
                   String thisLastLogin, String thisDate_Created, String thisLast_update )
    {

        this.id =thisId;
        this.username = thisUsername;
        this.password = thisPassword;
        this.salt = thisSalt;

        this.description = "";
        this.avatar = 1;
        this.mail  = "";
        this.phone = "";
        this.last_login = thisLastLogin;

        this.date_created = thisDate_Created;
        this.last_update = thisLast_update;
        this.isPresent = false;
    }


    // ?-------------------------------------------------------------------------------------------------------------------------------------------
    private void         updateLast_update()		 {  this.last_update = Utils.updateTime_Now();  }
    public String             getLast_update()		 { return last_update; }

    // ?-------------------------------------------------------------------------------------------------------------------------------------------
    // GETTERS
    
    public String getDate_created()	{ return date_created; }
    public String getLast_login()  	{ return last_login; }

    
    public UUID getId()  				{ return id; }
    public String getUsername()  		{ return username; }
    public String getPassword()  		{ return password; }
    public String getSalt()  			{ return salt; }
    public String getDescription()  	{ return description; }
    public Integer  getAvatar()  		    { return avatar; }
    public String getMail()  		{ return mail; }
    public String getPhone()  	    { return phone; }
    public Boolean getIsPresent()  	    { return isPresent; }
    
    //?-------------------------------------------------------------------------------------------
    //SETTERS

    public void setId(UUID thisId) 							{ id = thisId; updateLast_update(); }

    public void setUsername(String thisUsername) 			{ username = thisUsername; updateLast_update(); }
    public void setPassword(String thisPassword) 			{ password = thisPassword; updateLast_update(); }
    public void setSalt(String thisSalt) 					{ salt = thisSalt; updateLast_update();}
    public void setDescription(String thisDescription) 		{ description = thisDescription; updateLast_update();}
    public void setAvatar(Integer thisAvatar) 			{    avatar = thisAvatar; updateLast_update();}
    public void setMail(String thisMail) 					{ mail = thisMail; updateLast_update();}
    public void setPhone(String thisPhone) 		{ phone = thisPhone; updateLast_update();}
    public void setIsPresent(Boolean thisIsPresent)  	    {  isPresent = thisIsPresent; updateLast_update();}

    public void setDate_created(String thisDate_created) { date_created = thisDate_created; }
    public void setLast_login(String thisLast_login) 	{ last_login = thisLast_login; }
    public void setLast_update(String thisLast_updated) { last_update = thisLast_updated; }

    //?-------------------------------------------------------------------------------------------
	public 	String toJSON()
	{   //utile pour sauvegarde utf8 en format json et affichage sur console
	
		String  thisString = "\t{\n";              
		
	    thisString += "\t\t\"id\": \""   			+ id                    + "\",\n";
		thisString += "\t\t\"username\": \""        + username              + "\",\n";
		thisString += "\t\t\"password\": \""   		+ password              + "\",\n";
		thisString += "\t\t\"salt\": \""  			+ salt                  + "\",\n";
        thisString += "\t\t\"description\": \""     + description               + "\",\n";
        thisString += "\t\t\"avatar\": \""   		+ String.valueOf(avatar)    + "\",\n";
        thisString += "\t\t\"mail\": \""  		    + mail                      + "\",\n";
        thisString += "\t\t\"phone\": \""           + phone                      + "\"\n";
        thisString += "\t\t\"last_login\": \""      + last_login.toString()            + "\",\n";
        thisString += "\t\t\"date_created\": \""    + date_created.toString()          + "\",\n";
        thisString += "\t\t\"last_update\": \""     + last_update.toString()          + "\"\n";


        thisString += "\t}";
        return thisString;
	}
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public void logInfo()    { Log.i(TAG,    this.toJSON());    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------



    //?-------------------------------------------------------------------------------------------
    // TESTS
    public static Boolean TEST(E_TEST thisTest)
    {
		Boolean Result = false;		
		Member thisMember = null;
		
        switch(thisTest)
        {

            //?????????????????????????????????????????????????????????????????????????????????????????????????????
            case E_CONSTRUCTOR :
            {
                thisMember = Member.Create(  "MemberTest", "12345678" );

                if ( thisMember != null )
                {
                    Log.d( TestController.TAG,TAG +"	TEST:CONSTRUCTOR -> PASS"  + "\t WHILE EXECUTING -> [ member.Create( \"MemberTest\", \"12345678\" ))); ]");

                    Models.getMembers().remove(Models.getMembers().lastIndexOf(thisMember));  Result = true;
                }
                else  {  Log.d( TestController.TAG,TAG +"	TEST:CONSTRUCTOR -> FAIL"  + "\t WHILE EXECUTING -> [ member.Create( \"MemberTest\", \"12345678\" ))); ]");    Result = false;   }

            } break;
            //?????????????????????????????????????????????????????????????????????????????????????????????????????
          
            case         E_GETTER :           break;
            case         E_SETTER :           break;
            default :                         break;
        }		
        return Result;
    }
    //?-------------------------------------------------------------------------------------------
      

}
// ?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
