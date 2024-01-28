
package com.projet_integrateur.app.model;


import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.controller.TestController;
import com.projet_integrateur.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
public class Manif
{

        public static final String  TAG = "[" + Manif.class.getSimpleName().toUpperCase() + "]";

        private     UUID            id =  UUID.randomUUID();
        private     UUID            owner = null;
        private     String  	    name		 = "";
        private     String  	    description	 = "";
        private     UUID            slogan = null;
        private     String  	    city		 = "";
        private     String  	    meeting	 = "";
        private     Integer  	    interest = -1;

        private     String           start_date,  end_date;
        private 	String 	        date_created, last_update =  Utils.updateTime_Now();;

        private   List<Member> m_Members_List = new ArrayList<>();

        //!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

        //?-------------------------------------------------------------------------------------------------------------------------------------------
        //BUILDER
        public static Manif Create(String thisId,
                                   String thisOwner,
                                   String thisName,
                                   String thisDescription,
                                   String thisSlogan,
                                   String thisCity,
                                   String thisMeeting,
                                   String thisInterest,
                                   String thisStart_date, String thisEnd_date,
                                   String thisDate_created, String thisLast_update)
        {
                thisStart_date = Utils.updateTime_Now();
                thisEnd_date = Utils.updateTime_Now();
                thisDate_created = Utils.updateTime_Now();
                thisLast_update = thisDate_created;

                Manif newManif = null;

                if (Models.getManif(thisId) == null ) //SI NEXISTE PAS
                {
                        newManif = new Manif(   UUID.fromString(thisId),
                                                UUID.fromString(thisOwner),
                                                thisName,
                                                thisDescription,
                                                UUID.fromString(thisSlogan),
                                                thisCity,
                                                thisMeeting,
                                               Integer.valueOf(thisInterest),
                                                thisStart_date,
                                                thisEnd_date,
                                                thisDate_created,
                                               thisLast_update);

                        if (newManif == null) { Log.e(TAG, "Une erreur est survenue lors la creation !!");    }
                        else
                        {

                            Models.getManifs().add(newManif);

                        }


                }
                else Log.e(TAG, "La manifestation " + thisId + ": " + thisName + " EXISTE DEJA");


                return newManif;
        }

        private Manif(UUID thisId, UUID thisOwner, String thisName, String thisDescription, UUID thisSlogan,
                      String thisCity, String thisMeeting, Integer thisInterest,
                      String thisStart_date, String thisEnd_date,  String thisDate_created, String thisLast_update)
        {
            this.id = thisId;
            this.owner = thisOwner;
            this.name =thisName;
            this.description = thisDescription;
            this.slogan = thisSlogan;
            this.city = thisCity;
            this.meeting = thisMeeting;
            this.interest = thisInterest;
            this.start_date = thisStart_date;
            this.end_date = thisEnd_date;

            if (thisDate_created.isEmpty()) Utils.updateTime_Now(); else this.date_created = thisDate_created;
            if (last_update.isEmpty())      Utils.updateTime_Now(); else this.last_update = thisLast_update;


            refresh();


        }
        public void addMember(Member thisMember)    {        m_Members_List.add(thisMember);   refresh();      }
        public void deleteMember(Member thisMember)    {        m_Members_List.remove(thisMember);   refresh();      }

        // ?-------------------------------------------------------------------------------------------------------------------------------------------
        private void         updateLast_update()		 {  this.last_update = Utils.updateTime_Now();   }
        public void refresh()
        {

                //si la liste a changer
            if (Models.members_by_Manifs.size() != m_Members_List.size())
            {
                    m_Members_List = new ArrayList<>();

                    for (int i = Models.members_by_Manifs.size()-1; i >= 0; --i)
                    {
                        if (Models.members_by_Manifs.get(i).getManif().equals(this.getId()))
                        {
                            Member thisMember = Models.getMember(Models.members_by_Manifs.get(i).getMember());
                            if (thisMember != null)
                            {
                                thisMember.setIsPresent(Models.members_by_Manifs.get(i).isPresent());
                                m_Members_List.add(thisMember);

                                if (AuthManager.getInstance().getAuthMember() != null)
                                    if (AuthManager.getInstance().getAuthMember().getId().equals(Models.members_by_Manifs.get(i).getMember()))
                                            Models.members_by_Manifs.get(i).setPresent(true);



                            }
                        }
                    }

            }
        }
        //?-------------------------------------------------------------------------------------------------------------------------------------------
        //GETTERS
            public UUID getId()  				        { return id; }
            public UUID getOwner()  				    { return owner; }
            public String getName()  			        { return name; }
            public String getDescription()  			{ return description; }
            public UUID getSlogan()  				    { return slogan; }
            public String getHeureDebut()               { return getStart_date().substring(10, start_date.length()-3); }
            public String getHeureFin()                 { return getEnd_date().substring(10, end_date.length()-2); }
            public String getCity()  			        { return city; }
            public String getMeeting()  			    { return meeting; }
            public Integer getInterest()  			    { return interest; }
            public String getStart_date()  			    { return start_date; }
            public String getEnd_date()  			    { return end_date; }
            public String getDate_created()	            { return date_created; }
            public String getLast_update()  	        { return last_update; }

             public List<Member> getMembers_List()    {     refresh();    return m_Members_List;        }

            //?-------------------------------------------------------------------------------------------------------------------------------------------
        //SETTERS
            public void setId(UUID thisId) 					        { id = thisId; updateLast_update();}
            public void setOwner(UUID thisOwner) 					    { owner = thisOwner; updateLast_update();}

            public void setName(String thisName) 					    { name = thisName; updateLast_update();}
            public void setDescription(String thisDescription )			{ description = thisDescription; updateLast_update(); }
            public void setSlogan(UUID thisSlogan) 					    { slogan = thisSlogan; updateLast_update();}

            public void setCity(String thisCity) 					    { city = thisCity; updateLast_update();}
            public void setMeeting(String thisMeeting) 		            { meeting = thisMeeting; updateLast_update(); }
        public void setInterest(Integer thisInterest) 		            { interest = thisInterest; updateLast_update(); }
            public void setStart_date(String thisStart_date) 		    { start_date = thisStart_date; updateLast_update();}
            public void setEnd_date(String thisEnd_date) 		        { end_date = thisEnd_date; updateLast_update();}
            public void setHeureDebut(String thisHeureDebut) 		    { String thisValue = getStart_date().substring(0, 9); thisValue+=thisHeureDebut;    start_date = thisValue; updateLast_update();}
            public void setHeureFin(String thisHeureFin) 		        { String thisValue = getEnd_date().substring(0, 9);   thisValue+=thisHeureFin;      end_date   = thisValue; updateLast_update();}



            public void setDate_created(String thisDate_created)         { date_created = thisDate_created; }
            public void setLast_update(String thisLast_updated)          { last_update = thisLast_updated; }
            public  void setMembers_List(List<Member> thisMembers_List)  {  m_Members_List = thisMembers_List; }
        //?-------------------------------------------------------------------------------------------------------------------------------------------
        
        //?-------------------------------------------------------------------------------------------------------------------------------------------
        public 	String toJSON()
        {
                String  thisString = "\t{\n";

                thisString += "\t\t\"id\": \""   			+ id                  + "\",\n";
                thisString += "\t\t\"owner\": \""   			+ owner                  + "\",\n";
                thisString += "\t\t\"name\": \""        	+ name              	+ "\",\n";
                thisString += "\t\t\"description\": \""     + description           + "\"\n";
                thisString += "\t\t\"slogan\": \""          + slogan           + "\"\n";
                thisString += "\t\t\"city\": \""   		    + city              + "\",\n";
                thisString += "\t\t\"meeting\": \""        + meeting                  + "\",\n";
                thisString += "\t\t\"interest\": \""        + interest                  + "\",\n";
                thisString += "\t\t\"start_date\": \""    + start_date          + "\",\n";
                thisString += "\t\t\"end_date\": \""    + end_date          + "\",\n";
                thisString += "\t\t\"date_created\": \""    + date_created          + "\",\n";
                thisString += "\t\t\"last_update\": \""    + last_update          + "\"\n";

                for (int i = 0; i < getMembers_List().size(); i++)
                {
                    Member currentMember = getMembers_List().get(i);
                    thisString += currentMember.toJSON();
                }
                thisString += "\t}";
                return thisString;
        }
        //?-------------------------------------------------------------------------------------------------------------------------------------------

        //?-------------------------------------------------------------------------------------------------------------------------------------------
        public void logInfo()    {   Log.i(TAG,  this.toJSON());     }
        //?-------------------------------------------------------------------------------------------------------------------------------------------


        //?-------------------------------------------------------------------------------------------------------------------------------------------
        //TESTS
        public static Boolean TEST( TestController.E_TEST thisTest)
        {
            Boolean Result = false;
            Manif newManif = null;

            switch(thisTest)
            {
                case E_CONSTRUCTOR :
                {
                    newManif = Manif.Create(            "4c1e51a3-178e-442a-9d20-9ee13d9e62d1",
                                                        "0c8c67fb-6206-4654-b10f-7ed26189ffe5",
                                                        "Peaceful Protest 2024",
                                                        "A peaceful gathering for a better future.",
                                                        "9c94ac81-1f84-4dc4-82a2-8d2df1f0c685",
                                                        "Montreal",
                                                        "Central Park",
                                                        "5",
                                                        "2024-02-15 10:00:00",
                                                        "2024-02-15 16:00:0",
                                                        "2024-01-10 12:00:00",
                                                        "2024-01-10 12:00:00");
                    if ( newManif != null )
                    {
                        Log.d( TestController.TAG,TAG +"	TEST:CONSTRUCTOR -> PASS"  );

                        Models.getManifs().remove(Models.getManifs().lastIndexOf(newManif));  Result = true;
                    }
                    else  {  Log.d( TestController.TAG,TAG +"	TEST:CONSTRUCTOR -> FAIL" );    Result = false;   }

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
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

