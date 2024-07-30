package com.nianatic;

public class ExerciseChallenge
{
    /*
     * Your companies website displays the name
     * of each of your employees. But the name
     * needs to be formatted with last name first.
     *
     * Examples:
     * Samuel Black             => Black, Samuel
     * Lori Bell, PhD           => Bell, Lori, PhD
     * Marcus Neuer III         => Neuer, Marcus, III
     * Miguel Bennett Jr., MBA  => Bennett, Miguel, Jr., MBA
     *
     * Your function will accept the full name of
     * an employee, and you must return the
     * appropriately formatted name.
     *
     * Input:
     * reformatName("Samuel Black")             => Black, Samuel
     * reformatName("Lori Bell, PhD")           => Bell, Lori, PhD
     * reformatName("Marcus Neuer III")         => Neuer, Marcus, III
     * reformatName("Miguel Bennett Jr., MBA")  => Bennett, Miguel, Jr., MBA
     *
     */
    public String reformatName(String fullName)
    {
        String [] nameChunks = fullName.split(" ");
        String [] removeCommaLastName = nameChunks[1].split(",");
        String lastName = removeCommaLastName[0];

        String lastNameFirst = lastName + ", " + nameChunks[0];

        if(nameChunks.length > 2)
        {
            lastNameFirst += ", " + nameChunks[2];
        }
        if(nameChunks.length >3) {
            lastNameFirst += " " + nameChunks[3];
        }

        return lastNameFirst;
    }

    /*
     * JSON is yet another format that is used to
     * describe and transfer data. JSON stands for
     * JavaScript Object Notation
     *
     * There are no XML tags, but it is still self describing.
     *
     * It is more light-weight than XMl, and has become the
     * standard for transferring data over the web.
     *
     * { "id": 1, "name": "Belinda Carter"}
     *
     * The user will provide you a customer id and their name.
     * You are required to return a formatted JSON String
     * like the pattern shown above.
     *
     * createJSON(1, "Belinda Carter") => { "id": 1, "name": "Belinda Carter"}
     *
     */
    public String createJSON(int id, String name)
    {
        String newId ="{ " + "\"id\": " + id + ", " ;
        String nameInQuotes = "\"" + name + "\"";
        String newName = "\"name\": " + nameInQuotes + " }";
        String formattedJSON = newId+ newName;
        return  formattedJSON;
    }

}
