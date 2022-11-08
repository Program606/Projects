
def gpa_to_message(gpa:float)-> str:
    if (gpa < 0.0) or (gpa > 4.0):
        gpa_to_message = ("Invalid Input")
    elif (gpa >= 0.0) and (gpa <= 0.9):
        gpa_to_message = (":(")
    elif (gpa >= 1.0) and (gpa <= 1.9):
        gpa_to_message =("You're falling behind, is everything okay?")
    elif (gpa >= 2.0) and (gpa <= 2.9):
        gpa_to_message =("Room for improvement, but you're getting there")
    elif (gpa >= 3.0) and (gpa <= 4.0):
        gpa_to_message =("Keep up the great work!")
    return gpa_to_message
def main():
    gpa = float(input("What is your GPA? "))
    gpa_message = gpa_to_message(gpa)
    print(gpa_message)
    

main()

