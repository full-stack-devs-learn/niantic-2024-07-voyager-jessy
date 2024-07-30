package com.nianatic;

public class Exercises
{
    /*
     * In this function you need to convert a word
     * either to all upper case letters or all
     * lower case.
     *
     * The user will provide you with the word, and
     * which case you should change it to.
     *
     * changeCase("Fancy", false) => fancy
     * changeCase("chocolate", true) => CHOCOLATE
     * changeCase("PARTY", false) => party
     * changeCase("PARTY", true) => PARTY
     *
     */
    public String changeCase(String word, boolean toUpperCase)
    {   String result; // this string will hoold the result of what comes from the boolean
        if(toUpperCase) //if it is true, change word to all uppercase and that will then be the value held for string result
        {
            result = word.toUpperCase();
        }
        else{ //if false, word will be converted to lowercase
            result = word.toLowerCase();
        }
        return result;
    }

    /*
     * As a full stack developer you will often need to
     * dynamically create Html in code. In this function
     * you are required to take the input and convert it
     * to a valid Html String.
     *
     * Html is made up of elements (also known as tags)
     * such as:
     *
     * <p>your content here</p>
     *
     * The element is <p> for paragraph
     *
     * Most elements have both an opening <p>
     * and a closing </p> tag, and the content
     * goes inside.
     *
     * The user will provide you with the content, and
     * the name of Html element.
     *
     * You need to return the formatted Html
     *
     * createHtml("This is a paragraph", "p") => <p>This is a paragraph</p>
     * createHtml("Bold text", "strong") => <strong>Bold text</strong>
     *
     */
    public String createHtml(String content, String elementName)
    {
        String beginningElement = ("<"+elementName+">");
        String endingElement = ("<"+"/"+elementName+">");
        String htmlForUser = beginningElement + content+endingElement;


        return htmlForUser;
    }

    /*
     * Sometimes Html elements do not have any content
     *
     * <p></p>
     *
     * Elements that have no content can be "self closing".
     *
     * <p />
     *
     * Modify the logic that you used for the CreateHtml
     * to return a self closing element when there is no
     * content provided.
     *
     * moreHtml("This is a paragraph", "p") => <p>This is a paragraph</p>
     * moreHtml("", "p") => <p />
     *
     */
    public String moreHtml(String content, String elementName)
    {
        String beginningElement = "<"+elementName+">";
        String endingElement = "</"+ elementName + ">";
        String userHTML= beginningElement + content + endingElement;
        String withoutContent = "<" + elementName +" />";


        String userHTMLPlus;
        if (content.isEmpty()) {     //if content is "" then use the self closing format for element
            userHTMLPlus= withoutContent;
        } else {                    //else, if content has content/isn't empty, then use my predefined format for userHTML
            userHTMLPlus= userHTML;
        }


        return userHTMLPlus;
    }

    /*
     * Xml is similar to Html - it uses element names
     * to describe the data that is being stored.
     *
     * Unlike html, however, there are no pre-defined
     * element names in xml. In other words, you can use
     * any word as a tag name.
     *
     * <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     * The user has a list of customer id and names. They
     * will provide you each customer id and their name.
     * You are required to return a formatted xml String
     * like the pattern shown above.
     *
     * createXml(1, "Belinda Carter") => <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     */
    public String createXml(int id, String name)
    {
        String idSignifier = "<id>" + id + "</id>";
        String nameSignifier = "<name>" + name + "</name>";
        String customerSignifier = "<customer>" + idSignifier + nameSignifier + "</customer>";

        return  customerSignifier;
    }

    /*
     * The customer has noted that even though
     * the xml that is returned is correct, it is still
     * somewhat difficult to read because it is all on
     * a single line
     *
     * <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     * Xml can be made easier to read by adding line breaks
     * and indentation like this:
     * (note: indentations are 2 spaces)
     *
     * <customer>
     *   <id>1</id>
     *   <name>Belinda Carter</name>
     * </customer>
     *
     * Modify your logic to return formatted xml.
     * each element must be on its own line.
     * Indent the nested elements with 2 spaces
     *
     * String format codes (see https://www.w3schools.com/java/java_Strings_specchars.asp):
     * \n = new line
     * \t = tab
     * \\ = \
     *
     * formattedXml(1, "Belinda Carter") => <customer>
     *                                        <id>1</id>
     *                                        <name>Belinda Carter</name>
     *                                      </customer>
     *
     */
    public String formattedXml(int id, String name)
    {
        String idSignifier = "  <id>" + id + "</id>\n";
        String nameSignifier = "  <name>" + name + "</name>\n";
        String customerSignifier = "<customer>\n" + idSignifier + nameSignifier + "</customer>";


        return customerSignifier;
    }

    /*
     * In this function you will be given all the
     * individual parts of a full name. You need to
     * return the fully formatted name as a single String
     *
     * The first and last names will always have a value,
     * but a user is not required to have a middle name
     * or a suffix.
     *
     * If middle name or suffix is provided, you must
     * format the name accordingly.
     *
     * Examples:
     * formatFullName("Glen", "", "Williamson", "") => Glen Williamson
     * formatFullName("Glen", "Carter", "Williamson", "") => Glen Carter Williamson
     * formatFullName("Glen", "", "Williamson", "Jr") => Glen Williamson, Jr
     * formatFullName("Glen", "Carter", "Williamson", "Jr") => Glen Carter Williamson, Jr
     *
     */
    public String formatFullName(String firstName, String middleName, String lastName, String suffix)
    {

        // second trial:
        String finalName = firstName + " ";
        if(middleName.isEmpty())
        {
            finalName += lastName;
        }
        else
        {
            finalName += middleName + " " + lastName;
        }

        if (suffix.isEmpty())
        {
        }
            else{
            finalName += ", " + suffix;
        }
        return  finalName;
    }

    /*
     * You are writing a program for HR.
     * When they hire a new employee they must be
     * given an username to access the network.
     *
     * The username must always be lower case and
     * is formatted as the employees first name
     * and last name separated by a period.
     *
     * Glen Williamson => glen.willimason
     *
     * If the employee has a middle name, the
     * middle initial should also be added like
     * this
     *
     * Glen Carter Williamson => glen.c.williamson
     *
     * Your function accepts the full name of the employee
     * and you must return the new username.
     *
     * Examples:
     * createUserName("Glen Williamson") => glen.williamson
     * createUserName("Glen Carter Williamson") => glen.c.williamson
     * createUserName("Glen Williamson, III") => glen.williamson
     *
     */
    public String createUserName(String fullName)
    {
        //step 1: change to lowercase. we added the .strip to make sure that if input had any whitespace, it would be deleted automatically
        String fullNameLower = fullName.strip().toLowerCase();

        // step 2. remove the suffix, by splitting it at the precusor (",")
        String[] fullNameChunks = fullNameLower.split(",");
        String withOutSuffix = fullNameChunks[0];                   //then selecting only the part of the string without the "," to continue forward with


        // step 3. account for middle names
        String[] nameChunks= withOutSuffix.split(" ");
        String firstname = nameChunks[0];
        String middleName= "";
        String lastName= "";

        if(nameChunks.length > 2) // step 4. middle name is present because there is a 0=name 1=middle, 2 = last name
        {
            middleName= nameChunks[1].substring(0,1); // making a substring of middle name so that it now only contains values 0 ending at 1 = only the first letter
            lastName = nameChunks[2];
        }
        else{
            lastName= nameChunks[1];
        }

        // step 5 .at this point we have all the parts needed and now we just need to test to see if there is a middle name, so then we can know how many periods are needed in the middle name
        String userName = ""; // new variable that will hold username value dependent on if there is a middle name or not
        if(middleName.isEmpty())
        {
            userName = firstname+ "." + lastName;
        }
        else{
            userName = firstname + "." + middleName + "." + lastName;
        }





        return userName;
    }
}
