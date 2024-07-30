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
        String userHTML= beginningElement+content+endingElement;
        String withoutContent = "<" + elementName +" />";
        String userHTMLPlus;

        boolean ifContent = Boolean.parseBoolean(content);
        if(ifContent) {
            userHTMLPlus= beginningElement+content+endingElement;
        }
        else{
            userHTMLPlus= "<" + elementName + " />";
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
        //String firstNameFormat= firstName+" ";
        //String suffixFormat = ", " + suffix;
        //String[] nameString = {firstName,   middleName, lastName, suffixFormat};


        String[] names = {firstName, middleName, lastName, suffix};

        boolean ifMiddle= Boolean.parseBoolean(names[1]);
        boolean ifSuffix = Boolean.parseBoolean(names[3]);
        String nameFormatted = names[0];

        for (int i = 1; i< names.length; i++) {
            if (names[i].isEmpty()) {
                continue;}
            if(ifMiddle)
            {
                nameFormatted+= middleName;
            }
            else {
                nameFormatted += " " + names[i];
            }
            if  (ifSuffix)
            { nameFormatted+= ", "+suffix;}

        }

        return  nameFormatted;
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
        //attempt 1
        //String[] nameChunks = fullName.toLowerCase().split(" ");






        //for (int i = 0; i<nameChunks.length; i++)
        //{
        //    if
        //}

        //atttempt 2
        //int firstEndPosition = fullName.indexOf(' ');
        //String firstName = fullName.substring(0,firstEndPosition);
        //int lastEndPosition = fullName.lastIndexOf(' ');
        //String lastName = fullName.substring(lastEndPosition);
        //String simpleName = firstName.toLowerCase()+"."+lastName.toLowerCase();
        //String middleName = fullName.substring(firstEndPosition,lastEndPosition);
        //String middleInitial = middleName.toLowerCase();
        //int suffixPosition = fullName.indexOf(',');
        //String suffix = fullName.substring(suffixPosition);

        //String userName;
        //if(Character.isDefined(middleInitial))
        //{
        //    userName = firstName.toLowerCase() + "." + middleInitial.length()+"."+lastName.toLowerCase();
        //}




        return null;
    }
}
