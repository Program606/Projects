from msilib.schema import Condition
#Use lots of comments between lines liberally

USERNAME = "Pmanz282"  # define your MRU username here

def get_beverage_type(a_enabled: bool, b_enabled: bool) -> str:
    """
    Returns the beverage type defined by the switches.
    """
    # Neither Buttons are turned on
    if (not a_enabled and not b_enabled):
        beverage =  ("Coffee, Latte")
   
    # Button a and b are turned on
    elif (a_enabled and b_enabled):
        beverage = "Wine, White"
    
    # Button a is on but not b
    elif (a_enabled and not b_enabled):
        beverage = "Juice, Apple"
   
    # Button b is on but not a
    elif (not a_enabled and b_enabled):
        beverage = "Wine, White"
    
    return beverage



def get_temperature_desc(slider_value: int) -> str:
    """
    Returns the temperature description defined by the slider value.
    Assume the value is always an integer between 0 and 100 (inclusive).
    """
# 0 Frozen, 1-15 Cold, 16-41 Warm, 42-99 Hot, 100 Boiling
  
   #If the slider input is 0 return Frozen
    if slider_value == 0:
        description = "Frozen"
   
   #If the slider input is between 1 and 15 returns Cold
    elif (slider_value > 0) and (slider_value <= 15):
        description = "Cold"
   
    #If the slider input is equal or greater than 16 and less than or 
    # equal to 41 returns Warm
    elif (slider_value >= 16) and (slider_value <= 41):
        description = "Warm"
    
    #If the slider input is equal or greater than 42 or equal to or 
    # less than 99 returns Hot
   
    elif (slider_value >=42) and (slider_value <=99):
        description = "Hot"
   
    #If the slider input is equal to 100 returns Boiling
    elif (slider_value == 100 ):
        description = "Boiling"
    
    return description

    

def get_switch_value(switch_name: str) -> bool:
    """
    Prompts the user for the state of the specified switch.
    Returns true if the specified switch is enabled and false otherwise.
    """
    #If input is n, return value is False
    if switch_name =="A":
       #Prompt for user input of y/n for button_a_input
        button_a_input = (input("Is switch A enabled? (y/n): "))
        if button_a_input == "n":
            return (False)
        elif button_a_input == "y":
            return (True)
    #If input is y, return value is True
    if switch_name =="B":
         #Prompt for user input of y/n for button_b_input
        button_b_input = (input("Is switch B enabled? (y/n): "))
        if button_b_input  == "n":
            return (False)
        elif button_b_input == "y":
            return (True)
    
    #Second Attempt after Newsletter
    #If input is n, return value is False
   # if switch_name =="n":
   #     return (False)
    #If input is y, return value is True
   # elif switch_name =="y":
   #     return (True)

# First Attempt 
# def get_switch_value_b_value(switch_name: str) -> bool:
 #   """
  #  Prompts the user for the state of the specified switch.
   # Returns true if the specified switch is enabled and false otherwise.
    #"""
    #print(f"{switch_name=}")
    #If input is n, return value is False
    #if switch_name =="n":
    #    return (False)
    #If input is y, return value is True
    #elif switch_name =="y":
    #    return (True)
    # After adding another function, it made me realized I don't really need to add a new function
     # I realized that I have to make variables that recieve the return result with different names but use the same
        # get_switch_value function for both. I don't know why that didn't become obvious when I started the code, but I am glad that I
     # added another function to help me realize that.

   
        

def main() -> None:
    get_beverage_type
    """
    Prompts the user for the state of switches A and B and
    the value of the numeric slider. Using the various provided
    function headers, duplicate the functionality of the
    abandoned replicator at https://mru-replicator.fly.dev.
    """
    #calling get_switch_value for button A
    button_a_bool=  get_switch_value("A")
    
    #calling get_switch_value for button B
    button_b_bool = get_switch_value("B")
    
    #First Attempt After Newsletter
    #Prompt for user input of y/n for button_a_input
    #button_a_input = (input("Is switch A enabled? (y/n): "))
    #Prompt for user input of y/n for button_b_input
    #button_b_input = (input("Is switch B enabled? (y/n): " ))
    #Put the inputs into the function get_switch_value, put result into specific variable
    #button_a_bool= get_switch_value(button_a_input)
    #button_b_bool = get_switch_value(button_b_input)

    #Input the the variables into function get_beverage_type
    beverage_type = get_beverage_type(button_a_bool,button_b_bool)

    #Prompt for user input of an integer number between 0-100
    temperature_input = int(input("What is the value of the numeric slider? (0-100): "))
    
    #Place the user input into the function get_temperature_desc
    temperature_describe = get_temperature_desc(temperature_input)

    #Print both final variables into a print statement to display the results to user
    print(f"Result: {beverage_type}, {temperature_describe}")
    


    
main()

