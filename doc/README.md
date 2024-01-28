
# Projet intégrateur: Manif

## Entête
   
    Projet: 
        Manif
    Étudiants: 
        Mathieu Hatin (2296939) / Simon Turcotte (2395412) / Jean-Nicolas Tessier (2395402)
    Cours: 
        Projet intégrateur (420-296-AH) / Collègue Ahuntsic / Montréal
    Date: 
        Janvier 2024

## Général
**Manif** est l'appication
- que tous utilisent pour créer et afficher une **manifestation** à venir, en informer d'autres et multiplier le taux de participation. Tous ensemble, nous pouvons améliorer ce monde, une revendication, un défi, une cause à la fois! 
- qui offre de partager un **slogan** thématique à scander lors d'une manisfestation. Voilà ce que nous allons dire et nous serons entendu une fois de plus! 
- qui vous permet de dire **"J'y suis"** durant une manifestion
- où **noter** une manisfestation quand on a pris le temps d'y être et le courage de se lever est permis
- où les **intérêts** sociaux des membres sont définis et considérés

_Pour faire fonctionner Manif, vous n'avez qu'à suivre les étapes._
  
## Base de données

0 - Install node_module in ./database  
    npm install
    
1 - Install MySQL CLI

2 - Connect as root

3 - In mysql console, run all commands from sql_setup.sql (located in ./database/doc/)

4 - Create folder ./database/env/

5 - Copy the environment files received from your admin.

    These files, related to the environment, contain sensitive, protected data and are therefore not included in the project from the start.

    Two files should be created: ./database/env/.env.development and ./database/env/.env.production.

    Below is the skeleton of these files, but with critical information missing.

    You must obtain this information from your admin to create, connect, and seed the database.
    
    DB_HOST=
    DB_USER=
    DB_PASSWORD=
    DB_NAME=
    DB_PORT=

    Exceptionally, for our teachers to easily run our product, the environment files can be found under ./doc/env/database for now.  

6 - But usualy you will get those files from your admin and you just update DB_HOST variable : 

    DB_HOST=192.168.1.99 #TO CHANGE FOR ACTUAL DB IP ADDRESS

    Set to local MySQL address. (Most likely localhost if ran on same PC)

7 - In vscode console, run :   
    npm run db:deploy
  
## Backend

0 - Install node_module in ./backend      
    npm install

1 - Create folder ./backend/env/

2 - Copy the environment files received from your admin.

    These files, related to the environment, contain sensitive, protected data and are therefore not included in the project from the start.

    Two files should be created: ./backend/env/.env.development and ./backend/env/.env.production.

    Below is the skeleton of these files, but with critical information missing.

    You must obtain this information from your admin in order to run the backend and make the manif REST API accessible.
    
    DB_USERNAME=
    DB_PASSWORD=
    DB_NAME=
    DB_PORT=
    BACKEND_DATA_PORT=
    JWT_SECRET_KEY=

    Exceptionally, for our teachers to easily run our product, the environment files can be found under ./doc/env/backend for now.  
    
3 - In vscode console, run one of those command depending in witch environment you are:   
    npm run start-dev  
    or  
    npm run start-prod  

## Frontend Mini
PWA (Progressive Web Application) version of the frontend.

0 - Install node_modules in ./mini        
    npm install

1 - Go to http://backend_ip:backend_port/mini/index.html  
    backend_ip and backend_port are defined in the environment file set earlier in the backend section.  
    A concrete example could be: http://127.0.0.1:5283/mini/index.html  
    
2 - Use a powerful, lightweight PWA interface capable of running on multiple operating systems like Windows, Linux, Android, iOS, and many more.


## Frontend Android
Version APK (Android PacKage) du frontend

0 - Aller dans ./frontend  
1 - Copier manif.apk sur votre téléphone Android et faire l'installation en permettant les sources inconnues

Sinon, vous pouvez ouvrir le code sous Android Studio  
- Il s'agit à l'origine d'un projet Android Studio Giraffe | 2022.3.1 Patch 2  
- Utilisant Gradle 8.1.2 pour la compilation  
- Qui devrait être en mesure de rouler sur les API Android de 26 à 34

---

## API Web

#### GET all manif
http://localhost:5283/api/data/getAllManif

#### GET latest manif
http://localhost:5283/api/data/getNewestManif?dateCreated=2024-01-12T10:00:00.000Z

#### GET all slogan
http://localhost:5283/api/data/getAllSlogan

#### GET latest slogan
http://localhost:5283/api/data/getNewestSlogan?dateCreated=2022-01-15T22:00:00.000Z

#### GET all interest
http://localhost:5283/api/data/getAllInterest

#### GET latest interest
http://localhost:5283/api/data/getNewestInterest?dateCreated=2024-01-22T10:00:00.000Z

#### GET member
http://localhost:5283/api/data/getMember?clientId=0c8c67fb-6206-4654-b10f-7ed26189ffe5

#### POST create manif
http://localhost:5283/api/data/createManif

    request body:
    {       
        "owner": "0c8c67fb-6206-4654-b10f-7ed26189ffe5",
        "name": "Test Manifestation",
        "description": "This is another test manifestation.",
        "slogan": "faff4db3-21a1-4ee4-8464-89f389265d7b",
        "city": "Test2 City",
        "meeting": "Test2 Meeting",
        "interest": "6",
        "start_date": "2023-01-30T12:00:00.000Z",
        "end_date": "2023-01-30T16:00:00.000Z"
    }

#### POST create interest
http://localhost:5283/api/data/createInterest

    request body:
    {
        "name": "Test Interest",
        "description": "This is a test interest."
    }

#### POST create slogan
http://localhost:5283/api/data/createSlogan

    request body:
    {
        "title": "Test Slogan",
        "slogan": "This is a test slogan.",
        "interest": "1"
    }

#### POST create new member by manif
http://localhost:5283/api/data/createMemberManif

    request body:
    {
        "manif": "8658e41d-106d-4d78-9ce5-2a2b97f7f0a8",
        "member": "602843e1-ceb5-4cb3-a960-95d0af960d81"
    }

#### POST login user
http://localhost:5283/api/auth/login

    request body:
    {
        "username": "alice_smith",
        "password": "another_hashed_password"
    }

#### POST create member
http://localhost:5283/api/auth/register

    request body:
    {
        "username": "alice_smith",
        "password": "another_hashed_password",
        "mail": "alice.smith@example.com",
        "description": "Another member of the community",
        "avatar": 2,
        "phone": "9876543210"
    }

#### PATCH update manif
note: All fields optional but minimally one.  
http://localhost:5283/api/data/updateManif

    request body :
    {
        "clientId": "0c8c67fb-6206-4654-b10f-7ed26189ffe5",
        "manifId": "4c1e51a3-178e-442a-9d20-9ee13d9e62d1",
        "updatedData": 
        {
            "name": "update Manifestation",
            "description": "This is another update testmanifn.",
            "slogan": "faff4db3-21a1-4ee4-8464-89f389265d7b",
            "city": "oppdate City",
            "meeting": "Test2update"
        }
    }

#### PATCH update member by manif rating
http://localhost:5283/api/data/updateRating

    request body: 
    {
        "clientId": "30233107-7181-4d93-a646-6b47a023d44a",
        "manifId": "e3b6c04c-bf04-4f5c-bac5-3a9ddce11239",
        "newRating": "4"
    }

#### PATCH update member by manif presence
http://localhost:5283/api/data/updatePresence

    request body: 
    {
        "clientId": "30233107-7181-4d93-a646-6b47a023d44a",
        "manifId": "e3b6c04c-bf04-4f5c-bac5-3a9ddce11239"
    }



