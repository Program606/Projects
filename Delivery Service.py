
MINIMUM_FREE_DELIVERY = 40
def check_free_delivery(order:float) -> None:
    """
    The amount inputed will be sorted to a different message
    depending if the amount is within a range.
    """
    if order < 0:
        result = ("Invalid entry, orders must be positive")
    elif (order >= 0) and (order < MINIMUM_FREE_DELIVERY):
        remaining_funds_for_free_delivery = (MINIMUM_FREE_DELIVERY - order)
        result = (f"Add ${remaining_funds_for_free_delivery:.2f} to your order to get free delivery")
    elif (order >= MINIMUM_FREE_DELIVERY):
        result = ("You get free delivery")
    return result
def main() -> None:
    """
    We ask user to input their amount then call to def
    check_free_delivery
    """
    order = float(input("What is the amount of your order?"))
    message_from_amount = check_free_delivery(order)
    print(message_from_amount)

main()

