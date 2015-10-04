# csm10j-hw01b


The program begins by initializing values such default stock name and value to have loop continue.
Then the do-while statement begins.
The user is then prompted with 5 choices and the program takes the choice.
The switch statement then begins and depending on the choice, to program executes that choice.
If user chooses case 1, then they are asked for the stock ticker. The input is converted to capitals.
Then the first method is called to make search the file for the max, min, and avg price of that stock price.
In case 2 and 3, variables are initialized to hold stock prices and another variable is initialized to identify the case.
Both cases call the same method and send parameters to method so that max and min stock prices are found.
In case c or C(break is omitted so user input is case insensitive) current file name is initialized to a string and then path directory to current file is placed.
User is asked for new file name. If original file name exists then it is given the new file name.
User is prompted that update of file name is successful.
Case q changes value of initial value so that loop ends.
If user enters a value other then what is listed, default is executed.
When user enters '1' case 1 executes and calls method GetStocksStats
This method gets current file name and reads it. When passed user input of stock ticker name is found then the next value, which is the price, is stored in a variable and converted into a double. Several if statements are used to compare values for max, min, and average of that particular stock ticker. Also a counter is maintained so that variables running total can be divided by amount of times the stock ticker is found. The method then prints out values for user to see.
The other method takes the file name and key value. Depending on the key value, the program executes and if statement that corresponds with either case 2 or 3 (min and max respectively).
If key is 0 min price is searched for and first value is given to min until lower values are located
Otherwise max is given first price and any other price larger then given. Method then outputs values. And program prompts user to enter another choice until user enters 'q' or 'Q'.
@andrewstanton1
Markdown supported
Write Preview

Attach files by dragging & dropping or selecting them.
