package com.niantic;



public class Main
{
    public static void main(String[] args)
    {
        examples();
        section01();
        section02();
        section03();
        clairesCookies();
        elliotsYardCare();
    }

    public static void examples()
    {
        // i. Create a variable that stores the name of the best
        // programming language.
        String bestLanguage;
        bestLanguage = "Java";

        System.out.println("i) Best Programming Language");
        System.out.println("language: " + bestLanguage);
        System.out.println();



        // ii. Create a variable to store the speed limit in
        // a school zone.
        int speedLimit;
        speedLimit = 20;

        System.out.println("ii) Speed Limit");
        System.out.println("speedLimit: " + speedLimit);
        System.out.println();
    }

    public static void section01()
    {
        /******************** Section 1 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 1: Declaring Variables");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();



        // 1. Declare a new variable to hold your name.
        // Variable name: name
        // Data Type: string (names/words are strings)
        String name= "Jessy";

        System.out.println("1) Name: ");
        System.out.println("name: " + name);
        System.out.println();


        // 2. Declare a variable to hold your age.
        // Variable name: age
        // Data Type: int (age is a whole number)
        int age;
        age = 30;

        System.out.println("2) Age:");
        System.out.println("age: " + age);
        System.out.println();



        // 3. Declare a variable that holds the first 5 digits of PI.
        // Variable name: pi
        // Data Type: double (pi is a number with decimal places)
        Double pi;
        pi = 3.1415;

        System.out.println("3) Pi: ");
        System.out.println("pi:" + pi);
        System.out.println();


        // 4. Declare a variable holds the price of
        // an adult meal at the buffet.
        // Variable name: price
        // Data Type: double (price contains a dollar and cent value)
        Double price;
        price = 24.99;

        System.out.println("4) Price");
        System.out.println("price: " + price);
        System.out.println();
        // NOTE: the decimal data type  is not automatically recognized
        // see lecture notes
    }

    public static void section02()
    {

        /******************** Section 2 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 2: Selecting DataTypes");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        // From this point forward you will need to choose
        // the variable name for each of your variables
        // as well as the DataType that will be used for
        // each variable.



        // 5. Declare a variable to store the name of your
        // favorite super hero.
        String superHero;
        superHero = "Wolverine";

        System.out.println("5) Favorite super hero:");
        System.out.println("Super hero: " + superHero);
        System.out.println();


        // Hint: You cannot use the same variable name
        // as a variable that you have used before.



        // 6. Declare a variable to hold the value of
        // value of a test score. The test has 100
        // questions and each question is worth 1 point.
        // (You can choose the score)
        int testScore;
        testScore =  89;
        double totalScore;
        totalScore = 100;
        double actualScore;
        actualScore = (testScore / totalScore) * 100;

        System.out.println("6) Test Score: ");
        System.out.println("your test score: " + testScore);
        System.out.println("out of a total: " + totalScore);
        System.out.println("Your total test score percentage: " + actualScore);
        System.out.println();


        // 7. Declare a variable that holds the current
        // population in the United States.
        // (search what the population is today)
        Double currentUsPopulationMillions;
        currentUsPopulationMillions = 333.3;

        System.out.println("7) Current US population (in millions): ");
        System.out.println("population: " + currentUsPopulationMillions);
        System.out.println();


        // 8. Declare a variable that holds the current
        // population in China.
        // (search what the population is today)
        Float currentChinaPopulationBillions;
        currentChinaPopulationBillions = 1.412F;

        System.out.println("8) Current population in China (in billions): ");
        System.out.println("population: " + currentChinaPopulationBillions);
        System.out.println();

        // 9. Declare a variable that holds the current
        // population in the world.
        // (search what the population is today)
        long currentWorldPopulation;
        currentWorldPopulation = 7_951_000_000l;

        System.out.println("9) Current world population (in billions)");
        System.out.println("world population: " + currentWorldPopulation);
        System.out.println();


        // 10. Declare a variable that specifies whether
        // or not your mouse is wireless.
        Boolean isWireless = true;


        System.out.println("10) Is your mouse wireless: ");
        System.out.println("your mouse is wireless: " + isWireless);
        System.out.println();


        // 11. Search what the Latitude and Longitude of your
        // home town are. Then declare 2 variables
        // to store the Latitude and Longitude.
        Double hometownLatitude;
        hometownLatitude = 47.1854;
        Double hometownLongitude;
        hometownLongitude = -122.292900;

        System.out.println("11) Home town Latitude and Longitude:");
        System.out.println("Latitude: " + hometownLatitude);
        System.out.println("Longitude: " + hometownLongitude);
        System.out.println();

        // 12. Create a variable that holds the current
        // Microsoft stock price.
        Double currentMicrosoftStockPrice;
        currentMicrosoftStockPrice = 444.85;

        System.out.println("12) Current Microsoft Stock Price: ");
        System.out.println("current stock price: " + currentMicrosoftStockPrice);
        System.out.println();


    }
    
    public static void section03()
    {
        /******************** Section 3 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 3: Expressions and Arithmetic");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        /*
         * In this section you are expected to create
         * multiple variables in each exercise. You should
         * create as many variables as you need in order to
         * solve each problem.
         *
         * Make sure that your variable names are meaningful
         * and that the name describes the purpose of the
         * variable. Also, your code should not have any
         * "magic numbers" but anyone who reads the code
         * should be able to understand your code and
         * the calculations.
         */

        System.out.println("----------------------------");
        System.out.println("Backyard Basketball");
        System.out.println("-----------------------------");
        System.out.println();


        // 13. In his last basketball game Pete made 7 shots,
        // but missed 3 of his shots.

        // How many shots did Pete take?
        int totalShotsMade;
        totalShotsMade = 7;
        int totalShotsMissed;
        totalShotsMissed = 3;
        int totalShots;
        totalShots = totalShotsMade + totalShotsMissed;

        System.out.println("13) How many shots Pete took in the last game: ");
        System.out.println("Pete made: " + totalShotsMade);
        System.out.println("Pete missed: " + totalShotsMissed);
        System.out.println("So Pete took a total shots of: " + totalShots);
        System.out.println();



        // 14. In his previous basketball game Pete took 20 shots.
        // He missed 6 shots, and he made 3 three point shots.

        // How many 2 point shots did Pete make?\
        int previousTotalShots = 20;
        double previousTotalShotsMissed = 6;
        double previousThreePointersMade = 3;
        double previousTotalTwoPointersMade = previousTotalShots - previousTotalShotsMissed - previousThreePointersMade;

        System.out.println("14) Total 2 point shots Pete made in his previous game: ");
        System.out.println("shots Pete took: " + previousTotalShots);
        System.out.println("Pete's missed shots: " + previousTotalShotsMissed);
        System.out.println("how many of those were 3 pointers: " + previousThreePointersMade);
        System.out.println("Pete's total 2 pointers: " + previousTotalTwoPointersMade);
        System.out.println();

        // 15. Pete and Pat are teammates. Pete made 6 shots.
        // Pat made twice as many shots as Pete.

        // How many total shots did they make?
        String teammate1 = "Pete";
        String teammate2 = "Pat";
        int teammate1Shots = 6;
        int teammate2Shots = teammate1Shots * 2;
        int totalteamShots = teammate1Shots + teammate2Shots;

        System.out.println("15) Total shots of teammates Pete and Pat: ");
        System.out.println(teammate1 + " made " + teammate1Shots);
        System.out.println(teammate2 + " made " + teammate2Shots);
        System.out.println("So, both teammates made: " + totalteamShots);
        System.out.println();




        // 16. Pete has made 13 shots, Pat has made 9.
        // If both Pete and Pat make 1 more shot each
        // before the game ends, how many total shots
        // did the Terrifying Twosome make in the game?
        int peteshotsTT = 13;
        int patshotsTT = 9;
        int totalShotsTT = (peteshotsTT + 1)  + (patshotsTT+ 1);


        System.out.println("16) The Terrifying Twosome made this many shots if both made 1 more shot before game ends: ");
        System.out.println(teammate1 + " made: " + peteshotsTT);
        peteshotsTT++;
        System.out.println(teammate2 + " made: " + patshotsTT);
        patshotsTT++;
        System.out.println("Terrifying Twosome total shots if both made one more shot each: " + totalShotsTT);
        System.out.println();

        // 17. In his last game Pete made 11 shots.
        // he missed 4 shots.

        // What percentage of his shots did he make?

        int lgShotsMade = 11;
        double lgShotsMissed = 4;
        double totalShots17 = lgShotsMissed + lgShotsMade;
        double percentageTotalMade = lgShotsMade / totalShots17;



        System.out.println("17) Percentage of shots Pete made: ");
        System.out.println("Pete's shots made: " + lgShotsMade);
        System.out.println("Pete's shots missed: " + lgShotsMissed);
        System.out.println("Pete made a total shots of: " + totalShots17);
        System.out.println("percentage shots made: " + percentageTotalMade * 100 + "%");
        System.out.println();


        // 18. Pete and Pat have decided to only take 3 point
        // shots in their next game. Together they make 70%
        // of their 3 point shots.

        // The team that they are playing scores 31 points a game.

        // How many shots do Pete and Pat have to take to win
        // this game?
        double percentage3ptmade = .70;
        double oppTeamScore = 31;
        double valuePerShot = 3;
       // double totalShotsNeeded = totalPointsNeeded / 3;
        //double totalNeededPercentageAllowance = totalShotsNeeded / percentage3ptmade;

        System.out.println("18) Shots Pete and Pat need to take in order to win the game: ");
        System.out.println("Points opposing team made: " + oppTeamScore);
        //add one point to know how much Pete and Pat need to score to win
        oppTeamScore++;
        System.out.println("Total score Pat and Pete need to win: " + oppTeamScore);
        // divide total needed to win by three (points) to learn how many 3 pointers are need to win
        System.out.println("To win, 3 pointer shots needed: " + oppTeamScore / 3 );
        System.out.println("Pete and Pat 3 point shot avg: " + percentage3ptmade);
        // find out how many total shots are needed if only 70% of total are 'made'
        System.out.println("Total shots needed to take with avg: " + (oppTeamScore/3) / percentage3ptmade);
        System.out.println();



    }
    
    public static void clairesCookies()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Claire's Cookies");
        System.out.println("-----------------------------");
        System.out.println();



        // 19. Claire sells cookies by the dozen. Sean has 14 students
        // in his class. He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. How many cookies will each student
        // receive? (Students can only receive whole cookies)
        int claresCookies = 12;
        int seansClass = 14;
        int cookieorder = claresCookies * 3;
        int cookiePerStudent = cookieorder / seansClass;
        int leftOverCookies = cookieorder - seansClass * cookiePerStudent;

        System.out.println("How many of Claire's cookies will each student get: ");
        System.out.println("Sean's Class size: " + seansClass);
        System.out.println("Cookies ordered: " + cookieorder);
        System.out.println("Each student will get: " + cookiePerStudent);
        System.out.println("With a leftover cookie count of: " + leftOverCookies);
        System.out.println();

        // 20. Sean has 14 students in his class.
        // He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. After giving the students their
        // cookies, how many cookies will be left over?
        System.out.println("How many cookies will be leftover from Sean's order: ");
        System.out.println(" Total leftover cookie count of: " + leftOverCookies);
        System.out.println();

        //this is a push test

        // 21. Sean's class has earned a cookie party.

        // If Sean has 14 students, how many dozen cookies
        // does he need to buy from Claire's Cookies so that
        // each student can receive 3 cookies.

        int desiredCookiePerStudent = 3;
        int seansNeededOrder = seansClass * desiredCookiePerStudent;

        System.out.println("Sean's needed order to ensure each student recieves 3 cookies: ");
        System.out.println("Sean needs to order at least: " + seansNeededOrder);
        System.out.println("Claire makes orders in the dozens so Sean needs to order: " + 4 );
        System.out.println();
        // 22. Sean's class has earned a cookie party. The number
        // of cookies that a student receives depends on
        // the score that they received on the cookie test.
        // Sean has 14 students.

        // 100 = 4 cookies
        // 90+ = 3 cookies
        // everyone else 2 cookies

        // Sean has 14 students. Chuck and Andrea scored
        // a perfect 100 on the test. Regina, Glen, Tony and Lorrie
        // all scored above 90. The rest of the class scored
        // below 90.

        // How many dozen cookies does Sean need to buy.



        // 23. If Claire's Cookies sells each dozen cookies for 12.99,
        // how much will it cost Sean to buy 4 dozen cookies.



        // (Use this information for the next several questions)
        // Claire now charges different prices for different
        // types of cookies as follows:

        // Snicker Doodles = $12.99 / dz
        // Chocolate Chip = $13.99 / dz
        // Frosted Chocolate Chip = $15.99 / dz

        // Each dozen cookies must be the same type of cookie.

        // Sean has allowed his students to choose 3
        // cookies each. Here is what they have selected

        // Snicker Doodles | Chocolate Chip | Frosted Chocolate Chip
        // ---------------------------------------------------------
        // 9                 15               18

        // 24. How many total dozen cookies does Sean need to buy?



        // 25. What is the total cost of this order?



        // 26. How many cookies will be left over of each type of cookie?
        // (Snicker Doodles, Chocolate Chip, Frosted Chocolate Chip)



        // 27. How much money could Sean have saved if he would
        // have bought: 2 dz Frosted Chocolate Chip
        //              1 dz Chocolate Chip
        //              1 dz Snicker Doodle
    }


    // bonus - challenge
    public static void elliotsYardCare()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Elliot's Yard Care");
        System.out.println("----------------------------");
        System.out.println();

        // Use the following information to answer the remaining questions.

        // Elliot runs a yard care business named "Elliot's Yard Care".
        // He charges $30 to mow and trim a medium size lawn (100 ft x 50 ft).
        // Elliot takes pride in his work and his lawns look
        // immaculate. In order to maintain such a quality reputation
        // his services include grass clipping removal and
        // complete sweeping of the property after the lawn
        // is mowed.

        // Elliot's goal is to earn at least $10 per hour.
        // It costs him about $2.50 in materials and gas per 1000 sq ft.
        // On average elliot has calculated that it takes him roughly
        // 45 minutes to fully maintain 1000 sq ft.


        // 28. What is the total cost to Elliot when
        // he mows a yard that is 100 x 50 feet?



        // 29. How much total money does Elliot earn
        // to maintain a 100 x 50 ft yard?



        // 30. How much time does it take Elliot to mow
        // a 100 x 50 ft yard?



        // 31. How much money does Elliot earn per hour
        // on a 100 x 50 foot yard?



        // 32. What is Elliot's cost per hour on a medium
        // sized yard?



        // 33. How much money should Elliot charge for a medium yard
        // in order to earn $10 per hour?


    }
}