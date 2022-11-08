
GALLON = 3.785
MILE = 1.61

def calculate_gas_c(gas:float,km:float)-> float:
    miles_calc = km * MILE
    gallon_calc = gas * GALLON
    miles_per_gallon = miles_calc/gallon_calc
    return miles_per_gallon

def main():
    gas = float(int(input("What is the gas in litres?")))
    km = float(float(input("What is the km driven?")))
    cheese = calculate_gas_c(gas,km)
    print(f"Your car's miles per gallon is {cheese}")

main()

