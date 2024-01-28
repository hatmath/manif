package com.projet_integrateur.app.model;

import android.util.Log;

import com.projet_integrateur.app.controller.TestController;
import com.projet_integrateur.utils.Utils;

import java.util.UUID;


//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
public class Slogan
{
        private final static String  TAG = "[" + Slogan.class.getSimpleName().toUpperCase() + "]";

		private     UUID            id           =  UUID.randomUUID();
		private     String  	    title		 = "";
		private     String  	    slogan		 = "";
		private     Integer         interest     = 0;
        private     String          date_created, last_update = Utils.updateTime_Now();;

        //?-------------------------------------------------------------------------------------------------------------------------------------------
        public static Slogan Create(String thisId, String thisTitle, String thisSlogan,  String thisInterest, String thisDate_created, String thisLast_update)
        {
            Slogan newSlogan = null;

            if (Models.getSlogan(UUID.fromString(thisId)) == null ) //SI NEXISTE PAS
            {
                newSlogan = new Slogan(UUID.fromString(thisId), thisTitle, thisSlogan, Integer.valueOf(thisInterest),thisDate_created, thisLast_update );
                if (newSlogan == null) { Log.e(TAG, "Une erreur est survenue lors la creation !!");    }
                else                  Models.getSlogans().add(newSlogan);


            }
            else Log.e(TAG, "Le slogan " + thisId + ": " + thisTitle + " EXISTE DEJA");

            return newSlogan;
        }
        //?-------------------------------------------------------------------------------------------------------------------------------------------

        private Slogan(UUID thisId, String thisTitle, String thisSlogan, Integer thisInterest, String thisDate_Created, String thisLast_update )
        {
            this.id = thisId;
            this.title =thisTitle;
            this.slogan = thisSlogan;
            this.interest  = thisInterest;
            this.date_created = thisDate_Created;
            this.last_update = thisLast_update;
        }
    //?-------------------------------------------------------------------------------------------------------------------------------------------

    //?-------------------------------------------------------------------------------------------------------------------------------------------
        private void        updateLast_update()		 {  this.last_update = Utils.updateTime_Now(); }
        public String         getLast_update()		 { return last_update; }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    //GETTERS 
        public UUID getId()  				                        { return id; }
        public String getTitle()  			                        { return title; }
        public String getSlogan()  			                        { return slogan; }
        public Integer getInterest()  			                    { return interest; }
        public String getDate_created()	                            { return date_created; }
        public String getLast_Update()  	                        { return last_update; }

    //?-------------------------------------------------------------------------------------------------------------------------------------------
    //SETTERS 
        public void setId(UUID thisId) 					            { id = thisId;                      updateLast_update(); }
        public void setTitle(String thisTitle) 					    { title = thisTitle;                updateLast_update();}
        public void setSlogan(String thisSlogan )			        { slogan = thisSlogan;              updateLast_update();}
        public void setInterest(Integer thisInterest)  			    { interest =  thisInterest; updateLast_update();}
        public void setDate_created(String thisDate_created)         { date_created = thisDate_created; }
        public void setLast_update(String thisLast_updated)          { last_update = thisLast_updated; }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    @Override public String toString() {    return this.toString();    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public String toJSON()
    {
        String  thisString = "\t{\n";
        thisString += "\t\t\"id\": \""   			+ id                        + "\",\n";
        thisString += "\t\t\"title\": \""        	+ title                     + "\",\n";
        thisString += "\t\t\"slogan\": \""          + slogan                    + "\",\n";
        thisString += "\t\t\"interest\": \""        + getInterest().toString()+ "\",\n";
        thisString += "\t\t\"date_created\": \""    + date_created              + "\",\n";
        thisString += "\t\t\"last_update\": \""     + last_update               + "\"\n";
        thisString += "\t}";
        return thisString;
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public void logInfo()    { Log.i(TAG,    this.toJSON());    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public static Boolean TEST( TestController.E_TEST thisTest)
    {
            Boolean Result = false;      Interest thisSlogan= null;

            switch(thisTest)
            {
                case        E_CONSTRUCTOR :      break;
                case        E_GETTER :           break;
                case        E_SETTER :           break;
                default :                        break;
            }
            return Result;
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------}
}
//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

