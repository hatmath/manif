package com.projet_integrateur.app.model;

import static com.projet_integrateur.app.controller.TestController.E_TEST;

import android.util.Log;

import com.projet_integrateur.app.controller.TestController;
import com.projet_integrateur.utils.Utils;

import java.time.LocalDateTime;

//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
public class Interest
{
    //!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    
	
    private static final String  TAG = "[" + Interest.class.getSimpleName().toUpperCase() + "]";


    private Integer         id       	= -1;
	private String 			name 		= "";
    private String          description = "";
    private String 	        date_created, last_update =  Utils.updateTime_Now();;
    //!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^    
    
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    //BUILDER
    public static Interest Create(String thisName, String thisDescription)	{  return  Interest.Create( String.valueOf(Models.getInterests().size()), thisName, thisDescription, "", "");	}
    public static Interest Create(String thisId, String thisName, String thisDescription, String thisDate_created, String thisLast_update)
    {
        Interest newInterest = null;

        if (Models.getInterest(thisName) == null ) //SI NEXISTE PAS
        {
            newInterest = new Interest( Integer.valueOf(thisId), thisName, thisDescription, thisDate_created, thisLast_update);
            if (newInterest == null) {Log.e(TAG, "Une erreur est survenue lors l\' initialisation !!");            }
            else
            {
                Models.getInterests().add(newInterest);
                newInterest.setId(Models.getInterests().indexOf(newInterest));
            }
        }  else Log.e(TAG, thisName + " EXISTE DEJA");

        return newInterest;
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
      
	//?-------------------------------------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    private Interest(Integer thisId, String thisName, String thisDescription, String thisDate_created, String thisLast_update )
    {
        this.id = thisId;
        this.name = thisName;
        this.description = thisDescription;

        if (thisDate_created.isEmpty()) Utils.updateTime_Now(); else this.date_created = thisDate_created;
        if (last_update.isEmpty())      Utils.updateTime_Now(); else this.last_update = thisLast_update;
    }
	//?-------------------------------------------------------------------------------------------------------------------------------------------
    private void         updateLast_update()		 {  this.last_update = Utils.updateTime_Now();   }
    // ?-------------------------------------------------------------------------------------------------------------------------------------------
    // GETTERS
    public Integer getId()  				                { return id; }
	public String getName()  			                    { return name; }
    public String getDescription()  			            { return description; }
    public String getDate_created()	                        { return date_created; }
    public String getLast_update()  	                    { return last_update; }

    //-------------------------------------------------------------------------------------------
    //SETTERS
    public void setId(Integer thisId) 				        { id = thisId; updateLast_update();}
	public void setName(String thisName) 		            { name = thisName; updateLast_update();}
    public void setDescription(String thisDescription) 		{ description = thisDescription; updateLast_update();}

    public void setDate_created(String thisDate_created)    { date_created = thisDate_created; updateLast_update();}
    public void setLast_update(String thisLast_updated)      { last_update = thisLast_updated; updateLast_update();}

    //?-------------------------------------------------------------------------------------------
	public 	String toJSON()
	{
		String  thisString = "\t{";
        thisString += "\t\"id\": \""  + id.toString()  + "\", " + "\"name\": \"" + name  + "\", " + "\"description\": \"" + description  + "\"";
        thisString += "\t}";
        return thisString;
	}
    //?-------------------------------------------------------------------------------------------
   
    public void logInfo()    {     Log.i(TAG,  this.toJSON());	}
    //?-------------------------------------------------------------------------------------------


	//?-------------------------------------------------------------------------------------------------------------------------------------------
    //TESTS 
    public static Boolean TEST( E_TEST thisTest)
    {
        Boolean Result = false;		Interest thisInterest = null;
		
        switch(thisTest)
        {
            case E_CONSTRUCTOR :
            {
                thisInterest = Interest.Create( "test", "This is a test description.");
                if ( thisInterest != null )
                {        Log.d( TestController.TAG,TAG +"\tTEST:CONSTRUCTOR -> PASS"  + "\t WHILE EXECUTING -> [ interest.Create( \"test\", \"This is a test description.\"); ]");    Result = true;    }
                else  {  Log.d( TestController.TAG,TAG +"\tTEST:CONSTRUCTOR -> FAIL"  + "\t WHILE EXECUTING -> [ interest.Create( \"test\", \"This is a test description.\"); ]");    Result = false;   }

            } break;
          
            case         E_GETTER :           break;
            case         E_SETTER :           break;
            default :                         break;
        }
        return Result;
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------





}
//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

