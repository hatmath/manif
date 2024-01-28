package com.projet_integrateur.app.model;

import static com.projet_integrateur.Globals.DEBUG_INFO;
import static com.projet_integrateur.app.controller.TestController.E_TEST.E_CONSTRUCTOR;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.utils.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Models
{
    public enum E_MODELS {  E_INTEREST, E_MEMBER, E_SLOGAN, E_MANIF,  E_MEMBERS_MANIF, E_INTERESTS_MEMBER}

    public  static final String  TAG = "[" + Models.class.getSimpleName().toUpperCase() + "]";


    public static List<Manif> manifs = new ArrayList<>();
    public static List<Member> members = new ArrayList<>();
    public static List<Interest> interests = new ArrayList<>();
    public static List<Slogan> slogans = new ArrayList<>();
    public static List<Avatar> avatars = new ArrayList<>();
    public static List<Members_by_Manif> members_by_Manifs = new ArrayList<>();
    public static List<Interests_by_Member> interests_by_Members = new ArrayList<>();

    //?--------------------------------------------------------------------------------------------------
    //members_by_Manif
    public static List<Members_by_Manif> getMembers_by_Manifs() { return members_by_Manifs; }
    public static void clearMembers_by_Manifs()
    {
        if (members_by_Manifs.size() > 0 )    for (int i = 0; i < members_by_Manifs.size(); i++)  members_by_Manifs.remove(i);
        members_by_Manifs.clear();       members_by_Manifs = new ArrayList<>();
    }
    public static List<Members_by_Manif> getMembers_by_Manifs(UUID thisManif )
    {
        List<Members_by_Manif> thisList = new ArrayList<>();
        for (int i = 0; i < members_by_Manifs.size(); i++)
        {
            Members_by_Manif thisMembers_by_Manif = members_by_Manifs.get(i);
            if ( thisMembers_by_Manif.getManif().equals(thisManif) ) thisList.add(thisMembers_by_Manif);
        }
        //     if (DEBUG_INFO) Log.d("[getMembers_by_Manif]", String.valueOf(thisId) + " NOT FOUND");
        return thisList;
    }

    public static void logMembers_by_Manif() {  for (int i = 0; i < members_by_Manifs.size(); i++)   members_by_Manifs.get(i).logInfo();    }

    //---------------------------------------------------------------------------------------------------------------------------

    //?--------------------------------------------------------------------------------------------------
    //interests_by_Member
    public static List<Interests_by_Member> getInterests_by_Member_List() { return interests_by_Members; }
    public static void clearInterests_by_Members()
    {
        if (interests_by_Members.size() > 0 )    for (int i = 0; i < interests_by_Members.size(); i++)  interests_by_Members.remove(i);
        interests_by_Members.clear();       interests_by_Members = new ArrayList<>();
    }
    public static Interests_by_Member getInterests_by_Member(Integer thisInterest )
    {
        for (int i = 0; i < interests_by_Members.size(); i++)
        {
            Interests_by_Member thisInterests_by_Member = interests_by_Members.get(i);
            if ( thisInterests_by_Member.getInterest().equals(thisInterest) ) return thisInterests_by_Member;
        }
        //     if (DEBUG_INFO) Log.d("[getInterests_by_Member]", String.valueOf(thisId) + " NOT FOUND");
        return null;
    }

    public static void logInterests_by_Member() {  for (int i = 0; i < interests_by_Members.size(); i++)   interests_by_Members.get(i).logInfo();    }

    //?--------------------------------------------------------------------------------------------------
    //MEMBERS
    public static List<Member> getMembers() { return members; }
    public static int getMembersCount()     { int Count = members.size();         return Count;    }
    public static void clearMembers()
    {
        if (members.size() > 0 )    for (int i = 0; i < getMembersCount(); i++)  getMembers().remove(i);
        members.clear();       members = new ArrayList<>();
    }
    public static Member getMember(UUID thisId )
    {
        for (int i = 0; i < getMembersCount(); i++)
        {
            Member thisMember = getMembers().get(i);
            if ( thisMember.getId().equals(thisId) ) return thisMember;
        }
        //     if (DEBUG_INFO) Log.d("[getMember]", String.valueOf(thisId) + " NOT FOUND");
        return null;
    }
    public static Member getMember(String thisUsername )
    {
        for (int i = 0; i < getMembersCount(); i++)
        {
            Member thisMember = getMembers().get(i);
            if ( thisMember.getUsername().equals(thisUsername) ) return thisMember;
        }
        //     if (DEBUG_INFO)  Log.d("[getMember]", thisUsername + " NOT FOUND");
        return null;
    }

    public static void logMembers() {  for (int i = 0; i < getMembersCount(); i++)   members.get(i).logInfo();    }

    //---------------------------------------------------------------------------------------------------------------------------

    //?--------------------------------------------------------------------------------------------------
    //AVATARS
    public static int getAvatarsCount()   {    int Count = avatars.size();  return Count;    }
    public static List<Avatar> getAvatars() { return avatars; }
    public static void clearAvatars()
    {
        for (int i = 0; i < getAvatarsCount()-1; i++)  getAvatars().remove(i);
        avatars.clear();       avatars = new ArrayList<>();
    }
    public static Avatar getAvatar(Integer thisId )
    {
        for (int i = 0; i < getAvatarsCount(); i++)
        {
            Avatar thisAvatar = getAvatars().get(i);
            if ( thisAvatar.getId().equals(thisId) ) return thisAvatar;
        }
        //   if (DEBUG_INFO) Log.d("[getAvatar]", String.valueOf(thisId) + " NOT FOUND");
        return null;
    }
    public static Avatar getAvatar(String thisName )
    {
        for (int i = 0; i < getAvatarsCount(); i++)
        {
            Avatar thisAvatar = getAvatars().get(i);
            if ( thisAvatar.getName().equals(thisName) ) return thisAvatar;
        }
        //   if (DEBUG_INFO) Log.d("[getAvatar]", thisName + " NOT FOUND");
        return null;
    }
    public static void logAvatars()  {  for (int i = 0; i < getAvatarsCount(); i++)   avatars.get(i).logInfo();        }
    //?--------------------------------------------------------------------------------------------------

    //?--------------------------------------------------------------------------------------------------
    //INTERESTS
    public static int getInterestsCount()    {     int Count = interests.size();    return Count;    }
    public static List<Interest> getInterests() { return interests; }
    public static void clearInterests()
    {
        for (int i = 0; i < getInterestsCount(); i++)  getInterests().remove(i);
        interests.clear();       interests = new ArrayList<>();
    }
    public static Interest getInterest(Integer thisId )
    {
        for (int i = 0; i < getInterestsCount(); i++)
        {
            Interest thisInterest = getInterests().get(i);
            if ( thisInterest.getId().equals(thisId) ) return thisInterest;
        }
        //   if (DEBUG_INFO) Log.d("[getInterest]", String.valueOf(thisId) + " NOT FOUND");
        return null;
    }
    public static Interest getInterest(String thisName )
    {
        for (int i = 0; i < getInterestsCount(); i++)
        {
            Interest thisInterest = getInterests().get(i);
            if ( thisInterest.getName().equals(thisName) ) return thisInterest;
        }
        //   if (DEBUG_INFO) Log.d("[getInterest]", thisName + " NOT FOUND");
        return null;
    }
    public static void logInterests()  {  for (int i = 0; i < getInterestsCount(); i++)   interests.get(i).logInfo();        }
    //?--------------------------------------------------------------------------------------------------


    //?--------------------------------------------------------------------------------------------------
    //MANIF
    public static int getManifsCount()
    {
        int Count = manifs.size();   //   if (DEBUG_INFO) Log.d("[getManifCount]", String.valueOf(Count));
        return Count;
    }
    public static List<Manif> getManifs() { return manifs; }
    public static void clearManifs()
    {
        if (manifs.size() > 0 )    for (int i = 1; i < getMembersCount(); i++)  getMembers().remove(i);
        manifs.clear();       manifs = new ArrayList<>();
    }
    public static Manif getManif(UUID thisId )
    {
        for (int i = 0; i < getManifsCount(); i++)
        {
            Manif thisManif = getManifs().get(i);
            if ( thisManif.getId().equals(thisId) ) return thisManif;
        }
        //     if (DEBUG_INFO) Log.d("[getManif]", String.valueOf(thisId) + " NOT FOUND");
        return null;
    }
    public static Manif getManif(String thisName )
    {
        for (int i = 0; i < getManifsCount(); i++)
        {
            Manif thisManif = getManifs().get(i);
            if ( thisManif.getName().equals(thisName) ) return thisManif;
        }
        //     if (DEBUG_INFO)  Log.d("[getManif]", thisName + " NOT FOUND");
        return null;
    }
    public static void logManifs() {  for (int i = 0; i < getManifsCount(); i++)   manifs.get(i).logInfo();    }
    //?--------------------------------------------------------------------------------------------------

    //?--------------------------------------------------------------------------------------------------
    //SLOGAN
    public static int getSlogansCount()    {   int Count = slogans.size();       return Count;    }
    public static List<Slogan> getSlogans() { return slogans; }
    public static void clearSlogans()
    {
        if (slogans.size() > 0 )    for (int i = 0; i < getSlogansCount(); i++)  getSlogans().remove(i);
        slogans.clear();             slogans = new ArrayList<>();
    }
    public static Slogan getSlogan(UUID thisId )
    {
        for (int i = 0; i < getSlogansCount(); i++)
        {
            Slogan thisSlogan = getSlogans().get(i);
            if ( thisSlogan.getId().equals(thisId) ) return thisSlogan;
        }
        //     if (DEBUG_INFO) Log.d("[getSlogan]", String.valueOf(thisId) + " NOT FOUND");
        return null;
    }
    public static Slogan getSlogan(String thisTitre )
    {
        for (int i = 0; i < getSlogansCount(); i++)
        {
            Slogan thisSlogan = getSlogans().get(i);
            if ( thisSlogan.getTitle().equals(thisTitre) ) return thisSlogan;
        }
        //     if (DEBUG_INFO)  Log.d("[getSlogan]", thisName + " NOT FOUND");
        return null;
    }
    public static void logSlogans() {  for (int i = 0; i < getSlogansCount(); i++)   slogans.get(i).logInfo();    }
    //?--------------------------------------------------------------------------------------------------




    public static void clear()    {     clearMembers();       clearInterests();     clearManifs(); }
    public static void logInfo()
    {
        logMembers();    Log.d("[MODEL]", "MEMBERS Count = " + String.valueOf(getMembersCount()-1) + "\n");
        logInterests();  Log.d("[MODEL]", "INTERESTS Count =  " + String.valueOf(getInterestsCount()-1)+ "\n");
        logManifs();     Log.d("[MODEL]", "MANIFS Count =  " + String.valueOf(getManifsCount()-1)+ "\n");
        logAvatars();    Log.d("[MODEL]", "AVATARS Count =  " + String.valueOf(getAvatarsCount()-1)+ "\n");
    }

    public static Members_by_Manif getMembers_by_Manif(Integer thisId)
    {
        for (int i = 0; i < getMembers_by_Manifs().size(); i++)
        {
            Members_by_Manif thisMembers_by_Manif = getMembers_by_Manifs().get(i);
            if ( thisMembers_by_Manif.getId().equals(thisId) ) return thisMembers_by_Manif;
        }

        return null;
    }

    public static List<Member> getMembers_From_Manif( UUID thisUUID)
    {
        if (thisUUID == null) return null ;
        Manif thisManif = Models.getManif(thisUUID);
        if (thisManif != null)
        {
            if (DEBUG_INFO)
            {
                Log.i(TAG, "\n-------------------\t  MEMBERS_BY_MANIF:\t"+thisManif.getName()+ "\t-------------------");

                for (int i = thisManif.getMembers_List().size()-1; i >= 0; --i)
                {
                    if (Models.getMember(thisManif.getOwner()) != null)
                    {
                        if (thisManif.getMembers_List().get(i).getUsername().equals(Models.getMember(thisManif.getOwner()).getUsername()))
                        {      Log.i(TAG, "\t" + thisManif.getMembers_List().get(i).getUsername()+" (OWNER)");}
                        else  Log.i(TAG, "\t" + thisManif.getMembers_List().get(i).getUsername());
                    }   else Log.e(TAG, "WARNING MANIF.OWNER NOT FOUND " + thisManif.getOwner());
                }
            }
            return thisManif.getMembers_List();
        }

        return null;
    }

    public static List<Manif> getManifs_for_AuthMember()
    {
        List<Manif> thisList = new ArrayList<>();
        Member AuthMember = AuthManager.getInstance().getAuthMember();
        if ( AuthMember != null)
        {
            Log.i(TAG, "\n-------------------------------------------------------------");
            Log.i(TAG, "AUTHMEMBER: " + AuthMember.getId().toString() + ", " + AuthMember.getUsername());

            List<String> thisManifs_by_Member_List = new ArrayList<>();
            for (int i = 0; i < Models.members_by_Manifs.size(); i++)
            {
                Members_by_Manif thisMembers_by_Manifs = Models.members_by_Manifs.get(i);
                String Manif_UUID =  thisMembers_by_Manifs.getManif().toString(); String Manif_Name="";
                Manif currentManif = Models.getManif(UUID.fromString(Manif_UUID));
                if (currentManif == null ) Log.e(TAG, "WARNING: \tMANIF -> " +  Manif_UUID + " N\'EXISTE PAS");
                else { Manif_Name = Models.getManif(thisMembers_by_Manifs.getManif()).getName(); }
                String Member_UUID =  thisMembers_by_Manifs.getMember().toString();   String Member_Username="";
                Member  currentMember = Models.getMember(UUID.fromString(Member_UUID));
                if (currentMember == null ) Log.e(TAG, "WARNING: \tMEMBER -> " + Member_UUID + " N\'EXISTE PAS");
                else { Member_Username = Models.getMember(thisMembers_by_Manifs.getMember()).getUsername(); }
                Log.i(TAG, "-------------------------------------------------------------");
                Log.i(TAG, "Index: " + String.valueOf(i));
                Log.i(TAG, "MANIF UUID: " + Manif_UUID + ", \tNAME: " + Manif_Name );
                Log.i(TAG, "MEMBER UUID: " + Member_UUID + ", \tUSERNAME: " + Member_Username);


                if (currentManif != null)
                {
                    //liste des membres inscrit a la manif courante
                    Member thisMember =  Models.getMember(UUID.fromString(Member_UUID));

                    if (AuthMember.getId().equals(thisMember.getId()))
                    {
                        thisList.add(currentManif);
                    }
                }
            }
            Log.i(TAG, "-------------------------------------------------------------");
            Log.i(TAG, "AUTHMEMBER: " + AuthMember.getUsername() );
            for (int i=0; i< thisList.size(); i++)  Log.i(TAG, "\tMANIF: " + thisList.get(i).getName() );
            Log.i(TAG, "-------------------------------------------------------------\n");
        }
        return thisList;
    }

    //?--------------------------------------------------------------------------------------------------
    public static Boolean seeds_temporaryData()
    {
        //?--------------------------------------------------------------------------------------------
        //Avatars
        if (Models.getAvatars().size() == 0 )
        {
            Avatar.Create("R.drawable.img_avatar_default");
            Avatar.Create("R.drawable.img_avatar_jntessier");
            if (DEBUG_INFO) Models.logAvatars();
        }
        //?--------------------------------------------------------------------------------------------
        //Interests

        if (Models.getInterests().size() == 0 )
        {
          /* if (Globals.TESTS_ENABLED == true)  if ( Interest.TEST(E_CONSTRUCTOR) == false) return false;

            Interest.Create("Peaceful Protest 2024", "A peaceful gathering for a better future.");
            Interest.Create("Changement Climatique et Environnement");
            Interest.Create("Droits des Animaux");
            Interest.Create("Justice Sociale et Économique");
            Interest.Create("Éducation");
            Interest.Create("Santé Publique");
            Interest.Create("Droits des Travailleurs et Syndicalisme");
            Interest.Create("Réformes Gouvernementales et Politiques");
            Interest.Create("Liberté d\'Expression et Censure");
            Interest.Create("Immigration et Droits des Réfugiés");
            Interest.Create("Démilitarisation et Paix");
            Interest.Create("Racisme et Discrimination");
            Interest.Create("Protection des Données et Vie Privée");
            Interest.Create("Innovation et Technologie");
            Interest.Create("Développement Urbain et Logement");
            Interest.Create("Sécurité Alimentaire et Agriculture");
            Interest.Create("Culture et Patrimoine");
            Interest.Create("Transport et Mobilité Urbaine");
            if (DEBUG_INFO)  Models.logInterests();*/
        }
        //?--------------------------------------------------------------------------------------------
        //Members
        if (Models.getMembers().size() == 0 )
        {
            Member thisMember_admin = Member.Create("00000000-0000-0000-0000-000000000000", "admin", "12345678", "", "", "1", "", "", Utils.updateTime_Now(), Utils.updateTime_Now(), LocalDateTime.now().toString() );
            thisMember_admin.setDescription("Compte administrateur");

            Member  thisMember_jntessier = Member.Create("00000000-0000-0000-0000-000000000001", "jntessier", "12345678", "", "", "1", "", "",Utils.updateTime_Now(), Utils.updateTime_Now(), LocalDateTime.now().toString() );
            thisMember_jntessier.setDescription("For question related about manif -> Contact me");
            thisMember_jntessier.setAvatar(1);
            thisMember_jntessier.setMail("jntessier@hotmail.com");
            thisMember_jntessier.setPhone("8196993576");
/*
            Member  thisMember_Alfonzo45 = Member.Create(   "0c8c67fb-6206-4654-b10f-7ed26189ffe5",
                                                            "Alfonzo45",
                                                            "12345678",
                                                            "mockSalt",
                                                            "Alfonzo45 - Description",
                                                            "8",
                                                            "Libbie.Nader@yahoo.com",
                                                            "5575996260",
                                                            "2023-04-28 18:28:25",
                                                            "2024-01-10 16:29:20",
                                                            "2024-01-09 23:04:04");


            Member  thisMember_BlazeHayes50 = Member.Create(    "21ab87a9-bccb-46fc-9330-1ae98f3be813",
                                                                "Blaze.Hayes50",
                                                                "12345678",
                                                                "mockSalt",
                                                                "BlazeHayes50-Description",
                                                                "4",
                                                                "Rhett60@hotmail.com",
                                                                "4568894611",
                                                                "2023-11-21 08:22:39",
                                                                "2024-01-10 08:23:13",
                                                                "2024-01-10 00:02:03");


            Member  thisMember_BernhardWalter99 = Member.Create("30233107-7181-4d93-a646-6b47a023d44a",
                                                                "Bernhard.Walter99",
                                                                "12345678",
                                                                "mockSalt",
                                                                "BernhardWalter99-Description",
                                                                "10",
                                                                "Mireille50@gmail.com",
                                                                "4512354565",
                                                                "2023-08-06 00:38:55",
                                                                "2024-01-10 16:28:29",
                                                                "2024-01-10 13:25:25");

            Member  thisMember_Gavin52 = Member.Create( "4a5b1083-0ce3-474d-b65f-5e664f9e2cd9",
                                                        "Gavin52",
                                                        "12345678",
                                                        "mockSalt",
                                                        "Gavin52-Description",
                                                        "8",
                                                        "Harley12@yahoo.com",
                                                        "6146064237",
                                                        "2023-07-08 10:11:33",
                                                        "2024-01-10 07:48:16",
                                                        "2024-01-10 03:09:29");

            Member  thisMember_Rahsaan74 = Member.Create(   "602843e1-ceb5-4cb3-a960-95d0af960d81",
                                                            "Rahsaan74",
                                                            "12345678",
                                                            "mockSalt",
                                                            "Rahsaan74-Description",
                                                            "2",
                                                            "Zechariah.Hirthe4@gmail.com",
                                                            "5947972923",
                                                            "2023-08-23 20:54:52",
                                                            "2024-01-10 01:17:06",
                                                            "2024-01-09 22:49:45");


            if (DEBUG_INFO) Models.logMembers();
*/
        }

        //?--------------------------------------------------------------------------------------------
        //Slogans
       if (Models.getSlogans().size() == 0 )
        {
           // if (Globals.TESTS_ENABLED == true)  if (Slogan.TEST(E_CONSTRUCTOR) == false) return false;

            Slogan.Create(   "00000000-0000-0000-0000-000000000000",
                    "Stage en entreprise optionel pour obtention du diplome",
                    "Pas de stage, sommes imcompetant\nPourtant on na reussi notre formation\nEst-ce nous qui decidons d\'etre engager et avions eu suffisament du support et de temps.",
                    "3",
                    "2024-01-18T17:00:00.000",
                    "2024-01-18T17:00:00.000"   );
/*
            Slogan.Create(   "9c94ac81-1f84-4dc4-82a2-8d2df1f0c685",
                    "Stand Up for Equality",
                    "Together for a world where everyone is treated with fairness and respect.",
                    "3",
                    "2022-01-15 10:00:00",
                    "2022-01-15 10:00:00"   );

            Slogan.Create(   "22d10f54-83d5-4a4a-b3c7-5c4bce0c0599",
                    "Green Future, Clean Future",
                    "Join the movement for a sustainable and environmentally friendly world.",
                    "2",
                    "2022-01-15 11:00:00",
                    "2022-01-15 11:00:00"   );

            if (DEBUG_INFO) Models.logSlogans();*/
        }
        //?--------------------------------------------------------------------------------------------
        //Manifs

        if (Models.getManifsCount() > 0 ) Models.clearManifs();
        if (Models.getManifs().isEmpty() )
        {
            if (Globals.TESTS_ENABLED == true)      if (Slogan.TEST(E_CONSTRUCTOR) == false) return false;

            Manif.Create(
                    "00000000-0000-0000-0000-000000000000",
                    "00000000-0000-0000-0000-000000000001",
                    "LEA.CB - Obtention diplome",
                    "Negocier une entente avec le Colllege Ahuntsic de donner le diplome au groupe application mobile.\nVue le faible pourcentage de placement, est-ce que ca veut dire qu\'on n\'ai pas bon. Imaginer le temps et l\'argent perdu et les probleme qui vont arriver. Nous ne pouvons pas recommencer, nous avons deja ecouler nos ressources",
                    "00000000-0000-0000-0000-000000000000",
                    "Montreal",
                    "CollegeAhuntsic",
                    "4",
                    "2024-01-17 10:00:00",
                    "2024-01-17 16:00:0",
                    "2024-01-10 12:00:00",
                    "2024-01-10T12:00:00.000");

           /* Manif.Create("4c1e51a3-178e-442a-9d20-9ee13d9e62d1",
                    "0c8c67fb-6206-4654-b10f-7ed26189ffe5",
                    "Peaceful Protest 2024",
                    "A peaceful gathering for a better future.",
                    "9c94ac81-1f84-4dc4-82a2-8d2df1f0c685",
                    "cityVille",
                    "Central Park",
                    "5",
                    "2024-02-15 10:00:00",
                    "2024-02-15 16:00:0",
                    "2024-01-10 12:00:00",
                    "2024-01-10 12:00:00");

            Manif.Create("8658e41d-106d-4d78-9ce5-2a2b97f7f0a8",
                    "21ab87a9-bccb-46fc-9330-1ae98f3be813",
                    "Equality March",
                    "Marching for equality and justice.",
                    "22d10f54-83d5-4a4a-b3c7-5c4bce0c0599",
                    "Equality Town",
                    "Main Square",
                    "10",
                    "2024-03-01 14:00:00",
                    "2024-03-01 18:00:0",
                    "2024-01-11 9:30:00",
                    "2024-01-11 9:30:00");

            Manif.Create("e3b6c04c-bf04-4f5c-bac5-3a9ddce11239",
                    "30233107-7181-4d93-a646-6b47a023d44a",
                    "Climate Action Rally",
                    "Raising awareness for climate change",
                    "563a23d7-0d8b-4a9c-90f6-8b18133d7b69",
                    "Green City",
                    "City Hall",
                    "7",
                    "2024-04-05 11:30:00",
                    "2024-04-05 15:30:00",
                    "2024-01-12 15:45:00",
                    "2024-01-12 15:45:00");

            if (DEBUG_INFO) Models.logManifs();*/
        }
        //?--------------------------------------------------------------------------------------------
        //members_by_Manifs
        if (members_by_Manifs.size() > 0 ) members_by_Manifs.clear();
        if (members_by_Manifs.isEmpty() )
        {
           /* Members_by_Manif.Create(    "00000000-0000-0000-0000-000000000000",
                    "00000000-0000-0000-0000-000000000001",
                    "false", "5",
                    "2024-01-18 17:00:00",
                    "2024-01-18 17:00:00" );



            Members_by_Manif.Create(    "4c1e51a3-178e-442a-9d20-9ee13d9e62d1",
                    "00000000-0000-0000-0000-000000000000",
                    "false", "5",
                    "2024-01-11 12:00:00",
                    "2024-01-11 12:00:00" );

           Members_by_Manif.Create(    "4c1e51a3-178e-442a-9d20-9ee13d9e62d1",
                    "0c8c67fb-6206-4654-b10f-7ed26189ffe5",
                    "true", "4",
                    "2024-01-11 12:00:00",
                    "2024-01-11 12:00:00" );
*/
            Members_by_Manif.Create(    "8658e41d-106d-4d78-9ce5-2a2b97f7f0a8",
                    "00000000-0000-0000-0000-000000000000",
                    "false", "5",
                    "2024-01-11 12:00:00",
                    "2024-01-11 12:00:00" );
/*
            Members_by_Manif.Create(    "8658e41d-106d-4d78-9ce5-2a2b97f7f0a8",
                    "21ab87a9-bccb-46fc-9330-1ae98f3be813",
                    "true", "5",
                    "2024-01-11 14:30:00",
                    "2024-01-11 14:30:00" );*/

            Members_by_Manif.Create(    "e3b6c04c-bf04-4f5c-bac5-3a9ddce11239",
                    "00000000-0000-0000-0000-000000000000",
                    "false", "5",
                    "2024-01-11 12:00:00",
                    "2024-01-11 12:00:00" );
/*
            Members_by_Manif.Create(    "e3b6c04c-bf04-4f5c-bac5-3a9ddce11239",
                    "30233107-7181-4d93-a646-6b47a023d44a",
                    "false", "0",
                    "2024-01-11 16:45:00",
                    "2024-01-11 16:45:00" );

            if (DEBUG_INFO) Models.logMembers_by_Manif();*/
        }
        //?--------------------------------------------------------------------------------------------

        return true;
    }


}
